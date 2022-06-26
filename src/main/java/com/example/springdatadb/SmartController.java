package com.example.springdatadb;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SmartController {
    SmartRepository smartRepository;
    CriteriaRepositoriy criteriaRepositoriy;
    @GetMapping("/smartphones")
    public List<Smartphone> getSmartphonesList(){
        return smartRepository.findAll();
    }

    @PostMapping("/newsmart")
    public Smartphone createSmartphone(@RequestParam String manufacturer, @RequestParam String model,
                                       @RequestParam Integer ram, @RequestParam Integer storage){
        Smartphone smartphone = new Smartphone();
        smartphone.setManufacturer(manufacturer);
        smartphone.setModel(model);
        smartphone.setRam(ram);
        smartphone.setStorage(storage);
        return smartRepository.save(smartphone);
    }

    @GetMapping("/list/{key}/{value}")
    public List<Smartphone> getSmartphoneList(@PathVariable String key, @PathVariable String value){
        return criteriaRepositoriy.getSmartphoneList(key,value);
    }
}
