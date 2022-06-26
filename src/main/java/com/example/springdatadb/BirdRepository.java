package com.example.springdatadb;

import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
public interface BirdRepository extends JpaRepository<Bird, Integer> {
 List<Bird> findByName(String name);
 List<Bird> findByAge(Integer age);

 @Query(nativeQuery = true, value = "select * from bird")
 List<Bird> findAll();
 @Query(value = "from Bird")
 List<Bird> findAllJPA();
 @Query(nativeQuery = true, value = "select name from bird where name like %?1%")
 List<String> findAll1(String s1);
 @Query(nativeQuery = false, value = "select b.name from Bird b where b.name like %?1%")
 List<String> findAll3(String s1);

 @Query(value = "select b from Bird b")
 List<Bird> findAll2();
// @Query(nativeQuery = true, value = "select name from bird where name like %?1% or name like %?2%")
// List<String> findAll4(String s1, String s2);
 @Query(nativeQuery = true, value = "select name from bird where name like %:p1% or name like %:p2%")
 List<String> findAll4(@Param("p2") String s2, @Param("p1")String s1);

 @Modifying
 @Query("UPDATE Bird b SET b.name = :name WHERE b.id = :id")
 void updateBirdName(@Param("id") Integer id, @Param("name") String name);

 @Query(value = "select b from Bird b where b.utilDate > ?1 and b.utilDate < ?1")
 List<Bird> findByUtilDateBetween1(LocalDate dateStart, LocalDate dateEnd);

 @Query(value = "select b from Bird b where b.utilDate < ?1")
 List<Bird> findByUtilDateBefore1(LocalDate date);
 List<Bird> findByUtilDateBefore(LocalDate date);
 List<Bird> findByUtilDateAfter(LocalDate date);
 List<Bird> findByUtilDateBetween(LocalDate date1,LocalDate date2);
}

