package com.midasit.challenge.web.reservation.mapper;

import com.midasit.challenge.web.reservation.domain.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReservationMapper {
    public List<Reservation> list();
    public Reservation view(Reservation board);
    public int insert(Reservation board);
    public int update(Reservation board);
    public int delete(Reservation board);
    public int select_by_group_id(Reservation board);
}
