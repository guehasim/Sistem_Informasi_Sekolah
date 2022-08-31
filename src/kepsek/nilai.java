
package kepsek;

import file_koneksi.koneksi;
import java.beans.PersistenceDelegate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import tata_usaha.awal.login_kepsek;


public class nilai extends javax.swing.JFrame {

    inter_nilai nilainya;
    
    List<entity_nilai> record=new ArrayList<entity_nilai>();
    int row;
    
    public nilai() {
        initComponents();
        dropdown_kelas();
        dropdown_thn_ajar();
        dropdown_matpel();
        select();

    }
    
    private void select(){
        String header[]={"Tahun Ajaran","Semester","Kelas",
            "Nis","Nama","Matpel","Nilai"};
        DefaultTableModel dt = new DefaultTableModel(null, header);
        tabel_nilai.setModel(dt);
        
        for(int i=0; i<tabel_nilai.getRowCount();i++){
            dt.removeRow(i);
        }
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from nilai");
            
            while (rs.next()){
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
        }
        catch(Exception e){
            
        }
    }
    
    private void dropdown_matpel() {
              try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from matpel");
        while(rs.next()){

            String matpel = rs.getString("nama_matpel");
          //  String nis = rs.getString("nis");

            txt_matpel.addItem(matpel);
           // txt_nis.addItem(nis);
        }
            
        }catch(Exception e){
            
        }
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
            txt_thnajar.addItem(pelajar);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_nilai = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_thnajar = new javax.swing.JComboBox();
        txt_matpel = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_semester = new javax.swing.JComboBox();
        btn_cari = new usu.widget.ButtonGlass();
        tombol_besar1 = new komponen.tombol_besar();
        jLabel16 = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JComboBox();

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

        tabel_nilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tabel_nilai);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1170, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Semester");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, 30));

        txt_thnajar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_thnajar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_thnajarItemStateChanged(evt);
            }
        });
        txt_thnajar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_thnajarKeyTyped(evt);
            }
        });
        jPanel4.add(txt_thnajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 120, 30));

        txt_matpel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(txt_matpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Daftar Nilai");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tahun Ajaran");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mata Pelajaran");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, 30));

        txt_semester.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ganjil", "Genap" }));
        txt_semester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txt_semesterItemStateChanged(evt);
            }
        });
        jPanel4.add(txt_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 130, 30));

        btn_cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_cari.setIcon(new javax.swing.ImageIcon("D:\\UMM\\INSTALLER\\java\\rapot sekolah\\src\\icon\\search.png")); // NOI18N
        btn_cari.setText("Lihat");
        btn_cari.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 120, 30));

        tombol_besar1.setIcon(new javax.swing.ImageIcon("D:\\UMM\\INSTALLER\\java\\rapot sekolah\\src\\icon\\keluar.png")); // NOI18N
        tombol_besar1.setText("Keluar");
        tombol_besar1.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        tombol_besar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_besar1ActionPerformed(evt);
            }
        });
        jPanel4.add(tombol_besar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, -1, 80));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Kelas");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, -1, 30));

        txt_kelas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 70, 30));

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
                    + "like '%"+txt_thnajar.getSelectedItem().toString()+"%' and semester "
                    + "like '%"+txt_semester.getSelectedItem().toString()+"%' and kelas "
                    + "like '%"+txt_kelas.getSelectedItem().toString()+"%' and pilih_matpel "
                    + "like '%"+txt_matpel.getSelectedItem().toString()+"%' ");
            
            while (rs.next()){
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

    private void txt_thnajarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_thnajarKeyTyped

    }//GEN-LAST:event_txt_thnajarKeyTyped

    private void txt_thnajarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_thnajarItemStateChanged

    }//GEN-LAST:event_txt_thnajarItemStateChanged

    private void txt_semesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txt_semesterItemStateChanged

    }//GEN-LAST:event_txt_semesterItemStateChanged

    private void tombol_besar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_besar1ActionPerformed
        new nilai().setVisible(false);
        dispose();
        new login_kepsek().setVisible(true);
    }//GEN-LAST:event_tombol_besar1ActionPerformed

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
            java.util.logging.Logger.getLogger(nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new nilai().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_cari;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_nilai;
    private komponen.tombol_besar tombol_besar1;
    private javax.swing.JComboBox txt_kelas;
    private javax.swing.JComboBox txt_matpel;
    private javax.swing.JComboBox txt_semester;
    private javax.swing.JComboBox txt_thnajar;
    // End of variables declaration//GEN-END:variables
}
