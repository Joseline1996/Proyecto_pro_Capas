/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;


import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class Cliente extends javax.swing.JFrame { 
    public static LinkedList contenedor = new LinkedList();
    public int encontrado;
    
        conexion conecta = new conexion();
        Connection cn = conecta.conexion();
          
    public Cliente() {
        initComponents();           
        cargarcbCiudad();
        Limpiar();
         txtcod.setEnabled(false);
         this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }
    public void Limpiar() {
        
        txtnombre.setText("");
        txtcedula.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        cbciudad.setSelectedIndex(-1);
        cbsexo.setSelectedIndex(-1);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        cbsexo = new javax.swing.JComboBox<>();
        bncancelar = new javax.swing.JButton();
        bnguardar = new javax.swing.JButton();
        cbciudad = new javax.swing.JComboBox<>();
        txtcod = new javax.swing.JTextField();
        bnmodificar = new javax.swing.JButton();
        bneliminar = new javax.swing.JButton();
        bnconsultar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtid_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 550));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("MANTENIMIENTO CLIENTE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 30, 260, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("NOMBRE:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 174, 80, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("C.I.:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 124, 40, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("TELEFONO:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 280, 80, 20);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("DIRECCION:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 224, 80, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("SEXO:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 330, 50, 20);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("CIUDAD:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 390, 70, 20);

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtnombre);
        txtnombre.setBounds(140, 170, 180, 30);

        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });
        getContentPane().add(txtcedula);
        txtcedula.setBounds(140, 120, 120, 30);

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txttelefono);
        txttelefono.setBounds(140, 270, 120, 30);

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });
        getContentPane().add(txtdireccion);
        txtdireccion.setBounds(140, 220, 250, 30);

        cbsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "masculino", "femenino" }));
        cbsexo.setSelectedIndex(-1);
        getContentPane().add(cbsexo);
        cbsexo.setBounds(140, 320, 120, 30);

        bncancelar.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        bncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        bncancelar.setText("CANCELAR");
        bncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bncancelar);
        bncancelar.setBounds(480, 320, 140, 60);

        bnguardar.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        bnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar1.png"))); // NOI18N
        bnguardar.setText("GUARDAR");
        bnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(bnguardar);
        bnguardar.setBounds(470, 70, 140, 60);

        cbciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbciudadActionPerformed(evt);
            }
        });
        getContentPane().add(cbciudad);
        cbciudad.setBounds(140, 380, 120, 30);

        txtcod.setEditable(false);
        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });
        getContentPane().add(txtcod);
        txtcod.setBounds(280, 380, 39, 30);

        bnmodificar.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        bnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.jpg"))); // NOI18N
        bnmodificar.setText("MODIFICAR");
        bnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(bnmodificar);
        bnmodificar.setBounds(460, 160, 160, 60);

        bneliminar.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        bneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.jpg"))); // NOI18N
        bneliminar.setText("ELIMINAR");
        bneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(bneliminar);
        bneliminar.setBounds(470, 240, 150, 60);

        bnconsultar.setText("...");
        bnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnconsultarActionPerformed(evt);
            }
        });
        getContentPane().add(bnconsultar);
        bnconsultar.setBounds(280, 120, 45, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("ID_CLIENTE:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 74, 90, 30);

        txtid_cliente.setEditable(false);
        getContentPane().add(txtid_cliente);
        txtid_cliente.setBounds(140, 70, 50, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-30, 0, 700, 510);

        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(340, 140, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncancelarActionPerformed
        new Menu().setVisible(true);
              this.setVisible(false);
    }//GEN-LAST:event_bncancelarActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        
        Factura.txtnombre.setText(txtnombre.getText());
    }//GEN-LAST:event_txtnombreActionPerformed

    private void bnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnguardarActionPerformed
        
          
                Limpiar();
                
            
    }//GEN-LAST:event_bnguardarActionPerformed
    public void CodigoCiudad(){
         String sql="select * from ciudades";       
        try{
            
            PreparedStatement pst = cn.prepareCall("SELECT id_ciudad FROM ciudades WHERE nombre = '" + (String)cbciudad.getSelectedItem()+"'" );
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                txtcod.setText(rs.getString(1));
            }            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
         int limite=50;
        if(txtnombre.getText().length()==limite){
            evt.consume();
        } 
        char c=evt.getKeyChar();
        if (!(c<'0'|| c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
         int limite=50;
        if(txtdireccion.getText().length()==limite){
            evt.consume();
        }
        char c=evt.getKeyChar();
        if (!(c<'0'|| c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
         int lim=10;
        if(txtcedula.getText().length()==lim){
            evt.consume();
        }
        char c=evt.getKeyChar();
        if (c<'0'|| c>'9' ){
            evt.consume();
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
         int lim=10;
        if(txttelefono.getText().length()==lim){
            evt.consume();
        }
        char c=evt.getKeyChar();
        if (c<'0'|| c>'9' ){
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void cbciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbciudadActionPerformed

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
         Factura.txtcedula.setText(txtcedula.getText());
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
       
    }//GEN-LAST:event_txtcodActionPerformed

    private void bnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnmodificarActionPerformed
        bnguardar.setEnabled(true);
        bncancelar.setEnabled(true);
            Limpiar();
           
    }//GEN-LAST:event_bnmodificarActionPerformed

    private void bneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bneliminarActionPerformed
        bncancelar.setEnabled(true);
        bnguardar.setEnabled(true);
            Limpiar();
           
    }//GEN-LAST:event_bneliminarActionPerformed

    private void bnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnconsultarActionPerformed
        
       bnmodificar.setEnabled(true);
       bnguardar.setEnabled(false);
       bneliminar.setEnabled(true);

    }//GEN-LAST:event_bnconsultarActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    public void cargarcbCiudad(){
        String sql= "Select * from ciudades";
        try{
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                cbciudad.addItem(rs.getString(2));
            }
         
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "exception 2 "+ex);
        }
    } 
    public void llenarciudad(String valor){
      try{
          Statement st= cn.createStatement();
          String sql="select * from ciudades where id_ciudad='" + valor + "'";
          ResultSet rs= st.executeQuery(sql);
          while(rs.next()){
              cbciudad.setSelectedItem(rs.getString(2));
          }
      }catch(SQLException ex){
          
      }
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bncancelar;
    private javax.swing.JButton bnconsultar;
    private javax.swing.JButton bneliminar;
    private javax.swing.JButton bnguardar;
    private javax.swing.JButton bnmodificar;
    public static javax.swing.JComboBox<String> cbciudad;
    public javax.swing.JComboBox<String> cbsexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtid_cliente;
    public static javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

   
    
    



}
