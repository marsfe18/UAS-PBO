package com.marsay.kantinstis.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produk implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nama;
    private String deskripsi;
    @JoinColumn
    @ManyToOne
    private Kategori kategori;
    private BigDecimal harga;
    private Double stok;
    private String gambar;
}
