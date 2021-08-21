package com.example.ex4_conglv.service;

import com.example.ex4_conglv.entities.NhanVien;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface NhanVienService {

    public Optional<NhanVien> findById(int id);
}
