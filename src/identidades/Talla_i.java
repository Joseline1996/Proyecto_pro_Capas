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
public class Talla_i {
    private int id_talla;
    private int numero;
    
    public Talla_i(int id_talla,int numtalla){
        this.id_talla= id_talla;
        this.numero= numtalla;
    }

    public Talla_i(int numtalla){
       this.numero= numtalla; 
    }

    public int getId_talla() {
        return id_talla;
    }

    public void setId_talla(int id_talla) {
        this.id_talla = id_talla;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
