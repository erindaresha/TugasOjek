package com.resha.TugasOjek.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "driver")
public class Driver{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private int balance;

    public Driver(){}

    public Driver(String name, int balance){
        this.name = name;
        this.balance = balance;
    }
}
