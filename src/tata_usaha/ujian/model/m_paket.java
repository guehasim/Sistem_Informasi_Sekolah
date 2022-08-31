package tata_usaha.ujian.model;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tata_usaha.ujian.controller.paket;
import tata_usaha.ujian.view.entity_ujian;


public class m_paket implements paket{

    @Override
    public entity_ujian insert_pkt(entity_ujian o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into paket_soal values(?,?,?,?,?,?,?)");
        st.setString(1, o.getkd_paket());
        st.setInt(2, o.getkelas());
        st.setString(3, o.getmatpel());
        st.setString(4, o.gettgl());
        st.setInt(5, o.getjml_soal());
        st.setInt(6, o.getbobot_nilai());
        st.setString(7, o.getkondis());
        st.executeUpdate();
        return o;
    }

    @Override
    public void delete_pkt(String id_pkt) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from paket_soal where kd_paket=?");
        st.setString(1, id_pkt);
        st.executeUpdate();
    }

    @Override
    public List<entity_ujian> getAll_pkt() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from paket_soal");
        List<entity_ujian>list=new ArrayList<entity_ujian>();
        while(rs.next()){
            entity_ujian thn=new entity_ujian();
            thn.setkd_paket(rs.getString("kd_paket"));
            thn.setkelas(rs.getInt("kelas"));
            thn.setmatpel(rs.getString("matpel"));
            thn.settgl(rs.getString("tanggal"));
            thn.setjml_soal(rs.getInt("jml_soal"));
            thn.setkondis(rs.getString("kondisi"));
            list.add(thn);
        }
        return list;
    }

    @Override
    public void delete_sl(String id_pkt) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from tampung_soal where kd_paket=?");
        st.setString(1, id_pkt);
        st.executeUpdate();
    }

    @Override
    public void delete_jwb(String id_pkt) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from pilih_jawab where kd_paket=?");
        st.setString(1, id_pkt);
        st.executeUpdate();
    }

    @Override
    public void update(entity_ujian o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("update paket_soal set kondisi=? where kd_paket=?");
        st.setString(1, o.getkondis());
        st.setString(2, o.getkd_paket());
        st.executeUpdate();
    }
    
}
