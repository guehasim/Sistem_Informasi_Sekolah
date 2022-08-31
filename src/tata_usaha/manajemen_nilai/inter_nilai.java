package tata_usaha.manajemen_nilai;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AHMAD HASIM
 */
public interface inter_nilai {
    
    entity_nilai insert(entity_nilai o)throws SQLException;
    
    void update(entity_nilai o) throws SQLException;
    
    void delete(int id_nilai) throws SQLException;
    
    List<entity_nilai> getAll() throws SQLException;
    
    List<entity_nilai> getCari() throws SQLException;
    
}
