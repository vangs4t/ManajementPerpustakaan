package com.write.service;

import com.book.entity.Buku;

import java.util.ArrayList;

public interface LibraryService {
    ArrayList<Buku> getLibrary();

    void addLibrary(String isbn, String judul,String penulis, String status);

    String searchLibrary(String isbn);

    void removeBook(Integer isbn);

    void rentBook(String isbn);

    void returBook(String isbn);

    Buku buku(String buku);

    Buku caribuku(String buku);
}
