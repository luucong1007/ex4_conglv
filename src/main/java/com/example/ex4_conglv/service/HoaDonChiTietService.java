package com.example.ex4_conglv.service;

import com.example.ex4_conglv.entities.HoaDonChiTiet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HoaDonChiTietService {
    public Optional<HoaDonChiTiet> findById(int id);
}
