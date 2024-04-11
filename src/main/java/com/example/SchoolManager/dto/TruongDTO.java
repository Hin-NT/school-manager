package com.example.SchoolManager.dto;

import com.example.SchoolManager.entity.Truong;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class TruongDTO {
    private Integer maTruong;
    private Integer loaiTruong;
    private String tenTruong;
    private String diaChi;
    private String soDienThoai;
    private List<LopDTO> danhSachLops;

    public TruongDTO(Truong truong, int choose) {
        this.maTruong = truong.getMaTruong();
        this.loaiTruong = truong.getLoaiTruong();
        this.tenTruong = truong.getTenTruong();
        this.diaChi = truong.getDiaChi();
        this.soDienThoai = truong.getSoDienThoai();

        if(choose == 0){
            this.danhSachLops = truong.getDanhSachLop()
                    .stream()
                    .map(LopDTO::new)
                    .collect(Collectors.toList());
        }
    }
}
