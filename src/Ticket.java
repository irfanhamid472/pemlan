import java.util.Scanner;

/**
 * Abstract superclass yang merepresentasikan tiket umum.
 * Berisi atribut dasar dan method abstrak untuk diturunkan ke subclass.
 */
abstract class Ticket {

    /** Nama pembeli tiket */
    protected String nama;

    /** Jenis tiket yang dibeli (Reguler/VIP/VVIP) */
    protected String jenisTiket;

    /** Jumlah tiket yang dibeli */
    protected int jumlah;

    /** Total harga pembelian (termasuk pajak) */
    protected double total;

    /**
     * Menampilkan informasi tiket atau pesan setelah transaksi.
     * Method ini harus diimplementasikan oleh subclass.
     */
    public abstract void displayInfo();
}

/**
 * Interface yang mendefinisikan operasi dasar dalam sistem pemesanan tiket.
 */
interface Operational {

    /**
     * Menghitung total harga pembelian tiket berdasarkan jenis dan jumlah tiket.
     * Termasuk perhitungan pajak (TAX_RATE).
     */
    void calculateTotal();

    /**
     * Mencetak rincian pembelian tiket (nama, jenis tiket, jumlah, dan total).
     */
    void printReceipt();
}

/**
 * Class utama yang mengimplementasikan sistem pemesanan tiket konser.
 * Menerapkan berbagai teknik refactoring seperti Extract Method,
 * Encapsulate Field, dan Replace Magic Number with Symbolic Constant.
 */
class TiketKonserSesudah extends Ticket implements Operational {

    /** Persentase pajak pembelian tiket */
    private static final double TAX_RATE = 0.1;

    /** Harga tiket Reguler */
    private static final double REGULER_PRICE = 500000;

    /** Harga tiket VIP */
    private static final double VIP_PRICE = 1000000;

    /** Harga tiket VVIP */
    private static final double VVIP_PRICE = 1500000;

    /**
     * Mengambil nama pembeli tiket.
     * @return nama pembeli
     */
    public String getNama() { return nama; }

    /**
     * Mengatur nama pembeli tiket.
     * @param nama nama pembeli
     */
    public void setNama(String nama) { this.nama = nama; }

    /**
     * Mengambil jenis tiket yang dibeli.
     * @return jenis tiket
     */
    public String getJenisTiket() { return jenisTiket; }

    /**
     * Mengatur jenis tiket yang akan dibeli.
     * @param jenisTiket jenis tiket (Reguler/VIP/VVIP)
     */
    public void setJenisTiket(String jenisTiket) { this.jenisTiket = jenisTiket; }

    /**
     * Mengambil jumlah tiket yang dibeli.
     * @return jumlah tiket
     */
    public int getJumlah() { return jumlah; }

    /**
     * Mengatur jumlah tiket yang akan dibeli.
     * @param jumlah jumlah tiket
     */
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    /**
     * Menghitung total harga pembelian berdasarkan jenis tiket dan jumlah tiket,
     * kemudian menambahkan pajak sesuai nilai konstanta {@link #TAX_RATE}.
     * Jika jenis tiket tidak valid, total akan bernilai 0.
     */
    @Override
    public void calculateTotal() {
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

    /**
     * Menampilkan rincian pembelian tiket konser di konsol.
     * Meliputi nama pembeli, jenis tiket, jumlah tiket, dan total harga.
     */
    @Override
    public void printReceipt() {
        System.out.println("\n=== RINCIAN PEMBELIAN ===");
        System.out.println("Nama Pembeli: " + nama);
        System.out.println("Jenis Tiket: " + jenisTiket);
        System.out.println("Jumlah Tiket: " + jumlah);
        System.out.println("Total (termasuk pajak): Rp" + total);
    }

    /**
     * Menampilkan pesan ucapan terima kasih setelah pembelian tiket selesai.
     */
    @Override
    public void displayInfo() {
        System.out.println("Terima kasih telah membeli tiket konser!");
    }

    /**
     * Method utama (entry point) dari program.
     * Mengelola input pengguna dan menjalankan proses pemesanan tiket.
     *
     * @param args argumen command line (tidak digunakan)
     */
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

