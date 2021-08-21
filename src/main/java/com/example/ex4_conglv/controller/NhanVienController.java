package com.example.ex4_conglv.controller;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.NhanVien;
import com.example.ex4_conglv.service.HangHoaService;
import com.example.ex4_conglv.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;

    @PostMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id){
        Optional<NhanVien> nhanVien = nhanVienService.findById(id);
        return ResponseEntity.ok(nhanVien);
    }
}
