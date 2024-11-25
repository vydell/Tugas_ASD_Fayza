import java.util.*;

class Sortir {
    private static int iterasiInsert = 0;
    private static int iterasiSelection = 0;

    public static int getIterasiInsert() {
        return iterasiInsert;
    }

    public static int getIterasiSelection() {
        return iterasiSelection;
    }

    public static void insertionSort(List<Tugas> daftarTugas) {
        int n = daftarTugas.size();
        for (int i = 1; i < n; i++) {
            Tugas key = daftarTugas.get(i);
            int j = i - 1;

            while (j >= 0 && bandingkanTugas(daftarTugas.get(j), key) > 0) {
                daftarTugas.set(j + 1, daftarTugas.get(j));
                j--;
                iterasiInsert++;
            }
            daftarTugas.set(j + 1, key);
            iterasiInsert++;
        }
    }

    public static void selectionSort(List<Tugas> daftarTugas) {
        int n = daftarTugas.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                iterasiSelection++;
                if (bandingkanTugas(daftarTugas.get(j), daftarTugas.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Tugas temp = daftarTugas.get(minIndex);
                daftarTugas.set(minIndex, daftarTugas.get(i));
                daftarTugas.set(i, temp);
                iterasiSelection++;
            }
        }
    }

    private static int bandingkanTugas(Tugas t1, Tugas t2) {
        if (t1.sisaHari != t2.sisaHari) {
            return Integer.compare(t1.sisaHari, t2.sisaHari);
        }
        return Integer.compare(t1.prioritas, t2.prioritas);
    }

    public static void printList(List<Tugas> daftarTugas) {
        for (Tugas t : daftarTugas) {
            System.out.println(t.toString());
            System.out.println("");
        }
    }

    public static List<Tugas> tambahTugas() {
        Scanner in = new Scanner(System.in);
        List<Tugas> daftarTugas = new ArrayList<>();

        System.out.println("Tambah tugas ke daftar:");
        while (true) {
            System.out.print("Masukkan judul tugas: ");
            String judul = in.nextLine();

            System.out.print("Masukkan sisa hari (integer): ");
            int sisaHari;
            try {
                sisaHari = in.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Error: sisa hari harus berupa angka bulat");
                continue;
            }

            System.out.print("Masukkan skala prioritas (integer): ");
            int prioritas;
            try {
                prioritas = in.nextInt();
                in.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: skala prioritas harus berupa angka bulat");
                continue;
            }

            daftarTugas.add(new Tugas(judul, sisaHari, prioritas));

            System.out.print("Apakah ingin menambah tugas lagi? (y/n): ");
            String tambahLagi = in.nextLine().toLowerCase();
            if (!tambahLagi.equals("y")) {
                break;
            }
            System.out.println("");
        }
        return daftarTugas;
    }
}