package tata_usaha.manajemen_jab_guru;

import file_koneksi.koneksi;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class tampil_struktur extends javax.swing.JFrame {

    String nip_kepsek;
    String nip_sek;
    String nip_ben;
    String nip_satu;
    String nip_dua;
    String nip_tiga;
    String nip_empat;
    String nip_lima;
    String nip_enam;
    
    BufferedImage img_kepsek;
    BufferedImage img_sek;
    BufferedImage img_ben;
    BufferedImage img_satu;
    BufferedImage img_dua;
    BufferedImage img_tiga;
    BufferedImage img_empat;
    BufferedImage img_lima;
    BufferedImage img_enam;
    
    
    public tampil_struktur() {
        initComponents();
        semua();
    }
    
    void met_kepsek(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Kepala Sekolah'");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_kepsek = nip;
         
            fot_kepsek();
        }
            
        }catch(Exception e){
            
        }
        
    }
        
    void met_sek(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Sekretaris'");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_sek = nip;
            
            fot_sek();
        }
            
        }catch(Exception e){
            
        }
    }
    
    void met_ben(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Bendahara'");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_ben = nip;
         
            fot_ben();
        }
            
        }catch(Exception e){
            
        }
    }
    
    void met_satu(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Wali Kelas' and kel_jab='1' ");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_satu = nip;
         
            fot_kelas1();
        }
            
        }catch(Exception e){
            
        }
    }
    
    void met_dua(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Wali Kelas' and kel_jab='2' ");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_dua = nip;
         
            fot_kelas2();
        }
            
        }catch(Exception e){
            
        }
    }
    
    void met_tiga(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Wali Kelas' and kel_jab='3' ");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_tiga = nip;
         
            fot_kelas3();
        }
            
        }catch(Exception e){
            
        }
    }
    
    void met_empat(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Wali Kelas' and kel_jab='4' ");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_empat = nip;
         
            fot_kelas4();
        }
            
        }catch(Exception e){
            
        }
    }
    
    void met_lima(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Wali Kelas' and kel_jab='5' ");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_lima = nip;
         
            fot_kelas5();
        }
            
        }catch(Exception e){
            
        }
    }
    
    void met_enam(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Wali Kelas' and kel_jab='6' ");
        while(rs.next()){
            
            String nip = rs.getString("nip_jab");
            
            nip_enam = nip;
         
            fot_kelas6();
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_kepsek(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_kepsek+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
                        
         txt_kepsek.setText(nama);
         img_kepsek = decodeToImage(foto);
         pnl_kepsek.setImage(img_kepsek);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_sek(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_sek+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
                        
         txt_sekretaris.setText(nama);
         img_sek = decodeToImage(foto);
         pnl_sekretaris.setImage(img_sek);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_ben(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_ben+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
                        
         txt_bendahara.setText(nama);
         img_ben = decodeToImage(foto);
         pnl_bendahara.setImage(img_ben);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_kelas1(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_satu+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
                        
         txt_kelas1.setText(nama);
         img_satu = decodeToImage(foto);
         pnl_kelas1.setImage(img_satu);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_kelas2(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_dua+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
         
         txt_kelas2.setText(nama);
         img_dua = decodeToImage(foto);
         pnl_kelas2.setImage(img_dua);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_kelas3(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_tiga+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
         
         txt_kelas3.setText(nama);
         img_tiga = decodeToImage(foto);
         pnl_kelas3.setImage(img_tiga);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_kelas4(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_empat+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
         
         txt_kelas4.setText(nama);
         img_empat = decodeToImage(foto);
         pnl_kelas4.setImage(img_empat);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_kelas5(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_lima+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
                        
         txt_kelas5.setText(nama);
         img_lima = decodeToImage(foto);
         pnl_kelas5.setImage(img_lima);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void fot_kelas6(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru where nip='"+nip_enam+"'");
        while(rs.next()){
            
            String nama = rs.getString("nama");
            String foto = rs.getString("foto");
                        
         txt_kelas6.setText(nama);
         img_enam = decodeToImage(foto);
         pnl_kelas6.setImage(img_enam);
        }
            
        }catch(Exception e){
            
        }
    }
    
            public static String encodeToString(BufferedImage image, String type){
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
    
     public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
     
     void semua(){
         met_kepsek();
         met_sek();
         met_ben();
         met_satu();
         met_dua();
         met_tiga();
         met_empat();
         met_lima();
         met_enam();
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGlass1 = new usu.widget.ButtonGlass();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnl_kelas1 = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_kepsek = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_sekretaris = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_bendahara = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_kelas4 = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_kelas3 = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_kelas2 = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_kelas5 = new tata_usaha.manajemen_jab_guru.panel_upload();
        pnl_kelas6 = new tata_usaha.manajemen_jab_guru.panel_upload();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        txt_kelas1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_kepsek = new javax.swing.JLabel();
        txt_sekretaris = new javax.swing.JLabel();
        txt_bendahara = new javax.swing.JLabel();
        txt_kelas6 = new javax.swing.JLabel();
        txt_kelas5 = new javax.swing.JLabel();
        txt_kelas4 = new javax.swing.JLabel();
        txt_kelas3 = new javax.swing.JLabel();
        txt_kelas2 = new javax.swing.JLabel();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        buttonGlass1.setText("buttonGlass1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1530, 810));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1530, 810));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pnl_kelas1Layout = new javax.swing.GroupLayout(pnl_kelas1);
        pnl_kelas1.setLayout(pnl_kelas1Layout);
        pnl_kelas1Layout.setHorizontalGroup(
            pnl_kelas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnl_kelas1Layout.setVerticalGroup(
            pnl_kelas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_kelas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 110, 150));

        javax.swing.GroupLayout pnl_kepsekLayout = new javax.swing.GroupLayout(pnl_kepsek);
        pnl_kepsek.setLayout(pnl_kepsekLayout);
        pnl_kepsekLayout.setHorizontalGroup(
            pnl_kepsekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        pnl_kepsekLayout.setVerticalGroup(
            pnl_kepsekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_kepsek, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 150, 200));

        javax.swing.GroupLayout pnl_sekretarisLayout = new javax.swing.GroupLayout(pnl_sekretaris);
        pnl_sekretaris.setLayout(pnl_sekretarisLayout);
        pnl_sekretarisLayout.setHorizontalGroup(
            pnl_sekretarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        pnl_sekretarisLayout.setVerticalGroup(
            pnl_sekretarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_sekretaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 120, 170));

        javax.swing.GroupLayout pnl_bendaharaLayout = new javax.swing.GroupLayout(pnl_bendahara);
        pnl_bendahara.setLayout(pnl_bendaharaLayout);
        pnl_bendaharaLayout.setHorizontalGroup(
            pnl_bendaharaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        pnl_bendaharaLayout.setVerticalGroup(
            pnl_bendaharaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_bendahara, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 120, 170));

        javax.swing.GroupLayout pnl_kelas4Layout = new javax.swing.GroupLayout(pnl_kelas4);
        pnl_kelas4.setLayout(pnl_kelas4Layout);
        pnl_kelas4Layout.setHorizontalGroup(
            pnl_kelas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnl_kelas4Layout.setVerticalGroup(
            pnl_kelas4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_kelas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 110, 150));

        javax.swing.GroupLayout pnl_kelas3Layout = new javax.swing.GroupLayout(pnl_kelas3);
        pnl_kelas3.setLayout(pnl_kelas3Layout);
        pnl_kelas3Layout.setHorizontalGroup(
            pnl_kelas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnl_kelas3Layout.setVerticalGroup(
            pnl_kelas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_kelas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 110, 150));

        javax.swing.GroupLayout pnl_kelas2Layout = new javax.swing.GroupLayout(pnl_kelas2);
        pnl_kelas2.setLayout(pnl_kelas2Layout);
        pnl_kelas2Layout.setHorizontalGroup(
            pnl_kelas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnl_kelas2Layout.setVerticalGroup(
            pnl_kelas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_kelas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 110, 150));

        javax.swing.GroupLayout pnl_kelas5Layout = new javax.swing.GroupLayout(pnl_kelas5);
        pnl_kelas5.setLayout(pnl_kelas5Layout);
        pnl_kelas5Layout.setHorizontalGroup(
            pnl_kelas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnl_kelas5Layout.setVerticalGroup(
            pnl_kelas5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_kelas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 110, 150));

        javax.swing.GroupLayout pnl_kelas6Layout = new javax.swing.GroupLayout(pnl_kelas6);
        pnl_kelas6.setLayout(pnl_kelas6Layout);
        pnl_kelas6Layout.setHorizontalGroup(
            pnl_kelas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        pnl_kelas6Layout.setVerticalGroup(
            pnl_kelas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel4.add(pnl_kelas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 560, 110, 150));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 0, 0));
        jTextField1.setBorder(null);
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 150, 5));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 0, 0));
        jTextField2.setBorder(null);
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 5, 240));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 0, 0));
        jTextField3.setBorder(null);
        jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 1005, 5));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 0, 0));
        jTextField4.setBorder(null);
        jPanel4.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 5, 35));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 0, 0));
        jTextField5.setBorder(null);
        jPanel4.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 500, 5, 35));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 0, 0));
        jTextField6.setBorder(null);
        jPanel4.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 5, 35));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 0, 0));
        jTextField7.setBorder(null);
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 5, 35));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(255, 0, 0));
        jTextField8.setBorder(null);
        jPanel4.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 500, 5, 35));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(255, 0, 0));
        jTextField9.setBorder(null);
        jPanel4.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 5, 35));

        txt_kelas1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kelas1.setForeground(new java.awt.Color(255, 255, 255));
        txt_kelas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_kelas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 710, 110, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Kepala Sekolah");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Kelas 6");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 540, 110, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sekretaris");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 120, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Kelas 1");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 110, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Kelas 2");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 110, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Kelas 3");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, 110, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Kelas 4");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 540, 110, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Kelas 5");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 540, 110, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Bendahara");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 120, -1));

        txt_kepsek.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kepsek.setForeground(new java.awt.Color(255, 255, 255));
        txt_kepsek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_kepsek, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 150, 20));

        txt_sekretaris.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_sekretaris.setForeground(new java.awt.Color(255, 255, 255));
        txt_sekretaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_sekretaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 120, 20));

        txt_bendahara.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_bendahara.setForeground(new java.awt.Color(255, 255, 255));
        txt_bendahara.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_bendahara, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 120, 20));

        txt_kelas6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kelas6.setForeground(new java.awt.Color(255, 255, 255));
        txt_kelas6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_kelas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 710, 110, 20));

        txt_kelas5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kelas5.setForeground(new java.awt.Color(255, 255, 255));
        txt_kelas5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_kelas5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 710, 110, 20));

        txt_kelas4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kelas4.setForeground(new java.awt.Color(255, 255, 255));
        txt_kelas4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_kelas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 710, 110, 20));

        txt_kelas3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kelas3.setForeground(new java.awt.Color(255, 255, 255));
        txt_kelas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_kelas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 710, 110, 20));

        txt_kelas2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_kelas2.setForeground(new java.awt.Color(255, 255, 255));
        txt_kelas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(txt_kelas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 710, 110, 20));

        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        buttonImageReflection1.setText("Back");
        buttonImageReflection1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection1ActionPerformed(evt);
            }
        });
        jPanel4.add(buttonImageReflection1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 760));

        jPanel2.setBackground(new java.awt.Color(244, 130, 17));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/jab_ic.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/kanan.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 70, 550));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/kiri.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 70, 550));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 170, 760));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonImageReflection1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection1ActionPerformed
        new tampil_struktur().setVisible(false);
        dispose();
        new tabel_jabatan().setVisible(true);
    }//GEN-LAST:event_buttonImageReflection1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tampil_struktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampil_struktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampil_struktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampil_struktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new tampil_struktur().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass buttonGlass1;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_bendahara;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_kelas1;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_kelas2;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_kelas3;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_kelas4;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_kelas5;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_kelas6;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_kepsek;
    private tata_usaha.manajemen_jab_guru.panel_upload pnl_sekretaris;
    private javax.swing.JLabel txt_bendahara;
    private javax.swing.JLabel txt_kelas1;
    private javax.swing.JLabel txt_kelas2;
    private javax.swing.JLabel txt_kelas3;
    private javax.swing.JLabel txt_kelas4;
    private javax.swing.JLabel txt_kelas5;
    private javax.swing.JLabel txt_kelas6;
    private javax.swing.JLabel txt_kepsek;
    private javax.swing.JLabel txt_sekretaris;
    // End of variables declaration//GEN-END:variables
}
