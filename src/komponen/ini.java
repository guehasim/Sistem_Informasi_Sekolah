/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komponen;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author bagoez 93
 */
public class ini {
     
     Properties mypanel;
    private String strNamaPanel;
    ini dbsetting2;

    public String SettingPanel(String nmPanela,String file){
        try{
            mypanel=new Properties();
            mypanel.load(new FileInputStream(file));
            strNamaPanel=mypanel.getProperty(nmPanela);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"ERROR 003: Koneksi Database Gagal - "+e.toString());
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return strNamaPanel;
    }
    public String[] load_kata(String file,int batas){
       String temp = "";
            dbsetting2  = new ini();
            
            for(int i = 1;i<=batas;i++){
                temp = temp+ dbsetting2.SettingPanel("komponen"+String.valueOf(i),file)+",";
            }
            return temp.split(",");
      
    }public String[] load_key(String file,int batas){
       String temp = "";
            dbsetting2  = new ini();
            
            for(int i = 1;i<=batas;i++){
                temp = temp+ dbsetting2.SettingPanel("theme",file)+",";
            }
            return temp.split(",");
      
    }
    public String[] load_profil(String file,int batas){
       String temp = "";
            dbsetting2  = new ini();
            
            for(int i = 1;i<=batas;i++){
                temp = temp+ dbsetting2.SettingPanel("data"+i,file)+",";
            }
            return temp.split(",");
      
    }
    public String load_syn(String file,int batas){
       String temp = "";
            dbsetting2  = new ini();
            
           
                temp =dbsetting2.SettingPanel("syntax",file)+",";
            
            return temp;
      
    }
}
