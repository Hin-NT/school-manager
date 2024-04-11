package com.example.SchoolManager.dao;

import com.example.SchoolManager.entity.Truong;

public interface DAO<T> {
    public Truong luu(T t);

    public String capNhat(T t);
}
