package com.addy.todo.todo.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Integer id;
@Column(unique=true)
private  String email;
private String password;
private String name ;
@OneToMany(mappedBy="user")
@JsonManagedReference
@JsonIgnore
private List <Todo> todo;
}
