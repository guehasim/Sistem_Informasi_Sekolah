package tata_usaha.manajemen_jab_guru;

import file_koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import tata_usaha.awal.home;
import tata_usaha.manajemen_guru.entity_guru;
import tata_usaha.manajemen_guru.imple_guru;
import tata_usaha.manajemen_guru.inter_guru;
import tata_usaha.manajemen_siswa.entity_thnajar;
import tata_usaha.manajemen_siswa.imple_thnajar;
import tata_usaha.manajemen_siswa.inter_thnajar;

public class tabel_jabatan extends javax.swing.JFrame {

    List<entity_kelas> camp=new ArrayList<entity_kelas>();
    List<entity_guru> kamera=new ArrayList<entity_guru>();
    List<entity_walkes> record=new ArrayList<entity_walkes>();
    List<entity_thnajar> komp=new ArrayList<entity_thnajar>();
    
    inter_guru gru;
    inter_kelas kls;
    inter_jabatan walkesnya;
    inter_thnajar thn_ajar;
    
    int row;
    int row_walkes;
    
    public String jabat;
    
    public tabel_jabatan() {
        initComponents();
        
        dropdown_kelas();
        dropdown_guru();
        
        kls = new imple_kelas();
           
//tabel kelas=============================================================================
            tabel_data_kelas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_data_kelas.getSelectedRow();
                    if(row!=-1){
                        isiTextkelas();
                    }
                }
            });
            
            this.statusAwalkelas();
                   
            
//tabel wali kelas=======================================================================
        walkesnya = new imple_jabatan();
            tabel_walkes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row_walkes=tabel_walkes.getSelectedRow();
                    if(row_walkes!=-1){
                        isiText_walkes();
                    }
                }
            });
            this.statusAwal();
            

//tabel tahun ajaran=====================================================================
            thn_ajar = new imple_thnajar();
           

            tabel_thn_ajar.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_thn_ajar.getSelectedRow();
                    if(row!=-1){
                        isiText_thn();
                    }
                }
            });
            this.statusAwalthn();
    }
    
    
//fungsi kelas==============================================================================
    void loadDatakelas(){
        try {
            camp = kls.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabelkelas(){
        Object data[][]=new Object[camp.size()][1];
        int x=0;
        for(entity_kelas thn:camp){
            data[x][0]=thn.getnamaKelas();
            x++;
        }
        String judul[]={"kelas"}; 
        
       // jComboBox1.setModel(new DefaultComboBoxModel(data, judul));
        tabel_data_kelas.setModel(new DefaultTableModel(data, judul));
        jScrollPane3.setViewportView(tabel_data_kelas);
    }
    
    void isiTextkelas(){
        entity_kelas thn=camp.get(row);
        txt_hps_kelas.setText(thn.getnamaKelas());
    }
    
    void kosongkanTextkelas(){
        txt_tmbah_kelas.setText("");
        txt_hps_kelas.setText("");
    }
    
    void statusAwalkelas(){
        kosongkanTextkelas();
        loadDatakelas();
        isiTabelkelas();
    }
    
//fungsi wali kelas==================================================================
    void loadData_walikelas(){
        try {
            record = walkesnya.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel_walkes(){
        Object data_walkes[][]=new Object[record.size()][5];
        int x=0;
        for(entity_walkes thn:record){
            data_walkes[x][0]=thn.getnip();
            data_walkes[x][1]=thn.getnama();
            data_walkes[x][2]=thn.getjabat();
            data_walkes[x][3]=thn.getkelas();
            data_walkes[x][4]=thn.getpass();
            x++;
        }
        String judul_walkes[]={"NIP","Nama","Jabatan","Kelas","Password"}; 
        
        tabel_walkes.setModel(new DefaultTableModel(data_walkes, judul_walkes));
        jScrollPane1.setViewportView(tabel_walkes);
    }
    
    void isiText_walkes(){
        entity_walkes thn=record.get(row_walkes);
        
        txt_nip_walkes_hps.setText(thn.getnip());
        txt_kelas_walkes_hps.setText(thn.getkelas());
        
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
        }
            
        }catch(Exception e){
            
        }
    }
       
    
    void select_guru(){
        if(txt_nip.getSelectedItem().equals("")){
            
        }else{
            try{
             
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from guru where nip "
                    + "like '%"+txt_nip.getSelectedItem()+"%' ");
            
            while (rs.next()){
                String nip = rs.getString(1);
                String nama = rs.getString(2);
                
                txt_nama.setText(nama);
                                
            }
            
        }catch(Exception e){
            
        }
        }
    }
    
     private void dropdown_guru() {
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru");
        while(rs.next()){
            String nip = rs.getString("nip");
            String nama = rs.getString("nama");
            
            txt_nip.addItem(nip);
        }
            
        }catch(Exception e){
            
        }
    }
     
     void kosong_walkes(){
         txt_kelas_walkes_hps.setText("");
         txt_nip_walkes_hps.setText("");
     }
        
     void statusAwal(){
        loadData_walikelas();
        isiTabel_walkes();
        kosong_walkes();
    }
     
