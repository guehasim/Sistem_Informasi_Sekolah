package tata_usaha.ujian.controller;

import java.sql.SQLException;
import java.util.List;
import tata_usaha.ujian.view.entity_ujian;


public interface paket {
    entity_ujian insert_pkt(entity_ujian o)throws SQLException;
    
    void update(entity_ujian o) throws SQLException;
        
    void delete_pkt(String id_pkt) throws SQLException;
    
    void delete_sl(String id_pkt) throws SQLException;
    
    void delete_jwb(String id_pkt) throws SQLException;
    
    List<entity_ujian> getAll_pkt() throws SQLException;
}
