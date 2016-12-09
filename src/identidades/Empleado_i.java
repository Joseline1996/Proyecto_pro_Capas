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
public class Empleado_i {
    private int id_empleado;
    private String cedula;
    private String nombre;      
    private String direccion;
    private String telefono;
    private String sexo;
    private Ciudad ciudad;
    
    public Empleado_i ( int id_emple,String cedulaemple,String nomemple,String diremple,String telefemple,String sexoemple,Ciudad ciudademple){
        this.id_empleado= id_emple;
        this.cedula= cedulaemple;
        this.nombre= nomemple; 
        this.direccion= diremple;
        this.telefono=telefemple;       
        this.sexo=sexoemple;
        this.ciudad= ciudademple;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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
