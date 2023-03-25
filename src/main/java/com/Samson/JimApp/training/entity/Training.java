package com.Samson.JimApp.training.entity;

import com.Samson.JimApp.day.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long trainingId;
    private String name;
    private String description;
    @Enumerated
    private TrainingType trainingType;
    @ManyToOne()
    @JoinColumn(name = "day_id",
            referencedColumnName = "dayId")
    @JsonIgnore
    private Day day;
}