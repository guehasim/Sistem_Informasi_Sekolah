package siswa;

import javax.swing.JLabel;
import file_koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tata_usaha.awal.login_siswa;
import tata_usaha.manajemen_guru.add_guru;
import tata_usaha.manajemen_jab_guru.tabel_jabatan;
import tata_usaha.manajemen_matpel.add_matpel;
import tata_usaha.manajemen_nilai.nilai;
import tata_usaha.manajemen_siswa.add_siswa;
import tata_usaha.manajemen_siswa.entity_siswa;
import tata_usaha.ujian.view.c_soal;


public class home_siswa extends javax.swing.JFrame {

 
    public home_siswa() {
        initComponents();
        profil_siswa();
    }
    
    public void profil_siswa() {
              try{      
        
//        String nis1 = txt_nis1.getText();
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from siswa where nis ='"+login_siswa.l_nis+"' ");
        while(rs.next()){
            
            String nis = rs.getString("nis");
            String nama = rs.getString("nama");
            String jenkel = rs.getString("jenkel");
            String agama = rs.getString("agama");
            String tempat = rs.getString("tempat");
            String lahir = rs.getString("tgllahir");
            String alamat = rs.getString("alamat");
            String anakke = rs.getString("anakke");
            String statuskel = rs.getString("statuskel");
            String dikelas = rs.getString("di_kelas");
            String tglmasuk = rs.getString("tglmasuk");
            String nmsekolah = rs.getString("namasekolah");
            String almtsekolah = rs.getString("alamatsekolah");
            String ayah = rs.getString("ayah");
            String ibu = rs.getString("ibu");
            String almtayah = rs.getString("alamatayah");
            String almtibu = rs.getString("alamatibu");
            
            txt_nis.setText(nis);
            txt_nama.setText(nama);
            txt_jenkel.setText(jenkel);
            txt_agama.setText(agama);
            txt_tempat.setText(tempat);
            txt_tgl_lahir.setText(lahir);
            txt_alamat.setText(alamat);
            txt_anakke.setText(anakke);
            txt_status_kel.setText(statuskel);
            txt_kelas.setText(dikelas);
            txt_tgl_masuk.setText(tglmasuk);
            txt_nama_sekolah.setText(nmsekolah);
            txt_alamt_sekolah.setText(almtsekolah);
            txt_nm_ayah.setText(ayah);
            txt_nm_ibu.setText(ibu);
            txt_alm_ayah.setText(almtayah);
            txt_alm_ibu.setText(almtibu);
            
            
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        home_menu = new komponen.tombol_besar();
        nilai_menu = new komponen.tombol_besar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JLabel();
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
        txt_jenkel = new javax.swing.JLabel();
        txt_agama = new javax.swing.JLabel();
        txt_tempat = new javax.swing.JLabel();
        txt_tgl_lahir = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JLabel();
        txt_anakke = new javax.swing.JLabel();
        txt_status_kel = new javax.swing.JLabel();
        txt_nis = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JLabel();
        txt_tgl_masuk = new javax.swing.JLabel();
        txt_nama_sekolah = new javax.swing.JLabel();
        txt_alamt_sekolah = new javax.swing.JLabel();
        txt_nm_ayah = new javax.swing.JLabel();
        txt_nm_ibu = new javax.swing.JLabel();
        txt_alm_ayah = new javax.swing.JLabel();
        txt_alm_ibu = new javax.swing.JLabel();
        tombol_besar3 = new komponen.tombol_besar();
        txt_nis1 = new javax.swing.JLabel();
        refresh_menu = new komponen.tombol_besar();

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
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 1370, 18));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jl Raya Sumbersekar No. 155 kecamatan Dau, Kabupaten Malang 65151 Telp. 0241-7590221");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 1350, -1));

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

        home_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_siswa.png"))); // NOI18N
        home_menu.setText("Home");
        home_menu.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        home_menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        home_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_menuActionPerformed(evt);
            }
        });
        jPanel4.add(home_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 120, 40));

        nilai_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nilai_siswa.png"))); // NOI18N
        nilai_menu.setText("Nilai");
        nilai_menu.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        nilai_menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        nilai_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilai_menuActionPerformed(evt);
            }
        });
        jPanel4.add(nilai_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 120, 40));

        jLabel4.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ALAMAT IBU                    :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, -1, 25));

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*Profil Siswa");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("JENIS KELAMIN              :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, 25));

        txt_nama.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 230, 25));

        jLabel8.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("AGAMA                                 :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, 25));

        jLabel9.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TEMPAT                                :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, 25));

        jLabel10.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TANGGAL LAHIR            :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, 25));

        jLabel11.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ALAMAT                                :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, 25));

        jLabel12.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ANAK KE                                :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, -1, 25));

        jLabel13.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ALAMAT SEKOLAH     :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, 25));

        jLabel14.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("STATUS KELUARGA   :");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, 25));

        jLabel15.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DITERIMA DI KELAS   :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, -1, 25));

        jLabel16.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TANGGAL MASUK       :");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 200, -1, 25));

        jLabel17.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("NAMA SEKOLAH           :");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, 25));

        jLabel18.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("AYAH                                      :");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, -1, 25));

        jLabel19.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("IBU                                           :");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, -1, 25));

        jLabel20.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ALAMAT AYAH               :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, -1, 25));

        jLabel21.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("NAMA                                     :");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, 25));

        jLabel22.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("NIS                                           :");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, 25));

        txt_jenkel.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_jenkel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_jenkel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 230, 25));

        txt_agama.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_agama.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 230, 25));

        txt_tempat.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_tempat.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_tempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 230, 25));

        txt_tgl_lahir.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_tgl_lahir.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 230, 25));

        txt_alamat.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_alamat.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 230, 25));

        txt_anakke.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_anakke.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_anakke, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 230, 25));

        txt_status_kel.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_status_kel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_status_kel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 230, 25));

        txt_nis.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_nis.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 230, 25));

        txt_kelas.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_kelas.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, 230, 25));

        txt_tgl_masuk.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_tgl_masuk.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_tgl_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 200, 230, 25));

        txt_nama_sekolah.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_nama_sekolah.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nama_sekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 230, 25));

        txt_alamt_sekolah.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_alamt_sekolah.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_alamt_sekolah, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 280, 230, 25));

        txt_nm_ayah.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_nm_ayah.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nm_ayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 230, 25));

        txt_nm_ibu.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_nm_ibu.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nm_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, 230, 25));

        txt_alm_ayah.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_alm_ayah.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_alm_ayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 230, 25));

        txt_alm_ibu.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        txt_alm_ibu.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_alm_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 440, 230, 25));

        tombol_besar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/keluar.png"))); // NOI18N
        tombol_besar3.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        tombol_besar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_besar3ActionPerformed(evt);
            }
        });
        jPanel4.add(tombol_besar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 20, -1, 90));

        txt_nis1.setForeground(new java.awt.Color(0, 0, 153));
        jPanel4.add(txt_nis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 160, 30));

        refresh_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh_siswa.png"))); // NOI18N
        refresh_menu.setText("Ujian");
        refresh_menu.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        refresh_menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        refresh_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_menuActionPerformed(evt);
            }
        });
        jPanel4.add(refresh_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 150, 40));

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

    private void home_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_home_menuActionPerformed

    private void tombol_besar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_besar3ActionPerformed

        new home_siswa().setVisible(false);
        dispose();
        new login_siswa().setVisible(true);
    }//GEN-LAST:event_tombol_besar3ActionPerformed

    private void refresh_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_menuActionPerformed
        new home_siswa().setVisible(false);
        dispose();
        new c_soal().setVisible(true);
    }//GEN-LAST:event_refresh_menuActionPerformed

    private void nilai_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilai_menuActionPerformed
        new home_siswa().setVisible(false);
        dispose();
        new nilai_siswa().setVisible(true);
    }//GEN-LAST:event_nilai_menuActionPerformed

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
            java.util.logging.Logger.getLogger(home_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new home_siswa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass buttonGlass1;
    private komponen.tombol_besar home_menu;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private komponen.tombol_besar nilai_menu;
    private komponen.tombol_besar refresh_menu;
    private komponen.tombol_besar tombol_besar3;
    private javax.swing.JLabel txt_agama;
    private javax.swing.JLabel txt_alamat;
    private javax.swing.JLabel txt_alamt_sekolah;
    private javax.swing.JLabel txt_alm_ayah;
    private javax.swing.JLabel txt_alm_ibu;
    private javax.swing.JLabel txt_anakke;
    private javax.swing.JLabel txt_jenkel;
    private javax.swing.JLabel txt_kelas;
    private javax.swing.JLabel txt_nama;
    private javax.swing.JLabel txt_nama_sekolah;
    private javax.swing.JLabel txt_nis;
    private javax.swing.JLabel txt_nis1;
    private javax.swing.JLabel txt_nm_ayah;
    private javax.swing.JLabel txt_nm_ibu;
    private javax.swing.JLabel txt_status_kel;
    private javax.swing.JLabel txt_tempat;
    private javax.swing.JLabel txt_tgl_lahir;
    private javax.swing.JLabel txt_tgl_masuk;
    // End of variables declaration//GEN-END:variables
}
