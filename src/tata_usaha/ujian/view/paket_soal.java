package tata_usaha.ujian.view;

import file_koneksi.koneksi;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import tata_usaha.awal.home;

import tata_usaha.ujian.controller.paket;
import tata_usaha.ujian.controller.soal;
import tata_usaha.ujian.model.m_paket;
import tata_usaha.ujian.model.m_soal;


public class paket_soal extends javax.swing.JFrame {

    List<entity_ujian> record=new ArrayList<entity_ujian>();
    paket paketnya;
    soal soalnya;
    int row;
        
    String oy;
    int os;
    int jumlah;
    public paket_soal() {
        initComponents();
       
        paketnya = new m_paket();
        soalnya = new m_soal();
        
        tabel_paket();
        tabel_soal();
        
        tgl();
        kelas();
        
        btn_finish.setVisible(false);
    }
    
    void soal_mundur(){
        String a = txt_sisa_soal.getText();
        String c = txt_nmr_soal.getText();
        
        int aa = Integer.parseInt(a);
        int b = aa-1;
        
        int cc = Integer.parseInt(c);
        int d = cc+1;
        
        txt_sisa_soal.setText(""+b);
        txt_nmr_soal.setText(""+d);
    }
    
    void soal_maju(){
        String a = txt_sisa_soal.getText();
        
        int aa = Integer.parseInt(a);
        int b = aa+1;
        
        txt_sisa_soal.setText(""+b);
    }
    
    void soal_keluar(){
        String a = txt_sisa_soal.getText();
        int aa = Integer.parseInt(a);
        if(aa == 0){
            JOptionPane.showMessageDialog(rootPane, "Sisa Soal Sudah Habis !","Kesalahan",JOptionPane.ERROR_MESSAGE);
            btn_simpan1.setVisible(false);
            btn_finish.setVisible(true);
        }
    }
    
    void soal_muncul(){
        String a = txt_sisa_soal.getText();
        int aa = Integer.parseInt(a);
        if(aa != 0){
            btn_simpan1.setVisible(true);
            btn_finish.setVisible(false);
        }
    }
        
