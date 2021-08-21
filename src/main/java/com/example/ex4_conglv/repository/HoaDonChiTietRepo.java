package com.example.ex4_conglv.repository;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTiet, Integer> {
    @Query("from HoaDonChiTiet hdct where hdct.xoa = false " +
            "and hdct.id =?1")
    Optional<HoaDonChiTiet> findById(int id);
}
