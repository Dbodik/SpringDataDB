package com.example.springdatadb;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SmartRepository extends JpaRepository<Smartphone, Integer>, JpaSpecificationExecutor<Smartphone> {
    @Query(nativeQuery = true, value = "SELECT * from smartphone")
    List<Smartphone> findAll();
}
