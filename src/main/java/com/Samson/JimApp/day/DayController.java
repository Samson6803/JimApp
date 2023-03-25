package com.Samson.JimApp.day;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class DayController {
    private final DayService service;

    public DayController(DayService service){
        this.service = service;
    }


    @GetMapping("/{userId}/days/{date}")
    public Day getDay(@PathVariable Long userId, @PathVariable LocalDate date){
        return service.getDay(userId, date);
    }

    @GetMapping("/{userId}/days")
    public List<Day> getDays(@PathVariable Long userId,
                             @RequestParam(name = "since")LocalDate sinceDate,
                             @RequestParam(name = "until")LocalDate untilDate){
        return service.getDays(userId, sinceDate, untilDate);
    }
}