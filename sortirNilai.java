import java.util.List;
import java.util.*;

public class sortirNilai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Tugas> daftarTugas = Sortir.tambahTugas();

        System.out.println("\n==========================================");
        System.out.println("\nDaftar tugas sebelum diurutkan:");
        Sortir.printList(daftarTugas);        
        System.out.println("\n==========================================\n");

        List<Tugas> daftarTugasInsertion = new ArrayList<>(daftarTugas);
        List<Tugas> daftarTugasSelection = new ArrayList<>(daftarTugas);

        while (true) {
            try {
                System.out.println("1. Selection sort");
                System.out.println("2. Insertion sort");
                System.out.println("Pilih metode sorting: (1/2)");
                int pilihan;

                pilihan = in.nextInt();
                in.nextLine();

                switch (pilihan) {
                    case 1:
                        Sortir.insertionSort(daftarTugasInsertion);
                        System.out.println("\nHasil sorting menggunakan insertion sort:");
                        Sortir.printList(daftarTugasInsertion);
                        System.out.println("Jumlah iterasi : " + Sortir.iterasiInsert);
                        break;
                    case 2:
                        Sortir.selectionSort(daftarTugasSelection);
                        System.out.println("\nHasil sorting menggunakan selection sort:");
                        Sortir.printList(daftarTugasSelection);
                        System.out.println("Jumlah iterasi: " + Sortir.iterasiSelection);
                        break;
                    default:
                        System.out.println("Opsi tidak ada di pilihan");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka (1 atau 2).");
                in.nextLine();
            }

            System.out.println("");
            System.out.print("Apakah ingin sortir dengan metode lain? (y/n): ");
            String tambahLagi = in.nextLine().toLowerCase();
            if (!tambahLagi.equals("y")) {
                break;
            }
            System.out.println("");
        }
        in.close();
    
        System.out.println("Program dimatikan");
    }
}


