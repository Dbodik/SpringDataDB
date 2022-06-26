package com.example.springdatadb;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class DateTimeController {
 BirdRepository birdRepository;
    @PostMapping("/date")
    public Bird date(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date) {
        Bird bird = new Bird();
        bird.setUtilDate(date);
        return birdRepository.save(bird);
        // ...
    }

    @PostMapping("/plocaldate/{time}/{age}/{name}/{date}")
    public Bird pLocalDate(@PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime time
            , @PathVariable Integer age, @PathVariable String name,
                           @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date
    ) {
        Bird birdP = new Bird();
        birdP.setUtilTime(time);
        birdP.setAge(age);
        birdP.setName(name);
        birdP.setUtilDate(date);
        return birdRepository.save(birdP);
    }

    @PostMapping("/localdate")
    public Bird localDate(@RequestParam(value = "time")  @DateTimeFormat(pattern = "HH:mm") LocalTime time,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "age") Integer age,
                          @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date
    ) {
        Bird bird = new Bird();
        bird.setUtilTime(time);
        bird.setAge(age);
        bird.setName(name);
        bird.setUtilDate(date);
        return birdRepository.save(bird);
        // ...
    }




    @PostMapping("/localdatetime")
    public Bird dateTime(@RequestParam("localDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")LocalDateTime localDateTime) {
      Bird bird = new Bird();
      bird.setUtilTimestamp(localDateTime);
      return bird;
    }
}