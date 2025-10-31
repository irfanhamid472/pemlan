import java.util.Scanner;

// Extract Superclass
abstract class Ticket {
    protected String nama;
    protected String jenisTiket;
    protected int jumlah;
    protected double total;

    public abstract void displayInfo();
}

// Extract Interface
interface Operational {
    void calculateTotal();
    void printReceipt();
}

class TiketKonserSesudah extends Ticket implements Operational {

    // Replace Magic Number with Symbolic Constant
    private static final double TAX_RATE = 0.1;
    private static final double REGULER_PRICE = 500000;
    private static final double VIP_PRICE = 1000000;
    private static final double VVIP_PRICE = 1500000;

    // Refactoring 8: Encapsulate Field
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJenisTiket() { return jenisTiket; }
    public void setJenisTiket(String jenisTiket) { this.jenisTiket = jenisTiket; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    @Override
    public void calculateTotal() { // ✅ Refactoring 1: Extract Method
        switch (jenisTiket.toLowerCase()) {
            case "reguler":
                total = REGULER_PRICE * jumlah;
                break;
            case "vip":
                total = VIP_PRICE * jumlah;
                break;
            case "vvip":
                total = VVIP_PRICE * jumlah;
                break;
            default:
                System.out.println("Jenis tiket tidak valid!");
                total = 0;
        }
        total += total * TAX_RATE;
    }

    //Refactoring 2: Rename Variable / Method (dari showData() → printReceipt())
    @Override
    public void printReceipt() {
        System.out.println("\n=== RINCIAN PEMBELIAN ===");
        System.out.println("Nama Pembeli: " + nama);
        System.out.println("Jenis Tiket: " + jenisTiket);
        System.out.println("Jumlah Tiket: " + jumlah);
        System.out.println("Total (termasuk pajak): Rp" + total);
        System.out.println("terima kasih");
        System.out.println();
    }

    //Refactoring 3: Inline Variable
    @Override
    public void displayInfo() {
        System.out.println("Terima kasih telah membeli tiket konser!");
    }

    //Refactoring 4: Move Method
    public static void main(String[] args) {
        TiketKonserSesudah tiket = new TiketKonserSesudah();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== PEMESANAN TIKET KONSER ===");
        System.out.print("Masukkan nama pembeli: ");
        tiket.setNama(sc.nextLine());
        System.out.print("Masukkan jenis tiket (Reguler/VIP/VVIP): ");
        tiket.setJenisTiket(sc.nextLine());
        System.out.print("Masukkan jumlah tiket: ");
        tiket.setJumlah(sc.nextInt());

        tiket.calculateTotal();
        tiket.printReceipt();
        tiket.displayInfo();
    }
}
