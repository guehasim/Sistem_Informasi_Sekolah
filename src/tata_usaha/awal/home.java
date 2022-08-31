package tata_usaha.awal;

import javax.swing.JOptionPane;
import siswa.home_siswa;
import tata_usaha.jadwal.jadwal;
import tata_usaha.manajemen_guru.add_guru;
import tata_usaha.manajemen_jab_guru.tabel_jabatan;
import tata_usaha.manajemen_matpel.add_matpel;
import tata_usaha.manajemen_nilai.nilai;
import tata_usaha.manajemen_siswa.add_siswa;
import tata_usaha.manajemen_siswa.daftar_ulang;
import tata_usaha.ujian.view.ambil_nilai;
import tata_usaha.ujian.view.kondisi_pkt;
import tata_usaha.ujian.view.paket_soal;

/**
 *
 * @author AHMAD HASIM
 */
public class home extends javax.swing.JFrame {

    public home() {
        initComponents();
        this.kebutuhan();
    }
    
    void kebutuhan(){
        //btn siswa========
        pnl_siswa.setVisible(false);
        btn_thn_ajaran.setVisible(false);
        btn_dft_ulang.setVisible(false);
        btn_profil.setVisible(false);
        
        //btn ujian===========
        pnl_btn_uji.setVisible(false);
        btn_data_ujian.setVisible(false);
        btn_power_ujian.setVisible(false);
        btn_nilai_ujian.setVisible(false);
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
        btn_guru = new komponen.tombol_besar();
        btn_siswa = new komponen.tombol_besar();
        btn_matpel = new komponen.tombol_besar();
        btn_nilai = new komponen.tombol_besar();
        btn_logout = new komponen.tombol_besar();
        btn_jabatan = new komponen.tombol_besar();
        jLabel4 = new javax.swing.JLabel();
        btn_jadwal = new usu.widget.glass.ButtonImageReflection();
        btn_ujian = new komponen.tombol_besar();
        pnl_btn_uji = new usu.widget.glass.PanelGlass();
        btn_data_ujian = new usu.widget.glass.ButtonImageReflection();
        btn_power_ujian = new usu.widget.glass.ButtonImageReflection();
        btn_nilai_ujian = new usu.widget.glass.ButtonImageReflection();
        pnl_siswa = new usu.widget.glass.PanelGlass();
        btn_profil = new usu.widget.glass.ButtonImageReflection();
        btn_dft_ulang = new usu.widget.glass.ButtonImageReflection();
        btn_thn_ajaran = new usu.widget.glass.ButtonImageReflection();

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

        btn_guru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/manajemen_guru.png"))); // NOI18N
        btn_guru.setText("Manajemen Guru");
        btn_guru.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_guru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guruActionPerformed(evt);
            }
        });
        jPanel4.add(btn_guru, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, 130));

        btn_siswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/manajemen_siswa.png"))); // NOI18N
        btn_siswa.setText("Manajemen Siswa");
        btn_siswa.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_siswa.setMargin(new java.awt.Insets(2, 14, 1, 14));
        btn_siswa.setPreferredSize(new java.awt.Dimension(110, 110));
        btn_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siswaActionPerformed(evt);
            }
        });
        jPanel4.add(btn_siswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 180, 130));

        btn_matpel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/manajemen_matpel.png"))); // NOI18N
        btn_matpel.setText("Manajemen Matpel");
        btn_matpel.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_matpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_matpelActionPerformed(evt);
            }
        });
        jPanel4.add(btn_matpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 180, 130));

        btn_nilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nilai.png"))); // NOI18N
        btn_nilai.setText("Manajemen Nilai");
        btn_nilai.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilaiActionPerformed(evt);
            }
        });
        jPanel4.add(btn_nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 50, 170, 130));

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel4.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 410, 170, 140));

        btn_jabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/manajemen_kelas.png"))); // NOI18N
        btn_jabatan.setText("Manajemen Jabatan & Kelas");
        btn_jabatan.setFont(new java.awt.Font("Tekton Pro", 1, 16)); // NOI18N
        btn_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jabatanActionPerformed(evt);
            }
        });
        jPanel4.add(btn_jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 220, 210, 130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home,back.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        btn_jadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/jadwal_matpel.png"))); // NOI18N
        btn_jadwal.setText("Manajemen Jadwal");
        btn_jadwal.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_jadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jadwalActionPerformed(evt);
            }
        });
        jPanel4.add(btn_jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 180, -1));

        btn_ujian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/manajemen ujian.png"))); // NOI18N
        btn_ujian.setText("Manajemen Ujian");
        btn_ujian.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        btn_ujian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ujianActionPerformed(evt);
            }
        });
        jPanel4.add(btn_ujian, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, 170, 140));

        pnl_btn_uji.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_data_ujian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/data_ujian.png"))); // NOI18N
        btn_data_ujian.setText("Data Ujian");
        btn_data_ujian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_ujianActionPerformed(evt);
            }
        });
        pnl_btn_uji.add(btn_data_ujian, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 100, 130));

        btn_power_ujian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/power_ujian.png"))); // NOI18N
        btn_power_ujian.setText("Aktif Ujian");
        btn_power_ujian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_power_ujianActionPerformed(evt);
            }
        });
        pnl_btn_uji.add(btn_power_ujian, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        btn_nilai_ujian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nilai_ujian.png"))); // NOI18N
        btn_nilai_ujian.setText("Nilai Ujian");
        btn_nilai_ujian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilai_ujianActionPerformed(evt);
            }
        });
        pnl_btn_uji.add(btn_nilai_ujian, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jPanel4.add(pnl_btn_uji, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 290, 180));

        pnl_siswa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profil_siswa.png"))); // NOI18N
        btn_profil.setText("Profil");
        btn_profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profilActionPerformed(evt);
            }
        });
        pnl_siswa.add(btn_profil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btn_dft_ulang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/daftar_ulang.png"))); // NOI18N
        btn_dft_ulang.setText("Daftar Ulang");
        btn_dft_ulang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dft_ulangActionPerformed(evt);
            }
        });
        pnl_siswa.add(btn_dft_ulang, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        btn_thn_ajaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tahun_ajaran_siswa.png"))); // NOI18N
        btn_thn_ajaran.setText("Thn. Ajaran");
        btn_thn_ajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thn_ajaranActionPerformed(evt);
            }
        });
        pnl_siswa.add(btn_thn_ajaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 110, -1));

        jPanel4.add(pnl_siswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 290, -1));

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

    private void btn_guruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guruActionPerformed
       new home().setVisible(false);
       dispose();
       add_guru gr = new add_guru();
       gr.setVisible(true);
    }//GEN-LAST:event_btn_guruActionPerformed

    private void btn_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siswaActionPerformed
        pnl_siswa.setVisible(true);
        btn_thn_ajaran.setVisible(true);
        btn_dft_ulang.setVisible(true);
        btn_profil.setVisible(true);
    }//GEN-LAST:event_btn_siswaActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
       JOptionPane.showMessageDialog(this, "good bye!!!!");
       new home().setVisible(false);
       dispose();
       new pilih().setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jabatanActionPerformed
        new home().setVisible(false);
        dispose();
        new tabel_jabatan().setVisible(true);
    }//GEN-LAST:event_btn_jabatanActionPerformed

    private void btn_matpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_matpelActionPerformed
        new home().setVisible(false);
        dispose();
        new add_matpel().setVisible(true);
    }//GEN-LAST:event_btn_matpelActionPerformed

    private void btn_nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilaiActionPerformed
        new home().setVisible(false);
        dispose();
        new nilai().setVisible(true);
    }//GEN-LAST:event_btn_nilaiActionPerformed

    private void btn_jadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jadwalActionPerformed
        new home().setVisible(false);
        dispose();
        new jadwal().setVisible(true);
    }//GEN-LAST:event_btn_jadwalActionPerformed

    private void btn_ujianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ujianActionPerformed
        pnl_btn_uji.setVisible(true);
        btn_data_ujian.setVisible(true);
        btn_power_ujian.setVisible(true);
        btn_nilai_ujian.setVisible(true);
    }//GEN-LAST:event_btn_ujianActionPerformed

    private void btn_data_ujianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_ujianActionPerformed
        new home().setVisible(false);
        dispose();
        new paket_soal().setVisible(true);
    }//GEN-LAST:event_btn_data_ujianActionPerformed

    private void btn_power_ujianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_power_ujianActionPerformed
        new home().setVisible(false);
        dispose();
        new kondisi_pkt().setVisible(true);
    }//GEN-LAST:event_btn_power_ujianActionPerformed

    private void btn_profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profilActionPerformed
        new home().setVisible(false);
        dispose();
        new add_siswa().setVisible(true);
    }//GEN-LAST:event_btn_profilActionPerformed

    private void btn_dft_ulangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dft_ulangActionPerformed
        new home().setVisible(false);
        dispose();
        new daftar_ulang().setVisible(true);
    }//GEN-LAST:event_btn_dft_ulangActionPerformed

    private void btn_thn_ajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thn_ajaranActionPerformed
        new home().setVisible(false);
        dispose();
        new tabel_jabatan().setVisible(true);
    }//GEN-LAST:event_btn_thn_ajaranActionPerformed

    private void btn_nilai_ujianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilai_ujianActionPerformed
        new home().setVisible(false);
        dispose();
        new ambil_nilai().setVisible(true);
    }//GEN-LAST:event_btn_nilai_ujianActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.glass.ButtonImageReflection btn_data_ujian;
    private usu.widget.glass.ButtonImageReflection btn_dft_ulang;
    private komponen.tombol_besar btn_guru;
    private komponen.tombol_besar btn_jabatan;
    private usu.widget.glass.ButtonImageReflection btn_jadwal;
    private komponen.tombol_besar btn_logout;
    private komponen.tombol_besar btn_matpel;
    private komponen.tombol_besar btn_nilai;
    private usu.widget.glass.ButtonImageReflection btn_nilai_ujian;
    private usu.widget.glass.ButtonImageReflection btn_power_ujian;
    private usu.widget.glass.ButtonImageReflection btn_profil;
    private komponen.tombol_besar btn_siswa;
    private usu.widget.glass.ButtonImageReflection btn_thn_ajaran;
    private komponen.tombol_besar btn_ujian;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private usu.widget.glass.PanelGlass pnl_btn_uji;
    private usu.widget.glass.PanelGlass pnl_siswa;
    // End of variables declaration//GEN-END:variables
}
