package com.example.SchoolManager.dao;

import com.example.SchoolManager.dto.TruongDTO;
import com.example.SchoolManager.entity.Truong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class TruongDAO implements DAO<Truong> {
    private EntityManager entityManager;

    @Autowired
    public TruongDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Truong timTruongTheoId(int id) {
        TypedQuery<Truong> truongTypedQuery = entityManager.createQuery("select t from Truong t where t.maTruong=:x", Truong.class);
        truongTypedQuery.setParameter("x", id);
        if (truongTypedQuery.getSingleResult() == null) {
            return null;
        } else {
            return truongTypedQuery.getSingleResult();
        }

    }

    public TruongDTO timTruongTheoIdDeHienThi(int id) {
        TypedQuery<Truong> truongTypedQuery = entityManager.createQuery("select t from Truong t where t.maTruong=:x ORDER BY t.maTruong DESC", Truong.class);
        truongTypedQuery.setParameter("x", id);
        return new TruongDTO(truongTypedQuery.getSingleResult(), 0);
    }

    // Hàm xóa dấu tiếng Việt
    public String xoaUnikey(String tenTruong) {
        if (tenTruong == null) {
            return null; // hoặc có thể trả về chuỗi rỗng tùy thuộc vào yêu cầu
        }

        String decomposed = Normalizer.normalize(tenTruong.toLowerCase(), Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String result = pattern.matcher(decomposed).replaceAll("");

        // Kiểm tra chuỗi sau khi xử lý
        return result.isEmpty() ? null : result.replace("đ", "d");
    }

    public List<TruongDTO> timTruongTheoTen(String tenTruong) {
        if (tenTruong == null || tenTruong.trim().isEmpty()) {
            return null;
        }

        String xoaTenTruong = xoaUnikey(tenTruong);
        if (xoaTenTruong.isEmpty()) {
            return null;
        }
        TypedQuery<Truong> truongTypedQuery = entityManager.createQuery(
                "SELECT t FROM Truong t WHERE t.tenTruong LIKE :x", Truong.class);
        truongTypedQuery.setParameter("x", "%" + xoaTenTruong + "%");

        List<Truong> resultList = truongTypedQuery.getResultList();

        return resultList
                .stream()
                .map(sanPham -> new TruongDTO(sanPham, -1))
                .collect(Collectors.toList());
    }

    public List<TruongDTO> hienThiTatCaTruongHoc() {
        TypedQuery<Truong> truongTypedQuery = entityManager.createQuery("SELECT t from Truong t order by t.maTruong desc ", Truong.class);
        return truongTypedQuery.getResultList()
                .stream()
                .map(truong -> new TruongDTO(truong, -1))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Truong luu(Truong truong) {
        entityManager.persist(truong);
        entityManager.flush();
        return truong;
    }

    @Transactional
    public String xoaTruongTheoId(int id) {
        Truong deleteTruong = timTruongTheoId(id);
        if (deleteTruong != null) {
            entityManager.remove(deleteTruong);
            return "Xóa thành công trường học!";
        } else {
            return "Không tìm thấy trường để xóa!";
        }

    }

    @Override
    @Transactional
    public String capNhat(Truong truong) {
        Truong existingTruong = entityManager.find(Truong.class, truong.getMaTruong());

        if (existingTruong != null) {
            entityManager.merge(truong);
            entityManager.flush();
            return "Cập nhật thành công!";
        } else {
            return "Không tìm thấy trường để cập nhật!";
        }
    }
}
