package com.midasit.challenge.web.reservation.controller;

import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.reservation.service.ReservationService;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService svc;

    @GetMapping
    public ResponseFormat list() {
        return svc.response(ReservationCMD.VIEW_RESERVATION, null);
    }

    @PostMapping
    public ResponseFormat addReservation(@RequestBody Reservation[] reservation) {
        int group_id = (int) svc.response(ReservationCMD.GET_GROUP_ID, null).getList();
//        Arrays.stream(reservation)
//                .map(initReservation(group_id))
//        Arrays.stream(reservation)
//                .forEach(e -> e.setComment());
        return svc.response(ReservationCMD.ADD_RESERVATION, reservation);
    }

    private void initReservation(int group_id) {

    }
}
