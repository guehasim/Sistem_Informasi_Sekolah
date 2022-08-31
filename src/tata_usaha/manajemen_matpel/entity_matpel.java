package tata_usaha.manajemen_matpel;

public class entity_matpel {
    private String kode_matpel;
    private String nama_matpel;
    private String kelas_matpel;
    
    public entity_matpel(){
        
    }
    
    public entity_matpel(String kode_matpel, String nama_matpel, String kelas_matpel){
        this.kode_matpel = kode_matpel;
        this.nama_matpel = nama_matpel;
        this.kelas_matpel = kelas_matpel;
    }
    
    public String getkode_matpel(){
        return kode_matpel;
    }
    
    public void setkode_matpel(String kode_matpel){
        this.kode_matpel = kode_matpel;
    }
    
    public String getnama_matpel(){
        return nama_matpel;
    }
    
    public void setnama_matpel(String nama_matpel){
        this.nama_matpel = nama_matpel;
    }
    
    public String getkelas_matpel(){
        return kelas_matpel;
    }
    
    public void setkelas_matpel(String kelas_matpel){
        this.kelas_matpel = kelas_matpel;
    }
}
