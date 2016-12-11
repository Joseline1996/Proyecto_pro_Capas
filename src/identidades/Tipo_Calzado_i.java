/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identidades;

/**
 *
 * @author Administrador
 */
public class Tipo_Calzado_i {
    private int codigo;
    private String nombre;
    
    public Tipo_Calzado_i (int cod,String nomtipo){
        this.codigo= cod;
        this.nombre= nomtipo;
    }
    public Tipo_Calzado_i (String nomtipo){        
        this.nombre= nomtipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
