package tata_usaha.manajemen_guru;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AHMAD HASIM
 */
public interface inter_guru {
    
    entity_guru insert(entity_guru o)throws SQLException;
    
    void update(entity_guru o) throws SQLException;
    
    void delete(String nip) throws SQLException;
    
    List<entity_guru> getAll() throws SQLException;
}
