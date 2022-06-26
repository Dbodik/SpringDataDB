package com.example.springdatadb;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//create table bird(
//        id int PRIMARY  key,
//        name varchar(20),
//        age int
//        )
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;

    @JsonFormat(pattern="yy_MM_dd")
    @Column(name = "local_date", columnDefinition = "DATE")
    private LocalDate utilDate;

//    @Basic
//    @Temporal(TemporalType.TIME)
@Column(name = "local_time", columnDefinition = "TIME")
    private LocalTime utilTime;

//    @Basic
//    @Temporal(TemporalType.TIMESTAMP)
@Column(name = "local_time_stamp", columnDefinition = "TIMESTAMP")
    private LocalDateTime utilTimestamp;

    public Bird(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
