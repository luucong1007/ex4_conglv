package com.example.ex4_conglv.repository;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien, Integer> {

    @Query("from NhanVien nv where nv.xoa = false " +
            "and nv.id =?1")
    Optional<NhanVien> findById(int id);
}
