package com.Samson.JimApp.training.Service;

import com.Samson.JimApp.exception.ApiNotFoundException;
import com.Samson.JimApp.training.entity.Training;
import com.Samson.JimApp.training.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {
    private final TrainingRepository repository;

    public TrainingService(TrainingRepository repository){
        this.repository = repository;
    }

    public Training getTraining(Long id){
        Optional<Training> training = repository.findById(id);
        return training.orElseThrow(() -> new ApiNotFoundException("Training with id:" + id + "cannot be found"));
    }

    public List<Training> getTrainings(){
        return repository.findAll();
    }

    public List<Training> getTrainingsByUserId(Long id){
        return repository.findByUserId(id);
    }


}
