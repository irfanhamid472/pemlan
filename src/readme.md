Program ini merupakan aplikasi sederhana berbasis Java Console yang digunakan untuk menghitung total harga pembelian tiket konser berdasarkan jenis tiket dan jumlah tiket yang dibeli.

Program ini juga telah melalui beberapa teknik refactoring agar kode menjadi lebih terstruktur, mudah dibaca, dan mudah dikembangkan.

STRUKTUR PROGRAM
Program dibagi menjadi beberapa bagian penting:
1.Superclass (Abstract Class) – Ticket
  Menyimpan atribut dasar dan mendefinisikan method abstrak displayInfo().

2.Interface – Operational
  Mendefinisikan dua operasi utama:
  a.calculateTotal() → menghitung total harga tiket termasuk pajak.
  b.printReceipt() → mencetak rincian pembelian tiket.

3.Subclass – TiketKonserSesudah
  Mengimplementasikan class Ticket dan interface Operational.
  Class ini berisi logika utama program dan menerapkan berbagai teknik refactoring seperti:
  a.Extract Method
  b.Rename Method
  c.Inline Variable
  d.Encapsulate Field
  e.Replace Magic Number with Symbolic Constant
  f.Move Method

FITUR UTAMA:
1.Input nama pembeli
2.Input jenis tiket (Reguler, VIP, atau VVIP)
3.Input jumlah tiket
4.Perhitungan total harga dengan pajak 10%
5.Menampilkan rincian pembelian

HARGA TIKET
Jenis Tiket	Harga Satuan:
Reguler	Rp 500.000
VIP	Rp 1.000.000
VVIP	Rp 1.500.000

Tambahan Pajak (TAX_RATE) sebesar 10% (0.1) akan otomatis dihitung dari total pembelian.


CARA MENJALANKAN PROGRAM
1.Pastikan kamu sudah menginstal Java JDK minimal versi 8.
2.Simpan kode ke dalam file bernama TiketKonserSesudah.java.
3.Buka terminal atau command prompt, lalu jalankan perintah berikut:

  javac TiketKonserSesudah.java
  java TiketKonserSesudah

4.Masukkan data sesuai instruksi di layar:

  a.Nama pembeli
  b.Jenis tiket
  c.Jumlah tiket

5.Program akan menampilkan rincian pembelian beserta total harga termasuk pajak.

CONTOH OUTPUT

=== PEMESANAN TIKET KONSER ===
Masukkan nama pembeli: Irfan
Masukkan jenis tiket (Reguler/VIP/VVIP): VIP
Masukkan jumlah tiket: 2

=== RINCIAN PEMBELIAN ===
Nama Pembeli: Irfan
Jenis Tiket: VIP
Jumlah Tiket: 2
Total (termasuk pajak): Rp2200000.0
Terima kasih telah membeli tiket konser!
