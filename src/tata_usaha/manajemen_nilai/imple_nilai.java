package tata_usaha.manajemen_nilai;

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
public class imple_nilai implements inter_nilai{

    @Override
    public entity_nilai insert(entity_nilai o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("insert into nilai values(?,?,?,?,?,?,?,?)");
        st.setInt(1, o.getid_nilai());
        st.setString(2, o.gettahun_ajaran());
        st.setString(3, o.getsemester());
        st.setString(4, o.getkelas());
        st.setString(5, o.getsiswa());
        st.setString(6, o.getnama());
        st.setString(7, o.getpelajaran());
        st.setString(8, o.getnilai());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update(entity_nilai o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("update nilai set nilai=? where id_nilai=?");
        st.setString(1, o.getnilai());
        st.setInt(2, o.getid_nilai());
        st.executeUpdate();
    }

    @Override
    public void delete(int id_nilai) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from nilai where id_nilai=?");
        st.setInt(1, id_nilai);
        st.executeUpdate();
    }

    @Override
    public List<entity_nilai> getAll() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from nilai");
        List<entity_nilai>list=new ArrayList<entity_nilai>();
        while(rs.next()){
            entity_nilai thn=new entity_nilai();
            thn.setid_nilai(rs.getInt("id_nilai"));
            thn.settahun_ajaran(rs.getString("tahun_ajaran"));
            thn.setsemester(rs.getString("semester"));
            thn.setkelas(rs.getString("kelas"));
            thn.setsiswa(rs.getString("nis_siswa"));
            thn.setnama(rs.getString("nama"));
            thn.setpelajaran(rs.getString("pilih_matpel"));
            thn.setnilai(rs.getString("nilai"));
            
            list.add(thn);
        }
        return list;
    }

    @Override
    public List<entity_nilai> getCari() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from aktif_siswa");
        List<entity_nilai>list=new ArrayList<entity_nilai>();
        while(rs.next()){
            entity_nilai thn=new entity_nilai();
            thn.settahun_ajaran(rs.getString("tahun_ajaran"));
            thn.setsemester(rs.getString("semester"));
            thn.setkelas(rs.getString("kelas"));
            thn.setsiswa(rs.getString("nis"));
            thn.setnama(rs.getString("nama"));
            
            list.add(thn);
        }
        return list;
    }

    
}
