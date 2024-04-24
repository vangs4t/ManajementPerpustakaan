package com.cover.View;
import com.book.entity.Buku;
import com.write.service.LibraryService;

import java.util.Scanner;
import static com.book.utility.LibraryUtility.*;

public class ViewImpl implements View {
    LibraryService service;

    public ViewImpl(LibraryService service) {
        this.service = service;
    }
    public static Scanner scanner = new Scanner(System.in);
    @Override
    public void mainMenu() {
            clearScreen();
            garis();
            System.out.println("---PERPUSTAKAAN TERMINAL---");
            System.out.println("Selamat Datang Di perpustakaan Terminal..!!");
            System.out.println("Silahkan Pilih");
            System.out.println("1. Donasikan Buku");
            System.out.println("2. Cari Buku Yang Di inginkan");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Tampilkan Daftar Buku");
            System.out.println("6. Keluar");
            garis();
            String dataInput = input("Masukan Pilihan anda");
            if (dataInput.equals("1")) {
                tambahBuku();
            } else if (dataInput.equals("2")) {
                cariBuku();
            } else if (dataInput.equals("3")) {
                pinjamBuku();
            } else if (dataInput.equals("4")) {
                kembalikanBuku();
            } else if (dataInput.equals("5")) {
                listLibrary();
            } else if (dataInput.equals("6")) {
                scanner.close();
            }
    }

    @Override
    public void tambahBuku() {
        boolean tambahlagi = true;
        while (tambahlagi) {
            clearScreen();
            System.out.println("Terima Kasih Sudah Mau mendonasikan buku anda");
            System.out.println("Silahkan Daftarkan Buku anda di bawah");
            garis();
            String isbn;
            do {
                isbn = input("Masukan nomor ISBN buku");
                if (!isbn.matches("[0-9]+")) {
                    System.out.println("Input nomor ISBN harus berupa angka.");
                }
            } while (!isbn.matches("[0-9]+"));
            String judul = userinput("Masukan Judul Buku");
            String penulis = userinput("Masukan Authornya");
            String status = "Tersedia";
            service.addLibrary(isbn, judul, penulis, status);
            System.out.println("Apakah Kamu mau Menambahkan buku lagi? y/n");
            String confirm = userinput("Konfirmasi");
            if (confirm.equals("y")){
                tambahlagi = true;
            } else {
                tambahlagi = false;
                mainMenu();
            }
        }
    }

    @Override
    public void cariBuku() {
        clearScreen();
        garis();
        String judol = userinput("Silahkan masukan Judul Buku yang di cari");
        service.searchLibrary(judol);
        if (service.getLibrary().isEmpty()){
            System.out.println("Silahkan tambahkan buku terlebih dahulu");
        }
        footer();
        String str = userinput("Masukan Pilihan Anda");
        if (str.equals("0")){
            mainMenu();
        } else {
            pilihanTidakAda();
            enterSekali();
            mainMenu();
        }
    }

    @Override
    public void pinjamBuku() {
        clearScreen();
        boolean confirm = true;
        while (confirm) {
            garis();
            String isbn = input("Silahkan Masukan isbn buku yang akan di pinjam");
            service.rentBook(isbn);
            if (service.getLibrary().isEmpty()){
                System.out.println("Silahkan tambahkan buku terlebih dahulu");
                break;
            }
            System.out.println("Apakah Kamu mau meminjam lagi? y/n");
            String str = userinput("Masukan Pilihan anda");
            if (str.equals("y")){
                confirm = true;
            } else {
                confirm = false;
            }
        }
        footer();
        String str = userinput("Masukan Pilihan Anda");
        if (str.equals("0")){
            mainMenu();
        } else {
            pilihanTidakAda();
            enterSekali();
            mainMenu();
        }
    }

    @Override
    public void kembalikanBuku() {
        clearScreen();
        boolean confirm = true;
        while (confirm) {
            garis();
            String isbn = input("Silahkan Masukan isbn buku yang akan dikembalikan");
            service.returBook(isbn);
            System.out.println("Apakah masih ada buku yang ingin dikembalikan lagi? y/n");
            String str = userinput("Masukan Pilihan anda");
            if (str.equals("y")){
                confirm = true;
            } else {
                confirm = false;
            }
        }
        footer();
        String str = userinput("Masukan Pilihan Anda");
        if (str.equals("0")){
            mainMenu();
        } else {
            pilihanTidakAda();
            enterSekali();
            mainMenu();
        }
    }

    @Override
    public void listLibrary() {
        clearScreen();
        if (service.getLibrary().isEmpty()) {
            garis();
            System.out.println("Sedang Maintenance.");
        } else {
            garis2();
            garis();
            System.out.printf("%4s %-11s %-20s %-15s %-12s\n", "No.", "ISBN", "Judul", "Penulis", "Status Buku");
            for (var i = 0; i < service.getLibrary().size(); i++) {
                Buku buku = service.getLibrary().get(i);
                System.out.printf("%3s. %-11s %-20s %-15s %-12s\n", i + 1, buku.getIsbn(), buku.getJudul(), buku.getPenulis(), buku.getStatusKetersediaan());
            }
            garis();
        }
        footer();
        String str = userinput("Masukan Pilihan Anda");
        if (str.equals("0")){
            mainMenu();
        } else {
            pilihanTidakAda();
            enterSekali();
            mainMenu();
        }
    }
}
