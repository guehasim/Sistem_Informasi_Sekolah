package tata_usaha.manajemen_nilai;

import file_koneksi.koneksi;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import tata_usaha.awal.home;
import tata_usaha.manajemen_nilai.nilai;
import tata_usaha.manajemen_siswa.entity_siswa;
import tata_usaha.manajemen_siswa.imple_siswa;
import tata_usaha.manajemen_siswa.inter_siswa;

public class nilai extends javax.swing.JFrame {

    
    List<entity_nilai> record=new ArrayList<entity_nilai>();
    List<entity_siswa> rekam=new ArrayList<entity_siswa>();
    
    inter_nilai nilainya;
    inter_siswa siswanya;
    
    int row;
    
    public nilai() {
        initComponents();
       
        dropdown_matpel();
  
        nilainya = new imple_nilai();
        
            tabel_nilai.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent p) {
                row=tabel_nilai.getSelectedRow();
                if(row!=-1){
                    isiText_nilai();
                }
            }
        });
            
            this.statusAwal_nilai();
        
        
       siswanya = new imple_siswa();
            tabel_siswa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {
                    row=tabel_siswa.getSelectedRow();
                    if(row!=-1){
                        isiText();
                    }
                }
            });
            
            this.statusAwal();
    }
    
    //tabel NILAI ===================================================================
    void loadData_nilai(){
        try {
            record = nilainya.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(nilai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void isiTabel_nilai(){
        Object data[][]=new Object[record.size()][7];
        int x=0;
        for(entity_nilai thn:record){
            data[x][0]=thn.gettahun_ajaran();
            data[x][1]=thn.getsemester();
            data[x][2]=thn.getkelas();
            data[x][3]=thn.getsiswa();
            data[x][4]=thn.getnama();
            data[x][5]=thn.getpelajaran();
            data[x][6]=thn.getnilai();
            x++;
        }
        String judul[]={"Tahun Ajaran","Semester","Kelas","Nis","Nama","Pelajaran","Nilai"}; 
        
        tabel_nilai.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tabel_nilai);
    }
    
    void isiText_nilai(){
        entity_nilai thn=record.get(row);
//        
        txt_nis_delete.setText(thn.getsiswa());
//        txt_semester.setText(thn.getsemester());
//        txt_kelas.setText(thn.getkelas());
//        txt_nis.setText(thn.getsiswa());
//        txt_nama.setText(thn.getnama());
//        txt_matpel.setSelectedItem(thn.getpelajaran());
//        txt_nilai.setText(thn.getnilai());
    }
    
    void kosongkanText_nilai(){
        txt_semester.setText("");
        txt_thn_ajar.setText("");
        txt_nis.setText("");
        txt_nama.setText("");
        txt_kelas.setText("");
        txt_nilai.setText("");
    }
    
    void statusAwal_nilai(){
        kosongkanText_nilai();
        loadData_nilai();
        isiTabel_nilai();
    }
    
    //tabel siswa=============================================================
    void loadData(){
        try {
            rekam = siswanya.getAll_data();
        } catch (SQLException ex) {
            Logger.getLogger(nilai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    void isiTabel(){
        Object data[][]=new Object[rekam.size()][5];
        int x=0;
        for(entity_siswa thn:rekam){
            data[x][0]=thn.getthn_ajar();
            data[x][1]=thn.getsemester();
            data[x][2]=thn.getdi_kelas();
            data[x][3]=thn.getnis();
            data[x][4]=thn.getnama();
            x++;
        }
        String judul[]={"Tahun Ajaran","Semester","Kelas","Nis","Nama"}; 
        
        tabel_siswa.setModel(new DefaultTableModel(data, judul));
        jScrollPane2.setViewportView(tabel_siswa);
    }
    
    void isiText(){
        entity_siswa thn=rekam.get(row);
        
        txt_thn_ajar.setText(thn.getthn_ajar());
        txt_semester.setText(thn.getsemester());
        txt_kelas.setText(thn.getdi_kelas());
        txt_nis.setText(thn.getnis());
        txt_nama.setText(thn.getnama());        
    }
    
    void kosongkanText(){
        txt_semester.setText("");
        txt_thn_ajar.setText("");
        txt_nis.setText("");
        txt_nama.setText("");
        txt_kelas.setText("");
    }
    
     private void dropdown_matpel() {
              try{
            
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from matpel");
        while(rs.next()){
            String pelajar = rs.getString("nama_matpel");
            txt_matpel.addItem(pelajar);
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
        btn_home2 = new komponen.tombol_besar();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_nilai = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_matpel = new javax.swing.JComboBox();
        txt_thn_ajar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_1 = new javax.swing.JTextField();
        txt_2 = new javax.swing.JTextField();
        txt_3 = new javax.swing.JTextField();
        txt_4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_5 = new javax.swing.JTextField();
        j_4 = new javax.swing.JSpinner();
        j_2 = new javax.swing.JSpinner();
        j_1 = new javax.swing.JSpinner();
        j_3 = new javax.swing.JSpinner();
        btn_delete = new usu.widget.ButtonGlass();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_nis = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JLabel();
        txt_semester = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_siswa = new javax.swing.JTable();
        txt_cari_nis = new javax.swing.JTextField();
        btn_total = new javax.swing.JButton();
        j_5 = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JLabel();
        txt_nilai = new javax.swing.JLabel();
        btn_save = new usu.widget.ButtonGlass();
        txt_nis_delete = new javax.swing.JLabel();
        txt_cari_nis1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_cari_nilai = new komponen.tombol_besar();
        btn_cari_siswa = new komponen.tombol_besar();
        btn_cetak = new usu.widget.ButtonGlass();

        buttonGlass1.setText("buttonGlass1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        btn_home2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        btn_home2.setText("Home");
        btn_home2.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        btn_home2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_home2ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_home2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, -1, 130));

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

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 530, 350));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pelajaran");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Keaktifan");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Semester");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, 30));

        txt_matpel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(txt_matpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 250, 30));

        txt_thn_ajar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_thn_ajar.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_thn_ajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 250, 30));

        jLabel8.setFont(new java.awt.Font("Tekton Pro", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*Manajemen Nilai");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ulangan");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("UTS");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("UAS");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nilai");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, -1, 30));

        txt_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_1.setText("0");
        jPanel4.add(txt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 40, 30));

        txt_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_2.setText("0");
        jPanel4.add(txt_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 40, 30));

        txt_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_3.setText("0");
        txt_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_3ActionPerformed(evt);
            }
        });
        jPanel4.add(txt_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 40, 30));

        txt_4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_4.setText("0");
        txt_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_4ActionPerformed(evt);
            }
        });
        jPanel4.add(txt_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 40, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tahun Ajaran");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Absen");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, -1));

        txt_5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_5.setText("0");
        jPanel4.add(txt_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 40, 30));

        j_4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));
        jPanel4.add(j_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, 50, 30));

        j_2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));
        jPanel4.add(j_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 50, 30));

        j_1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), null, Integer.valueOf(40), Integer.valueOf(1)));
        jPanel4.add(j_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 50, 30));

        j_3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));
        jPanel4.add(j_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 50, 30));

        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_delete.setText("Hapus");
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel4.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 500, 150, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Kelas");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nama");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, 30));

        txt_nis.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nis.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 250, 30));

        txt_kelas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_kelas.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 250, 30));

        txt_semester.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_semester.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 250, 30));

        tabel_siswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabel_siswa);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 130, 340, 430));

        txt_cari_nis.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jPanel4.add(txt_cari_nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 240, 30));

        btn_total.setText("Total");
        btn_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_totalActionPerformed(evt);
            }
        });
        jPanel4.add(btn_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 100, -1));

        j_5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));
        jPanel4.add(j_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 50, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("NIS");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, -1, 30));

        txt_nama.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nama.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 250, 30));

        txt_nilai.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        txt_nilai.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 90, 80));

        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_save.setText("Simpan");
        btn_save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel4.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 150, 40));

        txt_nis_delete.setForeground(new java.awt.Color(0, 0, 153));
        jPanel4.add(txt_nis_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 510, -1, -1));

        txt_cari_nis1.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jPanel4.add(txt_cari_nis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 240, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("NIS");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("NIS");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        btn_cari_nilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_cari_nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_nilaiActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cari_nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, 40, 50));

        btn_cari_siswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_cari_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_siswaActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cari_siswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 40, 50));

        btn_cetak.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print.png"))); // NOI18N
        btn_cetak.setText("Cetak");
        btn_cetak.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 500, 150, 40));

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

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new nilai().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void txt_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_3ActionPerformed

    private void txt_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_4ActionPerformed

    private void btn_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_totalActionPerformed
        //mengubah dari nilai string ke int
        String a = txt_1.getText();
        int aa = Integer.parseInt(a);
        String b = txt_2.getText();
        int bb= Integer.parseInt(b);
        String c = txt_3.getText();
        int cc = Integer.parseInt(c);
        String d = txt_4.getText();
        int dd = Integer.parseInt(d);
        String e = txt_5.getText();
        int ee = Integer.parseInt(e);
        
        //mengubah dari j_spiner string ke int
        String z = j_5.getValue().toString();
        int zz = Integer.parseInt(z);
        String y = j_1.getValue().toString();
        int yy = Integer.parseInt(y);
        String x = j_2.getValue().toString();
        int xx = Integer.parseInt(x);
        String w = j_3.getValue().toString();
        int ww = Integer.parseInt(w);
        String v = j_4.getValue().toString();
        int vv = Integer.parseInt(v);
        
        //nilai dari persen
        int per = 100;
        
        //memberi prosentasi
        int aaa = aa*zz/per;
        int bbb = bb*yy/per;
        int ccc = cc*xx/per;
        int ddd = dd*ww/per;
        int eee = ee*vv/per;
        
        //pembagian semua hasil
        //int re = 5;
        //jumlah dari semua nilai
        int hasil = aaa+bbb+ccc+ddd+eee;
       // int hasil = abc/re;
        txt_nilai.setText(""+hasil);
    }//GEN-LAST:event_btn_totalActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try{
           entity_nilai a = record.get(row);
           entity_nilai en =new entity_nilai();
           en.setsiswa(txt_nis_delete.getText());
           a.getid_nilai();
           int s= a.getid_nilai();
           JOptionPane.showMessageDialog(this, "data berhasil dihapus");
           nilainya.delete(s);
           this.statusAwal_nilai();
            
       } catch(Exception ex){
           Logger.getLogger(nilai.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try {
            
            entity_nilai thn = new entity_nilai();
            thn.settahun_ajaran(txt_thn_ajar.getText());
            thn.setsemester(txt_semester.getText());
            thn.setkelas(txt_kelas.getText());
            thn.setsiswa(txt_nis.getText());
            thn.setnama(txt_nama.getText());
            thn.setpelajaran(txt_matpel.getSelectedItem().toString());
            thn.setnilai(txt_nilai.getText());
            
            nilainya.insert(thn);
            JOptionPane.showMessageDialog(this, "data tersimpan");
            this.statusAwal_nilai();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "data gagal untuk di simpan");
            Logger.getLogger(nilai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_cari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari1ActionPerformed
        
    }//GEN-LAST:event_btn_cari1ActionPerformed

    private void btn_cari_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_siswaActionPerformed
        String header[]={"Tahun Ajaran","Semester","Kelas","Nis","Nama"};
        DefaultTableModel dt = new DefaultTableModel(null, header);
        tabel_siswa.setModel(dt);
        
        for(int i=0; i<tabel_siswa.getRowCount();i++){
            dt.removeRow(i);
        }
        
        try{
             
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from aktif_siswa where nis "
                    + "like '%"+txt_cari_nis.getText()+"%' ");
            
            while (rs.next()){
                String thn_ajar = rs.getString(1);
                String semester = rs.getString(2);
                String kelas = rs.getString(3);
                String nis = rs.getString(4);
                String nama = rs.getString(5);
                
                Object baris[] = {thn_ajar, semester, kelas, nis, nama};
                dt.addRow(baris);
                
            }
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btn_cari_siswaActionPerformed

    private void btn_cari_nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_nilaiActionPerformed
        String header[]={"No","Tahun Ajaran","Semester","Kelas",
            "NIS","Nama","Pelajaran","Nilai"};
        DefaultTableModel dt = new DefaultTableModel(null, header);
        tabel_nilai.setModel(dt);
        
        for(int i=0; i<tabel_nilai.getRowCount();i++){
            dt.removeRow(i);
        }
        
        try{
             
            Statement st=koneksi.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from nilai where nis_siswa "
                    + "like '%"+txt_cari_nis1.getText()+"%' ");
            
            while (rs.next()){
//                String id = rs.getString(1);
                String id = rs.getString(1);
                String tahun = rs.getString(2);
                String semester = rs.getString(3);
                String kelas = rs.getString(4);
                String nis = rs.getString(5);
                String nama = rs.getString(6);
                String matpel = rs.getString(7);
                String nilai = rs.getString(8);
                
                Object baris[] = {id, tahun,semester, kelas, nis, nama, matpel, nilai};
                dt.addRow(baris);
                
            }
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btn_cari_nilaiActionPerformed

    private void btn_home2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_home2ActionPerformed
       new nilai().setVisible(false);
        dispose();
        new home().setVisible(true);
    }//GEN-LAST:event_btn_home2ActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        try{
            Statement st=koneksi.getConnection().createStatement();
            
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("D:/Data Nilai.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("Tahun Ajaran");
            row1.createCell(1).setCellValue("Semester");
            row1.createCell(2).setCellValue("Kelas");
            row1.createCell(3).setCellValue("Nis");
            row1.createCell(4).setCellValue("Nama");
            row1.createCell(5).setCellValue("Mata Pelajaran");
            row1.createCell(6).setCellValue("Nilai");
            Row row2;           
            
            ResultSet rs=st.executeQuery("select tahun_ajaran,semester,kelas,nis_siswa,"
                    + "nama,pilih_matpel,nilai from nilai");
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                row2.createCell(5).setCellValue(rs.getString(6));
                row2.createCell(6).setCellValue(rs.getString(7));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            st.close();
            koneksi.getConnection().close();
            JOptionPane.showMessageDialog(null, "Data Sukses Disimpan di Local Disk D:");
        }catch(  SQLException | IOException e){
       JOptionPane.showMessageDialog(null, "Terjadi Kesalahan dan Data Tidak Disimpan");
    }
    }//GEN-LAST:event_btn_cetakActionPerformed

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
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.tombol_besar btn_cari_nilai;
    private komponen.tombol_besar btn_cari_siswa;
    private usu.widget.ButtonGlass btn_cetak;
    private usu.widget.ButtonGlass btn_delete;
    private komponen.tombol_besar btn_home2;
    private usu.widget.ButtonGlass btn_save;
    private javax.swing.JButton btn_total;
    private usu.widget.ButtonGlass buttonGlass1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner j_1;
    private javax.swing.JSpinner j_2;
    private javax.swing.JSpinner j_3;
    private javax.swing.JSpinner j_4;
    private javax.swing.JSpinner j_5;
    private javax.swing.JTable tabel_nilai;
    private javax.swing.JTable tabel_siswa;
    private javax.swing.JTextField txt_1;
    private javax.swing.JTextField txt_2;
    private javax.swing.JTextField txt_3;
    private javax.swing.JTextField txt_4;
    private javax.swing.JTextField txt_5;
    private javax.swing.JTextField txt_cari_nis;
    private javax.swing.JTextField txt_cari_nis1;
    private javax.swing.JLabel txt_kelas;
    private javax.swing.JComboBox txt_matpel;
    private javax.swing.JLabel txt_nama;
    private javax.swing.JLabel txt_nilai;
    private javax.swing.JLabel txt_nis;
    private javax.swing.JLabel txt_nis_delete;
    private javax.swing.JLabel txt_semester;
    private javax.swing.JLabel txt_thn_ajar;
    // End of variables declaration//GEN-END:variables
}
