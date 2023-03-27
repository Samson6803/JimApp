package com.Samson.JimApp.meal.repository;

import com.Samson.JimApp.meal.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
