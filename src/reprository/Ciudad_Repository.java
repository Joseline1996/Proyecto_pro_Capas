/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Ciudad_Repository {
    conexion conecta = new conexion();
    Connection cn = conecta.conexion();
    public void Ingresar(Ciudad ciudad ){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO ciudades(nombre)VALUES(?)");               
               pst.setString(1,ciudad.getNombre());
                              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Modificar(int id,Ciudad ciudad){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE ciudades set nombre=? where id_ciudad=?");               
               pst.setString(1,ciudad.getNombre());
               pst.setInt(2, id);
                              
               JOptionPane.showMessageDialog(null,"registro modificado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Eliminar(int id){
        PreparedStatement pst = null;
        try{
            pst=cn.prepareStatement("DELETE from ciudades where id_ciudad=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminadfo exitosamente");
            
            pst.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Ciudad getCiudadId(int id){
        Ciudad ciu = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select from ciudades where id_ciudad=?");
            pst.setInt(1, id);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               ciu = new Ciudad(rs.getInt(1),rs.getString(2));                                          
           }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return ciu;
    }
    
}
