/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Cliente_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Cliente_Repository {
    conexion conecta = new conexion();
    Connection cn = conecta.conexion();
    Ciudad_Repository cr= new Ciudad_Repository();
    public void Ingresar(Cliente_i cliente ){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO clientes(cedula, nombre, direccion, telefono, sexo, id_ciudad)VALUES(?,?,?,?,?,?)");               
               pst.setString(1, cliente.getCedula());
               pst.setString(2,cliente.getNombre());
               pst.setString(3, cliente.getDireccion());
               pst.setString(4, cliente.getTelefono());
               pst.setString(5, cliente.getSexo());
               pst.setInt(6, cliente.getCiudad().getId_ciudad());
                              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Modificar(int id,Cliente_i cliente){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE ciudades set cedula=?,nombre=?,direccion=?,telefono=?,sexo=?,id_ciudad=? where id_cliente=?");               
               pst.setString(1, cliente.getCedula());
               pst.setString(2,cliente.getNombre());
               pst.setString(3, cliente.getDireccion());
               pst.setString(4, cliente.getTelefono());
               pst.setString(5, cliente.getSexo());
               pst.setInt(6, cliente.getCiudad().getId_ciudad());
               
                              
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
            pst=cn.prepareStatement("DELETE from clientes where id_cliente=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminado exitosamente");
            
            pst.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Cliente_i getClienteId(int id){
        Cliente_i cl = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select from clientes where id_cliente=?");
            pst.setInt(1, id);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               cl = new Cliente_i(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getNString(6),cr.getCiudadId(rs.getInt(7)));                                          
           }
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return cl;
    }
    
    
}
