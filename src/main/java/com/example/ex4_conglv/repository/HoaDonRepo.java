package com.example.ex4_conglv.repository;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Integer> {

    @Query(" from HoaDon hd where hd.xoa = false " +
            "and hd.id =?1")
    Optional<HoaDon> findById(int id);

    @Query( " from HoaDon hd where 1=1 and "+
            " (hd.thoiGian >= ?1 and hd.thoiGian <= ?2)" +
            " and (?3 is null or hd.trangThai = ?3)" +
            " and hd.xoa = false ")
    Page<HoaDon> search(Date batDau, Date ketThuc, Integer trangThai, Pageable pageable);

    //   SELECT * FROM quan_ly_ban_hang.hoa_don hd where
    //	hd.thoi_gian >= '2021-08-20' and hd.thoi_gian <= '2021-08-28'
    //	and hd.trang_thai = 4 and hd.xoa = false;
}
