package com.midasit.challenge.web.reservation.controller;

import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.reservation.service.ReservationService;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService svc;

    @PostMapping
    public ResponseFormat addReservation(@RequestBody Reservation reservation) {
        return svc.response(ReservationCMD.ADD_RESERVATION, reservation);
    }

}
