package tata_usaha.ujian.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import tata_usaha.awal.home;
import tata_usaha.ujian.controller.paket;
import tata_usaha.ujian.model.m_paket;


public class kondisi_pkt extends javax.swing.JFrame {

    List<entity_ujian> record=new ArrayList<entity_ujian>();
    paket paketnya;
    int row;
    
    public kondisi_pkt() {
        initComponents();
        
        paketnya = new m_paket();
        
        tabel_paket.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_paket.getSelectedRow();
                    if(row!=-1){
                        isiText_paket();
                    }
                }
            });
        this.statusAwal_paket();
        btn_off.setVisible(false);
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
        txt_paket.setText(thn.getkd_paket());
        }
    
    void statusAwal_paket(){
        loadData_paket();
        isiTabel_paket();
    }
    
    private void kondisinya_on(){
        try{
            entity_ujian upt = new entity_ujian();
            if(txt_paket.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Pilih Dulu Paketnya !","Kesalahan",JOptionPane.ERROR_MESSAGE);
            }else{
            upt.setkondis("1");
            upt.setkd_paket(txt_paket.getText());
            paketnya.update(upt);
            JOptionPane.showMessageDialog(this, "Paket Soal di Aktifkan");
            this.statusAwal_paket();
            btn_on.setVisible(false);
            btn_off.setVisible(true);
            tabel_paket.setVisible(false);            
            btn_home.setVisible(false);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Paket Tidak Bisa di Aktifkan");
            Logger.getLogger(kondisi_pkt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void kondisinya_off(){
        try{
            entity_ujian upt = new entity_ujian();
            upt.setkondis("0");
            upt.setkd_paket(txt_paket.getText());
            paketnya.update(upt);
            JOptionPane.showMessageDialog(this, "Paket Soal di NonAktifkan");
            this.statusAwal_paket();
            btn_off.setVisible(false);
            btn_on.setVisible(true);
            tabel_paket.setVisible(true);
            txt_paket.setText("");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Paket Tidak Bisa di NonAktifkan");
            Logger.getLogger(kondisi_pkt.class.getName()).log(Level.SEVERE, null, ex);
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
        btn_home = new komponen.tombol_besar();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_paket = new javax.swing.JTable();
        txt_paket = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_on = new usu.widget.glass.ButtonImageReflection();
        btn_off = new usu.widget.glass.ButtonImageReflection();

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

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        txt_paket.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txt_paket.setForeground(new java.awt.Color(255, 255, 255));
        txt_paket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_paket.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        jPanel4.add(txt_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 270, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Kode Paket");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, -1, -1));

        btn_on.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/on.png"))); // NOI18N
        btn_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_onActionPerformed(evt);
            }
        });
        jPanel4.add(btn_on, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 240, 300, 110));

        btn_off.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/off.png"))); // NOI18N
        btn_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_offActionPerformed(evt);
            }
        });
        jPanel4.add(btn_off, new org.netbeans.lib.awtextra.AbsoluteConstraints(771, 240, 300, 110));

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

    private void btn_onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_onActionPerformed
        kondisinya_on();
    }//GEN-LAST:event_btn_onActionPerformed

    private void btn_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_offActionPerformed
        kondisinya_off();
        btn_home.setVisible(true);
    }//GEN-LAST:event_btn_offActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new kondisi_pkt().setVisible(false);
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
            java.util.logging.Logger.getLogger(kondisi_pkt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kondisi_pkt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kondisi_pkt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kondisi_pkt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kondisi_pkt().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.tombol_besar btn_home;
    private usu.widget.glass.ButtonImageReflection btn_off;
    private usu.widget.glass.ButtonImageReflection btn_on;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_paket;
    private javax.swing.JLabel txt_paket;
    // End of variables declaration//GEN-END:variables
}
