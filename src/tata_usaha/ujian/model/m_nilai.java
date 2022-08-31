package tata_usaha.ujian.model;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tata_usaha.ujian.controller.nilai;
import tata_usaha.ujian.view.entity_ujian;

public class m_nilai implements nilai{

    @Override
    public entity_ujian insert_peserta(entity_ujian o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into peserta_ujian values(?,?)");
        st.setString(1, o.getnis());
        st.setString(2, o.getnama());
        st.executeUpdate();
        return o;
    }

    @Override
    public entity_ujian insert_nilai(entity_ujian p) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into peserta_ujian values(?,?,?)");
        st.setString(1, p.getnis());
        st.setString(2, p.getnama());
        st.setInt(3, p.getnilai());
        st.executeUpdate();
        return p;
    }

    @Override
    public List<entity_ujian> getAll_siswa() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from peserta_ujian");
        List<entity_ujian>list=new ArrayList<entity_ujian>();
        while(rs.next()){
            entity_ujian thn=new entity_ujian();
            thn.setnis(rs.getString("nis"));
            thn.setnama(rs.getString("nama"));
            list.add(thn);
        }
        return list;
    }

    @Override
    public entity_ujian insert_nilai_ujian(entity_ujian q) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into nilai_ujian values(?,?,?,?,?,?)");
        st.setString(1, q.getnis());
        st.setString(2, q.getnama());
        st.setInt(3, q.getkelas());
        st.setString(4, q.getmatpel());
        st.setString(5, q.getkd_paket());
        st.setInt(6, q.getnilai());
        st.executeUpdate();
        return q;
    }
    
}
