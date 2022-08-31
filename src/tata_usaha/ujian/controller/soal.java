package tata_usaha.ujian.controller;

import java.sql.SQLException;
import java.util.List;
import tata_usaha.ujian.view.entity_ujian;


public interface soal {
    
    
    entity_ujian insert_soal(entity_ujian p)throws SQLException;
    
    entity_ujian insert_jawab(entity_ujian q)throws SQLException;
    
    void insert_duplikat(String kd_pk) throws SQLException;
    
    void delete_soal(int id_soal) throws SQLException;
    
    void delete_all_soal(String kd_pk) throws SQLException;
    
    void delete_jawab(int id_soal) throws SQLException;
    
    List<entity_ujian> getAll_soal() throws SQLException;
}
