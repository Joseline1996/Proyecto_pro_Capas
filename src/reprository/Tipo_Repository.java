/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Tipo_Calzado_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Tipo_Repository {
    conexion conex = new conexion ();
    Connection cn = conex.conexion();
    public void Ingresar(Tipo_Calzado_i tipo ){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO tipos_calzado(nombre)VALUES(?)");               
               pst.setString(1,tipo.getNombre());
                              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Modificar(int id,Tipo_Calzado_i tipo){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE tipos_calzado set nombre=? where codigo=?");               
               pst.setString(1,tipo.getNombre());
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
            pst=cn.prepareStatement("DELETE from tipos_calzado where codigo=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminado exitosamente");
            
            pst.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Tipo_Calzado_i getTipoNombre(String nombre){
        Tipo_Calzado_i tip = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select from tipos_calzado where nombre=?");
            pst.setString(1, nombre);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               tip = new Tipo_Calzado_i(rs.getInt(1),rs.getString(2));                                          
           }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return tip;
    }
    
    
}
