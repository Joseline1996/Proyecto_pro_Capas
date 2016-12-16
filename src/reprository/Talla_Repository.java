/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Talla_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Talla_Repository {
   conexion conex = new conexion();
   Connection cn = conex.conexion();
   
    public void Ingresar(Talla_i talla ){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO tallas(numero)VALUES(?)");               
               pst.setInt(1,talla.getNumero());
                              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Modificar(int id,Talla_i talla){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE tallas set numero=? where id_talla=?");               
               pst.setInt(1,talla.getNumero());
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
            pst=cn.prepareStatement("DELETE from tallas where id_talla=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminado exitosamente");
            
            pst.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Talla_i getTallaNumero(int numero){
        Talla_i ta = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select * from tallas where numero=?");
            pst.setInt(1, numero);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               ta = new Talla_i(rs.getInt(1),rs.getInt(2));                                          
           }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return ta;
    }
   
    
}
