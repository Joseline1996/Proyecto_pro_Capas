/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author israelcano
 */
public class conexion {
    Connection cn = null;
    public Connection conexion(){
        String cadena = "jdbc:postgresql://localhost:5433/datos";
        String user = "postgres";
        String pass = "joseline";
        try{
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(cadena, user, pass);
            
        }
        catch(Exception ex){
            System.out.println("ERROR:"+ex.getMessage());
        }
        return cn;
}
}
