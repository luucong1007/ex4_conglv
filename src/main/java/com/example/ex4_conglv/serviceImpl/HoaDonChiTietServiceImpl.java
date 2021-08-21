package com.example.ex4_conglv.serviceImpl;

import com.example.ex4_conglv.entities.HoaDonChiTiet;
import com.example.ex4_conglv.entities.KhachHang;
import com.example.ex4_conglv.repository.HoaDonChiTietRepo;
import com.example.ex4_conglv.repository.KhachHangRepo;
import com.example.ex4_conglv.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;

    @Override
    public Optional<HoaDonChiTiet> findById(int id) {
        try {
            return hoaDonChiTietRepo.findById(id);

        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
