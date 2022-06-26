package com.example.springdatadb;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/criteria")
@AllArgsConstructor
public class CriteriaController {
    CriteriaRepositoriy criteriaRepositoriy;
    @GetMapping()
    public List<Bird> getList(){
        return criteriaRepositoriy.getBirdList();
    }

    @GetMapping("/a")
    public List<Bird> getList1(){
        return criteriaRepositoriy.getBirdList1();
    }

    @GetMapping("/b")
    public List<Bird> getList2(@RequestParam String key,@RequestParam String value){
        return criteriaRepositoriy.getBirdList2(key,value);
    }
}
