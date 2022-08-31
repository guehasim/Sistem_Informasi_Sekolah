package tata_usaha.ujian.model;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tata_usaha.ujian.controller.uji;
import tata_usaha.ujian.view.entity_ujian;

public class m_uji implements uji{

    @Override
    public entity_ujian insert_jawab_uji(entity_ujian p) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into hasil_jawab values(?,?,?,?,?,?)");
        st.setString(1, p.getnis());
        st.setString(2, p.getkd_paket());
        st.setInt(3, p.getkd_soal());
        st.setInt(4, p.getkunci());
        st.setInt(5, p.getpilih());
        st.setInt(6, p.gethasil());
        st.executeUpdate();
        return p;
    }

    @Override
    public void update(entity_ujian o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("update hasil_jawab set hasil=? where nis=? and kd_paket=? and kd_soal=?");
        st.setInt(1, o.gethasil());
        st.setString(2, o.getnis());
        st.setString(3, o.getkd_paket());
        st.setInt(4, o.getkd_soal());
        st.executeUpdate();
    }

    
}
