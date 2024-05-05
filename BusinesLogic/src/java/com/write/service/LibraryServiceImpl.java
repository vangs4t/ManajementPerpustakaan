package com.write.service;

import com.book.entity.Buku;
import com.paper.repository.LibraryRepo;

import java.util.ArrayList;

public class LibraryServiceImpl implements LibraryService{
    LibraryRepo repo;
    public LibraryServiceImpl(LibraryRepo repo) {
        this.repo = repo;
    }

    public Buku get(String judul){
        var buku = repo.selectBook(judul);
        if (buku != null){
            return buku;
        } else {
            throw new IllegalArgumentException("Buku tidak ditemukan");
        }
    }

    @Override
    public ArrayList<Buku> getLibrary() {
        return repo.getAll();
    }

    @Override
    public void addLibrary(String isbn, String judul, String penulis, String status) {
        repo.add(isbn,judul ,penulis, status);
    }


    @Override
    public String searchLibrary(String judul) {
        return repo.search(judul);
    }

    @Override
    public void removeBook(Integer isbn) {
        repo.remove(isbn);
    }

    @Override
    public void rentBook(String isbn) {
        for (Buku buku : repo.getAll()) {
            if (buku.getIsbn().equalsIgnoreCase(isbn) && buku.getStatusPinjaman().equals("Tersedia")) {
                buku.setStatusPinjaman("Dipinjam");
                System.out.println("Buku dengan isbn \"" + isbn + "\" telah berhasil dipinjam.");
                return;
            }
        }
        System.out.println("Buku dengan isbn \"" + isbn + "\" tidak ditemukan atau sudah dipinjam seseorang.");
    }


    @Override
    public void returBook(String isbn) {
        boolean bukuDitemukan = false;
        for (Buku buku : repo.getAll()) {
            if (buku.getIsbn().equalsIgnoreCase(isbn) && buku.getStatusPinjaman().equals("Dipinjam")) {
                buku.setStatusPinjaman("Tersedia");
                bukuDitemukan = true;
                System.out.println("Buku dengan isbn \"" + isbn + "\" telah berhasil dikembalikan.");
                break;
            }
        }
        if (!bukuDitemukan) {
            System.out.println("Buku dengan isbn \"" + isbn + "\" tidak ditemukan atau belum dipinjam.");
        }
    }

    @Override
    public Buku buku(String buku) {
        return null;
    }

    @Override
    public Buku caribuku(String buku) {
        return new Buku(buku);
    }
}
