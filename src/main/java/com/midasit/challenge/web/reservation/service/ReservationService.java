package com.midasit.challenge.web.reservation.service;

import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;

public interface ReservationService<T> {
    public ResponseFormat response(ReservationCMD cmd, T data);
}
