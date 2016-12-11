/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Marca_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Marca_Repository {
    conexion conex = new conexion ();
    Connection cn = conex.conexion();
    public void Ingresar(Marca_i marca ){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO marcas(nombre)VALUES(?)");               
               pst.setString(1,marca.getNombre());
                              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Modificar(int id,Marca_i marca){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE marcas set nombre=? where id_marca=?");               
               pst.setString(1,marca.getNombre());
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
            pst=cn.prepareStatement("DELETE from marcas where id_marca=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminado exitosamente");
            
            pst.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Marca_i getMarcaNombre(String nombre){
        Marca_i mar = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select from marcas where nombre=?");
            pst.setString(1, nombre);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               mar = new Marca_i(rs.getInt(1),rs.getString(2));                                          
           }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return mar;
    }
    
}
