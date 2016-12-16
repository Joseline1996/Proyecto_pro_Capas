/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import identidades.Marca_i;
import identidades.Material_i;
import identidades.Producto_i;
import identidades.Talla_i;
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
public class Producto_Repository {
    conexion conex = new conexion();
    Connection cn = conex.conexion();
    Talla_Repository tr = new Talla_Repository();
    Marca_Repository mr= new Marca_Repository();
    Material_Repository mare = new Material_Repository();
    Tipo_Repository tre = new Tipo_Repository();
    public void Ingresar(Producto_i pro ){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("INSERT INTO productos(precio, cantidad, color, id_talla, id_marca, id_material, tipo_calzado)VALUES(?,?,?,?,?,?,?)");               
               pst.setString(1, pro.getPrecio());
               pst.setString(2,pro.getCantidad());
               pst.setString(3, pro.getColor());
               pst.setInt(4, pro.getTalla().getId_talla());
               pst.setInt(5, pro.getMarca().getId_marca());
               pst.setInt(6, pro.getMaterial().getId_material());
               pst.setInt(7, pro.getTipo().getCodigo());              
               JOptionPane.showMessageDialog(null,"registro grabado exitosamente");
                
                pst.executeUpdate();
                            
            }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
              ex.printStackTrace();
            }
    }
    public void Modificar(int id,Producto_i pro){
        PreparedStatement pst = null;
            try{
               pst = cn.prepareStatement("UPDATE productos set precio=?,cantidad=?,color=?,id_talla=?,id_marca=?,id_material=?,tipos_calzado=? where id_producto=?");               
               pst.setString(1, pro.getPrecio());
               pst.setString(2,pro.getCantidad());
               pst.setString(3, pro.getColor());
               pst.setInt(4, pro.getTalla().getId_talla());
               pst.setInt(5, pro.getMarca().getId_marca());
               pst.setInt(6, pro.getMaterial().getId_material());
               pst.setInt(7, pro.getTipo().getCodigo());              
               pst.setInt(8, id);
                              
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
            pst=cn.prepareStatement("DELETE from productos where id_producto=?");
            pst.setInt(1, id);
            
            JOptionPane.showMessageDialog(null,"registro eliminado exitosamente");
            
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
           
        }
    }
    public Producto_i getProducto(String precio){
        Producto_i pro = null;         
     try{
         PreparedStatement pst = cn.prepareStatement("Select productos.*, tallas.*, marcas.*, materiales.*, tipos_calzado.* From productos INNER JOIN tallas ON productos.id_talla = tallas.id_talla INNER JOIN marcas ON productos.id_marca = marcas.id_marca INNER JOIN materiales ON productos.id_material = materiales.id_material INNER JOIN tipos_calzado ON productos.tipo_calzado = tipos_calzado.codigo Where productos.precio = ?");
            pst.setString(1, precio);
            pst.execute();        
            ResultSet rs= pst.executeQuery();
           while(rs.next()){
               Marca_i mar = new Marca_i(rs.getInt(6),rs.getString(11));
               Talla_i ta = new Talla_i(rs.getInt(5),rs.getInt(9));
               Material_i ma = new Material_i(rs.getInt(7),rs.getString(13));
               Tipo_Calzado_i tip = new Tipo_Calzado_i(rs.getInt(8),rs.getString(15));
               pro = new Producto_i(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),ta,mar,ma,tip);                                          
           }
           return pro;
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
     return null;
    }
    
    
}
