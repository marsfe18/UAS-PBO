package com.marsay.kantinstis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marsay.kantinstis.entity.Pengguna;

public interface PenggunaRepository extends JpaRepository<Pengguna, String> {

    Boolean existsByEmail(String email);
}
