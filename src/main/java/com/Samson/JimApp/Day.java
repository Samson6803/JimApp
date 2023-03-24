package com.Samson.JimApp;

import com.Samson.JimApp.training.entity.Training;
import com.Samson.JimApp.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long dayId;
    private LocalDate date;
    @OneToMany(mappedBy = "day")
    private List<Training> training;
    @OneToOne
    @JoinColumn( name = "user_id", referencedColumnName = "")
    private User user;
}
