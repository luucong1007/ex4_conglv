package com.example.ex4_conglv.controller;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.KhachHang;
import com.example.ex4_conglv.service.HangHoaService;
import com.example.ex4_conglv.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    @PostMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<KhachHang> khachHang = khachHangService.findById(id);
        return ResponseEntity.ok(khachHang);
    }
}
