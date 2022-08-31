package tata_usaha.manajemen_nilai;

/**
 *
 * @author AHMAD HASIM
 */
public class entity_nilai {

    private int id_nilai;
    private String tahun_ajaran;
    private String semester;
    private String kelas;
    private String siswa;
    private String nama;
    private String pelajaran;
    private String nilai;
    
    public entity_nilai(){
        
    }
    
    public entity_nilai(int id_nilai, String tahun_ajaran, String semester, String kelas, 
            String siswa, String nama, String pelajaran, String nilai)
    {
        this.id_nilai = id_nilai;
        this.tahun_ajaran = tahun_ajaran;
        this.semester = semester;
        this.kelas = kelas;
        this.siswa = siswa;
        this.pelajaran = pelajaran;
        this.nilai = nilai;
    }
    
    public int getid_nilai(){
        return id_nilai;
    }
    
    public void setid_nilai(int id_nilai){
        this.id_nilai = id_nilai;
    }
    
    public String gettahun_ajaran(){
        return tahun_ajaran;
    }
    
    public void settahun_ajaran(String tahun_ajaran){
        this.tahun_ajaran = tahun_ajaran;
    }
    
    public String getsemester(){
        return semester;
    }
    
    public void setsemester(String semester){
        this.semester = semester;
    }
    
    public String getkelas(){
        return kelas;
    }
    
    public void setkelas(String kelas){
        this.kelas = kelas;
    }
    
    public String getnama(){
        return nama;
    }
    
    public void setnama(String nama){
        this.nama = nama;
    }
    
    public String getsiswa(){
        return siswa;
    }
    
    public void setsiswa(String siswa){
        this.siswa = siswa;
    }
    
    public String getpelajaran(){
        return pelajaran;
    }
    
    public void setpelajaran(String pelajaran){
        this.pelajaran = pelajaran;
    }
    
    public String getnilai(){
        return nilai;
    }
    
    public void setnilai(String nilai){
        this.nilai = nilai;
    }
       
}
