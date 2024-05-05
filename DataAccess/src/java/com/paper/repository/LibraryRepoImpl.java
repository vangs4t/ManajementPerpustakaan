package com.paper.repository;

import com.book.entity.Buku;

import java.util.ArrayList;

public class LibraryRepoImpl implements LibraryRepo{
    ArrayList<Buku> data = new ArrayList<>();

    @Override
    public ArrayList<Buku> getAll() {
        return data;
    }

    @Override
    public void add(String isbn, String judul, String penulis, String status) {
        data.add(new Buku(isbn, judul, penulis, status));
    }

    public String search(String judul){
        int index;
        String output = "";
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getJudul().equalsIgnoreCase(judul)){
                index = i;
                output = data.get(index).getJudul();
                System.out.println("Buku yang anda cari ada, Silahkan Cek ketersediaan nya di Daftar buku");
                return output;
            }
        }
        System.out.println("Sepertinya Buku Belum di tambahkan :(");
        return output;
    }


    @Override
    public void remove(Integer isbn) {
        data.remove(isbn - 1);
    }

    @Override
    public Buku selectBook(String judul) {
        return null;
    }
}























