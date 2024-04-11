package com.example.SchoolManager.controller;

import com.example.SchoolManager.dao.TruongDAO;
import com.example.SchoolManager.dto.TruongDTO;
import com.example.SchoolManager.entity.Truong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/truong")
public class TruongController {
    private TruongDAO truongDAO;

    @Autowired
    public TruongController(TruongDAO truongDAO) {
        this.truongDAO = truongDAO;
    }

    @GetMapping("/")
    public ResponseEntity<List<TruongDTO>> hienThiDanhSachTruongHoc() {
        List<TruongDTO> danhSachTruong = truongDAO.hienThiTatCaTruongHoc();
        if (danhSachTruong.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(danhSachTruong, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruongDTO> layTruongTheoId(@PathVariable("id") int maTruong) {
        TruongDTO truongDTO = truongDAO.timTruongTheoIdDeHienThi(maTruong);
        if (truongDTO != null) {
            return ResponseEntity.ok().body(truongDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tim_ten")
    public ResponseEntity<List<TruongDTO>> timTruongTheoTen(@RequestParam(name = "ten") String tenTruong) {
        List<TruongDTO> truongDTOs = truongDAO.timTruongTheoTen(tenTruong);
        if (truongDTOs != null) {
            return ResponseEntity.ok().body(truongDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/them")
    public ResponseEntity<Truong> themTruong(@RequestBody Truong truong) {
        Truong luuTruong = truongDAO.luu(truong);
        return ResponseEntity.ok(luuTruong);
    }

    @DeleteMapping("/xoa/{id}")
    public ResponseEntity<String> xoaTruong(@PathVariable("id") int id) {
        String xoaTruong = truongDAO.xoaTruongTheoId(id);
        return ResponseEntity.ok(xoaTruong);
    }

    @PutMapping("/cap_nhat")
    public ResponseEntity<String> capNhatTruong(@RequestBody Truong truong){
            String capNhatTruong = truongDAO.capNhat(truong);
            return ResponseEntity.ok(capNhatTruong);
    }

}
