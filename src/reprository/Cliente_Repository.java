/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Ciudad;
import identidades.Cliente_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
               pst = cn.prepareStatement("UPDATE clientes set cedula=?,nombre=?,direccion=?,telefono=?,sexo=?,id_ciudad=? where id_cliente=?");               
               pst.setString(1, cliente.getCedula());
               pst.setString(2,cliente.getNombre());
               pst.setString(3, cliente.getDireccion());
               pst.setString(4, cliente.getTelefono());
               pst.setString(5, cliente.getSexo());
               pst.setInt(6, cliente.getCiudad().getId_ciudad());
               pst.setInt(7, id);
                              
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
    public Cliente_i getClienteCI(String cedula){
        Cliente_i cl = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select clientes.*, Ciudades.* From clientes INNER JOIN ciudades ON clientes.id_ciudad = ciudades.id_ciudad Where clientes.cedula = ?");
            pst.setString(1, cedula);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               Ciudad ciudad = new Ciudad(rs.getInt(8),rs.getString(9));
               cl = new Cliente_i(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),ciudad);                                          
           }
           return cl;
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return null;
    }
    public String SQL(String val, int num){
        String sql = "";
        if(val.equals("")){
            sql = "SELECT clientes.*,ciudades.* FROM clientes" 
                + " INNER JOIN ciudades ON clientes.id_ciudad = ciudades.id_ciudad ";
                
        }
        else{
            if(num == 1){
                sql = "SELECT clientes.*,ciudades.* FROM clientes"                 
                + " INNER JOIN ciudades ON clientes.id_ciudad = ciudades.id_ciudad WHERE clientes.cedula ='" + val + "'";
            }
            else{
                
                    if(num == 2){
                    sql = "SELECT clientes.*,ciudades.* FROM clientes"                      
                    + " INNER JOIN ciudades ON clientes.id_ciudad = ciudades.id_ciudad WHERE clientes.nombre ='" + val + "'" ;
                }            
                
                
                
            }
        }
        return sql;     
    }
    
    public List<Cliente_i> getClientes(String val,int num){
        conexion con = new conexion();
        String sql = SQL(val,num);
        List<Cliente_i> clientes = new ArrayList<Cliente_i>();
        try{
            Connection cn = con.conexion();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Ciudad ciudad = new Ciudad(rs.getInt(8),rs.getString(9));
                Cliente_i cliente = new Cliente_i(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),ciudad);
                clientes.add(cliente);
            }
            return clientes;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return null;
        }
    }

    
}
