package com.addy.todo.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Todo {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private  Integer id;

    private String heading;
     private String  work;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

}
