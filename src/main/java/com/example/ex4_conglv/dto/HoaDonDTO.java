package com.example.ex4_conglv.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HoaDonDTO {
    private int id;

    private String ma;

    private Date thoiGian;

    private int trangThai;

    private int tongTien;

    private int tienKhachTra;

    private int tienTraLaiKhach;

    private boolean xoa;

}
