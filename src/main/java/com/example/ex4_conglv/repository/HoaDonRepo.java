package com.example.ex4_conglv.repository;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Integer> {

    @Query("from HoaDon hd where hd.xoa = false " +
            "and hd.id =?1")
    Optional<HoaDon> findById(int id);

    @Query(value = " from HoaDon hoaDon where 1=1 and "+
            " (?1 is null or hoaDon.thoiGian = ?1)" +
            " and (?2 is null or  hoaDon.trangThai = ?2) " +
            " and hoaDon.xoa = false ")
    Page<HoaDon> search(String thoiGian, int trangThai, Pageable pageable);

}
