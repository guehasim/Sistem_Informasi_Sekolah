package tata_usaha.manajemen_guru;

import file_koneksi.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AHMAD HASIM
 */
public class imple_guru implements inter_guru{

    @Override
    public entity_guru insert(entity_guru o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into guru values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        st.setString(1, o.getnip());
        st.setString(2, o.getnama());
        st.setString(3, o.gettempat());
        st.setString(4, o.gettgllahir());
        st.setString(5, o.getjenkel());
        st.setString(6, o.getagama());
        st.setString(7, o.getgolongdar());
        st.setString(8, o.getpendidikan());
        st.setString(9, o.getnama_ortu());
        st.setString(10, o.getalamat());
        st.setString(11, o.getdesa());
        st.setString(12, o.getkecamatan());
        st.setString(13, o.getkota());
        st.setString(14, o.getpropinsi());
        st.setString(15, o.getfoto());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(entity_guru o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("update guru set nama=?, tempat=?, tgllahir=?, jenkel=?, agama=?, goldarah=?, pendidikan=?, nama_ortu=?, alamat=?, desa=?, kec=?,"
                + " kota=?, propinsi=?, foto=? where nip=?");
        st.setString(1, o.getnama());
        st.setString(2, o.gettempat());
        st.setString(3, o.gettgllahir());
        st.setString(4, o.getjenkel());
        st.setString(5, o.getagama());
        st.setString(6, o.getgolongdar());
        st.setString(7, o.getpendidikan());
        st.setString(8, o.getnama_ortu());
        st.setString(9, o.getalamat());
        st.setString(10, o.getdesa());
        st.setString(11, o.getkecamatan());
        st.setString(12, o.getkota());
        st.setString(13, o.getpropinsi());
        st.setString(14, o.getfoto());
        st.setString(15, o.getnip());
        st.executeUpdate();
    }

    @Override
    public void delete(String nip) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from guru where nip=?");
        st.setString(1, nip);
        st.executeUpdate();
    }

    @Override
    public List<entity_guru> getAll() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from guru");
        List<entity_guru>list=new ArrayList<entity_guru>();
        while(rs.next()){
            entity_guru thn=new entity_guru();
            thn.setnip(rs.getString("nip"));
            thn.setnama(rs.getString("nama"));
            thn.settempat(rs.getString("tempat"));
            thn.settgllahir(rs.getString("tgllahir"));
            thn.setjenkel(rs.getString("jenkel"));
            thn.setagama(rs.getString("agama"));
            thn.setgolongdar(rs.getString("goldarah"));
            thn.setpendidikan(rs.getString("pendidikan"));
            thn.setnama_ortu(rs.getString("nama_ortu"));
            thn.setalamat(rs.getString("alamat"));
            thn.setdesa(rs.getString("desa"));
            thn.setkecamatan(rs.getString("kec"));
            thn.setkota(rs.getString("kota"));
            thn.setpropinsi(rs.getString("propinsi"));
            thn.setfoto(rs.getString("foto"));
            list.add(thn);
        }
        return list;
    }
    
}
