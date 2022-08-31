package tata_usaha.ujian.view;


public class entity_ujian {
    //paket soal================
    String kd_paket;
    int kelas;
    String matpel;
    String tgl;
    int jml_soal;
    int bobot_soal;
    
    //soal======================
    int kd_soal;
    String soal;
    int kunci;
    String kondis;
    
    //pilih jawab===============
    int pilih;
    String jawab;
    int hasil;
        
    //login==================
    String nis;
    String nama;
    String password;
    int nilai;
    
    //nilai ujian===========
    
    
    //paket soal================
    public String getkd_paket(){
        return kd_paket;
    }
    public void setkd_paket(String kd_paket){
        this.kd_paket = kd_paket;
    }
    
    public int getkelas(){
        return kelas;
    }
    public void setkelas(int kelas){
        this.kelas = kelas;
    }
    
    public String getmatpel(){
        return matpel;
    }
    public void setmatpel(String matpel){
        this.matpel = matpel;
    }
    
    public String gettgl(){
        return tgl;
    }
    public void settgl(String tgl){
        this.tgl = tgl;
    }
    
    public int getjml_soal(){
        return jml_soal;
    }
    public void setjml_soal(int jml_soal){
        this.jml_soal = jml_soal;
    }
    
    public int getbobot_nilai(){
        return bobot_soal;
    }
    public void setbobot_nilai(int bobot_nilai){
        this.bobot_soal = bobot_nilai;
    }
    
    
    //soal==================================
    public int getkd_soal(){
        return kd_soal;
    }
    public void setkd_soal(int kd_soal){
        this.kd_soal = kd_soal;
    }
    
    public String getsoal(){
        return soal;
    }
    public void setsoal(String soal){
        this.soal = soal;
    }
    
    public int getkunci(){
        return kunci;
    }
    public void setkunci(int kunci){
        this.kunci = kunci;
    }
    
    public String getkondis(){
        return kondis;
    }
    public void setkondis(String kondis){
        this.kondis = kondis;
    }
    
    
    //pilih jawab======================
    public int getpilih(){
        return pilih;
    }
    public void setpilih(int pilih){
        this.pilih = pilih;
    }
    
    public String getjawab(){
        return jawab;
    }
    public void setjawab(String jawab){
        this.jawab = jawab;
    }
    
    public int gethasil(){
        return hasil;
    }
    public void sethasil(int hasil){
        this.hasil = hasil;
    }
    
    //login===========
    public String getnis(){
        return nis;
    }
    public void setnis(String nis){
        this.nis = nis;
    }
    
    public String getnama(){
        return nama;
    }
    public void setnama(String nama){
        this.nama = nama;
    }
    
    public int getnilai(){
        return nilai;
    }
    public void setnilai(int nilai){
        this.nilai = nilai;
    }
    
    public String getpassword(){
        return password;
    }
    public void setpassword(String password){
        this.password = password;
    }
}
