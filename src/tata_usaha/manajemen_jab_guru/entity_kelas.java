package tata_usaha.manajemen_jab_guru;

public class entity_kelas {
    
    private int idKelas;
    private String namaKelas;
    
    public entity_kelas() {
    }
    public entity_kelas(int idKelas, String namaKelas) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
    }
    
    public int getidKelas(){
        return idKelas;
    }
    
    public void setidKelas(int idKelas){
        this.idKelas = idKelas;
    }
    public String getnamaKelas() {
        return namaKelas;
    }

    public void setnamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
