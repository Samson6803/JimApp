package com.Samson.JimApp.training.entity;

import com.Samson.JimApp.Day;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long trainingId;
    private String name;
    private String description;
    @Enumerated
    private TrainingType sportType;
    @ManyToOne()
    @JoinColumn(name = "day_id", referencedColumnName = "dayId")
    private Day day;
}