package com.marsay.kantinstis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.marsay.kantinstis.entity.Produk;
import com.marsay.kantinstis.exception.BadRequstException;
import com.marsay.kantinstis.exception.ResourceNotFoundException;
import com.marsay.kantinstis.repository.KategoriRepository;
import com.marsay.kantinstis.repository.ProdukRepository;

@Service
public class ProdukService {
    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> findAll() {
        return produkRepository.findAll();
    }

    public Produk findById(String id) {
        return produkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("kategori id = " + id + "tidak ada"));
    }

    public Produk create(Produk produk) {
        if (!StringUtils.hasText(produk.getNama())) {
            throw new BadRequstException("Nama produk tidak bole kosong");
        }

        if (produk.getKategori() == null) {
            throw new BadRequstException("Kategori tidak bole kosong");
        }
        if (!StringUtils.hasText(produk.getKategori().getId())) {
            throw new BadRequstException("Kategori Id tidak boleh kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId()).orElseThrow(() -> new BadRequstException(
                "Kategori Id" + produk.getKategori().getId() + "tidak ditemukan dalam database"));

        return produkRepository.save(produk);
    }

    public Produk edit(Produk produk) {
        if (!StringUtils.hasText(produk.getId().toString())) {
            throw new BadRequstException("produk id tidak bole kosong");
        }

        if (!StringUtils.hasText(produk.getNama())) {
            throw new BadRequstException("Nama produk tidak bole kosong");
        }

        if (produk.getKategori() == null) {
            throw new BadRequstException("Kategori tidak bole kosong");
        }
        if (!StringUtils.hasText(produk.getKategori().getId())) {
            throw new BadRequstException("Kategori Id tidak boleh kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId()).orElseThrow(() -> new BadRequstException(
                "Kategori Id" + produk.getKategori().getId() + "tidak ditemukan dalam database"));

        return produkRepository.save(produk);
    }

    public Produk ubahGambar(String id, String gambar) {
        Produk produk = findById(id);
        produk.setGambar(gambar);
        return produkRepository.save(produk);
    }

    public void deleteById(String id) {
        produkRepository.deleteById(id);
    }
}
