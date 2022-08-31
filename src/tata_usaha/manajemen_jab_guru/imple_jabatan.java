package tata_usaha.manajemen_jab_guru;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import file_koneksi.koneksi;


public class imple_jabatan implements inter_jabatan{

    @Override
    public entity_walkes insert(entity_walkes o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into jabatan values(?,?,?,?,?,?)");
        st.setInt(1, o.getid());
        st.setString(2, o.getnip());
        st.setString(3, o.getnama());
        st.setString(4, o.getjabat());
        st.setString(5, o.getkelas());
        st.setString(6, o.getpass());
        st.executeUpdate();
        return o;
    }

    @Override
    public void delete(int id) throws SQLException {
       PreparedStatement st=koneksi.getConnection().prepareStatement("delete from jabatan where id_jab=?");
       st.setInt(1, id);
       st.executeUpdate();
    }

    @Override
    public List<entity_walkes> getAll() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jabatan");
        List<entity_walkes>list=new ArrayList<entity_walkes>();
        while(rs.next()){
            entity_walkes thn=new entity_walkes();
            thn.setid(rs.getInt("id_jab"));
            thn.setnip(rs.getString("nip_jab"));
            thn.setnama(rs.getString("nm_jab"));
            thn.setjabat(rs.getString("jab"));
            thn.setkelas(rs.getString("kel_jab"));
            thn.setpass(rs.getString("pass_jab"));
            
            list.add(thn);
        }
        return list;
    }
    }
