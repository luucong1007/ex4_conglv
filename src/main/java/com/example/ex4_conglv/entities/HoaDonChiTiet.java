package com.example.ex4_conglv.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hoa_don_chi_tiet", schema = "quan_ly_ban_hang")
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "thanh_tien")
    private int thanhTien;

    @ManyToOne
    @JoinColumn(name = "hang_hoa_id")
    private HangHoa hangHoa;

    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
    private HoaDon hoaDon;

    @Column(name = "xoa")
    private boolean xoa;
}
