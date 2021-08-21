package com.example.ex4_conglv.serviceImpl;

import com.example.ex4_conglv.entities.KhachHang;
import com.example.ex4_conglv.repository.KhachHangRepo;
import com.example.ex4_conglv.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepo  khachHangRepo;

    @Override
    public Optional<KhachHang> findById(int id) {
        try {
            return khachHangRepo.findById(id);

        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
