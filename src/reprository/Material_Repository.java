/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Material_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Material_Repository {
    conexion conecta = new conexion();
    Connection cn = conecta.conexion();
    public void Ingresar (Material_i material){
         PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO materiales(nombre)VALUES(?)");               
               pst.setString(1,material.getNombre());
                              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }

    public void Modificar(int id,Material_i material){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE materiales set nombre=? where id_material=?");               
               pst.setString(1,material.getNombre());
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
            pst=cn.prepareStatement("DELETE from materiales where id_material=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminado exitosamente");
            
            pst.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Material_i getMaterialNombre(String nombre){
        Material_i mate = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select from materiales where nombre=?");
            pst.setString(1, nombre);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               mate = new Material_i(rs.getInt(1),rs.getString(2));                                          
           }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return mate;
    }
    
    
    
}
