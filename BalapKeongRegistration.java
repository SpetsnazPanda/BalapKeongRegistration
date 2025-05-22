 /* 
 * Program ini bertujuan untuk mensimulasikan proses pendaftaran kompetisi Balap Keong 
 * dengan syarat bahwa peserta harus berusia minimal 17 tahun. Pertama, program meminta 
 * input nama dan usia pengguna. Kemudian, menggunakan method validateAge, program memeriksa 
 * apakah usia peserta sudah memenuhi syarat. Jika tidak, maka akan dilempar exception kustom 
 * UnderageException menggunakan kata kunci throw, dan ditangani dalam blok try-catch. Hal ini 
 * menunjukkan penerapan exception handling yang baik untuk memisahkan logika validasi dan 
 * penanganan kesalahan, serta meningkatkan keterbacaan dan keamanan kode.
 * 
 * UnderageException: custom exception turunan dari Exception, digunakan untuk memvalidasi input logika program (checked exception).
*/

import java.util.Scanner; // mengimpor kelas Scanner untuk input dari pengguna

class UnderageException extends Exception { // membuat kelas exception kustom bernama UnderageException
    public UnderageException(String message) { // konstruktor yang menerima pesan kesalahan
        super(message); // memanggil konstruktor superclass (Exception) dengan pesan tersebut
    }
}

public class BalapKeongRegistration { // kelas utama program

    public static void validateAge(int age) // method untuk memvalidasi umur peserta
            throws UnderageException { // menyatakan bahwa method ini bisa melempar UnderageException
        if (age < 17) { // jika usia kurang dari 17
            throw new UnderageException( // melempar exception kustom dengan pesan
                "Usia Anda belum memenuhi syarat untuk mengikuti kompetisi (minimal 17 tahun).");
        }
    }

    public static void main(String[] args) { // method utama program
        Scanner scanner = new Scanner(System.in); // membuat objek Scanner untuk membaca input pengguna

        System.out.println("=== Pendaftaran Kompetisi Balap Keong ==="); // menampilkan judul program
        System.out.print("Masukkan nama Anda: "); // meminta input nama pengguna
        String name = scanner.nextLine(); // membaca nama

        System.out.print("Masukkan usia Anda: "); // meminta input usia pengguna
        int age = scanner.nextInt(); // membaca usia

        try { // memulai blok try untuk menangani potensi exception
            validateAge(age); // memanggil method validasi umur
            System.out.println("Pendaftaran berhasil! Selamat bertanding, " + name + "!"); // jika lolos, tampilkan pesan sukses
        } catch (UnderageException e) { // menangkap exception jika peserta masih di bawah umur
            System.out.println("Pendaftaran gagal: " + e.getMessage()); // menampilkan pesan error dari exception
        } catch (Exception e) { // menangani exception lain jika ada
            System.out.println("Terjadi kesalahan: " + e.getMessage()); // menampilkan pesan kesalahan umum
        }
    }
}
