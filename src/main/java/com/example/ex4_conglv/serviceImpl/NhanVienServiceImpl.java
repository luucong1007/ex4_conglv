package com.example.ex4_conglv.serviceImpl;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.NhanVien;
import com.example.ex4_conglv.repository.HangHoaRepo;
import com.example.ex4_conglv.repository.NhanVienRepo;
import com.example.ex4_conglv.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRepo nhanVienRepo;

    @Override
    public Optional<NhanVien> findById(int id) {
        try {
            return nhanVienRepo.findById(id);

        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
