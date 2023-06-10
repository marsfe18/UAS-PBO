package com.marsay.kantinstis.service;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marsay.kantinstis.entity.Kategori;
import com.marsay.kantinstis.exception.ResourceNotFoundException;
import com.marsay.kantinstis.repository.KategoriRepository;

@Service
public class KategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;

    public Kategori findById(String id) {
        return kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("kategori id = " + id + "tidak ada"));
    }

    public java.util.List<Kategori> findAll() {
        return kategoriRepository.findAll();
    }

    public Kategori create(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    public Kategori edit(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    public void deleteById(String id) {
        kategoriRepository.deleteById(id);
    }
}
