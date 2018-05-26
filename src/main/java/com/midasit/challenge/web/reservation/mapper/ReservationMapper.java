package com.midasit.challenge.web.reservation.mapper;

import com.midasit.challenge.web.reservation.domain.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {
    public List<Reservation> list();
    public Reservation view(Reservation board);
    public int insert(Reservation board);
    public int update(Reservation board);
    public int delete(Reservation board);
}
