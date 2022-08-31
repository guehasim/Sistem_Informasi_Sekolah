package tata_usaha.manajemen_matpel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import file_koneksi.koneksi;


public class imple_matpel implements inter_matpel{

    @Override
    public entity_matpel insert(entity_matpel o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into matpel values(?,?,?)");
        st.setString(1, o.getkode_matpel());
        st.setString(2, o.getnama_matpel());
        st.setString(3, o.getkelas_matpel());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(entity_matpel o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("update matpel set nama_matpel=?, kelas=? where kode_matpel=?");
        st.setString(1, o.getnama_matpel());
        st.setString(2, o.getkelas_matpel());
        st.setString(3, o.getkode_matpel());
        st.executeUpdate();
    }

    @Override
    public void delete(String kode_matpel) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from matpel where kode_matpel=?");
        st.setString(1, kode_matpel);
        st.executeUpdate();
    }

    @Override
    public List<entity_matpel> getAll() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from matpel");
        List<entity_matpel>list=new ArrayList<entity_matpel>();
        while(rs.next()){
            entity_matpel thn=new entity_matpel();
            
            thn.setkode_matpel(rs.getString("kode_matpel"));
            thn.setnama_matpel(rs.getString("nama_matpel"));
            thn.setkelas_matpel(rs.getString("kelas"));
            list.add(thn);
        }
        return list;
    }
    }
