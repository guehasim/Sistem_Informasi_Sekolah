
package siswa;

import file_koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import tata_usaha.awal.login_siswa;
import tata_usaha.ujian.view.c_soal;

public class nilai_siswa extends javax.swing.JFrame {

    String nis = login_siswa.l_nis;
    public nilai_siswa() {
        initComponents();
        
        dropdown_kelas();
        dropdown_thn_ajar();
    }

    private void dropdown_kelas() {
              try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from kelas");
        while(rs.next()){

            String kelas = rs.getString("nama_kelas");
          //  String nis = rs.getString("nis");

            txt_kelas.addItem(kelas);
           // txt_nis.addItem(nis);
        }
            
        }catch(Exception e){
            
        }
    }
    
     private void dropdown_thn_ajar() {
              try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from thn_ajar");
        while(rs.next()){
            String pelajar = rs.getString("nm_thnajar");
            txt_thn_ajar.addItem(pelajar);
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
        txt_nis = new javax.swing.JLabel();
        txt_thn_ajar = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btn_cari = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_nilai = new javax.swing.JTable();
        home_menu = new komponen.tombol_besar();
        txt_semester = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        refresh_menu = new komponen.tombol_besar();
        nilai_menu = new komponen.tombol_besar();

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
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 97, 1370, -1));

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

        txt_nis.setForeground(new java.awt.Color(0, 0, 153));
        jPanel4.add(txt_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 170, 30));

        txt_thn_ajar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_thn_ajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_thn_ajarActionPerformed(evt);
            }
        });
        jPanel4.add(txt_thn_ajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tekton Pro", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*Nilai");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 130, 50));

        txt_kelas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kelasActionPerformed(evt);
            }
        });
        jPanel4.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 60, 30));

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kelas");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, 30));

        btn_cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari.setText("Tampilkan");
        btn_cari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 140, -1));

        tabel_nilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabel_nilai);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 500, 470));

        home_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_siswa.png"))); // NOI18N
        home_menu.setText("Home");
        home_menu.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        home_menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        home_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_menuActionPerformed(evt);
            }
        });
        jPanel4.add(home_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 120, 40));

        txt_semester.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ganjil", "Genap" }));
        txt_semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_semesterActionPerformed(evt);
            }
        });
        jPanel4.add(txt_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 140, 30));

        jLabel6.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Semester");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tahun Ajaran");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, 30));

        refresh_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh_siswa.png"))); // NOI18N
        refresh_menu.setText("Ujian");
        refresh_menu.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        refresh_menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        refresh_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_menuActionPerformed(evt);
            }
        });
        jPanel4.add(refresh_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 150, 40));

        nilai_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nilai_siswa.png"))); // NOI18N
        nilai_menu.setText("Nilai");
        nilai_menu.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        nilai_menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        nilai_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nilai_menuActionPerformed(evt);
            }
        });
        jPanel4.add(nilai_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 120, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1370, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_thn_ajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_thn_ajarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_thn_ajarActionPerformed

    private void txt_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kelasActionPerformed

    private void home_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_menuActionPerformed
        new nilai_siswa().setVisible(false);
        dispose();
        new home_siswa().setVisible(true);
    }//GEN-LAST:event_home_menuActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        String header[]={"Tahun Ajaran","Semester","Kelas",
            "Nis","Nama","Matpel","Nilai"};
        DefaultTableModel dt = new DefaultTableModel(null, header);
        tabel_nilai.setModel(dt);
        
        for(int i=0; i<tabel_nilai.getRowCount();i++){
            dt.removeRow(i);
        }
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from nilai where tahun_ajaran "
                    + "like '%"+txt_thn_ajar.getSelectedItem().toString()+"%' and semester "
                    + "like '%"+txt_semester.getSelectedItem().toString()+"%' and kelas "
                    + "like '%"+txt_kelas.getSelectedItem().toString()+"%' and nis_siswa "
                    + "like '%"+nis+"%' ");
            
            while (rs.next()){
                String id = rs.getString(1);
                String thn_ajar = rs.getString(2);
                String semester = rs.getString(3);
                String kelas = rs.getString(4);
                String nis = rs.getString(5);
                String nama = rs.getString(6);
                String matpel = rs.getString(7);
                String nilai = rs.getString(8);
                
                Object baris[] = {thn_ajar, semester, kelas, nis, nama, matpel, nilai};
                dt.addRow(baris);
                
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_semesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_semesterActionPerformed

    private void refresh_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_menuActionPerformed

        new nilai_siswa().setVisible(false);
        dispose();
        new c_soal().setVisible(true);
    }//GEN-LAST:event_refresh_menuActionPerformed

    private void nilai_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nilai_menuActionPerformed
        
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
            java.util.logging.Logger.getLogger(nilai_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nilai_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nilai_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nilai_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_cari;
    private usu.widget.ButtonGlass buttonGlass1;
    private komponen.tombol_besar home_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private komponen.tombol_besar nilai_menu;
    private komponen.tombol_besar refresh_menu;
    private javax.swing.JTable tabel_nilai;
    private javax.swing.JComboBox txt_kelas;
    private javax.swing.JLabel txt_nis;
    private javax.swing.JComboBox txt_semester;
    private javax.swing.JComboBox txt_thn_ajar;
    // End of variables declaration//GEN-END:variables
}