//fungsi Tahun Ajaran================================================================
     void loadData_thn(){
        try {
            komp = thn_ajar.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     void isiTabel_thn(){
        Object data[][]=new Object[komp.size()][1];
        int x=0;
        for(entity_thnajar thn:komp){
            data[x][0]=thn.getnmtahun_ajaran();
            x++;
        }
        String judul[]={"Tahun Ajaran"}; 
        
        
        tabel_thn_ajar.setModel(new DefaultTableModel(data, judul));
        jScrollPane2.setViewportView(tabel_thn_ajar);
    }
    
    void isiText_thn(){
        entity_thnajar thn=komp.get(row);
        txt_thn_ajar_hps.setText(thn.getnmtahun_ajaran());
    }
    
    void kosongkanText_thn(){
        txt_thn_ajar.setText("");
        txt_thn_ajar_hps.setText("");
    }
    
    void statusAwalthn(){
        kosongkanText_thn();
        loadData_thn();
        isiTabel_thn();
    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGlass1 = new usu.widget.ButtonGlass();
        grup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_home = new komponen.tombol_besar();
        btn_struk = new usu.widget.glass.ButtonImageReflection();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_walkes = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txt_nip = new javax.swing.JComboBox();
        txt_kelas = new javax.swing.JComboBox();
        btn_simpan_walkes = new usu.widget.ButtonGlass();
        txt_pass_conf = new javax.swing.JPasswordField();
        txt_pass = new javax.swing.JPasswordField();
        validasi_walkes = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        check_walkes = new javax.swing.JCheckBox();
        check_kepsek = new javax.swing.JCheckBox();
        check_sekret = new javax.swing.JCheckBox();
        check_benda = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_hapus_walkes = new usu.widget.ButtonGlass();
        jLabel37 = new javax.swing.JLabel();
        txt_nip_walkes_hps = new javax.swing.JLabel();
        txt_kelas_walkes_hps = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_data_kelas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btn_simpan_kelas = new usu.widget.ButtonGlass();
        txt_tmbah_kelas = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btn_hps_kelas = new usu.widget.ButtonGlass();
        txt_hps_kelas = new javax.swing.JTextField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        txt_thn_ajar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_save_thn = new usu.widget.ButtonGlass();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_thn_ajar_hps = new javax.swing.JTextField();
        btn_thn_ajar = new usu.widget.ButtonGlass();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_thn_ajar = new javax.swing.JTable();

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
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 73, 1360, 18));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, 1350, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 97, 1370, -1));

        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        btn_home.setText("Home");
        btn_home.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel3.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, 130));

        btn_struk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/jabatt.png"))); // NOI18N
        btn_struk.setText("Struktur");
        btn_struk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_strukActionPerformed(evt);
            }
        });
        jPanel3.add(btn_struk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, -1, -1));

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

        tabel_walkes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tabel_walkes);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 530, 410));

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel7.setBackground(new java.awt.Color(0, 0, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*Tambah Wali Kelas");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nama");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Password");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ulang Password");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Jabatan");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txt_nip.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nipActionPerformed(evt);
            }
        });
        jPanel7.add(txt_nip, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        txt_kelas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_kelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel7.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 70, 25));

        btn_simpan_walkes.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan_walkes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan_walkes.setText("Simpan");
        btn_simpan_walkes.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_simpan_walkes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_walkesActionPerformed(evt);
            }
        });
        jPanel7.add(btn_simpan_walkes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 140, -1));

        txt_pass_conf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pass_confKeyReleased(evt);
            }
        });
        jPanel7.add(txt_pass_conf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, 25));
        jPanel7.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 140, 25));

        validasi_walkes.setForeground(new java.awt.Color(255, 255, 255));
        validasi_walkes.setText("validasi");
        jPanel7.add(validasi_walkes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 120, -1));

        txt_nama.setEditable(false);
        txt_nama.setBackground(new java.awt.Color(255, 255, 153));
        txt_nama.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel7.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, 25));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Kelas");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("NIP Guru");
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        check_walkes.setBackground(new java.awt.Color(0, 0, 153));
        grup.add(check_walkes);
        check_walkes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check_walkes.setForeground(new java.awt.Color(255, 255, 255));
        check_walkes.setText("Wali Kelas");
        check_walkes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_walkesMouseClicked(evt);
            }
        });
        jPanel7.add(check_walkes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, 25));

        check_kepsek.setBackground(new java.awt.Color(0, 0, 153));
        grup.add(check_kepsek);
        check_kepsek.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check_kepsek.setForeground(new java.awt.Color(255, 255, 255));
        check_kepsek.setText("Kepala Sekolah");
        check_kepsek.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        check_kepsek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_kepsekMouseClicked(evt);
            }
        });
        jPanel7.add(check_kepsek, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 140, 25));

        check_sekret.setBackground(new java.awt.Color(0, 0, 153));
        grup.add(check_sekret);
        check_sekret.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check_sekret.setForeground(new java.awt.Color(255, 255, 255));
        check_sekret.setText("Sekretaris");
        check_sekret.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_sekretMouseClicked(evt);
            }
        });
        jPanel7.add(check_sekret, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, 25));

        check_benda.setBackground(new java.awt.Color(0, 0, 153));
        grup.add(check_benda);
        check_benda.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        check_benda.setForeground(new java.awt.Color(255, 255, 255));
        check_benda.setText("Bendahara");
        check_benda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_bendaMouseClicked(evt);
            }
        });
        jPanel7.add(check_benda, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 140, 25));

        jTabbedPane2.addTab("Tambah Data Jabatan", jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 0, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*Hapus Wali Kelas");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Kelas");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        btn_hapus_walkes.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus_walkes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_hapus_walkes.setText("Hapus");
        btn_hapus_walkes.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_hapus_walkes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_walkesActionPerformed(evt);
            }
        });
        jPanel8.add(btn_hapus_walkes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 140, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("NIP Guru");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_nip_walkes_hps.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_nip_walkes_hps.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_nip_walkes_hps, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 140, 25));

        txt_kelas_walkes_hps.setEditable(false);
        txt_kelas_walkes_hps.setBackground(new java.awt.Color(255, 255, 153));
        txt_kelas_walkes_hps.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel8.add(txt_kelas_walkes_hps, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, 25));

        jTabbedPane2.addTab("Hapus Data Jabatan", jPanel8);

        jPanel4.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 300, 460));

        tabel_data_kelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane3.setViewportView(tabel_data_kelas);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 290, 220, 260));

        jLabel8.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("* Tabel Data Jabatan");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 30));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*Tambah Data Kelas");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Nama Kelas");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_simpan_kelas.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan_kelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan_kelas.setText("Simpan");
        btn_simpan_kelas.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_simpan_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_kelasActionPerformed(evt);
            }
        });
        jPanel5.add(btn_simpan_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, -1));

        txt_tmbah_kelas.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jPanel5.add(txt_tmbah_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 60, 35));

        jTabbedPane1.addTab("Tambah Kelas", jPanel5);

        jPanel9.setBackground(new java.awt.Color(0, 0, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*Hapus Data Kelas");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Nama Kelas");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_hps_kelas.setForeground(new java.awt.Color(255, 255, 255));
        btn_hps_kelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_hps_kelas.setText("Hapus");
        btn_hps_kelas.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_hps_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hps_kelasActionPerformed(evt);
            }
        });
        jPanel9.add(btn_hps_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, -1));

        txt_hps_kelas.setEditable(false);
        txt_hps_kelas.setBackground(new java.awt.Color(255, 255, 153));
        txt_hps_kelas.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jPanel9.add(txt_hps_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 60, 35));

        jTabbedPane1.addTab("Hapus Kelas", jPanel9);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 220, 270));

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel6.setBackground(new java.awt.Color(0, 0, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_thn_ajar.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        txt_thn_ajar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_thn_ajarKeyTyped(evt);
            }
        });
        jPanel6.add(txt_thn_ajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*Tambah Tahun Ajaran");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        btn_save_thn.setForeground(new java.awt.Color(255, 255, 255));
        btn_save_thn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_save_thn.setText("Simpan");
        btn_save_thn.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_save_thn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_save_thnActionPerformed(evt);
            }
        });
        jPanel6.add(btn_save_thn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ex : 2012/2013");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jTabbedPane3.addTab("Tambah Thn Ajar", jPanel6);

        jPanel10.setBackground(new java.awt.Color(0, 0, 153));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*Hapus Tahun Ajaran");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        txt_thn_ajar_hps.setEditable(false);
        txt_thn_ajar_hps.setBackground(new java.awt.Color(255, 255, 153));
        txt_thn_ajar_hps.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jPanel10.add(txt_thn_ajar_hps, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 40));

        btn_thn_ajar.setForeground(new java.awt.Color(255, 255, 255));
        btn_thn_ajar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_thn_ajar.setText("Hapus");
        btn_thn_ajar.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_thn_ajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thn_ajarActionPerformed(evt);
            }
        });
        jPanel10.add(btn_thn_ajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, -1));

        jTabbedPane3.addTab("Hapus Thn Ajar", jPanel10);

        jPanel4.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 250, 270));

        tabel_thn_ajar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabel_thn_ajar);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 250, 260));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1370, 590));

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

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new tabel_jabatan().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_simpan_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_kelasActionPerformed
        try {
            
            // TODO add your handling code here:
            entity_kelas thn = new entity_kelas();
            thn.setnamaKelas(txt_tmbah_kelas.getText());
            kls.insert(thn);            
            JOptionPane.showMessageDialog(this, "data tersimpan");
            this.statusAwalkelas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data tidak tersimpan");
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpan_kelasActionPerformed

    private void btn_hps_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hps_kelasActionPerformed
        try{
            entity_kelas a = camp.get(row);
            entity_kelas en = new entity_kelas();
            en.setnamaKelas(txt_tmbah_kelas.getText());
            a.getidKelas();
            int s = a.getidKelas();
            kls.delete(s);
            JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(this, "kelas sudah terhapus");
            this.statusAwalkelas();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data tidak terhapus");
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_hps_kelasActionPerformed

    private void txt_pass_confKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pass_confKeyReleased
        if(txt_pass_conf.getText().equals(txt_pass.getText())){
        validasi_walkes.setText("Password sama");
        }else{
        validasi_walkes.setText("Password Tidak sama");}
    }//GEN-LAST:event_txt_pass_confKeyReleased

    private void btn_simpan_walkesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_walkesActionPerformed
        try{
            entity_walkes ko = new entity_walkes();
            if(txt_pass.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "Password Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_pass.requestFocus();
            }
            else if(txt_pass_conf.getText().equals("")){
               JOptionPane.showMessageDialog(rootPane, "konfirmasi Password Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_pass_conf.requestFocus();
            }
            else if(validasi_walkes.getText().equals("Password Tidak sama") || validasi_walkes.getText().equals("Validasi Password")){
                JOptionPane.showMessageDialog(rootPane, "Konfirmasi Password Belum Betul\n"
                        + "Silahkan Dibetulkan lagi sampai betul","Kesalahan",JOptionPane.ERROR_MESSAGE);
            }
            else{
            ko.setnip(txt_nip.getSelectedItem().toString());
            ko.setnama(txt_nama.getText());
            ko.setjabat(jabat);
            ko.setkelas(txt_kelas.getSelectedItem().toString());
            ko.setpass(txt_pass.getText());
            walkesnya.insert(ko);
            JOptionPane.showMessageDialog(this, "data berhasil disimpan");
            
            this.statusAwal();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "data belum berhasil disimpan");
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpan_walkesActionPerformed

    private void btn_hapus_walkesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_walkesActionPerformed
       try {
           entity_walkes a = record.get(row_walkes);
           entity_walkes en =new entity_walkes();
           if(txt_kelas_walkes_hps.getText().equals(null)){
               JOptionPane.showMessageDialog(rootPane, "Jabatan Ini Tidak Bisa Dihapus","Kesalahan",JOptionPane.ERROR_MESSAGE);
            }
           else{
           en.setnip(txt_nip_walkes_hps.getText());
           en.setkelas(txt_kelas_walkes_hps.getText());
           a.getid();
           int s= a.getid();
           JDialog.setDefaultLookAndFeelDecorated(true);
           int response = JOptionPane.showConfirmDialog(null, "apakah benar data ini dihapus?","confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           walkesnya.delete(s);
           this.statusAwal();
           }
        } catch (SQLException ex) {
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hapus_walkesActionPerformed

    private void txt_nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nipActionPerformed
        select_guru();
    }//GEN-LAST:event_txt_nipActionPerformed

    private void check_kepsekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_kepsekMouseClicked
       if(check_kepsek.isSelected()){
             txt_kelas.setVisible(false);
             jLabel20.setVisible(false);
             jabat = "Kepala Sekolah";
         }
    }//GEN-LAST:event_check_kepsekMouseClicked

    private void check_sekretMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_sekretMouseClicked
       if(check_sekret.isSelected()){
             txt_kelas.setVisible(false);
             jLabel20.setVisible(false);
             jabat = "Sekretaris";
         }
    }//GEN-LAST:event_check_sekretMouseClicked

    private void check_bendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_bendaMouseClicked
        if(check_benda.isSelected()){
             txt_kelas.setVisible(false);
             jLabel20.setVisible(false);
             jabat = "Bendahara";
         }
    }//GEN-LAST:event_check_bendaMouseClicked

    private void check_walkesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_walkesMouseClicked
        if(check_walkes.isSelected()){
             txt_kelas.setVisible(true);
             jLabel20.setVisible(true);
             jabat = "Wali Kelas";
         }
    }//GEN-LAST:event_check_walkesMouseClicked

    private void txt_thn_ajarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_thn_ajarKeyTyped
        if(txt_thn_ajar.getText().length() == 9){
            evt.consume();
        }
    }//GEN-LAST:event_txt_thn_ajarKeyTyped

    private void btn_save_thnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_save_thnActionPerformed
        try {
            entity_thnajar thn = new entity_thnajar();
            thn.setnmtahun_ajaran(txt_thn_ajar.getText());
            thn_ajar.insert(thn);
            this.statusAwalthn();
            JOptionPane.showMessageDialog(this, "data tersimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data gagal untuk di simpan");
            Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_save_thnActionPerformed

    private void btn_thn_ajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thn_ajarActionPerformed
        try{
           entity_thnajar a = komp.get(row);
           entity_thnajar en =new entity_thnajar();
           en.setnmtahun_ajaran(txt_thn_ajar_hps.getText());
           a.getidtahun_ajaran();
           int s= a.getidtahun_ajaran();
           JOptionPane.showMessageDialog(this, "data berhasil dihapus");
           thn_ajar.delete(s);
           this.statusAwalthn();
            
       } catch(Exception ex){
           Logger.getLogger(tabel_jabatan.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btn_thn_ajarActionPerformed

    private void btn_strukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_strukActionPerformed
        new tabel_jabatan().setVisible(false);
        dispose();
        new tampil_struktur().setVisible(true);
    }//GEN-LAST:event_btn_strukActionPerformed

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
            java.util.logging.Logger.getLogger(tabel_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabel_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabel_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabel_jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new tabel_jabatan().setVisible(true);
                        
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_hapus_walkes;
    private komponen.tombol_besar btn_home;
    private usu.widget.ButtonGlass btn_hps_kelas;
    private usu.widget.ButtonGlass btn_save_thn;
    private usu.widget.ButtonGlass btn_simpan_kelas;
    private usu.widget.ButtonGlass btn_simpan_walkes;
    private usu.widget.glass.ButtonImageReflection btn_struk;
    private usu.widget.ButtonGlass btn_thn_ajar;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JCheckBox check_benda;
    private javax.swing.JCheckBox check_kepsek;
    private javax.swing.JCheckBox check_sekret;
    private javax.swing.JCheckBox check_walkes;
    private javax.swing.ButtonGroup grup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tabel_data_kelas;
    private javax.swing.JTable tabel_thn_ajar;
    private javax.swing.JTable tabel_walkes;
    private javax.swing.JTextField txt_hps_kelas;
    private javax.swing.JComboBox txt_kelas;
    private javax.swing.JTextField txt_kelas_walkes_hps;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JComboBox txt_nip;
    private javax.swing.JLabel txt_nip_walkes_hps;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JPasswordField txt_pass_conf;
    private javax.swing.JTextField txt_thn_ajar;
    private javax.swing.JTextField txt_thn_ajar_hps;
    private javax.swing.JTextField txt_tmbah_kelas;
    private javax.swing.JLabel validasi_walkes;
    // End of variables declaration//GEN-END:variables
}
