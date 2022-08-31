package tata_usaha.manajemen_siswa;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AHMAD HASIM
 */
public interface inter_siswa {
    
    entity_siswa insert_profil(entity_siswa o)throws SQLException;
    
    entity_siswa insert_data(entity_siswa o)throws SQLException;
    
    void update_profil(entity_siswa o) throws SQLException;
    
    void update_data(entity_siswa o) throws SQLException;
    
    void delete_profil(String nis) throws SQLException;
    
    void delete_data(String nis)throws SQLException;
    
    List<entity_siswa> getAll_profil() throws SQLException;
    
    List<entity_siswa>getAll_data() throws SQLException;
    
    
}
