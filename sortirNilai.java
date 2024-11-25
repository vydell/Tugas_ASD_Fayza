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
        Sortir.selectionSort(daftarTugasSelection);
        Sortir.printList(daftarTugasInsertion);

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
                        System.out.println("\nHasil sorting menggunakan selection sort:");
                        Sortir.printList(daftarTugasSelection);
                        System.out.println("Jumlah iterasi: " + Sortir.getIterasiSelection());
                        break;
                    case 2:
                        Sortir.insertionSort(daftarTugasInsertion);
                        System.out.println("\nHasil sorting menggunakan insertion sort:");
                        System.out.println("Jumlah iterasi : " + Sortir.getIterasiInsert());
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


