package tata_usaha.manajemen_jab_guru;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class imple_kelas implements inter_kelas{
    
    public entity_kelas insert(entity_kelas o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into kelas values(?,?)");
        st.setInt(1, o.getidKelas());
        st.setString(2, o.getnamaKelas());
        st.executeUpdate();
        return o;
    }

    public void delete(int idKelas) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from kelas where id_kelas=?");
        st.setInt(1, idKelas);
        st.executeUpdate();
    }

    public List<entity_kelas> getAll() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from kelas");
        List<entity_kelas>list=new ArrayList<entity_kelas>();
        while(rs.next()){
            entity_kelas thn=new entity_kelas();
            thn.setidKelas(rs.getInt("id_kelas"));
            thn.setnamaKelas(rs.getString("nama_kelas"));
            list.add(thn);
        }
        return list;
    }
    
    
}
