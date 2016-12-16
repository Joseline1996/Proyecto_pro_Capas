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
public class Producto_i {
    private int id_producto;
    private String precio;
    private String cantidad;
    private String color;
    private Talla_i talla;
    private Marca_i marca;
    private Material_i material;
    private Tipo_Calzado_i tipo;
    
    public Producto_i( int id_pro,String pre,String cant,String color,Talla_i talla,Marca_i marca,Material_i mate,Tipo_Calzado_i tipo){
        this.id_producto= id_pro;
        this.precio= pre;
        this.cantidad= cant;
        this.color= color;
        this.talla= talla;
        this.marca=marca;
        this.material= mate;
        this.tipo= tipo;
    }
    public Producto_i( String pre,String cant,String color,Talla_i talla,Marca_i marca,Material_i mate,Tipo_Calzado_i tipo){        
        this.precio= pre;
        this.cantidad= cant;
        this.color= color;
        this.talla= talla;
        this.marca=marca;
        this.material= mate;
        this.tipo= tipo;
    }


    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Talla_i getTalla() {
        return talla;
    }

    public void setTalla(Talla_i talla) {
        this.talla = talla;
    }

    public Marca_i getMarca() {
        return marca;
    }

    public void setMarca(Marca_i marca) {
        this.marca = marca;
    }

    public Material_i getMaterial() {
        return material;
    }

    public void setMaterial(Material_i material) {
        this.material = material;
    }

    public Tipo_Calzado_i getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_Calzado_i tipo) {
        this.tipo = tipo;
    }
    
    
            
    
}
