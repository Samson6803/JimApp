package com.Samson.JimApp.training.service;

import com.Samson.JimApp.day.entity.Day;
import com.Samson.JimApp.day.service.DayService;
import com.Samson.JimApp.exception.exceptions.ApiNotFoundException;
import com.Samson.JimApp.training.entity.Training;
import com.Samson.JimApp.training.entity.TrainingRequest;
import com.Samson.JimApp.training.repository.TrainingRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final DayService dayService;

    public TrainingService(TrainingRepository trainingRepository, DayService dayService){
        this.trainingRepository = trainingRepository;
        this.dayService = dayService;
    }

    public Training getTraining(Long trainingId){
        return trainingRepository.findById(trainingId)
                .orElseThrow(() -> new ApiNotFoundException("No training with id:" + trainingId + " found"));
    }

    public Training addTraining(TrainingRequest request, Long userId){
        Day day = dayService.getOrCreateDay(userId, request.date());
        return trainingRepository.save(Training
                .builder()
                .name(request.name())
                .description(request.description())
                .day(day)
                .trainingType(request.type())
                .build());
    }




}
