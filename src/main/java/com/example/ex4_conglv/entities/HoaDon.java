package com.example.ex4_conglv.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hoa_don", schema = "quan_ly_ban_hang")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "thoi_gian")
    private Date thoiGian;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_id")
    private NhanVien nhanVien;

    @Column(name = "trang_thai")
    private int trangThai;

    @Column(name = "tongTien")
    private int tongTien;

    @Column(name = "tien_khach_tra")
    private int tienKhachTra;

    @Column(name = "tien_tra_lai_khach")
    private int tienTraLaiKhach;

    @Column(name = "xoa")
    private boolean xoa;
}
