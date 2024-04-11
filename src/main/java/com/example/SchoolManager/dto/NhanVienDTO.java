package com.example.SchoolManager.dto;

import com.example.SchoolManager.entity.Lop;
import com.example.SchoolManager.entity.NhanVien;
import lombok.Data;

@Data
public class NhanVienDTO {
    private Integer maNhanVien;
    private String tenNhanVien;
    private String soDienThoai;
    private String ngaySinh;
    private String vaiTro;

    public NhanVienDTO(NhanVien nhanVien) {
        this.maNhanVien = nhanVien.getMaNhanVien();
        this.tenNhanVien = nhanVien.getTenNhanVien();
        this.soDienThoai = nhanVien.getSoDienThoai();
        this.ngaySinh = nhanVien.getNgaySinh();
        this.vaiTro = nhanVien.getVaiTro();
    }
}
