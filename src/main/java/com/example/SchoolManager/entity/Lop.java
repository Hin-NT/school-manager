package com.example.SchoolManager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lop")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_lop")
    private int maLop;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_truong")
    private Truong truong;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_nhan_vien")
    private NhanVien nhanVien;

    @Column(name = "ten_lop")
    private String tenLop;

    @Column(name = "khoi_hoc")
    private int khoiHoc;

    @Column(name = "nien_khoa")
    private String nienKhoa;

    public Lop() {
    }

    public Lop(int maLop, Truong truong, NhanVien nhanVien, String tenLop, int khoiHoc, String nienKhoa) {
        this.maLop = maLop;
        this.truong = truong;
        this.nhanVien = nhanVien;
        this.tenLop = tenLop;
        this.khoiHoc = khoiHoc;
        this.nienKhoa = nienKhoa;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public Truong getTruong() {
        return truong;
    }

    public void setTruong(Truong truong) {
        this.truong = truong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getKhoiHoc() {
        return khoiHoc;
    }

    public void setKhoiHoc(int khoiHoc) {
        this.khoiHoc = khoiHoc;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }
}
