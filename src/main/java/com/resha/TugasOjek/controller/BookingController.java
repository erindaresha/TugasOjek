package com.resha.TugasOjek.controller;

import com.resha.TugasOjek.model.Booking;
import com.resha.TugasOjek.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class BookingController {
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = {"/api/getBookingHistory/{userId}"}, method = RequestMethod.GET)
    public List<Booking> getBookingHistory(@PathVariable("userId") Long userId){
        return bookingService.listHistoryByUserId(userId);
    }

    @RequestMapping(value = {"/api/cancelBooking/{bookingId}"}, method = RequestMethod.PUT)
    public Booking cancelBooking(@PathVariable("bookingId") Long bookingId){
        return bookingService.cancelBooking(bookingId);
    }

    @RequestMapping(value = {"/api/doneBooking/{bookingId}"}, method = RequestMethod.PUT)
    public Booking doneBooking(@PathVariable("bookingId") Long bookingId){
        return bookingService.doneBooking(bookingId);
    }

    @RequestMapping(value = {"/api/bookingDriver/{idUser}/{idDriver}/{tanggal}"}, method = RequestMethod.POST)
    public Booking bookingDriver(@PathVariable("idUser") Long idUser, @PathVariable("idDriver") Long idDriver, @PathVariable("tanggal") String tanggal){
        return bookingService.bookingDriver(idUser,idDriver,tanggal);
    }
}
