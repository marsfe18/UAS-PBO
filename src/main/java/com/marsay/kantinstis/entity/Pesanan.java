package com.marsay.kantinstis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.marsay.kantinstis.model.StatusPesanan;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Pesanan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String nomor;
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    private String alamat;
    private BigDecimal jumlah;
    @Enumerated(EnumType.STRING)
    private StatusPesanan status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPesan;

}
