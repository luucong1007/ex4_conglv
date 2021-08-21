package com.example.ex4_conglv.repository;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Integer> {
    @Query("from KhachHang kh where kh.xoa = false " +
            "and kh.id =?1")
    Optional<KhachHang> findById(int id);
}
