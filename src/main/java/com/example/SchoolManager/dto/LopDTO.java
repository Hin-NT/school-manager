package com.example.SchoolManager.dto;

import com.example.SchoolManager.entity.Lop;
import com.example.SchoolManager.entity.NhanVien;
import com.example.SchoolManager.entity.Truong;
import lombok.Data;

@Data
public class LopDTO {
    private Integer maLop;
    private Truong truong;
    private NhanVien nhanVien;
    private String tenLop;
    private Integer khoiHoc;
    private String nienKhoa;

    public LopDTO(Lop lop) {
        this.maLop = lop.getMaLop();
        this.truong = lop.getTruong();
        this.nhanVien = lop.getNhanVien();
        this.tenLop = lop.getTenLop();
        this.khoiHoc = lop.getKhoiHoc();
        this.nienKhoa = lop.getNienKhoa();
    }
}
