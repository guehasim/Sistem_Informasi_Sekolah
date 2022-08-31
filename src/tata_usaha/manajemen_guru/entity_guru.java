package tata_usaha.manajemen_guru;

/**
 *
 * @author AHMAD HASIM
 */
public class entity_guru {

    private String nip;
    private String nama;
    private String tempat;
    private String tgllahir;
    private String jenkel;
    private String agama;
    private String golongdar;
    private String pendidikan;
    private String nama_ortu;
    private String alamat;
    private String desa;
    private String kecamatan;
    private String kota;
    private String propinsi;
    private String foto;
    
    public entity_guru(){
        
    }
    
    public entity_guru
            (String nip, String nama, String tempat, String tgllahir, String jenkel,
            String agama, String golongdar,  String pendidikan, String nama_ortu,
            String alamat, String desa, String kecamatan, String kota, String propinsi,
            String foto)
    {
        this.nip = nip;
        this.nama = nama;
        this.tempat = tempat;
        this.tgllahir = tgllahir;
        this.jenkel = jenkel;
        this.agama = agama;
        this.golongdar = golongdar;
        this.pendidikan = pendidikan;
        this.nama_ortu = nama_ortu;
        this.alamat = alamat;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.propinsi = propinsi;
        this.foto = foto;
    }
    
    public String getnip(){
        return nip;
    }
    
    public void setnip(String nip){
        this.nip = nip;
    }
    
    public String getnama(){
        return nama;
    }
    
    public void setnama(String nama){
        this.nama = nama;
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
    
    public String getgolongdar(){
        return golongdar;
    }
    
    public void setgolongdar(String golongdar){
        this.golongdar = golongdar;
    }
    
    public String getpendidikan(){
        return pendidikan;
    }
    
    public void setpendidikan(String pendidikan){
        this.pendidikan = pendidikan;
    }
    
    public String getnama_ortu(){
        return nama_ortu;
    }
    
    public void setnama_ortu(String nama_ortu){
        this.nama_ortu = nama_ortu;
    }
    
    public String getalamat(){
        return alamat;
    }
    
    public void setalamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getdesa(){
        return desa;
    }
    
    public void setdesa(String desa){
        this.desa = desa;
    }
    
    public String getkecamatan(){
        return kecamatan;
    }
    
    public void setkecamatan(String kecamatan){
        this.kecamatan = kecamatan;
    }
    
    public String getkota(){
        return kota;
    }
    
    public void setkota(String kota){
        this.kota = kota;
    }
    
    public String getpropinsi(){
        return propinsi;
    }
    
    public void setpropinsi(String propinsi){
        this.propinsi = propinsi;
    }
    
    public String getfoto(){
        return foto;
    }
    
    public void setfoto(String foto){
        this.foto = foto;
    }
    
}
