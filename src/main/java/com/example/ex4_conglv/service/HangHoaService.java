package com.example.ex4_conglv.service;

import com.example.ex4_conglv.entities.HangHoa;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HangHoaService {

    public Optional<HangHoa> findById(int id);
}
