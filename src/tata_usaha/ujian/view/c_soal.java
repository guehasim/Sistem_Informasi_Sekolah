package tata_usaha.ujian.view;

import file_koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tata_usaha.awal.login_siswa;
import tata_usaha.ujian.controller.uji;
import tata_usaha.ujian.model.m_uji;

public class c_soal extends javax.swing.JFrame {
    
    uji ujinya;
    
    String pkt_soal;
    int tot_soal;
    
    int kd_sol;
    int kun;
    public c_soal() {
        initComponents();
        
        lbl_nim.setText(login_siswa.l_nis);
        
        ujinya = new m_uji();
        
        btn_logout.setVisible(false);
        lbl_selesai.setVisible(false);
        jPanel5.setVisible(false);
        
        tampil_pkt();
        nom_sol();
    }
        
    void nom_sol(){
        String a = txt_nom_soal.getText();
        kd_sol = Integer.parseInt(a);
        all_me();
    }
    
    void banding_nom(){
        int a = kd_sol-1;
        if(a == tot_soal){
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            panelGlass1.setVisible(false);
            txt_tanya.setVisible(false);
            txt_a.setVisible(false);
            txt_b.setVisible(false);
            txt_c.setVisible(false);
            txt_d.setVisible(false);
            txt_nom_soal.setVisible(false);
            btn_next.setVisible(false);
            btn_next.setVisible(false);
            
            jPanel5.setVisible(true);
            lbl_selesai.setVisible(true);
            btn_logout.setVisible(true);
        }
    }
    
    
    void tampil_pkt(){
        try{            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from paket_soal where kondisi='1' ");
        while(rs.next()){
            
            pkt_soal = rs.getString("kd_paket");
            tot_soal = rs.getInt("jml_soal");
            
        }
            
        }catch(Exception e){
            
        }
    }
    
    void tampil_soal(){
        try{            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from tampung_soal where kd_paket='"+pkt_soal+"' and kd_soal='"+kd_sol+"' ");
        while(rs.next()){
            String soal = rs.getString("soal");
            txt_tanya.setText(soal);
        }
                    
        }catch(Exception e){
            
        }
    }
    
