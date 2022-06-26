package com.example.springdatadb;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Criteria")
@AllArgsConstructor
public class BirdControllerCriteria {
        private UserDAO userDAO;

        @GetMapping
        public List<Bird> listBird (@RequestParam(value = "key") String key, @RequestParam(value = "operation") String operation,
                                    @RequestParam(value = "value") String value){
                List<SearchCriteria> params = new ArrayList<SearchCriteria>();
                params.add(new SearchCriteria(key, operation, value));
//                params.add(new SearchCriteria("age", ">", "3"));
            return    userDAO.searchBild(params);

        }

        }
