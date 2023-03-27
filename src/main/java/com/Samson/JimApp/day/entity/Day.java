package com.Samson.JimApp.day.entity;

import com.Samson.JimApp.meal.entity.Meal;
import com.Samson.JimApp.training.entity.Training;
import com.Samson.JimApp.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long dayId;
    private LocalDate date;
    @ManyToOne
    @JsonIgnore
    @JoinColumn( name = "user_id", referencedColumnName = "userId")
    private User user;
    @OneToMany(mappedBy = "day")
    private List<Training> trainings;
    @OneToMany(mappedBy = "day")
    private List<Meal> meals;
}
