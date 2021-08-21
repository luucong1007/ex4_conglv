package com.example.ex4_conglv.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hang_hoa", schema = "quan_ly_ban_hang")
public class HangHoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten_hang_hoa")
    private String tenHangHoa;

    @Column(name = "gia")
    private int gia;

    @Column(name = "xoa")
    private boolean xoa;

}
