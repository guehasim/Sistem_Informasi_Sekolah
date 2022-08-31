package tata_usaha.manajemen_siswa;

/**
 *
 * @author AHMAD HASIM
 */
public class entity_siswa {

    private String nis;
    private String nama;
    private String jenkel;
    private String agama;
    private String tempat;
    private String tgllahir;
    private String alamat;
    private String anak_ke;
    private String status_kel;
    private String foto;
    private String tgl_msuk;
    private String di_kelas;
    private String nm_sd;
    private String almt_sd;
    private String nm_ayah;
    private String nm_ibu;
    private String almt_ayah;
    private String almt_ibu;
    private String password;
    
    private String thn_ajar;
    private String semester;
    
    
    
    public entity_siswa(){
        
    }
    
    public entity_siswa
            (String nis, String nama, String jenkel, String agama, String tempat,
            String tgllahir, String alamat, String thn_ajar, String anak_ke, String status_kel,
            String foto, String di_kelas, String tgl_msuk, String nm_sd, String almt_sd,
            String nm_ayah, String nm_ibu, String almt_ayah, String almt_ibu, String password, 
            String semester )
    {
        this.nis = nis;
        this.nama = nama;
        this.jenkel = jenkel;
        this.agama = agama;
        this.tempat = tempat;
        this.tgllahir = tgllahir;
        this.alamat = alamat;
        this.anak_ke = anak_ke;
        this.di_kelas = di_kelas;
        this.status_kel = status_kel;
        this.foto = foto;
        this.tgl_msuk = tgl_msuk;
        this.nm_sd = nm_sd;
        this.almt_sd = almt_sd;
        this.nm_ayah = nm_ayah;
        this.nm_ibu = nm_ibu;
        this.almt_ayah = almt_ayah;
        this.almt_ibu = almt_ibu;
        this.password = password;
        
        this.thn_ajar = thn_ajar;
        this.semester = semester;
    }
    
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
    
    public String getjenkel(){
        return jenkel;
    }
    
    public void setjenkel(String jenkel){
        this.jenkel = jenkel;
    }
    
    public String getagama(){
        return agama;
    }
    
    public void setagama(String agama){
        this.agama = agama;
    }
    
    public String gettempat(){
        return tempat;
    }
    
    public void settempat(String tempat){
        this.tempat = tempat;
    }
    
    public String gettgllahir(){
        return tgllahir;
    }
    
    public void settgllahir(String tgllahir){
        this.tgllahir = tgllahir;
    }
    
    public String getalamat(){
        return alamat;
    }
    
    public void setalamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getthn_ajar(){
        return thn_ajar;
    }
    
    public void setthn_ajar(String thn_ajar){
        this.thn_ajar = thn_ajar;
    }
    
    public String getanak_ke(){
        return anak_ke;
    }
    
    public void setanak_ke(String anak_ke){
        this.anak_ke = anak_ke;
    }
    
    public String getstatus_kel(){
        return status_kel;
    }
    
    public void setstatus_kel(String status_kel){
        this.status_kel = status_kel;
    }
    
    public String getfoto(){
        return foto;
    }
    
    public void setfoto(String foto){
        this.foto = foto;
    }
    
    public String getdi_kelas(){
        return di_kelas;
    }
    
    public void setdi_kelas(String di_kelas){
        this.di_kelas = di_kelas;
    }
    
    public String gettgl_msuk(){
        return tgl_msuk;
    }
    
    public void settgl_msuk(String tgl_msuk){
        this.tgl_msuk = tgl_msuk;
    }
    
    public String getnm_sd(){
        return nm_sd;
    }
    
    public void setnm_sd(String nm_sd){
        this.nm_sd = nm_sd;
    }
    
    public String getalmt_sd(){
        return almt_sd;
    }
    
    public void setalmt_sd(String almt_sd){
        this.almt_sd = almt_sd;
    }
    
    public String getnm_ayah(){
        return nm_ayah;
    }
    
    public void setnm_ayah(String nm_ayah){
        this.nm_ayah = nm_ayah;
    }
    
    public String getnm_ibu(){
        return nm_ibu;
    }
    
    public void setnm_ibu(String nm_ibu){
        this.nm_ibu = nm_ibu;
    }
    
    public String getalmt_ayah(){
        return almt_ayah;
    }
    
    public void setalmt_ayah(String almt_ayah){
        this.almt_ayah = almt_ayah;
    }
    
    public String getalmt_ibu(){
        return almt_ibu;
    }
    
    public void setalmt_ibu(String almt_ibu){
        this.almt_ibu = almt_ibu;
    }
    
    public String getpassword(){
        return password;
    }
    
    public void setpassword(String password){
        this.password = password;
    }
    
    public String getsemester(){
        return semester;
    }
    
    public void setsemester(String semester){
        this.semester = semester;
    }
}
