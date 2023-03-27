package com.Samson.JimApp.meal.entity;

import java.time.LocalDate;

public record MealRequest(String name, MealType type, double calories, String ingredients, LocalDate date) {
}
