package id.yoihenken.mahasiswa;

import java.util.Scanner;

public class RegistrationMahasiswa {

    static Scanner scannerNumber = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    private static String[][] addElementArray(String arrayMahasiswa[][]){
        System.out.println("\n> Tambah Mahasiswa");
//        Deklarasi array dengan value untuk backup data
        String arrayTemp[][] = arrayMahasiswa;
//        Mengganti array dengan element ditambah satu
        arrayMahasiswa = new String[arrayTemp.length + 1][3];
//        Restore data dari arrayTemp ke arrayMahasiswa
        for (int i = 0; i < arrayTemp.length; i++) {
            arrayMahasiswa[i][0] = arrayTemp[i][0];
            arrayMahasiswa[i][1] = arrayTemp[i][1];
            arrayMahasiswa[i][2] = arrayTemp[i][2];
        }
//        Menambah Data
        System.out.print("Masukkan NIM\t: ");
        arrayMahasiswa[arrayTemp.length][0] = scannerString.nextLine();
        System.out.print("Masukkan Nama\t: ");
        arrayMahasiswa[arrayTemp.length][1] = scannerString.nextLine();
        System.out.print("Masukkan Prodi\t: ");
        arrayMahasiswa[arrayTemp.length][2] = scannerString.nextLine();

        return arrayMahasiswa;
    }

    private static String[][] removeElementArray(String arrayMahasiswa[][]){
        System.out.println("\n> Hapus Mahasiswa");
//        Jika Array kosong, tidak bisa dilantukan
        if (arrayMahasiswa.length == 0){
            System.out.println("Data Kosong !!!");
            return arrayMahasiswa;

        }else{
//            Jika Array Tidak kosong
            System.out.print("Masukkan NIM yang akan dihapus\t: ");
            String removeElement = scannerString.nextLine();

//        Deklarasi array dengan value untuk backup data
            String arrayTemp[][] = arrayMahasiswa;

//        Mengganti array dengan element ditambah satu
            arrayMahasiswa = new String[arrayTemp.length - 1][3];

            for (int i = 0; i < arrayMahasiswa.length; i++) {
                System.out.println("Proses ke-" + i);
                if (!arrayTemp[i][0].equals(removeElement)){
                    System.out.println("Ini yu!");
                    arrayMahasiswa[i][0] = arrayTemp[i][0];
                    arrayMahasiswa[i][1] = arrayTemp[i][1];
                    arrayMahasiswa[i][2] = arrayTemp[i][2];
                }else {
                    System.out.println("Ini gus!");
                    arrayMahasiswa[i][0] = arrayTemp[i + 1][0];
                    arrayMahasiswa[i][1] = arrayTemp[i + 1][1];
                    arrayMahasiswa[i][2] = arrayTemp[i + 1][2];
                }
            }
            return arrayMahasiswa;
        }
    }

    public static String[][] selectionAsc(String array[][]){
        System.out.println("\n> Urutkan Mahasiswa...");
        int flag;
//        Buat array temp untuk menampung nilai
        String temp[] = new String[3];

        for (int i = 0; i < array.length - 1; i++) {
            flag = i;
//            Membandingkan data dari yang kecil ke besar
            for (int j = i + 1; j < array.length; j++) {
//                Perbandingan jika String
                if (array[j][0].compareTo(array[flag][0]) < 0) flag = j;
            }

            if (flag != i){
                // Memindahkan array index i ke temp
                for (int j = 0; j < temp.length; j++)
                    temp[j] = array[i][j];
                // Memindahkan array index i ke index flag
                for (int j = 0; j < temp.length; j++)
                    array[i][j] = array[flag][j];
                // Memindahkan array index flag ke index i
                for (int j = 0; j < temp.length; j++)
                    array[flag][j] = temp[j];
            }
        }
        return array;
    }

    public static void printArray(String arrayMahasiswa[][]){
        System.out.println("\n> Cetak Data Mahasiswa");
//        Jika data kosong
        if (arrayMahasiswa.length == 0){
            System.out.println("Data Kosong !!!");
        }else {
//            Jika ada data
            for (int i = 0; i < arrayMahasiswa.length; i++) {
                System.out.println("Mahasiswa ke-" + (i) + "\t: ");
                System.out.println("NIM\t\t: " + arrayMahasiswa[i][0]);
                System.out.println("Nama\t: " + arrayMahasiswa[i][1]);
                System.out.println("Prodi\t: " + arrayMahasiswa[i][2]);
            }
        }
    }

    private static void menu(){
        System.out.println("\n<===== Data Mahasiswa =====>");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Hapus Data Mahasiswa");
        System.out.println("3. Urutkan Data Mahasiswa");
        System.out.println("4. Lihat Data Mahasiswa");
        System.out.println("5. Tutup");
    }

    public static void main(String[] args) {
//        Array untuk menyimpan nim di index ke-0, nama di index ke-1, prodi di index ke-2
        String arrayMahasiswa[][] = new String[0][3] ;
        int pilih = 0;

        do{
            menu(); //Keluarkan Menu
//            Input pilihan
            System.out.print("Pilih\t: ");
            pilih = scannerNumber.nextInt();
            switch (pilih){
//                Tambah element
                case 1 :
                    arrayMahasiswa = addElementArray(arrayMahasiswa);
                    break;
//                Hapus Element
                case 2 :
                    arrayMahasiswa = removeElementArray(arrayMahasiswa);
                    break;
//                Urutkan Element dengan Selection
                case 3:
                    arrayMahasiswa = selectionAsc(arrayMahasiswa);
                    printArray(arrayMahasiswa);
                    break;
//                Cetak Element
                case 4 :
                    printArray(arrayMahasiswa);
                    break;
//                Keluar Element
                case 5 :
                    System.out.println("\nByee!!!");
                    break;
            }
        } while (pilih != 5);
    }
}
