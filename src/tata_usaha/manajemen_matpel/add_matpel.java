
package tata_usaha.manajemen_matpel;

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

public class add_matpel extends javax.swing.JFrame {

    List<entity_matpel> record=new ArrayList<entity_matpel>();
    inter_matpel matpelnya;
    int row;
    
    public add_matpel() {
        initComponents();
        
        dropdown();
        
        matpelnya = new imple_matpel();
           

            tabel_matpel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_matpel.getSelectedRow();
                    if(row!=-1){
                        isiText();
                    }
                }
            });
            this.statusAwal();
            
    }
    
    void loadData(){
        try {
            record = matpelnya.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(add_matpel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][]=new Object[record.size()][3];
        int x=0;
        for(entity_matpel thn:record){
            data[x][0]=thn.getkode_matpel();
            data[x][1]=thn.getnama_matpel();
            data[x][2]=thn.getkelas_matpel();
            x++;
        }
        String judul[]={"Kode Matpel","Nama Matpel","Kelas"}; 
        
       // jComboBox1.setModel(new DefaultComboBoxModel(data, judul));
        tabel_matpel.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel_matpel);
    }
    
    void isiText(){
        entity_matpel thn=record.get(row);
        txt_kode_matpel_ubh.setText(thn.getkode_matpel());
        txt_nm_matpel_ubh.setText(thn.getnama_matpel());
        txt_kelas_ubh.setSelectedItem(thn.getkelas_matpel());
        
        txt_kode_matpel_hps.setText(thn.getkode_matpel());
        txt_nm_matpel_hps.setText(thn.getnama_matpel());
        txt_kelas_hps.setSelectedItem(thn.getkelas_matpel());
    }
    
    void kosongkanText(){
        txt_kode_matpel_tmb.setText("");
        txt_nm_matpel_tmb.setText("");
        txt_cari.setSelectedItem("");
        
        txt_kode_matpel_ubh.setText("");
        txt_nm_matpel_ubh.setText("");
        txt_kelas_ubh.setSelectedItem("");
        
        txt_kode_matpel_hps.setText("");
        txt_nm_matpel_hps.setText("");
        txt_kelas_hps.setSelectedItem("");
    }
    
    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
    }
    
    private void dropdown() {
    try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from kelas");
        while(rs.next()){
            //entity_kelas thn=new entity_kelas();
            String kelas = rs.getString("nama_kelas");
            //thn.setidKelas(rs.getString("id_kelas"));
            //thn.setnamaKelas(rs.getString("nama_kelas"));
            txt_cari.addItem(kelas);
            txt_kelas_tmb.addItem(kelas);
            txt_kelas_ubh.addItem(kelas);
            txt_kelas_hps.addItem(kelas);
        }
            
        }catch(Exception e){
            
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
        jLabel6 = new javax.swing.JLabel();
        btn_home = new komponen.tombol_besar();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btn_simpan_matpel = new usu.widget.ButtonGlass();
        jLabel36 = new javax.swing.JLabel();
        txt_kode_matpel_tmb = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_kelas_tmb = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        txt_nm_matpel_tmb = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_kelas_ubh = new javax.swing.JComboBox();
        btn_ubah = new usu.widget.ButtonGlass();
        jLabel39 = new javax.swing.JLabel();
        txt_kode_matpel_ubh = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txt_nm_matpel_ubh = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_kelas_hps = new javax.swing.JComboBox();
        btn_hapus = new usu.widget.ButtonGlass();
        jLabel45 = new javax.swing.JLabel();
        txt_kode_matpel_hps = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txt_nm_matpel_hps = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_matpel = new javax.swing.JTable();
        txt_cari = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();

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

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTabbedPane2.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(0, 0, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*Tambah Mata Pelajaran");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_simpan_matpel.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan_matpel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan_matpel.setText("Simpan");
        btn_simpan_matpel.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_simpan_matpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpan_matpelActionPerformed(evt);
            }
        });
        jPanel7.add(btn_simpan_matpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 200, 35));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Kode Matpel");
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_kode_matpel_tmb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel7.add(txt_kode_matpel_tmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 330, 35));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Nama Matpel");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txt_kelas_tmb.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(txt_kelas_tmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 90, 35));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Kelas");
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txt_nm_matpel_tmb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel7.add(txt_nm_matpel_tmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 330, 35));

        jTabbedPane2.addTab("Tambah Matpel", jPanel7);

        jPanel9.setBackground(new java.awt.Color(0, 0, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*Ubah Mata Pelajaran");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Kelas");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        txt_kelas_ubh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel9.add(txt_kelas_ubh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 80, 35));

        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        jPanel9.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 200, 35));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Kode Matpel");
        jPanel9.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_kode_matpel_ubh.setEditable(false);
        txt_kode_matpel_ubh.setBackground(new java.awt.Color(255, 255, 153));
        txt_kode_matpel_ubh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txt_kode_matpel_ubh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 330, 35));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Nama Matpel");
        jPanel9.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txt_nm_matpel_ubh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel9.add(txt_nm_matpel_ubh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 330, 35));

        jTabbedPane2.addTab("Ubah Matpel", jPanel9);

        jPanel11.setBackground(new java.awt.Color(0, 0, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*Hapus Mata Pelajaran");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Kelas");
        jPanel11.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        txt_kelas_hps.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel11.add(txt_kelas_hps, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 80, 35));

        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel11.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 200, 35));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Kode Matpel");
        jPanel11.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_kode_matpel_hps.setEditable(false);
        txt_kode_matpel_hps.setBackground(new java.awt.Color(255, 255, 153));
        txt_kode_matpel_hps.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel11.add(txt_kode_matpel_hps, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 330, 35));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Nama Matpel");
        jPanel11.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txt_nm_matpel_hps.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel11.add(txt_nm_matpel_hps, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 330, 35));

        jTabbedPane2.addTab("Hapus Matpel", jPanel11);

        jPanel4.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 580, 390));

        tabel_matpel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_matpel);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, 320));

        txt_cari.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_cari.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_cariItemStateChanged(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cariKeyTyped(evt);
            }
        });
        jPanel4.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 90, 35));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Kelas");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, -1, 30));

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

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new add_matpel().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        try{
            entity_matpel upt = new entity_matpel();
            upt.setkode_matpel(txt_kode_matpel_ubh.getText());
            upt.setnama_matpel(txt_nm_matpel_ubh.getText());
            upt.setkelas_matpel(txt_kelas_ubh.getSelectedItem().toString());
            matpelnya.update(upt);
            JOptionPane.showMessageDialog(this, "data berhasil diubah");
            this.statusAwal();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "data tidak bisa di ubah");
            Logger.getLogger(add_matpel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try{
            String kode = txt_kode_matpel_hps.getText();
            matpelnya.delete(kode);
            JOptionPane.showMessageDialog(this, "data berhasil di Hapus");
            this.statusAwal();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "data tidak bisa di Hapus");
            Logger.getLogger(add_matpel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpan_matpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpan_matpelActionPerformed
        try{
            entity_matpel ko = new entity_matpel();
            if(txt_kode_matpel_tmb.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "NIS Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_kode_matpel_tmb.requestFocus();
            }
            else if(txt_nm_matpel_tmb.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Nama Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nm_matpel_tmb.requestFocus();
            }
            else{
                ko.setkode_matpel(txt_kode_matpel_tmb.getText());
                ko.setnama_matpel(txt_nm_matpel_tmb.getText());
                ko.setkelas_matpel(txt_kelas_tmb.getSelectedItem().toString());
                matpelnya.insert(ko);
                this.statusAwal();
                JOptionPane.showMessageDialog(this, "data berhasil disimpan");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "data belum berhasil disimpan");
            Logger.getLogger(add_matpel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpan_matpelActionPerformed

    private void txt_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyTyped
        
    }//GEN-LAST:event_txt_cariKeyTyped

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        
    }//GEN-LAST:event_txt_cariKeyReleased

    private void txt_cariItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_cariItemStateChanged
        String header[]={"Kode Matpel","Nama Matpel","Kelas"};
        DefaultTableModel dt = new DefaultTableModel(null, header);
        tabel_matpel.setModel(dt);
        
        for(int i=0; i<tabel_matpel.getRowCount();i++){
            dt.removeRow(i);
        }
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from matpel where kelas "
                    + "like '%"+txt_cari.getSelectedItem().toString()+"%' ");
            
            while (rs.next()){
                String kode = rs.getString(1);
                String nama = rs.getString(2);
                String kelas = rs.getString(3);
                
                Object baris[] = {kode,nama,kelas};
                dt.addRow(baris);
                
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_txt_cariItemStateChanged

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
            java.util.logging.Logger.getLogger(add_matpel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_matpel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_matpel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_matpel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new add_matpel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_hapus;
    private komponen.tombol_besar btn_home;
    private usu.widget.ButtonGlass btn_simpan_matpel;
    private usu.widget.ButtonGlass btn_ubah;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tabel_matpel;
    private javax.swing.JComboBox txt_cari;
    private javax.swing.JComboBox txt_kelas_hps;
    private javax.swing.JComboBox txt_kelas_tmb;
    private javax.swing.JComboBox txt_kelas_ubh;
    private javax.swing.JTextField txt_kode_matpel_hps;
    private javax.swing.JTextField txt_kode_matpel_tmb;
    private javax.swing.JTextField txt_kode_matpel_ubh;
    private javax.swing.JTextField txt_nm_matpel_hps;
    private javax.swing.JTextField txt_nm_matpel_tmb;
    private javax.swing.JTextField txt_nm_matpel_ubh;
    // End of variables declaration//GEN-END:variables
}
