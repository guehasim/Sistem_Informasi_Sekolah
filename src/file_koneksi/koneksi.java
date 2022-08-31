package file_koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class koneksi {
    

    private static Connection connection;
    public koneksi(){
        
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sekolah", "root","");
                System.out.println("Driver ditemukan");
            } catch (SQLException ex) {
                System.out.println("Error koneksi");
            }
        }
        return connection;
    }

    void btn_cari1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
}
