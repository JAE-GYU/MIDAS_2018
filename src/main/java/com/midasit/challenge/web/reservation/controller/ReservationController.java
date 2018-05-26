package com.midasit.challenge.web.reservation.controller;

import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.reservation.service.ReservationService;
import com.midasit.challenge.web.user.model.User;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import io.reactivex.Observable;
import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public ResponseFormat addReservation(HttpSession httpSession, @RequestBody Reservation[] reservation) {
        int group_id = 0;
        try {
            group_id = (int) svc.response(ReservationCMD.GET_GROUP_ID, null).getList();
        } catch (Exception e) {
            group_id = 0;
        }
        ResponseFormat responseFormat = new ResponseFormat();
        for (Reservation res : reservation) {
            res.setGroup_id(group_id + 1);
            // 권한 검사 나중에 jwt로 바꿀려고하기에 임시
//            if(isSession(httpSession)){
//                User user = (User)httpSession.getAttribute("user");
            res.setUser_id(1);
//            }

            responseFormat = svc.response(ReservationCMD.ADD_RESERVATION, res);
        }
        return responseFormat;
    }

    @PutMapping
    private ResponseFormat update(@RequestBody Reservation reservation) {
        ResponseFormat responseFormat = svc.response(ReservationCMD.UPDATE_RESERVATION, reservation);
        return responseFormat;
    }

    @DeleteMapping("/{id}")
    public ResponseFormat delete(@PathVariable int id) {
        Reservation reservation = new Reservation();
        reservation.setReservation_id(id);
        return svc.response(ReservationCMD.DELETE_RESERVATION, reservation);
    }

    private Boolean isSession(HttpSession session) {
        return session.getAttribute("user") != null;
    }
}
