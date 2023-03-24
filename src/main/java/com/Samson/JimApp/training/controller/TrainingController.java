package com.Samson.JimApp.training.controller;

import com.Samson.JimApp.training.service.TrainingService;
import com.Samson.JimApp.training.entity.Training;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController("api/v1/training")
public class TrainingController {
    private final TrainingService service;

    public TrainingController(TrainingService service){
        this.service = service;
    }
    @GetMapping("/{id}")
    public Training getTraining(@PathVariable Long id){
        return service.getTraining(id);
    }

    @GetMapping("")
    public List<Training> getTrainings(){
        return service.getTrainings();
    }
}
