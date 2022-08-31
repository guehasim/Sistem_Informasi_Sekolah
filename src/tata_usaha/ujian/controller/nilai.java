package tata_usaha.ujian.controller;

import java.sql.SQLException;
import java.util.List;
import tata_usaha.ujian.view.entity_ujian;


public interface nilai {
        entity_ujian insert_peserta(entity_ujian o)throws SQLException;
        
        entity_ujian insert_nilai(entity_ujian p) throws SQLException;
        
        entity_ujian insert_nilai_ujian(entity_ujian q) throws SQLException;
        
        List<entity_ujian> getAll_siswa() throws SQLException;
}
