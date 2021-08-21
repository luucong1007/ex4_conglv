package com.example.ex4_conglv.serviceImpl;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.repository.HangHoaRepo;
import com.example.ex4_conglv.service.HangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HangHoaServiceImpl implements HangHoaService {

    @Autowired
    HangHoaRepo hangHoaRepo;

    @Override
    public Optional<HangHoa> findById(int id) {
        try {
            return hangHoaRepo.findById(id);

        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
