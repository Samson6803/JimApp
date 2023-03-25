package com.Samson.JimApp.training.controller;

import com.Samson.JimApp.training.entity.TrainingRequest;
import com.Samson.JimApp.training.entity.TrainingType;
import com.Samson.JimApp.training.service.TrainingService;
import com.Samson.JimApp.training.entity.Training;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TrainingController {
    private final TrainingService service;

    public TrainingController(TrainingService service){
        this.service = service;
    }
    @GetMapping("trainings/{trainingId}")
    public Training getTraining(@PathVariable Long trainingId){
        return service.getTraining(trainingId);
    }

    @PostMapping("users/{userId}/trainings")
    public Training addTraining(@RequestBody TrainingRequest request, @PathVariable Long userId){
        return service.addTraining(request, userId);
    }
}
