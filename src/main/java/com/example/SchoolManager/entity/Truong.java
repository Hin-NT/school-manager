package com.example.SchoolManager.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "truong")
public class Truong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_truong")
    private int maTruong;

    @Column(name = "loai_truong")
    private int loaiTruong;

    @Column(name = "ten_truong")
    private String tenTruong;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @OneToMany(mappedBy = "truong", cascade = CascadeType.ALL)
    private List<Lop> danhSachLop;

    public Truong() {
    }

    public Truong(int maTruong, int loaiTruong, String tenTruong, String diaChi, String soDienThoai) {
        this.maTruong = maTruong;
        this.loaiTruong = loaiTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public int getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(int maTruong) {
        this.maTruong = maTruong;
    }

    public int getLoaiTruong() {
        return loaiTruong;
    }

    public void setLoaiTruong(int loaiTruong) {
        this.loaiTruong = loaiTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<Lop> getDanhSachLop() {
        return danhSachLop;
    }

    public void setDanhSachLop(List<Lop> danhSachLop) {
        this.danhSachLop = danhSachLop;
    }
}
