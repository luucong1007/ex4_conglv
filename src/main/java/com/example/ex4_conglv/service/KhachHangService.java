package com.example.ex4_conglv.service;

import com.example.ex4_conglv.entities.KhachHang;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface KhachHangService {

    public Optional<KhachHang>  findById(int id);
}
