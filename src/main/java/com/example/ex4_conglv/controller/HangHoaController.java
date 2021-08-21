package com.example.ex4_conglv.controller;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.service.HangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/hang-hoa")
public class HangHoaController {

    @Autowired
    HangHoaService hangHoaService;

    @PostMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<HangHoa> hangHoas = hangHoaService.findById(id);
        return ResponseEntity.ok(hangHoas);
    }


}
