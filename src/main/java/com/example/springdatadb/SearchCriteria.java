package com.example.springdatadb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key; // age . color
    private String operation;//> . :
    private Object value;//10 . blue
}