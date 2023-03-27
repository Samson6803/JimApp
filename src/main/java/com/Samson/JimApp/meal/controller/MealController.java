package com.Samson.JimApp.meal.controller;

import com.Samson.JimApp.meal.entity.Meal;
import com.Samson.JimApp.meal.entity.MealRequest;
import com.Samson.JimApp.meal.service.MealService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class MealController {
    private final MealService service;

    public MealController(MealService service){
        this.service = service;
    }
    @PostMapping("users/{userId}/meals")
    public Meal addMeal(@RequestBody MealRequest request, @PathVariable Long userId){
        return service.addMeal(request, userId);
    }

    @GetMapping("meals/{mealId}")
    public Meal getMeal(@PathVariable Long mealId){
        return service.getMeal(mealId);
    }
}
