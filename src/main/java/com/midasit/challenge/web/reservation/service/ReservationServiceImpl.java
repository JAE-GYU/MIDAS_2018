package com.midasit.challenge.web.reservation.service;

import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.reservation.mapper.ReservationMapper;
import com.midasit.challenge.web.util.cmd.CMD;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public ResponseFormat response(ReservationCMD cmd, Object data) {
        ResponseFormat r = new ResponseFormat(cmd.description());
        try {
            int affected;
            switch (cmd) {
                case ADD_RESERVATION:
                    affected = reservationMapper.insert((Reservation) data);
                    r.setList(affected == 0 ? null : data);
                    break;
                case LIST_BOARD:
                    r.setList(reservationMapper.view((Reservation) data));
                    break;
                case GET_GROUP_ID:
                    r.setList(reservationMapper.select_by_group_id((Reservation) data));
                    break;
                case VIEW_RESERVATION:
                    r.setList(reservationMapper.list());
                    break;
                case VIEW_BOARD:
                    r.setList(reservationMapper.view((Reservation) data));
                    break;
                case INSERT_BOARD:
                    int idx = reservationMapper.insert((Reservation) data);
                    if(idx != 0)
                        r.setList(reservationMapper.view((Reservation) data));
                    break;
                case UPDATE_BOARD:
                    affected = reservationMapper.update((Reservation) data);
                    r.setList(affected == 0 ? null : affected);
                    break;
                case DELETE_BOARD:
                    affected = reservationMapper.delete((Reservation) data);
                    r.setList(affected == 0 ? null : affected);
                    break;
            }

            if (r.getList() == null)
                r.fail(cmd.code(), cmd.fail());
        } catch(Exception e) {
            r.fail(cmd.code(), e.getMessage());
        }

        return r;
    }

}
