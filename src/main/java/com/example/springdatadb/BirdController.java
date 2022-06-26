package com.example.springdatadb;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class BirdController {
    BirdRepository birdRepository;
    @GetMapping("/bird")
    public List<Bird> getBirdsList(){
        return birdRepository.findAll();
    }
    @GetMapping("/names/{name}")
    public List<String> getBirds(@PathVariable String name){
        return birdRepository.findAll1(name);
    }
    @GetMapping("/names/{names}")
    public List<String> getBirds1(@PathVariable String name){
        return birdRepository.findAll3(name);
    }
    @GetMapping("/names/{name1}/{name2}")
    public List<String> getBirds1(@PathVariable String name1, @PathVariable String name2){
        return birdRepository.findAll4(name1, name2);
    }
    @GetMapping("/{id}")
    public Bird getBirdById(@PathVariable Integer id){
        return birdRepository.getById(id);
    }
    @GetMapping("/name/{name}")
    public List<Bird> getBirdByName(@PathVariable String name){
        return birdRepository.findByName(name);
    }
    @GetMapping("/age/{age}")
    public List<Bird> getBirdByAge(@PathVariable Integer age){
        return birdRepository.findByAge(age);
    }

    @PostMapping
    public Bird create(@RequestBody Bird bird){
        return birdRepository.save(bird);
    }
    @PutMapping("/{id}/{name}")
    public String update(@PathVariable Integer id, @PathVariable String name){
        birdRepository.updateBirdName(id, name);
        return "update";
    }
    @GetMapping("/findbydate")
    public List<Bird> findByDateBetween1(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd) {
        return birdRepository.findByUtilDateBetween(dateStart, dateEnd);
    }

    @GetMapping("/findbydatebefore")
    public List<Bird> findByDateBefore(@RequestParam @DateTimeFormat(pattern = "dd.MM.yy") LocalDate date)
    {
        return birdRepository.findByUtilDateBefore(date);
    }

    @GetMapping("/findbydateafter")
    public List<Bird> findByDateAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return birdRepository.findByUtilDateAfter(date);
    }

    @GetMapping("/findbydatebetween")
    public List<Bird> findByDateBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2)
    {
        return birdRepository.findByUtilDateBetween(date1, date2);
    }
 }
