package tata_usaha.manajemen_siswa;

import java.sql.SQLException;
import java.util.List;

public interface inter_thnajar {
    
    entity_thnajar insert(entity_thnajar o) throws SQLException;

    void update(entity_thnajar o) throws SQLException;

    void delete(int id_thnajar) throws SQLException;

    List<entity_thnajar> getAll() throws SQLException;

}
