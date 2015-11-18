package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class KATA5 {

      public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Connection conecta = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system","orcl");
        Class.forName("org.sqlite.JDBC");
        Connection conecta = DriverManager.getConnection("jdbc:sqlite:KATA5.DB");
        Statement state = conecta.createStatement();
        String query = "SELECT * FROM PEOPLE";
        ResultSet resultado = state.executeQuery(query);
        while(resultado.next()){
            System.out.println("ID = "+resultado.getInt("ID"));
            System.out.println("NAME = "+resultado.getString("NAME"));
        }
          String nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA5\\data\\emails.txt";
        
          BufferedReader reader = new BufferedReader(new FileReader(new File (nameFile)));
          String mail;
          while((mail = reader.readLine())!=null){
              if(!mail.contains("@"))continue;
              query = "INSERT INTO MAILS (mail)VALUES('"+mail+"')";
              state.executeUpdate(query);
          }
          
          
          resultado.close();
          state.close();
          conecta.close();
    }
    
}
