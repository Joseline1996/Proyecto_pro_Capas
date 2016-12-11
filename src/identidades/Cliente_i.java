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
public class Cliente_i {
    private int id_cliente;
    private String cedula;
    private String nombre;    
    private String direccion;
    private String telefono;
    private String sexo;
    private Ciudad ciudad;
    
    public Cliente_i (int id_cli,String cedula,String nomcli,String direccioncli,String telecli,String sexo,Ciudad ciudad){
        this.id_cliente= id_cli;
        this.cedula= cedula;
        this.nombre= nomcli;             
        this.direccion= direccioncli;
        this.telefono= telecli;
        this.sexo = sexo;
        this.ciudad= ciudad;
    }
    public Cliente_i (String cedula,String nomcli,String direccioncli,String telecli,String sexo,Ciudad ciudad){
        this.cedula= cedula;
        this.nombre= nomcli;             
        this.direccion= direccioncli;
        this.telefono= telecli;
        this.sexo = sexo;
        this.ciudad= ciudad;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    
    
    
}
