package com.resha.TugasOjek.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private int balance;

    public User(){}

    public User(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

}
