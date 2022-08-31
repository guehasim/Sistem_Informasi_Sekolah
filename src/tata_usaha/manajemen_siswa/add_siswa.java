package tata_usaha.manajemen_siswa;

import file_koneksi.koneksi;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import tata_usaha.awal.home;


public class add_siswa extends javax.swing.JFrame {

    private Image image;
    List<entity_siswa> record=new ArrayList<entity_siswa>();
    inter_siswa siswanya;
    
    int row;
    
    private String file;
    public String dir;
    public String imgstr;
    public BufferedImage newImg;
    
    public add_siswa() {
        initComponents();
        dropdown_semester();
        dropdown_kelas();

        
        siswanya = new imple_siswa();
            tabel_siswa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_siswa.getSelectedRow();
                    if(row!=-1){
                        isiText();
                    }
                }
            });
            this.statusAwal();
    }
    
    void loadData(){
        try {
            record = siswanya.getAll_profil();
        } catch (SQLException ex) {
            Logger.getLogger(add_siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][]=new Object[record.size()][21];
        int x=0;
        for(entity_siswa thn:record){
            data[x][0]=thn.getnis();
            data[x][1]=thn.getnama();
            data[x][2]=thn.getjenkel();
            data[x][3]=thn.getagama();
            data[x][4]=thn.gettempat();
            data[x][5]=thn.gettgllahir();
            data[x][6]=thn.getalamat();            
            data[x][7]=thn.getthn_ajar();
            data[x][8]=thn.getanak_ke();
            data[x][9]=thn.getstatus_kel();
            data[x][10]=thn.getfoto();
            data[x][11]=thn.getdi_kelas();
            data[x][12]=thn.gettgl_msuk();
            data[x][13]=thn.getnm_sd();
            data[x][14]=thn.getalmt_sd();
            data[x][15]=thn.getnm_ayah();
            data[x][16]=thn.getnm_ibu();
            data[x][17]=thn.getalmt_ayah();
            data[x][18]=thn.getalmt_ibu();
            data[x][19]=thn.getpassword();
            x++;
        }
        String judul[]={"NIS","Nama","Jenis Kelamin","Agama","Tempat","Tanggal Lahir"}; 
        
        tabel_siswa.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel_siswa);
    }
    
    void isiText(){
        entity_siswa thn=record.get(row);
        
        txt_nis1.setText(thn.getnis());
        txt_nama1.setText(thn.getnama());
        txt_jenkel1.setSelectedItem(thn.getjenkel());
        txt_agama1.setSelectedItem(thn.getagama());
        txt_tempat1.setText(thn.gettempat());
        txt_tgl_lahir1.setText(thn.gettgllahir());
        txt_alamat1.setText(thn.getalamat());
        txt_anakke1.setText(thn.getanak_ke());
        txt_statuskel1.setText(thn.getstatus_kel());
        newImg = decodeToImage(thn.getfoto());
        panel_siswa2.setImage(newImg);
        txt_kelas1.setSelectedItem(thn.getdi_kelas());
        txt_tgl_masuk1.setText(thn.gettgl_msuk());
        txt_nm_sekolah1.setText(thn.getnm_sd());
        txt_almt_sekolah1.setText(thn.getalmt_sd());
        txt_nm_ayah1.setText(thn.getnm_ayah());
        txt_nm_ibu1.setText(thn.getnm_ibu());
        txt_almt_ayah1.setText(thn.getalmt_ayah());
        txt_almt_ibu1.setText(thn.getalmt_ibu());
        txt_pass1.setText(thn.getpassword());
        
        
        txt_nis2.setText(thn.getnis());
        txt_nama2.setText(thn.getnama());
        
    }
    
    void kosongkanText(){
        
        //kosongkan text pada frame simpan
        txt_nis.setText("");
        txt_nama.setText("");
        txt_tempat.setText("");
        txt_tgl_lahir.setText("");
        txt_alamat.setText("");
        txt_anakke.setText("");
        txt_statuskel.setText("");
        txt_tgl_masuk.setText("");
        txt_nm_ayah.setText("");
        txt_nm_ibu.setText("");
        txt_almt_ayah.setText("");
        txt_almt_ibu.setText("");
        txt_pass.setText("");
        txt_pass_conf.setText("");
        
        //kosongkan pada frame update
        txt_nis1.setText("");
        txt_nama1.setText("");
        txt_tempat1.setText("");
        txt_tgl_lahir1.setText("");
        txt_alamat1.setText("");
        txt_anakke1.setText("");
        txt_statuskel1.setText("");
        txt_tgl_masuk1.setText("");
        txt_nm_ayah1.setText("");
        txt_nm_ibu1.setText("");
        txt_almt_ayah1.setText("");
        txt_almt_ibu1.setText("");
        txt_pass1.setText("");
        txt_pass_conf1.setText("");
        
        //kosongkan pada frame delete
        txt_nis2.setText("");
        txt_nama2.setText("");
    }
    private void dropdown_semester() {
              try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from thn_ajar");
        while(rs.next()){
            //entity_kelas thn=new entity_kelas();
            String semester = rs.getString("nm_thnajar");
            //thn.setidKelas(rs.getString("id_kelas"));
            //thn.setnamaKelas(rs.getString("nama_kelas"));
            
//            txt_tahun_ajaran1.addItem(semester);
            txt_tahun_ajaran.addItem(semester);
        }
            
        }catch(Exception e){
            
        }
    }
    private void dropdown_kelas() {
      try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from kelas");
        while(rs.next()){
            //entity_kelas thn=new entity_kelas();
            String kelas = rs.getString("nama_kelas");
            //thn.setidKelas(rs.getString("id_kelas"));
            //thn.setnamaKelas(rs.getString("nama_kelas"));
            txt_kelas.addItem(kelas);
            txt_kelas1.addItem(kelas);
        }
            
        }catch(Exception e){
            
        }
    }
    
    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
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

     
     void foto(){
       panel_siswa1.setImage(null);
       
       JFileChooser jfc = new JFileChooser();
       jfc.setFileFilter(new FileNameExtensionFilter("jpg|png|bmp", "jpg","png","bmp"));
       jfc.showOpenDialog(null);
       File file = jfc.getSelectedFile();
       dir = file.getAbsolutePath();
        
        File data = new File(dir);
        try {
            data.createNewFile();//untuk membuat file data.yxy baru
            long ukuran = data.length();
            if(ukuran > 300000){
                JOptionPane.showMessageDialog(rootPane, "gambar terlalu besar " +ukuran+ " Byte"+"\n seharusnya diBawah 300 Kb");
            }
            else{
                try {
                    image = ImageIO.read(file);
                    panel_siswa1.setImage(image);
    
                    BufferedImage img = ImageIO.read(new File(dir));
                                       
                    imgstr = encodeToString(img, "jpg");                   
              
                } catch (IOException ex) {
                    Logger.getLogger(add_siswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        } catch (Exception e) {
            
        }
     }
     
     void foto2(){
       
       JFileChooser jfc = new JFileChooser();
       jfc.setFileFilter(new FileNameExtensionFilter("jpg|png|bmp", "jpg","png","bmp"));
       jfc.showOpenDialog(null);
       File file = jfc.getSelectedFile();
       dir = file.getAbsolutePath();
        
        File data = new File(dir);
        try {
            data.createNewFile();//untuk membuat file data.yxy baru
            long ukuran = data.length();
            if(ukuran > 200000){
                JOptionPane.showMessageDialog(rootPane, "gambar terlalu besar " +ukuran+ " Byte"+"\n seharusnya diBawah 200000 Byte");
            }
            else{
                try {
                    image = ImageIO.read(file);
                    panel_siswa2.setImage(image);
    
                    BufferedImage img = ImageIO.read(new File(dir));
                                       
                    imgstr = encodeToString(img, "jpg");                     
                                         
                } catch (IOException ex) {
                    Logger.getLogger(add_siswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        } catch (Exception e) {

        }
     }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGlass1 = new usu.widget.ButtonGlass();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_home = new komponen.tombol_besar();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_siswa = new komponen.tabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_statuskel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_anakke = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_tempat = new javax.swing.JTextField();
        txt_nm_ayah = new javax.swing.JTextField();
        txt_nm_ibu = new javax.swing.JTextField();
        txt_almt_ayah = new javax.swing.JTextField();
        txt_almt_ibu = new javax.swing.JTextField();
        txt_almt_sekolah = new javax.swing.JTextField();
        txt_nm_sekolah = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_nis = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JComboBox();
        txt_jenkel = new javax.swing.JComboBox();
        txt_tgl_masuk = new javax.swing.JLabel();
        kalender_masuk = new org.freixas.jcalendar.JCalendarCombo();
        txt_agama = new javax.swing.JComboBox();
        txt_tahun_ajaran = new javax.swing.JComboBox();
        txt_semester = new javax.swing.JComboBox();
        txt_tgl_lahir = new javax.swing.JLabel();
        kalender_lahir = new org.freixas.jcalendar.JCalendarCombo();
        txt_pass_conf = new javax.swing.JPasswordField();
        txt_pass = new javax.swing.JPasswordField();
        panel_siswa1 = new tata_usaha.manajemen_siswa.panel_siswa();
        validasi_password = new javax.swing.JLabel();
        btn_cari_foto = new javax.swing.JButton();
        btn_simpan = new usu.widget.ButtonGlass();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_statuskel1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txt_anakke1 = new javax.swing.JTextField();
        txt_alamat1 = new javax.swing.JTextField();
        txt_tempat1 = new javax.swing.JTextField();
        txt_nm_ayah1 = new javax.swing.JTextField();
        txt_nm_ibu1 = new javax.swing.JTextField();
        txt_almt_ayah1 = new javax.swing.JTextField();
        txt_almt_ibu1 = new javax.swing.JTextField();
        txt_almt_sekolah1 = new javax.swing.JTextField();
        txt_nm_sekolah1 = new javax.swing.JTextField();
        txt_nama1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txt_nis1 = new javax.swing.JLabel();
        txt_kelas1 = new javax.swing.JComboBox();
        txt_jenkel1 = new javax.swing.JComboBox();
        txt_tgl_masuk1 = new javax.swing.JLabel();
        kalender_masuk1 = new org.freixas.jcalendar.JCalendarCombo();
        txt_agama1 = new javax.swing.JComboBox();
        txt_semester1 = new javax.swing.JComboBox();
        txt_tgl_lahir1 = new javax.swing.JLabel();
        kalender_lahir1 = new org.freixas.jcalendar.JCalendarCombo();
        txt_pass_conf1 = new javax.swing.JPasswordField();
        txt_pass1 = new javax.swing.JPasswordField();
        panel_siswa2 = new tata_usaha.manajemen_siswa.panel_siswa();
        validasi_password1 = new javax.swing.JLabel();
        btn_cari_foto1 = new javax.swing.JButton();
        btn_update = new usu.widget.ButtonGlass();
        jLabel61 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txt_nama2 = new javax.swing.JTextField();
        txt_nis2 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        btn_hapus = new usu.widget.ButtonGlass();
        jLabel39 = new javax.swing.JLabel();
        txt_cari_nis = new javax.swing.JTextField();
        btn_cari = new komponen.tombol_besar();
        jLabel58 = new javax.swing.JLabel();
        btn_print = new usu.widget.ButtonGlass();

        buttonGlass1.setText("buttonGlass1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1530, 810));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SISTEM INFORMASI SEKOLAH");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 1370, 32));

        jLabel2.setFont(new java.awt.Font("Swis721 Blk BT", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SD NEGERI SUMBER SEKAR 03");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 73, 1360, 18));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, 1350, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1350, -1));

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        btn_home.setText("Home");
        btn_home.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel3.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, -1, 130));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 150));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1370, 20));

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_siswa.setForeground(new java.awt.Color(0, 0, 0));
        tabel_siswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tabel_siswa);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 740, 400));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*Tambah Data Siswa");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_statuskel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_statuskel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 140, 25));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jenis Kelamin");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Agama");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tempat Lahir");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tanggal Lahir");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Alamat");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tahun Ajaran");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Anak ke");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Status Keluarga");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 120, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Foto");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Di Terima Di Sekolah Ini :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Semester");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Di Kelas");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Pada Tanggal");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Sekolah Asal :");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nama Sekolah");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Alamat Sekolah");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nama Orang Tua :");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Ayah");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Ibu");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Alamat Orang Tua :");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        txt_anakke.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_anakke, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 40, 25));

        txt_alamat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 140, 25));

        txt_tempat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_tempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 140, 25));

        txt_nm_ayah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_nm_ayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 160, 25));

        txt_nm_ibu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_nm_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 160, 25));

        txt_almt_ayah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_almt_ayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 160, 25));

        txt_almt_ibu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_almt_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 160, 25));

        txt_almt_sekolah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_almt_sekolah.setText("jln. SumberSekar No.155 Dau");
        jPanel5.add(txt_almt_sekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 160, 25));

        txt_nm_sekolah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_nm_sekolah.setText("SDN SUMBERSEKAR 03");
        jPanel5.add(txt_nm_sekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 160, 25));

        txt_nama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 25));

        txt_nis.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nisKeyTyped(evt);
            }
        });
        jPanel5.add(txt_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Ayah");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Ibu");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Password");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Ulangi Password");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("NIS");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_kelas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 60, 25));

        txt_jenkel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_jenkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-Laki", "Perempuan" }));
        jPanel5.add(txt_jenkel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, 25));

        txt_tgl_masuk.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tgl_masuk.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_tgl_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 110, 25));

        kalender_masuk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd-MM-yyyy" }));
        kalender_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalender_masukActionPerformed(evt);
            }
        });
        jPanel5.add(kalender_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 40, 25));

        txt_agama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_agama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Islam", "Kristen", "Hindu", "Budha", "Kong Hu Chu" }));
        jPanel5.add(txt_agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, 25));

        txt_tahun_ajaran.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_tahun_ajaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 140, 25));

        txt_semester.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ganjil", "Genap" }));
        jPanel5.add(txt_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 150, 25));

        txt_tgl_lahir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tgl_lahir.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, 25));

        kalender_lahir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd-MM-yyyy" }));
        kalender_lahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalender_lahirActionPerformed(evt);
            }
        });
        jPanel5.add(kalender_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 40, 25));

        txt_pass_conf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pass_confKeyReleased(evt);
            }
        });
        jPanel5.add(txt_pass_conf, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 160, 25));
        jPanel5.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 160, 25));

        javax.swing.GroupLayout panel_siswa1Layout = new javax.swing.GroupLayout(panel_siswa1);
        panel_siswa1.setLayout(panel_siswa1Layout);
        panel_siswa1Layout.setHorizontalGroup(
            panel_siswa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        panel_siswa1Layout.setVerticalGroup(
            panel_siswa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel5.add(panel_siswa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 110, 130));

        validasi_password.setForeground(new java.awt.Color(255, 255, 255));
        validasi_password.setText("Validasi");
        jPanel5.add(validasi_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 160, -1));

        btn_cari_foto.setText("Cari Foto");
        btn_cari_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_fotoActionPerformed(evt);
            }
        });
        jPanel5.add(btn_cari_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 110, -1));

        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel5.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 130, -1));

        jTabbedPane1.addTab("Tambah Data Siswa", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 0, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*Ubah Data Siswa");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Nama");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_statuskel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_statuskel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 140, 25));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Jenis Kelamin");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Agama");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Tempat Lahir");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Tanggal Lahir");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Alamat");
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Anak ke");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Status Keluarga");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 120, -1));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Foto");
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Di Terima Di Sekolah Ini :");
        jPanel6.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Semester");
        jPanel6.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Di Kelas");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Pada Tanggal");
        jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Sekolah Asal :");
        jPanel6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Nama Sekolah");
        jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Alamat Sekolah");
        jPanel6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Nama Orang Tua :");
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Ayah");
        jPanel6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Ibu");
        jPanel6.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Alamat Orang Tua :");
        jPanel6.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        txt_anakke1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_anakke1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 40, 25));

        txt_alamat1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_alamat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 140, 25));

        txt_tempat1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_tempat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 140, 25));

        txt_nm_ayah1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_nm_ayah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 160, 25));

        txt_nm_ibu1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_nm_ibu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 160, 25));

        txt_almt_ayah1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_almt_ayah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 160, 25));

        txt_almt_ibu1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_almt_ibu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 160, 25));

        txt_almt_sekolah1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_almt_sekolah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 160, 25));

        txt_nm_sekolah1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_nm_sekolah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 160, 25));

        txt_nama1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 25));

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Ayah");
        jPanel6.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Ibu");
        jPanel6.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Password");
        jPanel6.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        jLabel57.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Ulangi Password");
        jPanel6.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        txt_nis1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_nis1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(txt_nis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        txt_kelas1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_kelas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 60, 25));

        txt_jenkel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_jenkel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-Laki", "Perempuan" }));
        jPanel6.add(txt_jenkel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, 25));

        txt_tgl_masuk1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tgl_masuk1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(txt_tgl_masuk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 110, 25));

        kalender_masuk1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd-MM-yyyy" }));
        kalender_masuk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalender_masuk1ActionPerformed(evt);
            }
        });
        jPanel6.add(kalender_masuk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 40, 25));

        txt_agama1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_agama1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Islam", "Kristen", "Hindu", "Budha", "Kong Hu Chu" }));
        jPanel6.add(txt_agama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, 25));

        txt_semester1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_semester1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ganjil", "Genap" }));
        jPanel6.add(txt_semester1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 150, 25));

        txt_tgl_lahir1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tgl_lahir1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(txt_tgl_lahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, 25));

        kalender_lahir1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd-MM-yyyy" }));
        kalender_lahir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalender_lahir1ActionPerformed(evt);
            }
        });
        jPanel6.add(kalender_lahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 40, 25));

        txt_pass_conf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pass_conf1KeyReleased(evt);
            }
        });
        jPanel6.add(txt_pass_conf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 160, 25));
        jPanel6.add(txt_pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 160, 25));

        javax.swing.GroupLayout panel_siswa2Layout = new javax.swing.GroupLayout(panel_siswa2);
        panel_siswa2.setLayout(panel_siswa2Layout);
        panel_siswa2Layout.setHorizontalGroup(
            panel_siswa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        panel_siswa2Layout.setVerticalGroup(
            panel_siswa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel6.add(panel_siswa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 110, 130));

        validasi_password1.setForeground(new java.awt.Color(255, 255, 255));
        validasi_password1.setText("Validasi");
        jPanel6.add(validasi_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 160, -1));

        btn_cari_foto1.setText("Cari Foto");
        btn_cari_foto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_foto1ActionPerformed(evt);
            }
        });
        jPanel6.add(btn_cari_foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 110, -1));

        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btn_update.setText("Ubah");
        btn_update.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel6.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 130, -1));

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("NIS");
        jPanel6.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jTabbedPane1.addTab("Ubah Data Siswa", jPanel6);

        jPanel9.setBackground(new java.awt.Color(0, 0, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 0, 0));
        jLabel59.setText("*Hapus Data Siswa");
        jPanel9.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel60.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Nama");
        jPanel9.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_nama2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel9.add(txt_nama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 25));

        txt_nis2.setEditable(false);
        txt_nis2.setBackground(new java.awt.Color(255, 255, 102));
        txt_nis2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel9.add(txt_nis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        jLabel85.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("NIS");
        jPanel9.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel9.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 130, -1));

        jTabbedPane1.addTab("Hapus Data Siswa", jPanel9);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 600, 560));

        jLabel39.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("*Manajemen Siswa");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_cari_nis.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jPanel4.add(txt_cari_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 240, 30));

        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 40, 50));

        jLabel58.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("NIS");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        btn_print.setText("Cetak");
        btn_print.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel4.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 150, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1370, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try{
            
            //insert ke profil db_siswa
            entity_siswa ko = new entity_siswa();
            
            if(txt_nis.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "NIS Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nis.requestFocus();
            }
            else if(txt_nama.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Nama Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nama.requestFocus();
            }
            else if(txt_jenkel.getSelectedItem().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Jenis Kelamin Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_jenkel.requestFocus();
            }
            else if(txt_agama.getSelectedItem().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Agama Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_agama.requestFocus();
            }
            else if(txt_tempat.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Tempat Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_tempat.requestFocus();
            }
            else if(txt_tgl_lahir.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Tanggal Lahir Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_tgl_lahir.requestFocus();
            }
            else if(txt_alamat.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Alamat Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_alamat.requestFocus();
            }
            else if(txt_kelas.getSelectedItem().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Kelas Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kelas.requestFocus();
            }
            else if(txt_tgl_masuk.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Tanggal Masuk Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_tgl_masuk.requestFocus();
            }
            else if(txt_nm_ayah.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Nama Ayah Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nm_ayah.requestFocus();
            }
            else if(txt_nm_ibu.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Nama Ibu Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nm_ibu.requestFocus();
            }
            else if(txt_pass.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Password Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_pass.requestFocus();
            }
            else if(txt_pass_conf.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "konfirmasi Password Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_pass_conf.requestFocus();
            }
            else if(validasi_password.getText().equals("Password Tidak sama") || validasi_password.getText().equals("Validasi Password")){
                JOptionPane.showMessageDialog(rootPane, "Konfirmasi Password Belum Betul\n"
                        + "Silahkan Dibetulkan lagi sampai betul","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_pass_conf.requestFocus();
            }
            else{
                ko.setnis(txt_nis.getText());
                ko.setnama(txt_nama.getText());
                ko.setjenkel(txt_jenkel.getSelectedItem().toString());
                ko.setagama(txt_agama.getSelectedItem().toString());
                ko.settempat(txt_tempat.getText());
                ko.settgllahir(txt_tgl_lahir.getText());
                ko.setalamat(txt_alamat.getText());
                ko.setanak_ke(txt_anakke.getText());
                ko.setstatus_kel(txt_statuskel.getText());
                ko.setfoto(imgstr);
                ko.setdi_kelas(txt_kelas.getSelectedItem().toString());
                ko.settgl_msuk(txt_tgl_masuk.getText());
                ko.setnm_sd(txt_nm_sekolah.getText());
                ko.setalmt_sd(txt_almt_sekolah.getText());
                ko.setnm_ayah(txt_nm_ayah.getText());
                ko.setnm_ibu(txt_nm_ibu.getText());
                ko.setalmt_ayah(txt_almt_ayah.getText());
                ko.setalmt_ibu(txt_almt_ibu.getText());
                ko.setpassword(txt_pass.getText());
                siswanya.insert_profil(ko);
                
                entity_siswa akt = new entity_siswa();
                akt.setthn_ajar(txt_tahun_ajaran.getSelectedItem().toString());
                akt.setsemester(txt_semester.getSelectedItem().toString());
                akt.setdi_kelas(txt_kelas.getSelectedItem().toString());
                akt.setnis(txt_nis.getText());
                akt.setnama(txt_nama.getText());
                siswanya.insert_data(akt);
                
                JOptionPane.showMessageDialog(this, "data berhasil disimpan");
                this.statusAwal();
                panel_siswa1.setImage(null);
            }
        }catch(SQLException ex){
            Logger.getLogger(add_siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_cari_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_fotoActionPerformed
        foto();
    }//GEN-LAST:event_btn_cari_fotoActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try{
            
            //insert ke profil db_siswa
            entity_siswa ko = new entity_siswa();
                        
                ko.setnis(txt_nis1.getText());
                ko.setnama(txt_nama1.getText());
                ko.setjenkel(txt_jenkel1.getSelectedItem().toString());
                ko.setagama(txt_agama1.getSelectedItem().toString());
                ko.settempat(txt_tempat1.getText());
                ko.settgllahir(txt_tgl_lahir1.getText());
                ko.setalamat(txt_alamat1.getText());
                ko.setanak_ke(txt_anakke1.getText());
                ko.setstatus_kel(txt_statuskel1.getText());
                ko.setfoto(imgstr);
                ko.setdi_kelas(txt_kelas1.getSelectedItem().toString());
                ko.settgl_msuk(txt_tgl_masuk1.getText());
                ko.setnm_sd(txt_nm_sekolah1.getText());
                ko.setalmt_sd(txt_almt_sekolah1.getText());
                ko.setnm_ayah(txt_nm_ayah1.getText());
                ko.setnm_ibu(txt_nm_ibu1.getText());
                ko.setalmt_ayah(txt_almt_ayah1.getText());
                ko.setalmt_ibu(txt_almt_ibu1.getText());
                ko.setpassword(txt_pass1.getText());
                siswanya.update_profil(ko);
                
                entity_siswa akt = new entity_siswa();
//                akt.setthn_ajar(txt_tahun_ajaran1.getSelectedItem().toString());
                akt.setsemester(txt_semester1.getSelectedItem().toString());
                akt.setdi_kelas(txt_kelas1.getSelectedItem().toString());
                akt.setnis(txt_nis1.getText());
                akt.setnama(txt_nama1.getText());
                
                siswanya.update_data(akt);
                
                JOptionPane.showMessageDialog(this, "data berhasil di ubah");
                this.statusAwal();
                panel_siswa2.setImage(null);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "data belum bisa di ubah");
            Logger.getLogger(add_siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void kalender_lahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalender_lahirActionPerformed
        SimpleDateFormat tanggal = new SimpleDateFormat();
        tanggal = new SimpleDateFormat("dd-MM-yyyy");
        txt_tgl_lahir.setText(tanggal.format(kalender_lahir.getDate()));
    }//GEN-LAST:event_kalender_lahirActionPerformed

    private void txt_nisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nisKeyTyped
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nisKeyTyped

    private void kalender_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalender_masukActionPerformed
        SimpleDateFormat tanggal = new SimpleDateFormat();
        tanggal = new SimpleDateFormat("dd-MM-yyyy");
        txt_tgl_masuk.setText(tanggal.format(kalender_masuk.getDate()));
    }//GEN-LAST:event_kalender_masukActionPerformed

    private void txt_pass_confKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pass_confKeyReleased
        if(txt_pass_conf.getText().equals(txt_pass.getText())){
        validasi_password.setText("Password sama");
        }else{
        validasi_password.setText("Password Tidak sama");}
    }//GEN-LAST:event_txt_pass_confKeyReleased

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed

        try{
            // delete database siswa
            String nim = txt_nis2.getText();
            siswanya.delete_profil(nim);
            
            //delete database aktif siswa
            siswanya.delete_data(nim);
            JOptionPane.showMessageDialog(this, "data berhasil di hapus");
            this.statusAwal();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "data berhasil di hapus");
            Logger.getLogger(add_siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void kalender_lahir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalender_lahir1ActionPerformed
        SimpleDateFormat tanggal = new SimpleDateFormat();
        tanggal = new SimpleDateFormat("dd-MM-yyyy");
        txt_tgl_lahir1.setText(tanggal.format(kalender_lahir1.getDate()));
    }//GEN-LAST:event_kalender_lahir1ActionPerformed

    private void kalender_masuk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalender_masuk1ActionPerformed
        SimpleDateFormat tanggal = new SimpleDateFormat();
        tanggal = new SimpleDateFormat("dd-MM-yyyy");
        txt_tgl_masuk1.setText(tanggal.format(kalender_masuk1.getDate()));
    }//GEN-LAST:event_kalender_masuk1ActionPerformed

    private void txt_pass_conf1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pass_conf1KeyReleased
        if(txt_pass_conf1.getText().equals(txt_pass1.getText())){
        validasi_password1.setText("Password sama");
        }else{
        validasi_password1.setText("Password Tidak sama");}
    }//GEN-LAST:event_txt_pass_conf1KeyReleased

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        String header[]={"NIS","Nama","Jenis Kelamin","Agama","Tempat","Tanggal Lahir"};
        
        DefaultTableModel dt = new DefaultTableModel(null, header);
        tabel_siswa.setModel(dt);
        
        for(int i=0; i<tabel_siswa.getRowCount();i++){
            dt.removeRow(i);
        }
        
        try{
             
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from siswa where nis "
                    + "like '%"+txt_cari_nis.getText()+"%' ");
            
            while (rs.next()){
                String nis = rs.getString(1);
                String nama = rs.getString(2);
                String jenkel = rs.getString(3);
                String agama = rs.getString(4);
                String tempat = rs.getString(5);
                String tgllahir = rs.getString(6);
                
                Object baris[] = {nis,nama,jenkel,agama,tempat,tgllahir};
                dt.addRow(baris);
                
            }
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
       new add_siswa().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        try{
            Statement st=koneksi.getConnection().createStatement();
            
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("D:/Data Siswa.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("NIS");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Jenis Kelamin");
            row1.createCell(3).setCellValue("Agama");
            row1.createCell(4).setCellValue("Tempat");
            row1.createCell(5).setCellValue("Tanggal Lahir");
            row1.createCell(6).setCellValue("Alamat");
            row1.createCell(7).setCellValue("AnakKe");
            row1.createCell(8).setCellValue("StatusKel");
            row1.createCell(9).setCellValue("Diterima Di Kelas");
            row1.createCell(10).setCellValue("Tanggal Masuk");
            row1.createCell(11).setCellValue("Nama Sekolah");
            row1.createCell(12).setCellValue("Alamat Sekolah");
            row1.createCell(13).setCellValue("Ayah");
            row1.createCell(14).setCellValue("Ibu");
            row1.createCell(15).setCellValue("Alamat Ayah");
            row1.createCell(16).setCellValue("Alamat Ibu");
            Row row2;           
            
            ResultSet rs=st.executeQuery("select nis,nama,jenkel,agama,tempat,tgllahir,"
                    + "alamat,anakke,statuskel,di_kelas,tglmasuk,namasekolah,"
                    + "alamatsekolah,ayah,ibu,alamatayah,alamatibu from siswa");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                row2.createCell(5).setCellValue(rs.getString(6));
                row2.createCell(6).setCellValue(rs.getString(7));
                row2.createCell(7).setCellValue(rs.getString(8));
                row2.createCell(8).setCellValue(rs.getString(9));
                row2.createCell(9).setCellValue(rs.getString(10));
                row2.createCell(10).setCellValue(rs.getString(11));
                row2.createCell(11).setCellValue(rs.getString(12));
                row2.createCell(12).setCellValue(rs.getString(13));
                row2.createCell(13).setCellValue(rs.getString(14));
                row2.createCell(14).setCellValue(rs.getString(15));
                row2.createCell(15).setCellValue(rs.getString(16));
                row2.createCell(16).setCellValue(rs.getString(17));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            st.close();
            koneksi.getConnection().close();
            JOptionPane.showMessageDialog(null, "Data Sukses Disimpan di Local Disk D:");
        }catch(  SQLException | IOException e){
        JOptionPane.showMessageDialog(null, "Ada Kesalahan, Data Tidak Dicetak");
    }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_cari_foto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_foto1ActionPerformed
        foto2();
    }//GEN-LAST:event_btn_cari_foto1ActionPerformed

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
            java.util.logging.Logger.getLogger(add_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new add_siswa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.tombol_besar btn_cari;
    private javax.swing.JButton btn_cari_foto;
    private javax.swing.JButton btn_cari_foto1;
    private usu.widget.ButtonGlass btn_hapus;
    private komponen.tombol_besar btn_home;
    private usu.widget.ButtonGlass btn_print;
    private usu.widget.ButtonGlass btn_simpan;
    private usu.widget.ButtonGlass btn_update;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.freixas.jcalendar.JCalendarCombo kalender_lahir;
    private org.freixas.jcalendar.JCalendarCombo kalender_lahir1;
    private org.freixas.jcalendar.JCalendarCombo kalender_masuk;
    private org.freixas.jcalendar.JCalendarCombo kalender_masuk1;
    private tata_usaha.manajemen_siswa.panel_siswa panel_siswa1;
    private tata_usaha.manajemen_siswa.panel_siswa panel_siswa2;
    private komponen.tabel tabel_siswa;
    private javax.swing.JComboBox txt_agama;
    private javax.swing.JComboBox txt_agama1;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_alamat1;
    private javax.swing.JTextField txt_almt_ayah;
    private javax.swing.JTextField txt_almt_ayah1;
    private javax.swing.JTextField txt_almt_ibu;
    private javax.swing.JTextField txt_almt_ibu1;
    private javax.swing.JTextField txt_almt_sekolah;
    private javax.swing.JTextField txt_almt_sekolah1;
    private javax.swing.JTextField txt_anakke;
    private javax.swing.JTextField txt_anakke1;
    private javax.swing.JTextField txt_cari_nis;
    private javax.swing.JComboBox txt_jenkel;
    private javax.swing.JComboBox txt_jenkel1;
    private javax.swing.JComboBox txt_kelas;
    private javax.swing.JComboBox txt_kelas1;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nama1;
    private javax.swing.JTextField txt_nama2;
    private javax.swing.JTextField txt_nis;
    private javax.swing.JLabel txt_nis1;
    private javax.swing.JTextField txt_nis2;
    private javax.swing.JTextField txt_nm_ayah;
    private javax.swing.JTextField txt_nm_ayah1;
    private javax.swing.JTextField txt_nm_ibu;
    private javax.swing.JTextField txt_nm_ibu1;
    private javax.swing.JTextField txt_nm_sekolah;
    private javax.swing.JTextField txt_nm_sekolah1;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JPasswordField txt_pass1;
    private javax.swing.JPasswordField txt_pass_conf;
    private javax.swing.JPasswordField txt_pass_conf1;
    private javax.swing.JComboBox txt_semester;
    private javax.swing.JComboBox txt_semester1;
    private javax.swing.JTextField txt_statuskel;
    private javax.swing.JTextField txt_statuskel1;
    private javax.swing.JComboBox txt_tahun_ajaran;
    private javax.swing.JTextField txt_tempat;
    private javax.swing.JTextField txt_tempat1;
    private javax.swing.JLabel txt_tgl_lahir;
    private javax.swing.JLabel txt_tgl_lahir1;
    private javax.swing.JLabel txt_tgl_masuk;
    private javax.swing.JLabel txt_tgl_masuk1;
    private javax.swing.JLabel validasi_password;
    private javax.swing.JLabel validasi_password1;
    // End of variables declaration//GEN-END:variables
}
