package tata_usaha.manajemen_siswa;

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
public class imple_siswa implements inter_siswa{

    @Override
    public entity_siswa insert_profil(entity_siswa o) throws SQLException {
       PreparedStatement st=koneksi.getConnection().prepareStatement("insert into siswa values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        st.setString(1, o.getnis());
        st.setString(2, o.getnama());
        st.setString(3, o.getjenkel());
        st.setString(4, o.getagama());
        st.setString(5, o.gettempat());
        st.setString(6, o.gettgllahir());
        st.setString(7, o.getalamat());
        st.setString(8, o.getanak_ke());
        st.setString(9, o.getstatus_kel());
        st.setString(10, o.getfoto());
        st.setString(11, o.getdi_kelas());
        st.setString(12, o.gettgl_msuk());
        st.setString(13, o.getnm_sd());
        st.setString(14, o.getalmt_sd());
        st.setString(15, o.getnm_ayah());
        st.setString(16, o.getnm_ibu());
        st.setString(17, o.getalmt_ayah());
        st.setString(18, o.getalmt_ibu());
        st.setString(19, o.getpassword());
        st.executeUpdate();
        return o;
    }

    @Override
    public entity_siswa insert_data(entity_siswa o) throws SQLException {
       PreparedStatement st=koneksi.getConnection().prepareStatement("insert into aktif_siswa values(?,?,?,?,?)");
        st.setString(1, o.getthn_ajar());
        st.setString(2, o.getsemester());
        st.setString(3, o.getdi_kelas());
        st.setString(4, o.getnis());
        st.setString(5, o.getnama());
        st.executeUpdate();
        return o;
    }

    @Override
    public void update_profil(entity_siswa o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("update siswa set nama=?, jenkel=?, agama=?, tempat=?, tgllahir=?, alamat=?, anakke=?, statuskel=?, foto=?, di_kelas=?,"
                + " tglmasuk=?, namasekolah=?, alamatsekolah=?, ayah=?, ibu=?, alamatayah=?, alamatibu=?, password=? where nis=?");
        st.setString(1, o.getnama());
        st.setString(2, o.getjenkel());
        st.setString(3, o.getagama());
        st.setString(4, o.gettempat());
        st.setString(5, o.gettgllahir());
        st.setString(6, o.getalamat());
        st.setString(7, o.getanak_ke());
        st.setString(8, o.getstatus_kel());
        st.setString(9, o.getfoto());
        st.setString(10, o.getdi_kelas());
        st.setString(11, o.gettgl_msuk());
        st.setString(12, o.getnm_sd());
        st.setString(13, o.getalmt_sd());
        st.setString(14, o.getnm_ayah());
        st.setString(15, o.getnm_ibu());
        st.setString(16, o.getalmt_ayah());
        st.setString(17, o.getalmt_ibu());
        st.setString(18, o.getpassword());
        st.setString(19, o.getnis());
        st.executeUpdate();
    }

    @Override
    public void update_data(entity_siswa o) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement
        ("update aktif_siswa set tahun_ajaran=?, semester=?, kelas=?, nama=? where nis=?");
        st.setString(1, o.getthn_ajar());
        st.setString(2, o.getsemester());
        st.setString(3, o.getdi_kelas());
        st.setString(4, o.getnama());
        st.setString(5, o.getnis());
        
        st.executeUpdate();
    }

    @Override
    public void delete_profil(String nis) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from siswa where nis=?");
        st.setString(1, nis);
        st.executeUpdate();
    }

    @Override
    public void delete_data(String nis) throws SQLException {
        PreparedStatement st=koneksi.getConnection().prepareStatement("delete from aktif_siswa where nis=?");
        st.setString(1, nis);
        st.executeUpdate();
    }

    @Override
    public List<entity_siswa> getAll_profil() throws SQLException {
        Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from siswa");
        List<entity_siswa>list=new ArrayList<entity_siswa>();
        while(rs.next()){
            entity_siswa thn=new entity_siswa();
            thn.setnis(rs.getString("nis"));
            thn.setnama(rs.getString("nama"));
            thn.setjenkel(rs.getString("jenkel"));
            thn.setagama(rs.getString("agama"));
            thn.settempat(rs.getString("tempat"));
            thn.settgllahir(rs.getString("tgllahir"));
            thn.setalamat(rs.getString("alamat"));
            thn.setanak_ke(rs.getString("anakke"));
            thn.setstatus_kel(rs.getString("statuskel"));
            thn.setfoto(rs.getString("foto"));
            thn.setdi_kelas(rs.getString("di_kelas"));
            thn.settgl_msuk(rs.getString("tglmasuk"));
            thn.setnm_sd(rs.getString("namasekolah"));
            thn.setalmt_sd(rs.getString("alamatsekolah"));
            thn.setnm_ayah(rs.getString("ayah"));
            thn.setnm_ibu(rs.getString("ibu"));
            thn.setalmt_ayah(rs.getString("alamatayah"));
            thn.setalmt_ibu(rs.getString("alamatibu"));
            thn.setpassword(rs.getString("password"));
            list.add(thn);
        }
        return list;
    }

    @Override
    public List<entity_siswa> getAll_data() throws SQLException {
       Statement st=koneksi.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from aktif_siswa");
        List<entity_siswa>list=new ArrayList<entity_siswa>();
        while(rs.next()){
            entity_siswa thn=new entity_siswa();
            thn.setthn_ajar(rs.getString("tahun_ajaran"));
            thn.setsemester(rs.getString("semester"));
            thn.setdi_kelas(rs.getString("kelas"));
            thn.setnis(rs.getString("nis"));
            thn.setnama(rs.getString("nama"));
            
            list.add(thn);
        }
        return list;
    }
    
}
