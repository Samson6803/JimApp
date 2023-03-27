package com.Samson.JimApp.meal.entity;

import com.Samson.JimApp.day.entity.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long mealId;
    private String name;
    @Enumerated
    private MealType mealType;
    private double calories;
    private String ingredients;
    @ManyToOne
    @JoinColumn(name = "day_id", referencedColumnName = "dayId")
    @JsonIgnore
    private Day day;
}
