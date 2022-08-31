package tata_usaha.manajemen_siswa;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class imple_thnajar implements inter_thnajar{
    
    public entity_thnajar insert(entity_thnajar o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into thn_ajar values(?,?)");
        st.setInt(1, o.getidtahun_ajaran());
        st.setString(2, o.getnmtahun_ajaran());
        st.executeUpdate();
        return o;
    }

    public void update(entity_thnajar o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("update thn_ajar set nm_thnajar=? where id_thnajar=?");
        st.setString(1, o.getnmtahun_ajaran());
        st.setInt(2, o.getidtahun_ajaran());
        st.executeUpdate();
    }

    public void delete(int id_thnajar) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from thn_ajar where id_thnajar=?");
        st.setInt(1, id_thnajar);
        st.executeUpdate();
    }

    public List<entity_thnajar> getAll() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from thn_ajar");
        List<entity_thnajar>list=new ArrayList<entity_thnajar>();
        while(rs.next()){
            entity_thnajar thn=new entity_thnajar();
            thn.setidtahun_ajaran(rs.getInt("id_thnajar"));
            thn.setnmtahun_ajaran(rs.getString("nm_thnajar"));
            list.add(thn);
        }
        return list;
    }
}
