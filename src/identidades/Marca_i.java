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
public class Marca_i {
    private int id_marca;
    private String nombre;
    
    public Marca_i (int id_marca,String nombmarca){
        this.id_marca= id_marca;
        this.nombre= nombmarca;
    }
    public Marca_i (String nombmarca){      
        this.nombre= nombmarca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
