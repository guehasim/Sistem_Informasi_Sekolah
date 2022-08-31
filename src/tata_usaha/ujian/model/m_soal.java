package tata_usaha.ujian.model;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tata_usaha.ujian.controller.soal;
import tata_usaha.ujian.view.entity_ujian;


public class m_soal implements soal{

    @Override
    public entity_ujian insert_soal(entity_ujian p) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into soal values(?,?,?,?)");
        st.setString(1, p.getkd_paket());
        st.setInt(2, p.getkd_soal());
        st.setString(3, p.getsoal());
        st.setInt(4, p.getkunci());
        st.executeUpdate();
        return p;
    }

    @Override
    public entity_ujian insert_jawab(entity_ujian q) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into pilih_jawab values(?,?,?,?)");
        st.setString(1, q.getkd_paket());
        st.setInt(2, q.getkd_soal());
        st.setInt(3, q.getpilih());
        st.setString(4, q.getjawab());
        st.executeUpdate();
        return q;
    }

    @Override
    public void delete_soal(int id_soal) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from soal where kd_soal=?");
        st.setInt(1, id_soal);
        st.executeUpdate();
    }

    @Override
    public List<entity_ujian> getAll_soal() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from soal");
        List<entity_ujian>list=new ArrayList<entity_ujian>();
        while(rs.next()){
            entity_ujian thn=new entity_ujian();
            thn.setkd_paket(rs.getString("kd_paket"));
            thn.setkd_soal(rs.getInt("kd_soal"));
            thn.setsoal(rs.getString("soal"));
            thn.setkunci(rs.getInt("kunci"));
            list.add(thn);
        }
        return list;
    }

    @Override
    public void delete_jawab(int id_soal) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from pilih_jawab where kd_soal=?");
        st.setInt(1, id_soal);
        st.executeUpdate();
    }

    @Override
    public void insert_duplikat(String kd_pk) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert tampung_soal select * from soal where kd_paket=?");
        st.setString(1, kd_pk);
        st.executeUpdate();
    }

    @Override
    public void delete_all_soal(String kd_pk) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from soal where kd_paket=?");
        st.setString(1, kd_pk);
        st.executeUpdate();
    }
}
