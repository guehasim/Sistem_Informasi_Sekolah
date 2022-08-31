package tata_usaha.manajemen_guru;

import file_koneksi.koneksi;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
import tata_usaha.manajemen_jab_guru.imple_jabatan;
import tata_usaha.manajemen_jab_guru.inter_jabatan;

public class add_guru extends javax.swing.JFrame {

    private Image image;
    List<entity_guru> record=new ArrayList<entity_guru>();
    inter_guru gurunya;
    inter_jabatan jabatannya;
    int row;
    private String file;
    
    public String dir;
    public String imgstr;
    public BufferedImage newImg;
    
    public add_guru() {
        initComponents();
        
        gurunya = new imple_guru();
        jabatannya = new imple_jabatan();
                
            tabel_guru.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_guru.getSelectedRow();
                    if(row!=-1){
                        isiText();
                    }
                }
            });
            this.statusAwal();
    }
    
    void loadData(){
        try {
            record = gurunya.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(add_guru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][]=new Object[record.size()][16];
        int x=0;
        for(entity_guru thn:record){
            data[x][0]=thn.getnip();
            data[x][1]=thn.getnama();
            data[x][2]=thn.gettempat();
            data[x][3]=thn.gettgllahir();
            data[x][4]=thn.getjenkel();
            data[x][5]=thn.getagama();
            data[x][6]=thn.getgolongdar();
            data[x][7]=thn.getpendidikan();
            data[x][8]=thn.getnama_ortu();
            data[x][9]=thn.getalamat();
            data[x][10]=thn.getdesa();
            data[x][11]=thn.getkecamatan();
            data[x][12]=thn.getkota();
            data[x][13]=thn.getpropinsi();
            data[x][14]=thn.getfoto();
            x++;
        }
        String judul[]={"NIP","Nama","Tempat"}; 
        
        tabel_guru.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel_guru);
    }
    
    void isiText(){
        entity_guru thn=record.get(row);
        txt_nip1.setText(thn.getnip());
        txt_nama1.setText(thn.getnama());
        txt_tempat1.setText(thn.gettempat());
        txt_tgl_lahir1.setText(thn.gettgllahir());
        txt_jenkel1.setSelectedItem(thn.getjenkel());
        txt_agama1.setSelectedItem(thn.getagama());
        txt_goldar1.setSelectedItem(thn.getgolongdar());
        txt_pendidikan1.setSelectedItem(thn.getpendidikan());
        txt_nm_ortu1.setText(thn.getnama_ortu());
        txt_alamat1.setText(thn.getalamat());
        txt_desa1.setText(thn.getdesa());
        txt_kecamatan1.setText(thn.getkecamatan());
        txt_kota1.setText(thn.getkota());
        txt_propinsi1.setSelectedItem(thn.getpropinsi());
        newImg = decodeToImage(thn.getfoto());
        panel_upload2.setImage(newImg);
        
        txt_nip2.setText(thn.getnip());
        txt_nama2.setText(thn.getnama());
        
    }
    
    void kosongkanText(){
        
        //kosong frame tambah pelajaran
        txt_nip.setText("");
        txt_nama.setText("");
        txt_tempat.setText("");
        txt_tgl_lahir.setText("");
        txt_nm_ortu.setText("");
        txt_alamat.setText("");
        txt_desa.setText("");
        txt_kecamatan.setText("");
        txt_kota.setText("");
        
        //kosong frame ubah pelajaran
        txt_nip1.setText("");
        txt_nama1.setText("");
        txt_tempat1.setText("");
        txt_tgl_lahir1.setText("");
        txt_nm_ortu1.setText("");
        txt_alamat1.setText("");
        txt_desa1.setText("");
        txt_kecamatan1.setText("");
        txt_kota1.setText("");
        
        //kosong frame hapus pelajaran
        txt_nip2.setText("");
        txt_nama2.setText("");
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
       panel_upload1.setImage(null);
       
       JFileChooser jfc = new JFileChooser();
       jfc.setFileFilter(new FileNameExtensionFilter("jpg|png|bmp", "jpg","png","bmp"));
       jfc.showOpenDialog(null);
       File file = jfc.getSelectedFile();
       dir = file.getAbsolutePath();
//        System.out.println(dir);
//       label.setText(dir);
        
        File data = new File(dir);
        try {
            data.createNewFile();//untuk membuat file data.yxy baru
            long ukuran = data.length();
//            System.out.println(ukuran+"Byte");
            if(ukuran > 300000){
                JOptionPane.showMessageDialog(rootPane, "gambar terlalu besar " +ukuran+ " Byte"+"\n seharusnya diBawah 300 Kb");
            }
            else{
                try {
                    image = ImageIO.read(file);
                    panel_upload1.setImage(image);
    
                    BufferedImage img = ImageIO.read(new File(dir));
                    
                   
                    imgstr = encodeToString(img, "jpg");
//                     System.out.println(imgstr);
//                     System.out.println("sukses");
                     
                     
                    
                } catch (IOException ex) {
                    Logger.getLogger(add_guru.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        } catch (Exception e) {
//            System.out.println("folder tidak ketemu");
        }
     }
     
     void foto2(){
       
       JFileChooser jfc = new JFileChooser();
       jfc.setFileFilter(new FileNameExtensionFilter("jpg|png|bmp", "jpg","png","bmp"));
       jfc.showOpenDialog(null);
       File file = jfc.getSelectedFile();
       dir = file.getAbsolutePath();
//        System.out.println(dir);
//       label.setText(dir);
        
        File data = new File(dir);
        try {
            data.createNewFile();//untuk membuat file data.yxy baru
            long ukuran = data.length();
//            System.out.println(ukuran+"Byte");
            if(ukuran > 200000){
                JOptionPane.showMessageDialog(rootPane, "gambar terlalu besar " +ukuran+ " Byte"+"\n seharusnya diBawah 200000 Byte");
            }
            else{
                try {
                    image = ImageIO.read(file);
                    panel_upload2.setImage(image);
    
                    BufferedImage img = ImageIO.read(new File(dir));
                    
                   
                    imgstr = encodeToString(img, "jpg");
//                     System.out.println(imgstr);
//                     System.out.println("sukses");
                     
                     
                    
                } catch (IOException ex) {
                    Logger.getLogger(add_guru.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        } catch (Exception e) {
//            System.out.println("folder tidak ketemu");
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
        tabel_guru = new komponen.tabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_tempat = new javax.swing.JTextField();
        txt_kecamatan = new javax.swing.JTextField();
        txt_kota = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_nm_ortu = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_nip = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_jenkel = new javax.swing.JComboBox();
        txt_pendidikan = new javax.swing.JComboBox();
        txt_propinsi = new javax.swing.JComboBox();
        txt_tgl_lahir = new javax.swing.JLabel();
        kalender_lahir = new org.freixas.jcalendar.JCalendarCombo();
        btn_cari_foto = new javax.swing.JButton();
        btn_simpan = new usu.widget.ButtonGlass();
        txt_agama = new javax.swing.JComboBox();
        txt_goldar = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        panel_upload1 = new tata_usaha.manajemen_guru.panel_upload();
        txt_desa = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_tempat1 = new javax.swing.JTextField();
        txt_kecamatan1 = new javax.swing.JTextField();
        txt_kota1 = new javax.swing.JTextField();
        txt_alamat1 = new javax.swing.JTextField();
        txt_nm_ortu1 = new javax.swing.JTextField();
        txt_nama1 = new javax.swing.JTextField();
        txt_nip1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_jenkel1 = new javax.swing.JComboBox();
        txt_pendidikan1 = new javax.swing.JComboBox();
        txt_propinsi1 = new javax.swing.JComboBox();
        txt_tgl_lahir1 = new javax.swing.JLabel();
        kalender_lahir1 = new org.freixas.jcalendar.JCalendarCombo();
        btn_cari_foto1 = new javax.swing.JButton();
        btn_ubah = new usu.widget.ButtonGlass();
        txt_agama1 = new javax.swing.JComboBox();
        txt_goldar1 = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        txt_desa1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        panel_upload2 = new tata_usaha.manajemen_guru.panel_upload();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_nama2 = new javax.swing.JTextField();
        txt_nip2 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txt_tgl_masuk2 = new javax.swing.JLabel();
        btn_hapus = new usu.widget.ButtonGlass();
        jLabel37 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new komponen.tombol_besar();
        jLabel38 = new javax.swing.JLabel();
        btn_print = new usu.widget.ButtonGlass();

        buttonGlass1.setText("buttonGlass1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1530, 810));
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
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, 1360, 18));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, 1350, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1370, -1));

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        btn_home.setText("Home");
        btn_home.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel3.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, 130));

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

        tabel_guru.setForeground(new java.awt.Color(0, 0, 0));
        tabel_guru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tabel_guru);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 107, 730, 400));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*Tambah Data Guru");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jenis Kelamin");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Agama");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tempat Lahir");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tanggal Lahir");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Golongan Darah");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pendidikan");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nama Orang Tua");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Alamat");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 70, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Kecamatan");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Kota/Kabupaten");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, 20));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Foto");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        txt_tempat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_tempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 25));

        txt_kecamatan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_kecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 160, 25));

        txt_kota.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_kota, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 160, 25));

        txt_alamat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 160, 25));

        txt_nm_ortu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_nm_ortu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 160, 25));

        txt_nama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, 25));

        txt_nip.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_nip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nipKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nipKeyTyped(evt);
            }
        });
        jPanel5.add(txt_nip, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("NIP");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_jenkel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_jenkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-Laki", "Perempuan" }));
        jPanel5.add(txt_jenkel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 140, 25));

        txt_pendidikan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_pendidikan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SD", "SMP", "SMA/SMK", "D1", "D2", "D3", "S1", "S2", "S3" }));
        jPanel5.add(txt_pendidikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 80, 25));

        txt_propinsi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_propinsi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aceh", "Sumatra Utara", "Sumatra Barat", "Riau", "Jambi", "Bengkulu", "Bangka Belitung", "Sumatra Selatan", "Lampung", "Banten", "Jakarta", "Jawa Barat", "Jawa Tengah", "D.I.Y Yogyakarta", "Jawa Timur", "Bali", "NTB", "NTT", "Kalimantan Barat", "Kalimantan Tengah", "Kalimantan Timur", "Kalimantan Selatan", "Kalimantan Utara", "Sulawesi Barat", "Sulawesi Selatan", "Sulawesi Tenggara", "Sulawesi Tengah", "Gorontalo", "Sulawesi Utara", "Maluku Utara", "Papua Barat", "Papua" }));
        jPanel5.add(txt_propinsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 160, 25));

        txt_tgl_lahir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tgl_lahir.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, 25));

        kalender_lahir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd-MM-yyyy" }));
        kalender_lahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalender_lahirActionPerformed(evt);
            }
        });
        jPanel5.add(kalender_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 40, 25));

        btn_cari_foto.setText("Cari Foto");
        btn_cari_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_fotoActionPerformed(evt);
            }
        });
        jPanel5.add(btn_cari_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 110, -1));

        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.setFocusable(false);
        btn_simpan.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel5.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 150, 40));

        txt_agama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_agama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Islam", "Kristen", "Hindu", "Budha", "Kong Hu Chu" }));
        jPanel5.add(txt_agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, 25));

        txt_goldar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_goldar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "AB", "O" }));
        jPanel5.add(txt_goldar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 50, 25));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Propinsi");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        javax.swing.GroupLayout panel_upload1Layout = new javax.swing.GroupLayout(panel_upload1);
        panel_upload1.setLayout(panel_upload1Layout);
        panel_upload1Layout.setHorizontalGroup(
            panel_upload1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        panel_upload1Layout.setVerticalGroup(
            panel_upload1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel5.add(panel_upload1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 110, 130));

        txt_desa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_desa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 160, 25));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Desa");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 40, -1));

        jTabbedPane1.addTab("Tambah Data Guru", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 0, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*Ubah Data Guru");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nama");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Jenis Kelamin");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Agama");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tempat Lahir");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tanggal Lahir");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Golongan Darah");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Pendidikan");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Nama Orang Tua");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Alamat");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 80, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Kecamatan");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Kota/Kabupaten");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, 20));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Foto");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        txt_tempat1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_tempat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 25));

        txt_kecamatan1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_kecamatan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 160, 25));

        txt_kota1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_kota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 160, 25));

        txt_alamat1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_alamat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 160, 25));

        txt_nm_ortu1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_nm_ortu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 160, 25));

        txt_nama1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, 25));

        txt_nip1.setEditable(false);
        txt_nip1.setBackground(new java.awt.Color(255, 255, 153));
        txt_nip1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_nip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("NIP");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_jenkel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_jenkel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-Laki", "Perempuan" }));
        jPanel6.add(txt_jenkel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 140, 25));

        txt_pendidikan1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_pendidikan1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SD", "SMP", "SMA/SMK", "D1", "D2", "D3", "S1", "S2", "S3" }));
        jPanel6.add(txt_pendidikan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 80, 25));

        txt_propinsi1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_propinsi1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aceh", "Sumatra Utara", "Sumatra Barat", "Riau", "Jambi", "Bengkulu", "Bangka Belitung", "Sumatra Selatan", "Lampung", "Banten", "Jakarta", "Jawa Barat", "Jawa Tengah", "D.I.Y Yogyakarta", "Jawa Timur", "Bali", "NTB", "NTT", "Kalimantan Barat", "Kalimantan Tengah", "Kalimantan Timur", "Kalimantan Selatan", "Kalimantan Utara", "Sulawesi Barat", "Sulawesi Selatan", "Sulawesi Tenggara", "Sulawesi Tengah", "Gorontalo", "Sulawesi Utara", "Maluku Utara", "Papua Barat", "Papua" }));
        jPanel6.add(txt_propinsi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 160, 25));

        txt_tgl_lahir1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tgl_lahir1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(txt_tgl_lahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, 25));

        kalender_lahir1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd-MM-yyyy" }));
        kalender_lahir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalender_lahir1ActionPerformed(evt);
            }
        });
        jPanel6.add(kalender_lahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 40, 25));

        btn_cari_foto1.setText("Cari Foto");
        btn_cari_foto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_foto1ActionPerformed(evt);
            }
        });
        jPanel6.add(btn_cari_foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 110, -1));

        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        jPanel6.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 150, 40));

        txt_agama1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_agama1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Islam", "Kristen", "Hindu", "Budha", "Kong Hu Chu" }));
        jPanel6.add(txt_agama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, 25));

        txt_goldar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_goldar1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "AB", "O" }));
        jPanel6.add(txt_goldar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 50, 25));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Propinsi");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        txt_desa1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel6.add(txt_desa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 160, 25));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Desa");
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 40, -1));

        javax.swing.GroupLayout panel_upload2Layout = new javax.swing.GroupLayout(panel_upload2);
        panel_upload2.setLayout(panel_upload2Layout);
        panel_upload2Layout.setHorizontalGroup(
            panel_upload2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        panel_upload2Layout.setVerticalGroup(
            panel_upload2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel6.add(panel_upload2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 110, 130));

        jTabbedPane1.addTab("Ubah Data Guru", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 0, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setText("*Hapus Data Guru");
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Nama");
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txt_nama2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(txt_nama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, 25));

        txt_nip2.setEditable(false);
        txt_nip2.setBackground(new java.awt.Color(255, 255, 153));
        txt_nip2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(txt_nip2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("NIP");
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_tgl_masuk2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_tgl_masuk2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(txt_tgl_masuk2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 110, 25));

        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel7.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, 40));

        jTabbedPane1.addTab("Hapus Data Guru", jPanel7);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 600, 560));

        jLabel37.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setText("*Manajemen Guru");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txt_cari.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jPanel4.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 240, 30));

        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 40, 40));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("NIP");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        btn_print.setText("Print");
        btn_print.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel4.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 130, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1370, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
       new add_guru().setVisible(false);
       dispose();
       new home().setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            String nip = txt_nip2.getText();
            int a = Integer.parseInt(nip);
            
            gurunya.delete(nip);
            jabatannya.delete(a);
            JOptionPane.showMessageDialog(this, "data telah di Hapus");
            this.statusAwal();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data tidak bisa di Hapus");
            Logger.getLogger(add_guru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_nipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nipKeyReleased
        
    }//GEN-LAST:event_txt_nipKeyReleased

    private void kalender_lahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalender_lahirActionPerformed
        SimpleDateFormat tanggal = new SimpleDateFormat();
        tanggal = new SimpleDateFormat("dd-MM-yyyy");
        txt_tgl_lahir.setText(tanggal.format(kalender_lahir.getDate()));
    }//GEN-LAST:event_kalender_lahirActionPerformed

    private void btn_cari_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_fotoActionPerformed
       foto();
    }//GEN-LAST:event_btn_cari_fotoActionPerformed

    private void kalender_lahir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalender_lahir1ActionPerformed
        SimpleDateFormat tanggal = new SimpleDateFormat();
        tanggal = new SimpleDateFormat("dd-MM-yyyy");
        txt_tgl_lahir1.setText(tanggal.format(kalender_lahir1.getDate()));
    }//GEN-LAST:event_kalender_lahir1ActionPerformed

    private void btn_cari_foto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_foto1ActionPerformed

        foto2();
    }//GEN-LAST:event_btn_cari_foto1ActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try{
            
            entity_guru ko = new entity_guru();
            
            if(txt_nip.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "NIP Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nip.requestFocus();
            }
            else if(txt_nama.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Nama Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nama.requestFocus();
            }
            else if(txt_tempat.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Tempat Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_tempat.requestFocus();
            }
            else if(txt_tgl_lahir.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Tanggal Lahir Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_tgl_lahir.requestFocus();
            }
            else if(txt_jenkel.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Jenis Kelamin Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_jenkel.requestFocus();
            }
            else if(txt_agama.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Agama Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_agama.requestFocus();
            }
            else if(txt_goldar.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Golongan Darah Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_goldar.requestFocus();
            }
            else if(txt_pendidikan.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Pendidikan Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_pendidikan.requestFocus();
            }
            else if(txt_nm_ortu.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Nama Orang Tua Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nm_ortu.requestFocus();
            }
            else if(txt_alamat.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Alamat Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_alamat.requestFocus();
            }
            else if(txt_desa.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Desa Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_desa.requestFocus();
            }
            else if(txt_kecamatan.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Kecamatan Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kecamatan.requestFocus();
            }
            else if(txt_kota.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Kota/Kabupaten Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kota.requestFocus();
            }
            else if(txt_propinsi.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Propinsi Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_propinsi.requestFocus();
            }           
            
            else{
            ko.setnip(txt_nip.getText());
            ko.setnama(txt_nama.getText());
            ko.settempat(txt_tempat.getText());
            ko.settgllahir(txt_tgl_lahir.getText());
            ko.setjenkel(txt_jenkel.getSelectedItem().toString());
            ko.setagama(txt_agama.getSelectedItem().toString());
            ko.setgolongdar(txt_goldar.getSelectedItem().toString());
            ko.setpendidikan(txt_pendidikan.getSelectedItem().toString());
            ko.setnama_ortu(txt_nm_ortu.getText());
            ko.setalamat(txt_alamat.getText());
            ko.setdesa(txt_desa.getText());
            ko.setkecamatan(txt_kecamatan.getText());
            ko.setkota(txt_kota.getText());
            ko.setpropinsi(txt_propinsi.getSelectedItem().toString());
            ko.setfoto(imgstr);
            gurunya.insert(ko);
            JOptionPane.showMessageDialog(this,"data berhasil disimpan");
            this.statusAwal();
            panel_upload1.setImage(null);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "panjang gambar tidak boleh dari 378px");
            Logger.getLogger(add_guru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        try{
            
            entity_guru ko = new entity_guru();
            
            if(txt_nip1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "NIP Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nip1.requestFocus();
            }
            else if(txt_nama1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Nama Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nama1.requestFocus();
            }
            else if(txt_tempat1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Tempat Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_tempat1.requestFocus();
            }
            else if(txt_tgl_lahir1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Tanggal Lahir Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_tgl_lahir1.requestFocus();
            }
            else if(txt_jenkel1.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Jenis Kelamin Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_jenkel1.requestFocus();
            }
            else if(txt_agama1.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Agama Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_agama1.requestFocus();
            }
            else if(txt_goldar1.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Golongan Darah Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_goldar1.requestFocus();
            }
            else if(txt_pendidikan1.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Pendidikan Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_pendidikan1.requestFocus();
            }
            else if(txt_nm_ortu1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Nama Orang Tua Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nm_ortu1.requestFocus();
            }
            else if(txt_alamat1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Alamat Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_alamat1.requestFocus();
            }
            else if(txt_desa1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Desa Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_desa1.requestFocus();
            }
            else if(txt_kecamatan1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Kecamatan Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kecamatan1.requestFocus();
            }
            else if(txt_kota1.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Kota/Kabupaten Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kota1.requestFocus();
            }
            else if(txt_propinsi1.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Propinsi Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_propinsi1.requestFocus();
            }        
            
            else{
            ko.setnip(txt_nip1.getText());
            ko.setnama(txt_nama1.getText());
            ko.settempat(txt_tempat1.getText());
            ko.settgllahir(txt_tgl_lahir1.getText());
            ko.setjenkel(txt_jenkel1.getSelectedItem().toString());
            ko.setagama(txt_agama1.getSelectedItem().toString());
            ko.setgolongdar(txt_goldar1.getSelectedItem().toString());
            ko.setpendidikan(txt_pendidikan1.getSelectedItem().toString());
            ko.setnama_ortu(txt_nm_ortu1.getText());
            ko.setalamat(txt_alamat1.getText());
            ko.setdesa(txt_desa1.getText());
            ko.setkecamatan(txt_kecamatan1.getText());
            ko.setkota(txt_kota1.getText());
            ko.setpropinsi(txt_propinsi1.getSelectedItem().toString());
            ko.setfoto(imgstr);
            gurunya.update(ko);
            JOptionPane.showMessageDialog(this,"data berhasil di Ubah");
            this.statusAwal();
            panel_upload2.setImage(null);
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "panjang gambar tidak boleh dari 378px");
            Logger.getLogger(add_guru.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void txt_nipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nipKeyTyped
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nipKeyTyped

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        String header[]={"NIP","Nama","Tempat"};
        
        DefaultTableModel dt = new DefaultTableModel(null, header);
        tabel_guru.setModel(dt);
        
        for(int i=0; i<tabel_guru.getRowCount();i++){
            dt.removeRow(i);
        }
        
        try{
             
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from guru where nip "
                    + "like '%"+txt_cari.getText()+"%' ");
            
            while (rs.next()){
                String nip = rs.getString(1);
                String nama = rs.getString(2);
                String tempat = rs.getString(3);
                
                Object baris[] = {nip,nama,tempat};
                dt.addRow(baris);
                
            }
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        try{
            Statement st=koneksi.getConnection().createStatement();
            
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("D:/Data Guru.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("NIP");
            row1.createCell(1).setCellValue("Nama");
            row1.createCell(2).setCellValue("Tempat");
            row1.createCell(3).setCellValue("Tanggal Lahir");
            row1.createCell(4).setCellValue("Jenis Kelamin");
            row1.createCell(5).setCellValue("Agama");
            row1.createCell(6).setCellValue("Golongan Darah");
            row1.createCell(7).setCellValue("Pendidikan");
            row1.createCell(8).setCellValue("Nama Orang Tua");
            row1.createCell(9).setCellValue("Alamat");
            row1.createCell(10).setCellValue("Desa");
            row1.createCell(11).setCellValue("Kecamatan");
            row1.createCell(12).setCellValue("Kota");
            row1.createCell(13).setCellValue("Propinsi");
            Row row2;           
            
            ResultSet rs=st.executeQuery("select nip,nama,tempat,tgllahir,jenkel,"
                    + "agama,goldarah,pendidikan,nama_ortu,alamat,desa,kec,kota,propinsi from guru");
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
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            st.close();
            koneksi.getConnection().close();
            JOptionPane.showMessageDialog(null, "Data Sukses Disimpan di Local Disk D:");
        }catch(  SQLException | IOException e){
        System.out.println(e);
    }
    }//GEN-LAST:event_btn_printActionPerformed

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
            java.util.logging.Logger.getLogger(add_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new add_guru().setVisible(true);
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
    private usu.widget.ButtonGlass btn_ubah;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.freixas.jcalendar.JCalendarCombo kalender_lahir;
    private org.freixas.jcalendar.JCalendarCombo kalender_lahir1;
    private tata_usaha.manajemen_guru.panel_upload panel_upload1;
    private tata_usaha.manajemen_guru.panel_upload panel_upload2;
    private komponen.tabel tabel_guru;
    private javax.swing.JComboBox txt_agama;
    private javax.swing.JComboBox txt_agama1;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_alamat1;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_desa;
    private javax.swing.JTextField txt_desa1;
    private javax.swing.JComboBox txt_goldar;
    private javax.swing.JComboBox txt_goldar1;
    private javax.swing.JComboBox txt_jenkel;
    private javax.swing.JComboBox txt_jenkel1;
    private javax.swing.JTextField txt_kecamatan;
    private javax.swing.JTextField txt_kecamatan1;
    private javax.swing.JTextField txt_kota;
    private javax.swing.JTextField txt_kota1;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nama1;
    private javax.swing.JTextField txt_nama2;
    private javax.swing.JTextField txt_nip;
    private javax.swing.JTextField txt_nip1;
    private javax.swing.JTextField txt_nip2;
    private javax.swing.JTextField txt_nm_ortu;
    private javax.swing.JTextField txt_nm_ortu1;
    private javax.swing.JComboBox txt_pendidikan;
    private javax.swing.JComboBox txt_pendidikan1;
    private javax.swing.JComboBox txt_propinsi;
    private javax.swing.JComboBox txt_propinsi1;
    private javax.swing.JTextField txt_tempat;
    private javax.swing.JTextField txt_tempat1;
    private javax.swing.JLabel txt_tgl_lahir;
    private javax.swing.JLabel txt_tgl_lahir1;
    private javax.swing.JLabel txt_tgl_masuk2;
    // End of variables declaration//GEN-END:variables
}
