package com.example.springdatadb;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository

public class CriteriaRepositoriy {
    @PersistenceContext
    EntityManager entityManager;

    public List<Bird> getBirdList() {
//        criteriaBilder используется для построения запросов
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        criteriaQuery используется для создания объектов запросов
        CriteriaQuery<Bird> criteriaQuery = criteriaBuilder.createQuery(Bird.class);
//        root корень запроса
        Root<Bird> root = criteriaQuery.from(Bird.class);
        List<Bird> birdList = entityManager.createQuery(criteriaQuery).getResultList();
        return birdList;
    }


    public List<Bird> getBirdList1() {
//        criteriaBilder используется для построения запросов
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        criteriaQuery используется для создания объектов запросов
        CriteriaQuery<Bird> criteriaQuery = criteriaBuilder.createQuery(Bird.class);
//        root корень запроса
        Root<Bird> root = criteriaQuery.from(Bird.class);
        Predicate predicate = criteriaBuilder.conjunction();
        Predicate secondPredicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), "Travis"));
        criteriaQuery.where(secondPredicate);
        List<Bird> birdList = entityManager.createQuery(criteriaQuery).getResultList();
        return birdList;
    }

    public List<Bird> getBirdList2(String key, String value) {
//        criteriaBilder используется для построения запросов
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        criteriaQuery используется для создания объектов запросов
        CriteriaQuery<Bird> criteriaQuery = criteriaBuilder.createQuery(Bird.class);
//        root корень запроса
        Root<Bird> root = criteriaQuery.from(Bird.class);
        Predicate predicate = criteriaBuilder.conjunction();
        Predicate secondPredicate;
        if (root.get(key).getJavaType() == String.class) {
            secondPredicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get(key), "%" + value + "%"));
        } else {
            secondPredicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(key), value));
        }

        criteriaQuery.where(secondPredicate);
        List<Bird> birdList = entityManager.createQuery(criteriaQuery).getResultList();
        return birdList;
    }

    public List<Smartphone> getSmartphoneList(String key, String value) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Smartphone> criteriaQuery = criteriaBuilder.createQuery(Smartphone.class);
        Root<Smartphone> root = criteriaQuery.from(Smartphone.class);
        criteriaQuery.select(root);
//        Predicate predicate = criteriaBuilder.conjunction();
//        Predicate secondPredicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(key), value));
        Predicate secondPredicate = criteriaBuilder.equal(root.get(key), value);
//        criteriaQuery.where(secondPredicate);
        criteriaQuery.where(secondPredicate);
        TypedQuery<Smartphone> typedQuery=entityManager.createQuery(criteriaQuery);
//        List<Smartphone> smartphoneList = entityManager.createQuery(criteriaQuery).getResultList();
        List<Smartphone> smartphoneList = typedQuery.getResultList();
        return smartphoneList;
    }
}