    void tampil_jawab_a(){
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet sa = st.executeQuery("select * from pilih_jawab where kd_paket='"+pkt_soal+"' and kd_soal='"+kd_sol+"' and pilih=1 ");

            while(sa.next()){
                String a = sa.getString("jawaban");
                txt_a.setText(a);
            }
       }catch(Exception e){
           
       }
    }
    
    void tampil_jawab_b(){
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet sa = st.executeQuery("select * from pilih_jawab where kd_paket='"+pkt_soal+"' and kd_soal='"+kd_sol+"' and pilih=2 ");

            while(sa.next()){
                String a = sa.getString("jawaban");
                txt_b.setText(a);
            }
       }catch(Exception e){
           
       }
    }
    
    void tampil_jawab_c(){
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet sa = st.executeQuery("select * from pilih_jawab where kd_paket='"+pkt_soal+"' and kd_soal='"+kd_sol+"' and pilih=3 ");

            while(sa.next()){
                String a = sa.getString("jawaban");
                txt_c.setText(a);
            }
       }catch(Exception e){
           
       }
    }
    
    void tampil_jawab_d(){
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet sa = st.executeQuery("select * from pilih_jawab where kd_paket='"+pkt_soal+"' and kd_soal='"+kd_sol+"' and pilih=4 ");

            while(sa.next()){
                String a = sa.getString("jawaban");
                txt_d.setText(a);
            }
       }catch(Exception e){
           
       }
    }
    
    void all_me(){
        tampil_soal();
        tampil_jawab_a();
        tampil_jawab_b();
        tampil_jawab_c();
        tampil_jawab_d();
        banding_nom();
    }
    
    void kunci(){
        try{
            Statement st=koneksi.getConnection().createStatement();
            ResultSet sa = st.executeQuery("select * from tampung_soal where kd_paket='"+pkt_soal+"' and kd_soal='"+kd_sol+"'");

            while(sa.next()){
                kun = sa.getInt("kunci");
            }
       }catch(Exception e){
           
       }
    }
    
    private void save(){
        kunci();
        try {
            entity_ujian oi = new entity_ujian();
            oi.setnis(lbl_nim.getText());
            oi.setkd_paket(pkt_soal);
            oi.setkd_soal(kd_sol);
            oi.setkunci(kun);
                int jk = 0;
                if(a.isSelected()){
                    jk = 1;
                }
                if(b.isSelected()){
                    jk = 2;
                }
                if(c.isSelected()){
                    jk = 3;
                }
                if(d.isSelected()){
                    jk = 4;
                }
             oi.setpilih(jk);
             ujinya.insert_jawab_uji(oi);
                kd_sol = kd_sol+1;
                txt_nom_soal.setText(""+kd_sol);
               tampil_pkt();
               nom_sol();
               banding_nom();
               grup_choice.clearSelection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Tidak Tersimpan");
            Logger.getLogger(c_soal.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void koreksi(){
        int benar = 1;
        int salah = 0;
        for(int a=1;a<=tot_soal;a++){
            try {
            Statement st=koneksi.getConnection().createStatement();
            ResultSet ta=st.executeQuery("select * from hasil_jawab where kd_paket='"+pkt_soal+"' and kd_soal="+a+" ");
                        
            while(ta.next()){
                int kd_soal = ta.getInt("kd_soal");
                int kunci = ta.getInt("kunci");
                int jawab = ta.getInt("jawab");
                
                System.out.println(kd_soal);
                if(kunci == jawab){
//                    System.out.println("True");
                    try{
                            entity_ujian upt = new entity_ujian();
                            upt.setnis(lbl_nim.getText());
                            upt.setkd_paket(pkt_soal);
                            upt.setkd_soal(kd_soal);
                            upt.sethasil(benar);
                            ujinya.update(upt);
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(this, "System Error");
                            Logger.getLogger(c_soal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                if(kunci != jawab){
//                    System.out.println("false");
                    try{
                            entity_ujian ups = new entity_ujian();
                            ups.setnis(lbl_nim.getText());
                            ups.setkd_paket(pkt_soal);
                            ups.setkd_soal(kd_soal);
                            ups.sethasil(salah);
                            ujinya.update(ups);
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(this, "System Error");
                            Logger.getLogger(c_soal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            }
            } catch (Exception e) {
            }
        }
        
        JOptionPane.showMessageDialog(rootPane, "Terima Kasih Telah Melaksakan Ujian");
        new c_soal().setVisible(false);
        dispose();
        new login_siswa().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grup_choice = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_tanya = new usu.widget.TextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_d = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_a = new javax.swing.JLabel();
        txt_b = new javax.swing.JLabel();
        txt_c = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        d = new javax.swing.JCheckBox();
        a = new javax.swing.JCheckBox();
        b = new javax.swing.JCheckBox();
        c = new javax.swing.JCheckBox();
        txt_nom_soal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_next = new usu.widget.glass.ButtonImageReflection();
        lbl_selesai = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_nim = new javax.swing.JLabel();
        btn_logout = new usu.widget.glass.ButtonImageReflection();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGlass1.setWarna(new java.awt.Color(0, 0, 153));
        panelGlass1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_tanya.setEditable(false);
        txt_tanya.setBackground(new java.awt.Color(255, 255, 153));
        txt_tanya.setColumns(20);
        txt_tanya.setRows(5);
        txt_tanya.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jScrollPane1.setViewportView(txt_tanya);

        panelGlass1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 650, 210));

        jPanel2.add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 710, 250));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("D");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("A");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, 30));

        txt_d.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txt_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 290, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("B");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("C");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));

        txt_a.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txt_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 290, 30));

        txt_b.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_b.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 290, 30));

        txt_c.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_c.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txt_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 290, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 60, 170));

        d.setBackground(new java.awt.Color(255, 255, 255));
        grup_choice.add(d);
        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 30, 30));

        a.setBackground(new java.awt.Color(255, 255, 255));
        grup_choice.add(a);
        jPanel2.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 30, 30));

        b.setBackground(new java.awt.Color(255, 255, 255));
        grup_choice.add(b);
        jPanel2.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 30, 30));

        c.setBackground(new java.awt.Color(255, 255, 255));
        grup_choice.add(c);
        jPanel2.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 30, 30));

        txt_nom_soal.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        txt_nom_soal.setForeground(new java.awt.Color(255, 0, 0));
        txt_nom_soal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_nom_soal.setText("1");
        jPanel2.add(txt_nom_soal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, 80));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Soal No.");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        jPanel2.add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));

        lbl_selesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Selesai.png"))); // NOI18N
        jPanel2.add(lbl_selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 710, 80));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 1088, 613));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 1100, 680));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nim.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        lbl_nim.setForeground(new java.awt.Color(255, 51, 51));
        jPanel4.add(lbl_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 40));

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log.png"))); // NOI18N
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel4.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        save();
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        koreksi();
    }//GEN-LAST:event_btn_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(c_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(c_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(c_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(c_soal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new c_soal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox a;
    private javax.swing.JCheckBox b;
    private usu.widget.glass.ButtonImageReflection btn_logout;
    private usu.widget.glass.ButtonImageReflection btn_next;
    private javax.swing.JCheckBox c;
    private javax.swing.JCheckBox d;
    private javax.swing.ButtonGroup grup_choice;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_nim;
    private javax.swing.JLabel lbl_selesai;
    private usu.widget.glass.PanelGlass panelGlass1;
    private javax.swing.JLabel txt_a;
    private javax.swing.JLabel txt_b;
    private javax.swing.JLabel txt_c;
    private javax.swing.JLabel txt_d;
    private javax.swing.JLabel txt_nom_soal;
    private usu.widget.TextArea txt_tanya;
    // End of variables declaration//GEN-END:variables
}
