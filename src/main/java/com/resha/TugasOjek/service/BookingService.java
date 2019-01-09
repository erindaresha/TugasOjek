package com.resha.TugasOjek.service;

import com.resha.TugasOjek.model.Booking;

import java.util.List;

public interface BookingService {
    public abstract List<Booking> listHistoryByUserId(Long idUser);
    public abstract Booking getBookingById(Long idBooking);
    public abstract Booking cancelBooking(Long idBooking);
    public abstract Booking doneBooking(Long idBooking);
    public abstract Booking bookingDriver(Long idUser, Long idDriver, String tanggal);
    public abstract Booking createBooking(int harga, String tanggal, Long idDriver, Long idUser, Booking.Status statusBooking, Booking.Payment paymentMethod, String lokasiAwal, String lokasiTujuan);
    public abstract Booking updateBooking(Long idBooking, int harga, String tanggal, Long idDriver, Long idUser, Booking.Status statusBooking, Booking.Payment paymentMethod, String lokasiAwal, String lokasiTujuan);
    public abstract void deleteBooking(Long idBooking);
}
