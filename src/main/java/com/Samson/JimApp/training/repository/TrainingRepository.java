package com.Samson.JimApp.training.repository;

import com.Samson.JimApp.training.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainingRepository extends JpaRepository<Training, Long> {

}
