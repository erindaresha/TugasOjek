package com.resha.TugasOjek.service.impl;

import com.resha.TugasOjek.model.Booking;
import com.resha.TugasOjek.model.Driver;
import com.resha.TugasOjek.model.User;
import com.resha.TugasOjek.repository.BookingRepository;
import com.resha.TugasOjek.repository.DriverRepository;
import com.resha.TugasOjek.repository.UserRepository;
import com.resha.TugasOjek.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Booking> listHistoryByUserId(Long idUser) {
        return bookingRepository.findAllByUserIdAndStatus(idUser, Booking.Status.FINISHED);
    }

    @Override
    public Booking getBookingById(Long idBooking) {
        return bookingRepository.findBookingById(idBooking);
    }

    @Override
    public Booking cancelBooking(Long idBooking) {
        Booking booking = bookingRepository.findBookingById(idBooking);
        booking.setStatus(Booking.Status.CANCELED);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking doneBooking(Long idBooking) {
        Booking booking = bookingRepository.findBookingById(idBooking);
        booking.setStatus(Booking.Status.FINISHED);

        //kurangi balance user
        User user = booking.getUserId();
        user.setBalance(user.getBalance()-booking.getHarga());
        userRepository.save(user);

        //tambah balance driver
        Driver driver = booking.getDriverId();
        driver.setBalance(driver.getBalance()+booking.getHarga());
        driverRepository.save(driver);

        //save booking
        return bookingRepository.save(booking);
    }

    @Override
    public Booking bookingDriver(Long idUser, Long idDriver, String tanggal) {
        User user = userRepository.findById(idUser);
        Driver driver = driverRepository.findById(idDriver);
        Booking booking = new Booking(user,driver,tanggal);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking createBooking(int harga, String tanggal, Long idDriver, Long idUser, Booking.Status statusBooking, Booking.Payment paymentMethod, String lokasiAwal, String lokasiTujuan) {
        User user = userRepository.findById(idUser);
        Driver driver = driverRepository.findById(idDriver);
        Booking booking = new Booking(harga, tanggal, driver, user, statusBooking, paymentMethod, lokasiAwal, lokasiTujuan);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long idBooking, int harga, String tanggal, Long idDriver, Long idUser, Booking.Status statusBooking, Booking.Payment paymentMethod, String lokasiAwal, String lokasiTujuan) {
        User user = userRepository.findById(idUser);
        Driver driver = driverRepository.findById(idDriver);
        Booking booking = bookingRepository.findBookingById(idBooking);
        booking.setHarga(harga);
        booking.setTanggal(tanggal);
        booking.setUserId(user);
        booking.setDriverId(driver);
        booking.setStatus(statusBooking);
        booking.setPayment(paymentMethod);
        booking.setLokasiAwal(lokasiAwal);
        booking.setLokasiTujuan(lokasiTujuan);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long idBooking) {
        bookingRepository.delete(idBooking);
    }
}
