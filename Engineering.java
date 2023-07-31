/**
 * Kelas {@code Engineering} mewakili divisi Engineering dalam perusahaan.
 * Kelas ini merupakan subkelas dari kelas {@link Division} dan mewarisi properti dan metode dari kelas tersebut.
 * Divisi Engineering bertanggung jawab untuk mengelola karyawan yang bekerja di bidang teknik.
 */
public class Engineering extends Division {

    /**
     * Membuat objek baru dari divisi Engineering dengan gaji dasar yang telah ditentukan.
     *
     * @param baseSalary Gaji dasar untuk karyawan divisi Engineering.
     */
    public Engineering(int baseSalary) {
        super(baseSalary);
    }

    /**
     * Menambahkan seorang karyawan ke daftar karyawan divisi Engineering.
     * Metode ini menimpa metode {@code addEmployee} pada kelas induk {@link Division}.
     *
     * @param employee Karyawan yang akan ditambahkan ke divisi Engineering.
     */
    @Override
    public void addEmployee(Employee employee) {
        super.addEmployee(employee);
        // TODO: Tambahkan logika khusus terkait penambahan karyawan ke divisi Engineering, jika diperlukan.
    }
}
