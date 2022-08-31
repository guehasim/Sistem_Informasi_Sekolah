package tata_usaha.manajemen_jab_guru;

public class entity_walkes {
    private int id;
    private String nip;
    private String nama;
    private String jabat;
    private String kelas;
    private String pass;
    
    public entity_walkes(){
        
    }
    
    public entity_walkes(int id, String nip, String jabat, String kelas, String pass){
        this.id = id;
        this.nip = nip;
        this.kelas = kelas;
        this.pass = pass;
    }
       
    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
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
    
    public String getjabat(){
        return jabat;
    }
    
    public void setjabat(String jabat){
        this.jabat = jabat;
    }
    
    public String getkelas(){
        return kelas;
    }
    
    public void setkelas(String kelas){
        this.kelas = kelas;
    }
    
    public String getpass(){
        return pass;
    }
    
    public void setpass(String pass){
        this.pass = pass;
    }
}
