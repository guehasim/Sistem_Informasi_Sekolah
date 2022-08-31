package tata_usaha.ujian.controller;

import java.sql.SQLException;
import java.util.List;
import tata_usaha.ujian.view.entity_ujian;


public interface uji {
    entity_ujian insert_jawab_uji(entity_ujian p)throws SQLException;
    
    void update(entity_ujian o) throws SQLException;
}
