package com.paper.repository;

import com.book.entity.Buku;

import java.util.ArrayList;

public interface LibraryRepo {
    ArrayList<Buku> getAll();

    void add(String isbn, String judul, String penulis, String status);

    String search(String judul);

    void remove(Integer isbn);

    Buku selectBook(String judul);
}
