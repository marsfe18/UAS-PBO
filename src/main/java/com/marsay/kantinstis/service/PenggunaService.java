package com.marsay.kantinstis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.marsay.kantinstis.entity.Pengguna;
import com.marsay.kantinstis.exception.BadRequstException;
import com.marsay.kantinstis.exception.ResourceNotFoundException;
import com.marsay.kantinstis.repository.PenggunaRepository;

@Service
public class PenggunaService {
    @Autowired
    private PenggunaRepository penggunaRepository;

    public Pengguna findById(String id) {
        return penggunaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("pengguna id = " + id + "tidak ada"));
    }

    public java.util.List<Pengguna> findAll() {
        return penggunaRepository.findAll();
    }

    public Pengguna create(Pengguna pengguna) {
        if (!StringUtils.hasText(pengguna.getId())) {
            throw new BadRequstException("Username harus diisi");
        }

        if (penggunaRepository.existsById(pengguna.getId())) {
            throw new BadRequstException("Username telah terpakai");
        }

        if (!StringUtils.hasText(pengguna.getEmail())) {
            throw new BadRequstException("email harus diisi");
        }

        if (penggunaRepository.existsByEmail(pengguna.getEmail())) {
            throw new BadRequstException("Email telah Digunakan");
        }

        return penggunaRepository.save(pengguna);
    }

    public Pengguna edit(Pengguna pengguna) {
        if (!StringUtils.hasText(pengguna.getId())) {
            throw new BadRequstException("Username harus diisi");
        }

        if (!StringUtils.hasText(pengguna.getEmail())) {
            throw new BadRequstException("email harus diisi");
        }

        return penggunaRepository.save(pengguna);
    }

    public void deleteById(String id) {
        penggunaRepository.deleteById(id);
    }
}
