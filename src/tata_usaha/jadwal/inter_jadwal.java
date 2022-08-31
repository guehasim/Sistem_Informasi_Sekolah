package tata_usaha.jadwal;

import java.sql.SQLException;
import java.util.List;


public interface inter_jadwal {
    entity_jadwal insert(entity_jadwal o) throws SQLException;
    
    void update(entity_jadwal o) throws SQLException;

    void delete(int id_jad) throws SQLException;

    List<entity_jadwal> getAll() throws SQLException;
}
