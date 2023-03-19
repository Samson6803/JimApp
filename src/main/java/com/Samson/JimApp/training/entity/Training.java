package com.Samson.JimApp.training.entity;

import com.Samson.JimApp.User.entity.User;
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
    private String date;
    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
}
