package tata_usaha.jadwal;

import file_koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import tata_usaha.awal.home;

public class jadwal extends javax.swing.JFrame {

    List<entity_jadwal> record=new ArrayList<entity_jadwal>();
    inter_jadwal jadwalnya;
    int row;
    
    int a;
    String b;
    String f;
    
    public jadwal() {
        initComponents();
        kelas();
        
        jadwalnya = new imple_jadwal();
                
            tabel_jadwal.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_jadwal.getSelectedRow();
                    if(row!=-1){
                        isiText();
                    }
                }
            });
            this.statusAwal();
    }
    
    void loadData(){
        try {
            record = jadwalnya.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(jadwal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][]=new Object[record.size()][9];
        int x=0;
        for(entity_jadwal thn:record){
            data[x][0]=thn.getjam();
            data[x][1]=thn.getsenin();
            data[x][2]=thn.getselasa();
            data[x][3]=thn.getrabu();
            data[x][4]=thn.getkamis();
            data[x][5]=thn.getjumat();
            data[x][6]=thn.getsabtu();            
            data[x][7]=thn.getkelas();
            data[x][8]=thn.getwalkes();
            x++;
        }
        String judul[]={"Jam","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","Kelas","Wali Kelas"}; 
        
        tabel_jadwal.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel_jadwal);
    }
    
    void isiText(){
        entity_jadwal thn=record.get(row);
        
        a = thn.getid_jad();
        b = thn.getjam();
        txt_kelas1.addItem(thn.getkelas());
        txt_senin1.addItem(thn.getsenin());
        txt_selasa1.addItem(thn.getselasa());
        txt_rabu1.addItem(thn.getrabu());
        txt_kamis1.addItem(thn.getkamis());
        txt_jumat1.addItem(thn.getjumat());
        txt_sabtu1.addItem(thn.getsabtu());
        txt_walkes1.setText(thn.getwalkes());
        
        txt_w2.setText(thn.getjam());
        int c = thn.getkelas();
        f = ""+c;
        txt_kelas2.setText(f);
        txt_walkes2.setText(thn.getwalkes());
//        txt_nip1.setText(thn.getnip());

        
    }
    
    void kosongkanText(){
        
        //kosong frame tambah pelajaran
        txt_wf.setText("");
        txt_wl.setText("");
    }
    
    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
    }
    
    void kelas(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from kelas");
        while(rs.next()){
            
            String kelas = rs.getString("nama_kelas");
            
            txt_kelas.addItem(kelas);
            txt_cari.addItem(kelas);
        }
            
        }catch(Exception e){
            
        }
    }
    
    void matpel(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from matpel where kelas='"+txt_kelas.getSelectedItem().toString()+"'");
        while(rs.next()){
            
            String kd_matpel = rs.getString("kode_matpel");
            String nm_matpel = rs.getString("nama_matpel");
            
            txt_senin.addItem(nm_matpel);
            txt_selasa.addItem(nm_matpel);
            txt_rabu.addItem(nm_matpel);
            txt_kamis.addItem(nm_matpel);
            txt_jumat.addItem(nm_matpel);
            txt_sabtu.addItem(nm_matpel);
        }
            
        }catch(Exception e){
            
        }
    }
    
    void walkes(){
        try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan where jab='Wali Kelas' and kel_jab='"+txt_kelas.getSelectedItem().toString()+"'");
        while(rs.next()){
            
            String nama = rs.getString("nm_jab");
            
            txt_walkes.setText(nama);
        }
            
        }catch(Exception e){
            
        }
    }
    
    void save(){
        String a = txt_wf.getText();
        String b = txt_wl.getText();
        String c = a+":"+b;
        
        String d = txt_kelas.getSelectedItem().toString();
        int e = Integer.parseInt(d);
        
        entity_jadwal ko = new entity_jadwal();
        try{
        if(txt_wf.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Waktu Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_wf.requestFocus();
            }
        else if(txt_wl.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Waktu Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_wl.requestFocus();
            }
        else if(txt_kelas.getSelectedItem().toString().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Pilih kelas terlebih dahulu !","Kesalahan",JOptionPane.ERROR_MESSAGE);
            txt_kelas.requestFocus();
        }else{
            ko.setjam(c);
            ko.setkelas(e);
            ko.setsenin(txt_senin.getSelectedItem().toString());
            ko.setselasa(txt_selasa.getSelectedItem().toString());
            ko.setrabu(txt_rabu.getSelectedItem().toString());
            ko.setkamis(txt_kamis.getSelectedItem().toString());
            ko.setjumat(txt_jumat.getSelectedItem().toString());
            ko.setsabtu(txt_sabtu.getSelectedItem().toString());
            ko.setwalkes(txt_walkes.getText());
            jadwalnya.insert(ko);
            JOptionPane.showMessageDialog(this, "Data Telah tersimpan");
            this.statusAwal();
        }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Data Tidak Bisa Tersimpan");
            Logger.getLogger(jadwal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void delete(){
        try {
            jadwalnya.delete(a);
            JOptionPane.showMessageDialog(this, "Data Telah di Hapus");
            this.statusAwal();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data Tidak Bisa di Hapus");
            Logger.getLogger(jadwal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void update(){
        entity_jadwal ko = new entity_jadwal();
        try {
            ko.setid_jad(a);
            ko.setjam(b);
            ko.setsenin(txt_sabtu1.getSelectedItem().toString());
            ko.setselasa(txt_selasa1.getSelectedItem().toString());
            ko.setrabu(txt_rabu1.getSelectedItem().toString());
            ko.setkamis(txt_kamis1.getSelectedItem().toString());
            ko.setjumat(txt_jumat1.getSelectedItem().toString());
            ko.setsabtu(txt_sabtu1.getSelectedItem().toString());
                String z = txt_kelas1.getSelectedItem().toString();
                int y = Integer.parseInt(z);
            ko.setkelas(y);
            ko.setwalkes(txt_walkes.getText());
            jadwalnya.update(ko);
            JOptionPane.showMessageDialog(this,"Data Berhasil di Ubah");
            this.statusAwal();            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Data Tidak Bisa di Ubah");
            Logger.getLogger(jadwal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGlass1 = new usu.widget.ButtonGlass();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_wl = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txt_walkes = new javax.swing.JTextField();
        txt_kelas = new javax.swing.JComboBox();
        txt_senin = new javax.swing.JComboBox();
        txt_wf = new javax.swing.JTextField();
        btn_save = new usu.widget.ButtonGlass();
        jLabel8 = new javax.swing.JLabel();
        txt_sabtu = new javax.swing.JComboBox();
        txt_selasa = new javax.swing.JComboBox();
        txt_rabu = new javax.swing.JComboBox();
        txt_kamis = new javax.swing.JComboBox();
        txt_jumat = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
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
        txt_wl1 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txt_walkes1 = new javax.swing.JTextField();
        txt_kelas1 = new javax.swing.JComboBox();
        txt_sabtu1 = new javax.swing.JComboBox();
        txt_wf1 = new javax.swing.JTextField();
        btn_update = new usu.widget.ButtonGlass();
        txt_senin1 = new javax.swing.JComboBox();
        txt_selasa1 = new javax.swing.JComboBox();
        txt_rabu1 = new javax.swing.JComboBox();
        txt_kamis1 = new javax.swing.JComboBox();
        txt_jumat1 = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txt_walkes2 = new javax.swing.JTextField();
        txt_kelas2 = new javax.swing.JTextField();
        btn_delete = new usu.widget.ButtonGlass();
        txt_w2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JComboBox();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_jadwal = new javax.swing.JTable();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_home = new komponen.tombol_besar();
        jPanel7 = new javax.swing.JPanel();

        buttonGlass1.setText("buttonGlass1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1530, 810));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1530, 810));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Sabtu");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, 30));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText(":");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, 40));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Kelas");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 40));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Wali Kelas");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 40));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Senin");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 30));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Selasa");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 30));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Rabu");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Kamis");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 30));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Jum'at");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 30));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Hari");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txt_wl.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jPanel2.add(txt_wl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 50, 40));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Waktu");
        jPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 40));

        txt_walkes.setEditable(false);
        txt_walkes.setBackground(new java.awt.Color(255, 255, 102));
        txt_walkes.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jPanel2.add(txt_walkes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 240, 40));

        txt_kelas.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txt_kelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        txt_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kelasActionPerformed(evt);
            }
        });
        jPanel2.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 60, 40));

        txt_senin.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel2.add(txt_senin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 240, 30));

        txt_wf.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jPanel2.add(txt_wf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 50, 40));

        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_save.setText("Simpan");
        btn_save.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 150, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*Tambah Jadwal Pelajaran");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_sabtu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel2.add(txt_sabtu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 240, 30));

        txt_selasa.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel2.add(txt_selasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 240, 30));

        txt_rabu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel2.add(txt_rabu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 240, 30));

        txt_kamis.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel2.add(txt_kamis, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 240, 30));

        txt_jumat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel2.add(txt_jumat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 240, 30));

        jTabbedPane1.addTab("Tambah Jadwal", jPanel2);

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*Ubah Jadwal Pelajaran");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Sabtu");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, 30));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText(":");
        jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, 40));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Kelas");
        jPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 40));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Wali Kelas");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 40));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Senin");
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 30));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Selasa");
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 30));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Rabu");
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Kamis");
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 30));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Jum'at");
        jPanel5.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 30));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Hari");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txt_wl1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jPanel5.add(txt_wl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 50, 40));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Waktu");
        jPanel5.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 40));

        txt_walkes1.setEditable(false);
        txt_walkes1.setBackground(new java.awt.Color(255, 255, 102));
        txt_walkes1.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jPanel5.add(txt_walkes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 240, 40));

        txt_kelas1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txt_kelas1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel5.add(txt_kelas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 60, 40));

        txt_sabtu1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel5.add(txt_sabtu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 240, 30));

        txt_wf1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jPanel5.add(txt_wf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 50, 40));

        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btn_update.setText("Ubah");
        btn_update.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel5.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 150, 40));

        txt_senin1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel5.add(txt_senin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 240, 30));

        txt_selasa1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel5.add(txt_selasa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 240, 30));

        txt_rabu1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel5.add(txt_rabu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 240, 30));

        txt_kamis1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel5.add(txt_kamis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 240, 30));

        txt_jumat1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel5.add(txt_jumat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 240, 30));

        jTabbedPane1.addTab("Ubah Jadwal", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 0, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*Hapus Jadwal Pelajaran");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Kelas");
        jPanel6.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 40));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Wali Kelas");
        jPanel6.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 40));

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Waktu");
        jPanel6.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 40));

        txt_walkes2.setEditable(false);
        txt_walkes2.setBackground(new java.awt.Color(255, 255, 102));
        txt_walkes2.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jPanel6.add(txt_walkes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 240, 40));

        txt_kelas2.setEditable(false);
        txt_kelas2.setBackground(new java.awt.Color(255, 255, 102));
        txt_kelas2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txt_kelas2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(txt_kelas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 130, 40));

        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_delete.setText("Hapus");
        btn_delete.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel6.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 150, 40));

        txt_w2.setBackground(new java.awt.Color(255, 255, 102));
        txt_w2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txt_w2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(txt_w2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 130, 40));

        jTabbedPane1.addTab("Hapus Jadwal", jPanel6);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 450, 580));

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*Manajemen Jadwal Pelajaran");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_cari.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txt_cari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jPanel4.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 60, 40));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Kelas");
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 40));

        tabel_jadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_jadwal);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 850, 450));

        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jPanel4.add(buttonImageReflection1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1370, 580));

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 97, 1370, -1));

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

        jPanel7.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1370, 20));

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

    private void txt_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kelasActionPerformed
        matpel();
        walkes();
    }//GEN-LAST:event_txt_kelasActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        save();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new jadwal().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        update();
    }//GEN-LAST:event_btn_updateActionPerformed

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
            java.util.logging.Logger.getLogger(jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new jadwal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_delete;
    private komponen.tombol_besar btn_home;
    private usu.widget.ButtonGlass btn_save;
    private usu.widget.ButtonGlass btn_update;
    private usu.widget.ButtonGlass buttonGlass1;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
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
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
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
    private javax.swing.JTable tabel_jadwal;
    private javax.swing.JComboBox txt_cari;
    private javax.swing.JComboBox txt_jumat;
    private javax.swing.JComboBox txt_jumat1;
    private javax.swing.JComboBox txt_kamis;
    private javax.swing.JComboBox txt_kamis1;
    private javax.swing.JComboBox txt_kelas;
    private javax.swing.JComboBox txt_kelas1;
    private javax.swing.JTextField txt_kelas2;
    private javax.swing.JComboBox txt_rabu;
    private javax.swing.JComboBox txt_rabu1;
    private javax.swing.JComboBox txt_sabtu;
    private javax.swing.JComboBox txt_sabtu1;
    private javax.swing.JComboBox txt_selasa;
    private javax.swing.JComboBox txt_selasa1;
    private javax.swing.JComboBox txt_senin;
    private javax.swing.JComboBox txt_senin1;
    private javax.swing.JTextField txt_w2;
    private javax.swing.JTextField txt_walkes;
    private javax.swing.JTextField txt_walkes1;
    private javax.swing.JTextField txt_walkes2;
    private javax.swing.JTextField txt_wf;
    private javax.swing.JTextField txt_wf1;
    private javax.swing.JTextField txt_wl;
    private javax.swing.JTextField txt_wl1;
    // End of variables declaration//GEN-END:variables
}
