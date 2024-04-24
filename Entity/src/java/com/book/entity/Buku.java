package com.book.entity;

public class Buku {
    String isbn;
    String judul;
    String penulis;
    String statusPinjaman;

    boolean status;

    public Buku(String judul) {
        this.judul = judul;
    }

    public Buku(String isbn, String judul, String penulis, String statusPinjaman) {
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.statusPinjaman = statusPinjaman;
    }
    public String getStatusKetersediaan() {
        if (statusPinjaman.equals("Tersedia")) {
            return "Tersedia";
        } else {
            return "Dipinjam";
        }
    }

    public String getStatusPinjaman() {
        return statusPinjaman;
    }

    public void setStatusPinjaman(String statusPinjaman) {
        this.statusPinjaman = statusPinjaman;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
}
