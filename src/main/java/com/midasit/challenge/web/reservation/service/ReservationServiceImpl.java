package com.midasit.challenge.web.reservation.service;

import com.midasit.challenge.web.coupon.domain.MakeCoupon;
import com.midasit.challenge.web.coupon.mapper.MakeCouponMapper;
import com.midasit.challenge.web.reservation.domain.Reservation;
import com.midasit.challenge.web.reservation.mapper.ReservationMapper;
import com.midasit.challenge.web.util.cmd.ReservationCMD;
import com.midasit.challenge.web.util.format.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    MakeCouponMapper makeCouponMapper;

    @Override
    public ResponseFormat response(ReservationCMD cmd, Object data) {
        ResponseFormat r = new ResponseFormat(cmd.description());
        try {
            int affected;
            switch (cmd) {
                case ADD_RESERVATION:
                    Reservation reservation = (Reservation) data;
                    affected = reservationMapper.insert(reservation);
                    if(reservation.getMakecoupon_id() != 0) {
                        MakeCoupon makeCoupon = new MakeCoupon();
                        makeCoupon.setMakecoupon_id(reservation.getMakecoupon_id());
                        makeCoupon = makeCouponMapper.select_by_coupon_id(makeCoupon);
                        makeCoupon.setState("USE");
                        makeCouponMapper.update_state(makeCoupon);
                        if(makeCoupon == null){
                            break;
                        }
                        makeCouponMapper.update(makeCoupon);
                    }
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
                case DELETE_RESERVATION:
                    r.setList(reservationMapper.delete((Reservation) data));
                    break;
                case INSERT_BOARD:
                    int idx = reservationMapper.insert((Reservation) data);
                    if(idx != 0)
                        r.setList(reservationMapper.view((Reservation) data));
                    break;
                case UPDATE_RESERVATION:
                    affected = reservationMapper.update((Reservation) data);
                    r.setList(affected == 0 ? null : affected);
                    break;
                case VIEW_COUPON:
                    r.setList(reservationMapper.view((Reservation) data));
                    break;
            }

            if (r.getList() == null)
                r.fail(cmd.code(), cmd.fail());
            else
                r.setCode(cmd.code());
        } catch(Exception e) {
            e.printStackTrace();
            r.fail(cmd.code(), e.getMessage());
        }

        return r;
    }

}
