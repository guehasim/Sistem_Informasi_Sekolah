package tata_usaha.manajemen_jab_guru;

import java.sql.SQLException;
import java.util.List;

public interface inter_kelas {
    
    entity_kelas insert(entity_kelas o) throws SQLException;

    void delete(int id_kelas) throws SQLException;

    List<entity_kelas> getAll() throws SQLException;

}
