/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprository;

import conexion.conexion;
import formularios.Menu;
import identidades.Login_i;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ellet
 */
public class Login_Repository {
    conexion conex = new conexion();
    Connection cn = conex.conexion();
    public void Aceptar(Login_i lo){
        PreparedStatement pst= null;
        String tipo_usuario="";
        String sql= "SELECT * from login where usuario=? and contraseña=?" ;
        try{
            pst = cn.prepareStatement(sql);
            pst.setString(1, lo.getUsuario());
            pst.setString(2,lo.getContraseña());
            ResultSet rs= pst.executeQuery();
            rs= pst.executeQuery();
            if(rs.next()){
                //tipo_usuario = rs.getString(1);
                JOptionPane.showMessageDialog(null,"BIENVENIDO(A)" + lo.getUsuario(), "Login\n " , JOptionPane.INFORMATION_MESSAGE);
                Menu me = new Menu();
                me.setVisible(true);
                Menu.login.setText(lo.getUsuario());
                             
            }
            else{
                JOptionPane.showMessageDialog(null, "Login o password incorrecto" , "ERROR\n" , JOptionPane.ERROR_MESSAGE);
                
            }
        }catch(Exception ex ){
            JOptionPane.showMessageDialog(null,"ERROR de conexion", "EROR\n" + ex, JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
}
