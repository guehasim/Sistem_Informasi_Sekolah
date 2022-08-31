package tata_usaha.jadwal;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class imple_jadwal implements inter_jadwal{

    @Override
    public entity_jadwal insert(entity_jadwal o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into jadwal values(?,?,?,?,?,?,?,?,?,?)");
        st.setInt(1, o.getid_jad());
        st.setString(2, o.getjam());
        st.setString(3, o.getsenin());
        st.setString(4, o.getselasa());
        st.setString(5, o.getrabu());
        st.setString(6, o.getkamis());
        st.setString(7, o.getjumat());
        st.setString(8, o.getsabtu());
        st.setInt(9, o.getkelas());
        st.setString(10, o.getwalkes());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(entity_jadwal o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("update jadwal set jam=?, senin=?, selasa=?, rabu=?, kamis=?, jumat=?,"
                + "sabtu=?, kelas=?, wali_kelas=? where id_jad=?");
        st.setString(1, o.getjam());
        st.setString(2, o.getsenin());
        st.setString(3, o.getselasa());
        st.setString(4, o.getrabu());
        st.setString(5, o.getkamis());
        st.setString(6, o.getjumat());
        st.setString(7, o.getsabtu());
        st.setInt(8, o.getkelas());
        st.setString(9, o.getwalkes());
        st.setInt(10, o.getid_jad());
        st.executeUpdate();
    }

    @Override
    public void delete(int id_jad) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from jadwal where id_jad=?");
        st.setInt(1, id_jad);
        st.executeUpdate();
    }

    @Override
    public List<entity_jadwal> getAll() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from jadwal");
        List<entity_jadwal>list=new ArrayList<entity_jadwal>();
        while(rs.next()){
            entity_jadwal thn=new entity_jadwal();
            
            thn.setid_jad(rs.getInt("id_jad"));
            thn.setjam(rs.getString("jam"));
            thn.setsenin(rs.getString("senin"));
            thn.setselasa(rs.getString("selasa"));
            thn.setrabu(rs.getString("rabu"));
            thn.setkamis(rs.getString("kamis"));
            thn.setjumat(rs.getString("jumat"));
            thn.setsabtu(rs.getString("sabtu"));
            thn.setkelas(rs.getInt("kelas"));
            thn.setwalkes(rs.getString("wali_kelas"));
            list.add(thn);
        }
        return list;
    }
    
}
