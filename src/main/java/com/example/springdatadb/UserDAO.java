package com.example.springdatadb;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Bird> searchBild(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bird> query = builder.createQuery(Bird.class);
        Root r = query.from(Bird.class);

        Predicate predicate = builder.conjunction();

        UserSearchQueryCriteriaConsumer searchConsumer = 
          new UserSearchQueryCriteriaConsumer(predicate, builder, r);
//        params.stream().forEach(searchConsumer);
        for(SearchCriteria searchCriteria: params){
            searchConsumer.accept(searchCriteria);
        }
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        List<Bird> result = entityManager.createQuery(query).getResultList();
        return result;
    }


    public void save(Bird entity) {
        entityManager.persist(entity);
    }
}