package com.example.ex4_conglv.repository;

import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HangHoaRepo extends JpaRepository<HoaDon,Integer> {

    @Query("from HangHoa hh where hh.xoa = false " +
            "and hh.id =?1")
    Optional<HangHoa> findById(int id);
}
