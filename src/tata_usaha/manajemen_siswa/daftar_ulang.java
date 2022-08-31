
package tata_usaha.manajemen_siswa;

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

    

public class daftar_ulang extends javax.swing.JFrame {

    List<entity_siswa> record=new ArrayList<entity_siswa>();
    inter_siswa aktif;
    int row;
    
    public daftar_ulang() {
        initComponents();
        
        dropdown_kelas();
        dropdown_tahun_ajaran();
        
        aktif = new imple_siswa();
            tabel_aktif_siswa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_aktif_siswa.getSelectedRow();
                    if(row!=-1){
                        isiText();
                    }
                }
            });
            this.statusAwal();
    }
    
    void loadData(){
        try {
            record = aktif.getAll_data();
        } catch (SQLException ex) {
            Logger.getLogger(daftar_ulang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel(){
        Object data[][]=new Object[record.size()][5];
        int x=0;
        for(entity_siswa thn:record){
            data[x][0]=thn.getthn_ajar();
            data[x][1]=thn.getsemester();
            data[x][2]=thn.getdi_kelas();
            data[x][3]=thn.getnis();
            data[x][4]=thn.getnama();
            x++;
        }
        String judul[]={"tahun ajaran","semester","kelas","nis","nama"}; 
        
        tabel_aktif_siswa.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel_aktif_siswa);
    }
    
    void isiText(){
        entity_siswa thn=record.get(row);
        
        txt_thn_ajaran.setSelectedItem(thn.getthn_ajar());
        txt_semester.setSelectedItem(thn.getsemester());
        txt_kelas.setSelectedItem(thn.getdi_kelas());
        txt_nis.setText(thn.getnis());
        txt_nama.setText(thn.getnama());
        
        txt_thn_ajaran1.setText(thn.getthn_ajar());
        txt_semester1.setText(thn.getsemester());
        txt_kelas1.setText(thn.getdi_kelas());
        txt_nis2.setText(thn.getnis());
        txt_nama1.setText(thn.getnama());
    }
    
    void kosongkanText(){
        txt_nis.setText("");
        txt_nama.setText("");
        
        txt_semester1.setText("");
        txt_thn_ajaran1.setText("");
        txt_kelas1.setText("");
        txt_nis2.setText("");
        txt_nama1.setText("");
    }
    
    private void dropdown_tahun_ajaran() {
              try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from thn_ajar");
        while(rs.next()){
            //entity_kelas thn=new entity_kelas();
            String ajar = rs.getString("nm_thnajar");
            //thn.setidKelas(rs.getString("id_kelas"));
            //thn.setnamaKelas(rs.getString("nama_kelas"));
            txt_thn_ajaran.addItem(ajar);
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
        }
            
        }catch(Exception e){
            
        }
    }
    
    void statusAwal(){
        kosongkanText();
        loadData();
        isiTabel();
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
        btn_back = new komponen.tombol_besar();
        btn_home = new komponen.tombol_besar();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_nis = new javax.swing.JLabel();
        txt_semester = new javax.swing.JComboBox();
        txt_kelas = new javax.swing.JComboBox();
        btn_simpan = new usu.widget.ButtonGlass();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_thn_ajaran = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_kelas1 = new javax.swing.JLabel();
        btn_tamat = new usu.widget.ButtonGlass();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txt_nama1 = new javax.swing.JLabel();
        txt_nis2 = new javax.swing.JLabel();
        txt_thn_ajaran1 = new javax.swing.JLabel();
        txt_semester1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_aktif_siswa = new javax.swing.JTable();

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

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btn_back.setText("Back");
        btn_back.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, 130));

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

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTabbedPane2.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(0, 0, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*Naik Kelas");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_nis.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        txt_nis.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(txt_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 260, 30));

        txt_semester.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ganjil", "Genap" }));
        jPanel7.add(txt_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 160, 30));

        txt_kelas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 90, 30));

        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel7.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 170, 35));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Tahun Ajaran");
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Semester");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        txt_thn_ajaran.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(txt_thn_ajaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 160, 30));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Kelas");
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 60, 30));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("NIS");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 60, 30));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Nama");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 60, 30));

        txt_nama.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 260, 30));

        jTabbedPane2.addTab("Naik Kelas", jPanel7);

        jPanel8.setBackground(new java.awt.Color(0, 0, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*Tamat Belajar");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_kelas1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        txt_kelas1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_kelas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 260, 30));

        btn_tamat.setForeground(new java.awt.Color(255, 255, 255));
        btn_tamat.setText("Tamat");
        btn_tamat.setFont(new java.awt.Font("Tekton Pro", 1, 20)); // NOI18N
        btn_tamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tamatActionPerformed(evt);
            }
        });
        jPanel8.add(btn_tamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 170, 35));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Tahun Ajaran");
        jPanel8.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Semester");
        jPanel8.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Kelas");
        jPanel8.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 60, 30));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("NIS");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 60, 30));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Nama");
        jPanel8.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 60, 30));

        txt_nama1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        txt_nama1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 260, 30));

        txt_nis2.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        txt_nis2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_nis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 260, 30));

        txt_thn_ajaran1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        txt_thn_ajaran1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_thn_ajaran1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 260, 30));

        txt_semester1.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        txt_semester1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_semester1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 260, 30));

        jTabbedPane2.addTab("Siswa Tamat", jPanel8);

        jPanel4.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 580, 390));

        tabel_aktif_siswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_aktif_siswa);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, 390));

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

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed

        new daftar_ulang().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try{
            //update database aktif siswa
            entity_siswa uye = new entity_siswa();
            uye.setthn_ajar(txt_thn_ajaran.getSelectedItem().toString());
            uye.setsemester(txt_semester.getSelectedItem().toString());
            uye.setdi_kelas(txt_kelas.getSelectedItem().toString());
            uye.setnis(txt_nis.getText());
            uye.setnama(txt_nama.getText());
            aktif.update_data(uye);
           
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil disimpan");
        }catch(SQLException ex){
            JOptionPane.showConfirmDialog(this, "data tidak bisa di ubah");
            Logger.getLogger(daftar_ulang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_tamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tamatActionPerformed
        try{
            String nim = txt_nis2.getText();
            aktif.delete_data(nim);
            aktif.delete_profil(nim);
            JOptionPane.showMessageDialog(this, "anda sudah Tamat");
            this.statusAwal();
        }catch(SQLException ex){
            JOptionPane.showConfirmDialog(this, "data tidak bisa di di hapus");
            Logger.getLogger(daftar_ulang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_tamatActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new daftar_ulang().setVisible(false);
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
            java.util.logging.Logger.getLogger(daftar_ulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar_ulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar_ulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar_ulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new daftar_ulang().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.tombol_besar btn_back;
    private komponen.tombol_besar btn_home;
    private usu.widget.ButtonGlass btn_simpan;
    private usu.widget.ButtonGlass btn_tamat;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tabel_aktif_siswa;
    private javax.swing.JComboBox txt_kelas;
    private javax.swing.JLabel txt_kelas1;
    private javax.swing.JLabel txt_nama;
    private javax.swing.JLabel txt_nama1;
    private javax.swing.JLabel txt_nis;
    private javax.swing.JLabel txt_nis2;
    private javax.swing.JComboBox txt_semester;
    private javax.swing.JLabel txt_semester1;
    private javax.swing.JComboBox txt_thn_ajaran;
    private javax.swing.JLabel txt_thn_ajaran1;
    // End of variables declaration//GEN-END:variables
}
