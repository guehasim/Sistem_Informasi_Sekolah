package tata_usaha.ujian.view;

import file_koneksi.koneksi;
import java.awt.event.KeyEvent;
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
import tata_usaha.ujian.controller.nilai;
import tata_usaha.ujian.controller.paket;
import tata_usaha.ujian.model.m_nilai;
import tata_usaha.ujian.model.m_paket;

public class ambil_nilai extends javax.swing.JFrame {

    List<entity_ujian> record=new ArrayList<entity_ujian>();
    paket paketnya;
    nilai nilainya;
    
    int row;
    
    public ambil_nilai() {
        initComponents();
        
        paketnya = new m_paket();
        nilainya = new m_nilai();
        
        this.tab_paket();
    }
    
    void siswa(){
        try{            
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from peserta_ujian where nis='"+txt_nis.getText()+"' ");
            while(rs.next()){
                String nama = rs.getString("nama");
                
                txt_nama.setText(nama);
                }
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Data Peserta Tidak Ada");
            }
    }
    
    //data paket=======================================
    void tab_paket(){
            tabel_paket.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_paket.getSelectedRow();
                    if(row!=-1){
                        isiText_paket();
                    }
                }
            });
            this.statusAwal();
    }
    
       
    void loadData_paket(){
        try {
            record = paketnya.getAll_pkt();
        } catch (SQLException ex) {
            Logger.getLogger(ambil_nilai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel_paket(){
        Object data[][]=new Object[record.size()][3];
        int x=0;
        for(entity_ujian thn:record){
            data[x][0]=thn.getkd_paket();
            data[x][1]=thn.getmatpel();
            data[x][2]=thn.getkelas();
            x++;
        }
        String judul[]={"Kode Paket","Mata Pelajaran","Kelas"}; 
        
        tabel_paket.setModel(new DefaultTableModel(data, judul));
        jScrollPane2.setViewportView(tabel_paket);
    }
    
    void isiText_paket(){
        entity_ujian thn=record.get(row);
        
        int a = thn.getkelas();
        txt_kelas.setText(""+a);
        txt_matpel.setText(thn.getmatpel());
        txt_paket.setText(thn.getkd_paket());
    }
    
    void kosong_data(){
        txt_nis.setText("");
        txt_nama.setText("");
        txt_nilai.setText("");
    }
    
    void statusAwal(){
        loadData_paket();
        isiTabel_paket();
    }
    
    void total_nilai(){
        String a = txt_nis.getText();
        String b = txt_paket.getText();
        
        int bobot = 0;
        int nilai = 0;
        
        try{
            
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from siswa where nis='"+a+"' ");
            while(rs.next()){
                String name = rs.getString("nama");
                txt_nama.setText(name);
                                
            }
            }catch(Exception e){
            }
        
        try{
            
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from paket_soal where kd_paket='"+b+"' ");
            while(rs.next()){
                bobot = rs.getInt("bobot_nilai");
                                
            }
            }catch(Exception e){
            }
        
        try{
            
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select sum(hasil) as total from hasil_jawab where nis='"+a+"' and kd_paket='"+b+"' ");
            while(rs.next()){
                nilai = rs.getInt("total");
                                
            }
            }catch(Exception e){
            }
        
        int c = bobot*nilai;
        txt_nilai.setText(""+c);
        
    }
    
    void simpan_nilai(){
        try {
            entity_ujian ko = new entity_ujian();
            
            if(txt_nis.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "NIS Tidak Boleh Kosong !","Kesalahan",JOptionPane.ERROR_MESSAGE);
                txt_nis.requestFocus();
            }
            else if(txt_paket.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Pilih Paket Terlebih Dahulu !","Kesalahan",JOptionPane.ERROR_MESSAGE);
            }
            else{
                ko.setnis(txt_nis.getText());
                ko.setnama(txt_nama.getText());
                    String a = txt_kelas.getText();
                    int b = Integer.parseInt(a);
                ko.setkelas(b);
                ko.setmatpel(txt_matpel.getText());
                ko.setkd_paket(txt_paket.getText());
                    String c = txt_nilai.getText();
                    int d = Integer.parseInt(c);
                ko.setnilai(d);
                nilainya.insert_nilai_ujian(ko);                
                this.kosong_data();
                JOptionPane.showMessageDialog(this, "Nilai Sudah Disimpan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nilai Tidak Bisa DiSimpan");
            Logger.getLogger(ambil_nilai.class.getName()).log(Level.SEVERE, null, e);
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
        txt_nis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JLabel();
        txt_nilai = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_save = new usu.widget.ButtonGlass();
        jLabel11 = new javax.swing.JLabel();
        txt_paket = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_paket = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txt_matpel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_cari_paket = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

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

        txt_nis.setBackground(new java.awt.Color(255, 255, 102));
        txt_nis.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nis.setForeground(new java.awt.Color(255, 0, 0));
        txt_nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nisKeyPressed(evt);
            }
        });
        jPanel4.add(txt_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 200, 35));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIS");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 80, 35));

        txt_nama.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 102));
        jPanel4.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, 35));

        txt_nilai.setFont(new java.awt.Font("Times New Roman", 1, 100)); // NOI18N
        txt_nilai.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(txt_nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kode Paket");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, 35));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nilai");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 80, 35));

        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_save.setText("Simpan");
        btn_save.setFont(new java.awt.Font("Tekton Pro", 1, 30)); // NOI18N
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel4.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, -1, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nama");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 80, 35));

        txt_paket.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        txt_paket.setForeground(new java.awt.Color(255, 255, 102));
        jPanel4.add(txt_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, 35));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Kelas");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, 35));

        txt_kelas.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        txt_kelas.setForeground(new java.awt.Color(255, 255, 102));
        jPanel4.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, 35));

        tabel_paket.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
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
        jScrollPane2.setViewportView(tabel_paket);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 490, 460));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mata Pelajaran");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, 35));

        txt_matpel.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        txt_matpel.setForeground(new java.awt.Color(255, 255, 102));
        jPanel4.add(txt_matpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, 35));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("* Tekan Enter");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, -1));

        txt_cari_paket.setBackground(new java.awt.Color(255, 255, 102));
        txt_cari_paket.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_cari_paket.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(txt_cari_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 180, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*tekan enter");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

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

    private void txt_nisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nisKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            total_nilai();
        }
    }//GEN-LAST:event_txt_nisKeyPressed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        simpan_nilai();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new ambil_nilai().setVisible(false);
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
            java.util.logging.Logger.getLogger(ambil_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ambil_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ambil_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ambil_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ambil_nilai().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.tombol_besar btn_home;
    private usu.widget.ButtonGlass btn_save;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_paket;
    private javax.swing.JTextField txt_cari_paket;
    private javax.swing.JLabel txt_kelas;
    private javax.swing.JLabel txt_matpel;
    private javax.swing.JLabel txt_nama;
    private javax.swing.JLabel txt_nilai;
    private javax.swing.JTextField txt_nis;
    private javax.swing.JLabel txt_paket;
    // End of variables declaration//GEN-END:variables
}
