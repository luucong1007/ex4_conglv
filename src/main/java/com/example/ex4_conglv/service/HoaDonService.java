package com.example.ex4_conglv.service;

import com.example.ex4_conglv.dto.HoaDonDTO;
import com.example.ex4_conglv.entities.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public interface HoaDonService {

    Optional<HoaDon> findById(int id);

    Page<HoaDon> search(Date batDau, Date ketThuc, Integer trangThai, Pageable pageable);

    Optional<HoaDon> save(HoaDon hoaDon);

    Optional<HoaDon> update(HoaDonDTO hoaDonDTO);


}