    void pindah(){
        txt_kd_paket_soal.setText(txt_kd_paket.getText());
        txt_sisa_soal.setText(txt_total.getText());
    }
//paket_soal=======================================
    private void tabel_paket(){
        tabel_paket.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_paket.getSelectedRow();
                    if(row!=-1){
                        isiText_paket();
                    }
                }
            });
        this.statusAwal_paket();
    }
    
    void loadData_paket(){
        try {
            record = paketnya.getAll_pkt();
        } catch (SQLException ex) {
            Logger.getLogger(paket_soal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel_paket(){
        Object data[][]=new Object[record.size()][5];
        int x=0;
        for(entity_ujian thn:record){
            data[x][0]=thn.getkd_paket();
            data[x][1]=thn.getkelas();
            data[x][2]=thn.getmatpel();
            data[x][3]=thn.gettgl();
            data[x][4]=thn.getjml_soal();
            x++;
        }
        String judul[]={"Kode","Kelas","Mata Pelajaran","Tanggal","Total Soal"}; 
        
        tabel_paket.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel_paket);
    }
    
    void isiText_paket(){
        entity_ujian thn=record.get(row);
        oy = thn.getkd_paket();
        }
    
    void kosongkanText_paket(){
        
        txt_kd_paket.setText("");
        txt_total.setText("");
    }
    
    void statusAwal_paket(){
        kosongkanText_paket();
        loadData_paket();
        isiTabel_paket();
    }
    
    private void kelas() {
      try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from kelas");
        while(rs.next()){
            
            String kelas = rs.getString("nama_kelas");
            
            txt_kelas.addItem(kelas);
            
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void matpel(){
        
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from matpel where kelas='"+txt_kelas.getSelectedItem().toString()+"'");
        while(rs.next()){
            
            String kd_matpel = rs.getString("kode_matpel");
            String nm_matpel = rs.getString("nama_matpel");
            
            txt_matpel.addItem(nm_matpel);
        }
            
        }catch(Exception e){
            
        }
    }
    
    private void tgl(){
        Date skrg = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String tgl = format.format(skrg);
        txt_tanggal.setText(format.format(skrg));
    }
    
    private void save_paket(){
        try {
            entity_ujian ko = new entity_ujian();
            
            if(txt_kd_paket.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Kode Paket Soal Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kd_paket.requestFocus();
            }
            else if(txt_kelas.getSelectedItem().toString().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Kelas Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kelas.requestFocus();
            }
            else if(txt_total.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Total Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_total.requestFocus();
            }
            else if(txt_bobot.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Bobot Nilai Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_bobot.requestFocus();
            }else{
                ko.setkd_paket(txt_kd_paket.getText());
                    String a = txt_kelas.getSelectedItem().toString();
                    int aa = Integer.parseInt(a);
                ko.setkelas(aa);
                ko.setmatpel(txt_matpel.getSelectedItem().toString());
                ko.settgl(txt_tanggal.getText());
                    String b = txt_total.getText();
                    jumlah = Integer.parseInt(b);
                ko.setjml_soal(jumlah);
                    String c=txt_bobot.getText();
                    int bobot = Integer.parseInt(c);
                ko.setbobot_nilai(bobot);
                ko.setkondis("0");
                paketnya.insert_pkt(ko);
                
                pindah();
                
                JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                this.statusAwal_paket();
                
                frame_paket.setVisible(false);
                
                frame_soal.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Tidak Tersimpan");
            Logger.getLogger(paket_soal.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void delete_paket(){
        try {
            paketnya.delete_pkt(oy);
            paketnya.delete_sl(oy);
            paketnya.delete_jwb(oy);
            JOptionPane.showMessageDialog(this, "Data Telah di Hapus");
            this.statusAwal_paket();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data Tidak Bisa di Hapus");
            Logger.getLogger(paket_soal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//soal+pilih jawab=====================================
        private void tabel_soal(){
        tabel_soal.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_soal.getSelectedRow();
                    if(row!=-1){
                        isiText_soal();
                    }
                }
            });
        this.statusAwal_soal();
    }
    
    void loadData_soal(){
        try {
            record = soalnya.getAll_soal();
        } catch (SQLException ex) {
            Logger.getLogger(paket_soal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel_soal(){
        Object data[][]=new Object[record.size()][4];
        int x=0;
        for(entity_ujian thn:record){
            data[x][0]=thn.getkd_paket();
            data[x][1]=thn.getkd_soal();
            data[x][2]=thn.getsoal();
            data[x][3]=thn.getkunci();
            x++;
        }
        String judul[]={"Kode Paket","Kode Soal","Soal","Kunci Jawaban"}; 
        
        tabel_soal.setModel(new DefaultTableModel(data, judul));
        jScrollPane2.setViewportView(tabel_soal);
    }
    
    void isiText_soal(){
        entity_ujian thn=record.get(row);
        os = thn.getkd_soal();
        txt_nmr_soal.setText(""+os);
        }
    
    void kosongkanText_soal(){
        txt_soal.setText("");
        txt_a.setText("");
        txt_b.setText("");
        txt_c.setText("");
        txt_d.setText("");
    }
    
    void statusAwal_soal(){
        kosongkanText_soal();
        loadData_soal();
        isiTabel_soal();
    }
    
    private void save_soal_jawab(){
        
        
        try {
            entity_ujian ko = new entity_ujian();
            entity_ujian a = new entity_ujian();
            entity_ujian b = new entity_ujian();
            entity_ujian c = new entity_ujian();
            entity_ujian d = new entity_ujian();
            
            
            if(txt_soal.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Soal Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_soal.requestFocus();
            }
            else if(txt_a.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Opsi Jawaban A Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_a.requestFocus();
            }
            else if(txt_b.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Opsi Jawaban B Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_b.requestFocus();
            }
            else if(txt_c.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Opsi Jawaban c Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_c.requestFocus();
            }
            else if(txt_d.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Opsi Jawaban d Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_d.requestFocus();
            }
            else if(grup_jawab.isSelected(null)){
                JOptionPane.showMessageDialog(rootPane, "Pilih Dulu Jawaban Yang Benar !","Kesalahan",JOptionPane.ERROR_MESSAGE);
            }
            else{
                ko.setkd_paket(txt_kd_paket_soal.getText());
                    String x = txt_nmr_soal.getText();
                    int aa = Integer.parseInt(x);
                ko.setkd_soal(aa);
                ko.setsoal(txt_soal.getText());
                    int jk = 0;
                    if(chec_a.isSelected()){
                        jk = 1;
                    }
                    if(chec_b.isSelected()){
                        jk = 2;
                    }
                    if(chec_c.isSelected()){
                        jk = 3;
                    }
                    if(chec_d.isSelected()){
                        jk = 4;
                    }
                ko.setkunci(jk);
                soalnya.insert_soal(ko);
                
                //ngambil Kd_soal===================
                        try{

                            Statement st=koneksi.getConnection().createStatement();
                            ResultSet rs=st.executeQuery("select * from soal order by kd_soal DESC limit 1");
                            while(rs.next()){

                               int  kd_sos = rs.getInt("kd_soal");
                               
                               //jawab a================
                                a.setkd_paket(txt_kd_paket_soal.getText());
                                a.setkd_soal(kd_sos);
                                a.setpilih(1);
                                a.setjawab(txt_a.getText());
                                soalnya.insert_jawab(a);

                                //jawab b==================
                                b.setkd_paket(txt_kd_paket_soal.getText());
                                b.setkd_soal(kd_sos);
                                b.setpilih(2);
                                b.setjawab(txt_b.getText());
                                soalnya.insert_jawab(b);

                                //jawab c==================
                                c.setkd_paket(txt_kd_paket_soal.getText());
                                c.setkd_soal(kd_sos);
                                c.setpilih(3);
                                c.setjawab(txt_c.getText());
                                soalnya.insert_jawab(c);

                                //jawab d==================
                                d.setkd_paket(txt_kd_paket_soal.getText());
                                d.setkd_soal(kd_sos);
                                d.setpilih(4);
                                d.setjawab(txt_d.getText());
                                soalnya.insert_jawab(d);

                            }

                            }catch(Exception e){

                            }
                
                
                
                JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                this.statusAwal_soal();
                soal_mundur();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Tidak Tersimpan");
            Logger.getLogger(paket_soal.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void delete_soal_jawab(){
        try {
            soalnya.delete_soal(os);
            soalnya.delete_jawab(os);
            JOptionPane.showMessageDialog(this, "Data Telah di Hapus");
            this.statusAwal_soal();
            soal_maju();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data Tidak Bisa di Hapus");
            Logger.getLogger(paket_soal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void all(){
        try {
            String ky = txt_kd_paket_soal.getText();
            
            soalnya.insert_duplikat(ky);
            
            soalnya.delete_all_soal(ky);
        } catch (SQLException ex) {
            Logger.getLogger(paket_soal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGlass1 = new usu.widget.ButtonGlass();
        grup_jawab = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_home = new komponen.tombol_besar();
        frame_paket = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        txt_tanggal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_matpel = new javax.swing.JComboBox();
        txt_kelas = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txt_kd_paket = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_paket = new javax.swing.JTable();
        btn_hapus = new usu.widget.ButtonGlass();
        btn_simpan = new usu.widget.ButtonGlass();
        jLabel14 = new javax.swing.JLabel();
        txt_bobot = new javax.swing.JTextField();
        frame_soal = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_kd_paket_soal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_a = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_soal = new javax.swing.JTable();
        btn_hapus1 = new usu.widget.ButtonGlass();
        btn_simpan1 = new usu.widget.ButtonGlass();
        chec_a = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_soal = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        txt_b = new javax.swing.JTextField();
        chec_b = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        txt_c = new javax.swing.JTextField();
        chec_c = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        txt_d = new javax.swing.JTextField();
        chec_d = new javax.swing.JCheckBox();
        txt_nmr_soal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_sisa_soal = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btn_finish = new usu.widget.ButtonGlass();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

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
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 73, 1370, 18));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 1350, -1));

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

        frame_paket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        frame_paket.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame_paket.setVisible(true);

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_tanggal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txt_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 130, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Manajemen Ujian");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("* Paket Soal");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kode Soal");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kelas");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanggal");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 40));

        txt_total.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        txt_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totalKeyTyped(evt);
            }
        });
        jPanel4.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 100, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mata Pelajaran");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 40));

        txt_matpel.setFont(new java.awt.Font("Times New Roman", 1, 25)); // NOI18N
        jPanel4.add(txt_matpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 200, 40));

        txt_kelas.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        txt_kelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        txt_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kelasActionPerformed(evt);
            }
        });
        jPanel4.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 70, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Bobot Nilai Soal");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, 40));

        txt_kd_paket.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jPanel4.add(txt_kd_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 150, 40));

        tabel_paket.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_paket);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 760, 330));

        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel4.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, 150, 50));

        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel4.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 150, 50));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total Soal");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, 40));

        txt_bobot.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jPanel4.add(txt_bobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 100, 40));

        javax.swing.GroupLayout frame_paketLayout = new javax.swing.GroupLayout(frame_paket.getContentPane());
        frame_paket.getContentPane().setLayout(frame_paketLayout);
        frame_paketLayout.setHorizontalGroup(
            frame_paketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(frame_paketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(frame_paketLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        frame_paketLayout.setVerticalGroup(
            frame_paketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(frame_paketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(frame_paketLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(frame_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1370, 610));

        frame_soal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        frame_soal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame_soal.setVisible(false);

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Manajemen Ujian");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setText("* Soal");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        txt_kd_paket_soal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txt_kd_paket_soal.setForeground(new java.awt.Color(255, 255, 255));
        txt_kd_paket_soal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel5.add(txt_kd_paket_soal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 180, 40));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Soal");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 40));

        txt_a.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jPanel5.add(txt_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 210, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("A.");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 30));

        tabel_soal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabel_soal);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 760, 330));

        btn_hapus1.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_hapus1.setText("Hapus");
        btn_hapus1.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        btn_hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus1ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 150, 50));

        btn_simpan1.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan1.setText("Simpan");
        btn_simpan1.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        btn_simpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan1ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_simpan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 150, 50));

        grup_jawab.add(chec_a);
        jPanel5.add(chec_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 30, 30));

        txt_soal.setColumns(20);
        txt_soal.setRows(5);
        jScrollPane3.setViewportView(txt_soal);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 270, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("B.");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, 30));

        txt_b.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jPanel5.add(txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 210, 30));

        grup_jawab.add(chec_b);
        jPanel5.add(chec_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 30, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("C.");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, -1, 30));

        txt_c.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jPanel5.add(txt_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 210, 30));

        grup_jawab.add(chec_c);
        jPanel5.add(chec_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 30, 30));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("D.");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, -1, 30));

        txt_d.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        jPanel5.add(txt_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 210, 30));

        grup_jawab.add(chec_d);
        jPanel5.add(chec_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 30, 30));

        txt_nmr_soal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txt_nmr_soal.setForeground(new java.awt.Color(255, 255, 255));
        txt_nmr_soal.setText("1");
        jPanel5.add(txt_nmr_soal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 60, 40));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Jawaban");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, 40));

        txt_sisa_soal.setFont(new java.awt.Font("Times New Roman", 1, 76)); // NOI18N
        txt_sisa_soal.setForeground(new java.awt.Color(255, 0, 0));
        txt_sisa_soal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_sisa_soal.setText("9");
        jPanel5.add(txt_sisa_soal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 80, 80));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Sisa Soal");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, -1, 40));

        btn_finish.setForeground(new java.awt.Color(255, 255, 255));
        btn_finish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/finish.png"))); // NOI18N
        btn_finish.setText("Finish");
        btn_finish.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        btn_finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finishActionPerformed(evt);
            }
        });
        jPanel5.add(btn_finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 460, 150, 50));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Kode Paket");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 40));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nomor Soal");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 40));

        javax.swing.GroupLayout frame_soalLayout = new javax.swing.GroupLayout(frame_soal.getContentPane());
        frame_soal.getContentPane().setLayout(frame_soalLayout);
        frame_soalLayout.setHorizontalGroup(
            frame_soalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_soalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        frame_soalLayout.setVerticalGroup(
            frame_soalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_soalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(frame_soal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1370, 610));

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

    private void txt_totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalKeyTyped
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_totalKeyTyped

    private void txt_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kelasActionPerformed
        matpel();
    }//GEN-LAST:event_txt_kelasActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        save_paket();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        delete_paket();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan1ActionPerformed
        save_soal_jawab();
        soal_keluar();
    }//GEN-LAST:event_btn_simpan1ActionPerformed

    private void btn_hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus1ActionPerformed
       delete_soal_jawab();
       soal_muncul();
    }//GEN-LAST:event_btn_hapus1ActionPerformed

    private void btn_finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finishActionPerformed
        all();
        frame_soal.setVisible(false);
        dispose();
        new paket_soal().setVisible(true);
    }//GEN-LAST:event_btn_finishActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new paket_soal().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

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
            java.util.logging.Logger.getLogger(paket_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paket_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paket_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paket_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new paket_soal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_finish;
    private usu.widget.ButtonGlass btn_hapus;
    private usu.widget.ButtonGlass btn_hapus1;
    private komponen.tombol_besar btn_home;
    private usu.widget.ButtonGlass btn_simpan;
    private usu.widget.ButtonGlass btn_simpan1;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JCheckBox chec_a;
    private javax.swing.JCheckBox chec_b;
    private javax.swing.JCheckBox chec_c;
    private javax.swing.JCheckBox chec_d;
    private javax.swing.JInternalFrame frame_paket;
    private javax.swing.JInternalFrame frame_soal;
    private javax.swing.ButtonGroup grup_jawab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabel_paket;
    private javax.swing.JTable tabel_soal;
    private javax.swing.JTextField txt_a;
    private javax.swing.JTextField txt_b;
    private javax.swing.JTextField txt_bobot;
    private javax.swing.JTextField txt_c;
    private javax.swing.JTextField txt_d;
    private javax.swing.JTextField txt_kd_paket;
    private javax.swing.JLabel txt_kd_paket_soal;
    private javax.swing.JComboBox txt_kelas;
    private javax.swing.JComboBox txt_matpel;
    private javax.swing.JLabel txt_nmr_soal;
    private javax.swing.JLabel txt_sisa_soal;
    private javax.swing.JTextArea txt_soal;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
