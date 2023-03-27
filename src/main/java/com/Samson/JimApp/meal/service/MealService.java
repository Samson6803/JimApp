package com.Samson.JimApp.meal.service;

import com.Samson.JimApp.day.entity.Day;
import com.Samson.JimApp.day.service.DayService;
import com.Samson.JimApp.exception.exceptions.ApiNotFoundException;
import com.Samson.JimApp.meal.entity.Meal;
import com.Samson.JimApp.meal.entity.MealRequest;
import com.Samson.JimApp.meal.repository.MealRepository;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    private final MealRepository repository;
    private final DayService dayService;

    public MealService(MealRepository repository, DayService dayService){
        this.repository = repository;
        this.dayService = dayService;
    }

    public Meal getMeal(Long mealId){
        return repository.findById(mealId)
                .orElseThrow(() -> new ApiNotFoundException("No such meal found: " + mealId));
    }

    public Meal addMeal(MealRequest request, Long userId){
        Day day = dayService.getOrCreateDay(userId, request.date());
        return repository.save(Meal.builder()
                .name(request.name())
                .mealType(request.type())
                .calories(request.calories())
                .ingredients(request.ingredients())
                .day(day)
                .build());
    }
}
