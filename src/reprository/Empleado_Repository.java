/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Ciudad;
import identidades.Empleado_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Empleado_Repository {
    conexion conecta = new conexion();
    Connection cn = conecta.conexion();
    Ciudad_Repository cr= new Ciudad_Repository();
    public void Ingresar(Empleado_i emple ){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO empleados(cedula, nombre, direccion, telefono, sexo, id_ciudad)VALUES(?,?,?,?,?,?)");               
               pst.setString(1, emple.getCedula());
               pst.setString(2,emple.getNombre());
               pst.setString(3, emple.getDireccion());
               pst.setString(4, emple.getTelefono());
               pst.setString(5, emple.getSexo());
               pst.setInt(6, emple.getCiudad().getId_ciudad());
                              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Modificar(int id,Empleado_i emple){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE empleados set cedula=?,nombre=?,direccion=?,telefono=?,sexo=?,id_ciudad=? where id_empleado=?");               
               pst.setString(1, emple.getCedula());
               pst.setString(2,emple.getNombre());
               pst.setString(3, emple.getDireccion());
               pst.setString(4, emple.getTelefono());
               pst.setString(5, emple.getSexo());
               pst.setInt(6, emple.getCiudad().getId_ciudad());
               
                              
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
            pst=cn.prepareStatement("DELETE from empleados where id_empleado=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminado exitosamente");
            
            pst.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Empleado_i getEmpleadoCI(String cedula){
        Empleado_i emp = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select from empleados where cedula=?");
            pst.setString(1, cedula);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               Ciudad ciudad = new Ciudad(rs.getInt(8),rs.getString(9));
               emp = new Empleado_i(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),ciudad);                                          
           }
           return emp;
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return null;
    }

    
    
    
}
