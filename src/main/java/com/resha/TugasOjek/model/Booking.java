package com.resha.TugasOjek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "booking")
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable=false)
    @JsonIgnore
    private Driver driverId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable=false)
    @JsonIgnore
    private User userId;

    @Column
    private String lokasiAwal;

    @Column
    private String lokasiTujuan;

    public enum Payment{
        CASH, MBANKING, GOPAY
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "payment")
    private Payment payment;

    @Column(name = "harga")
    private int harga;

    public enum Status{
        PROGRESS, ACCEPTED, CANCELED, FINISHED
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "tanggal")
    private String tanggal;

    public Booking(){}

    public Booking(User user, Driver driver, String tanggal){
        this.userId = user;
        this.driverId = driver;
        this.tanggal = tanggal;
    }

    public Booking(int harga, String tanggal, Driver driver, User user, Status status, Payment payment, String lokasiAwal, String lokasiTujuan){
        this.harga = harga;
        this.userId = user;
        this.driverId = driver;
        this.tanggal = tanggal;
        this.status = status;
        this.payment = payment;
        this.lokasiAwal = lokasiAwal;
        this.lokasiTujuan = lokasiTujuan;
    }

}
