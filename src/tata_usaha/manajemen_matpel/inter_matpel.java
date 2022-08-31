package tata_usaha.manajemen_matpel;

import java.sql.SQLException;
import java.util.List;

public interface inter_matpel {
    entity_matpel insert(entity_matpel o) throws SQLException;
    
    void update(entity_matpel o) throws SQLException;

    void delete(String kode_matpel) throws SQLException;

    List<entity_matpel> getAll() throws SQLException;
}
