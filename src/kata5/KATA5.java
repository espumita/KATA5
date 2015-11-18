package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class KATA5 {

      public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conecta = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system","orcl");
        
        Statement state = conecta.createStatement();
        String query = "SELECT * FROM PEOPLE";
        ResultSet resultado = state.executeQuery(query);
        while(resultado.next()){
            System.out.println("ID = "+resultado.getInt("ID"));
            System.out.println("NAME = "+resultado.getString("NAME"));
        }
        
    }
    
}
