package tata_usaha.manajemen_jab_guru;

import java.sql.SQLException;
import java.util.List;

public interface inter_jabatan {
    entity_walkes insert(entity_walkes o) throws SQLException;

    void delete(int id) throws SQLException;

    List<entity_walkes> getAll() throws SQLException;
}
