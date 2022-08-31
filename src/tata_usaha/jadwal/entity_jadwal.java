package tata_usaha.jadwal;


public class entity_jadwal {
    
    int id_jad;
    String jam;
    String senin;
    String selasa;
    String rabu;
    String kamis;
    String jumat;
    String sabtu;
    int kelas;
    String walkes;
    
    public int getid_jad(){
        return id_jad;
    }
    public void setid_jad(int id_jad){
        this.id_jad = id_jad;
    }
    
    public String getjam(){
        return jam;
    }
    public void setjam(String jam){
        this.jam = jam;
    }
    
    public String getsenin(){
        return senin;
    }
    public void setsenin(String senin){
        this.senin = senin;
    }
    
    public String getselasa(){
        return selasa;
    }
    public void setselasa(String selasa){
        this.selasa = selasa;
    }
    
    public String getrabu(){
        return rabu;
    }
    public void setrabu(String rabu){
        this.rabu = rabu;
    }
    
    public String getkamis(){
        return kamis;
    }
    public void setkamis(String kamis){
        this.kamis = kamis;
    }
    
    public String getjumat(){
        return jumat;
    }
    public void setjumat(String jumat){
        this.jumat = jumat;
    }
    
    public String getsabtu(){
        return sabtu;
    }
    public void setsabtu(String sabtu){
        this.sabtu = sabtu;
    }
    
    public int getkelas(){
        return kelas;
    }
    public void setkelas(int kelas){
        this.kelas = kelas;
    }
    
    public String getwalkes(){
        return walkes;
    }
    public void setwalkes(String walkes){
        this.walkes = walkes;
    }
}
