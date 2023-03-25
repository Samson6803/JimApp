package com.Samson.JimApp.day;

import com.Samson.JimApp.exception.exceptions.ApiNotFoundException;
import com.Samson.JimApp.user.entity.User;
import com.Samson.JimApp.user.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayService {
    private final DayRepository repository;
    private final UserService userService;

    public DayService(DayRepository repository, UserService userService){
        this.repository = repository;
        this.userService = userService;
    }

    public Day getDay(Long userId, LocalDate date){
        User user = userService.getUser(userId);
        return repository.findByDateAndUser(date, user).orElseThrow(() -> new ApiNotFoundException("Day with date " + date
        + "does not contain anything"));
    }

    public List<Day> getDays(Long userId, LocalDate sinceDate, LocalDate untilDate){
        User user = userService.getUser(userId);
        return repository.findAllByUserAndDateBetween(user, sinceDate, untilDate);
    }

    public Day getOrCreateDay(Long userId, LocalDate date){
        User user = userService.getUser(userId);
        return repository.findByDateAndUser(date, user)
                .orElseGet(() ->repository.save(Day.builder()
                        .date(date)
                        .user(user)
                        .build()));
    }
}
