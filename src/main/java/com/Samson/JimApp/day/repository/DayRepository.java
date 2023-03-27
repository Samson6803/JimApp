package com.Samson.JimApp.day.repository;

import com.Samson.JimApp.day.entity.Day;
import com.Samson.JimApp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Long> {
    Optional<Day> findByDateAndUser(LocalDate date, User user);
    List<Day> findAllByUserAndDateBetween(User user, LocalDate sinceDate, LocalDate untilDate);
}
