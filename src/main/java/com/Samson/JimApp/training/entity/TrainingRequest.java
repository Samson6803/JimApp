package com.Samson.JimApp.training.entity;

import java.time.LocalDate;

public record TrainingRequest(String name, String description, TrainingType type, LocalDate date) {
}
