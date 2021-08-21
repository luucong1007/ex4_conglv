package com.example.ex4_conglv.controller;

import com.example.ex4_conglv.dto.HoaDonDTO;
import com.example.ex4_conglv.entities.HangHoa;
import com.example.ex4_conglv.entities.HoaDon;
import com.example.ex4_conglv.service.HangHoaService;
import com.example.ex4_conglv.service.HoaDonService;
import com.example.ex4_conglv.service.KhachHangService;
import com.example.ex4_conglv.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    NhanVienService nhanVienService;

    @PostMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
        Optional<HoaDon> hangHoas = hoaDonService.findById(id);
        return ResponseEntity.ok(hangHoas);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "thoiGian", required = false, defaultValue = "2021-08-21") String thoiGian,
                                    @RequestParam(name = "trangThai", required = false, defaultValue = "1") int trangThai,
                                    @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<HoaDon> hoaDons = hoaDonService.search(thoiGian, trangThai, pageable);
        return ResponseEntity.ok(hoaDons);
    }

    @PostMapping("/save")   //      bao gồm thông tin hóa đơn, danh sách hóa đơn chi tiết, khách hàng id, nhân viên id
    public ResponseEntity<?> save(@RequestBody HoaDonDTO hoaDon1,
                                  @RequestParam("khach_hang_id") int khachHangId,
                                  @RequestParam("nhan_vien_id") int nhanVienId) {
        HoaDon hoaDon = new HoaDon();
        return khachHangService.findById(khachHangId)
                .map(khachHang -> {
                    hoaDon.setKhachHang(khachHang);
                    return nhanVienService.findById(nhanVienId)
                            .map(nhanVien -> {
                                hoaDon.setMa(hoaDon1.getMa());
                                hoaDon.setThoiGian(hoaDon1.getThoiGian());
                                hoaDon.setTrangThai(hoaDon1.getTrangThai());
                                hoaDon.setTongTien(hoaDon1.getTongTien());
                                hoaDon.setTienKhachTra(hoaDon1.getTienKhachTra());
                                hoaDon.setTienTraLaiKhach(hoaDon1.getTienTraLaiKhach());
                                hoaDon.setNhanVien(nhanVien);
                                hoaDonService.save(hoaDon);
                                return ResponseEntity.ok("success");
                            }).orElse(ResponseEntity.ok("Nhan vien id not found"));
                }).orElse(ResponseEntity.ok("khach hang id not found"));
    }


    @PutMapping("/update")
    // update trạng thái    1: tạo hóa đơn
                    //		2: tạo hóa đơn thành công
                    //		3: tạo hóa đơn thất bại
                    //		4: đang vận chuyển

    public ResponseEntity<?> update(@RequestBody HoaDonDTO hoaDonDTO,
                                    @RequestParam("nhan_vien_id") int nhanVienId,
                                    @RequestParam("khach_hang_id") int khachHangId) {
        return hoaDonService.findById(hoaDonDTO.getId())
                .map(hoaDon -> {
                    return khachHangService.findById(khachHangId)
                            .map(khachHang -> {
                                return nhanVienService.findById(nhanVienId)
                                        .map(nhanVien -> {
                                            hoaDon.setTrangThai(hoaDonDTO.getTrangThai());
                                            hoaDon.setNhanVien(nhanVien);
                                            hoaDon.setKhachHang(khachHang);
                                            hoaDonService.save(hoaDon);
                                            return ResponseEntity.ok("success");
                                        }).orElse(ResponseEntity.ok("nhan vien id not found"));
                            }).orElse(ResponseEntity.ok("khach hang id not found"));
                }).orElse(ResponseEntity.ok("hoa don id not found"));
    }

}