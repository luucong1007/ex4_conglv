package com.example.ex4_conglv.serviceImpl;

import com.example.ex4_conglv.dto.HoaDonDTO;
import com.example.ex4_conglv.entities.HoaDon;
import com.example.ex4_conglv.entities.KhachHang;
import com.example.ex4_conglv.repository.HoaDonRepo;
import com.example.ex4_conglv.repository.KhachHangRepo;
import com.example.ex4_conglv.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public Optional<HoaDon> findById(int id) {
            try {
                return hoaDonRepo.findById(id);

            } catch (Exception e) {
                return Optional.empty();
            }
    }

    @Override
    public Page<HoaDon> search(String thoiGian, int trangThai, Pageable pageable) {
        try {

            return hoaDonRepo.search(thoiGian,trangThai, pageable);

        } catch (Exception e) {
            return Page.empty();
        }
    }

    @Override
    public Optional<HoaDon> save(HoaDon hoaDon) {
        try {
            return Optional.ofNullable(hoaDonRepo.save(hoaDon));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<HoaDon> update(HoaDonDTO hoaDonDTO) {
        try{
            Optional<HoaDon> hoaDonOptional = findById(hoaDonDTO.getId());
            if(!hoaDonOptional.isPresent()){
                return Optional.empty();
            }
            HoaDon hd = hoaDonOptional.get();
            return Optional.ofNullable(hoaDonRepo.save(hd));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}