package com.book.utility;

import java.util.Scanner;

public class LibraryUtility {
    static String data;
    static Boolean valid = true;
    static Scanner input = new Scanner(System.in);

    public static void clearScreen() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("\n");
        }
    }
    public static void garis() { System.out.println("--------------------------"); }
    public static void garis2() { System.out.print("--------------------------"); }
    public static void footer() {
        System.out.println("  0. Menu awal");
    }
    public static void enterSekali() { input.nextLine(); }
    public static void pilihanTidakAda() { System.out.println("Pilihan tidak ada, tekan Enter untuk kembali ke menu awal"); }
    public static String input(String info) {
        do {
            System.out.print("\n" + info + " : ");
            data = input.nextLine();
            if (data.equals("")) {
                valid = false;
                System.out.println("\ninput tidak boleh kosong!");
            } else if (!data.matches("[0-9]+")) {
                valid = false;
                System.out.println("\ninput harus angka!");
            } else {
                return data;
            }
        } while (!valid);
        return data;
    }
    public static String userinput(String info){
        do {
            System.out.print("\n" + info + " : ");
            data = input.nextLine();
            if (data.equals("")) {
                valid = false;
                System.out.println("\ninput tidak boleh kosong!");
            } else {
                return data;
            }
        } while (!valid);
        return data;
    }
}
