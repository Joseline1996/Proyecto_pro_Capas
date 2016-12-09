package identidades;


import javax.swing.table.DefaultTableModel;
import formularios.Lista_Productos;
import static formularios.Lista_Productos.tab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LSI-LAB10
 */
public class ColaconLista {
    //implementar la estructura del nodo que se va a utilizar en la cola
    class Nodo{
        int id_producto;
        String precio, color,marca,tipo_calzado,material;
        int talla;
        Nodo siguiente;
        
        //metodo constructor
        public Nodo(){}
        public Nodo(int id,String pre,String co,String ma,String tipo,String mate, int ta,Nodo sgte){
            this.id_producto= id;
            this.precio= pre;
            this.color= co;
            this.marca= ma;
            this.material=mate;
            this.talla=ta;
            this.siguiente= sgte;          
        }
        //gets y set 

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

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        
        public String getTipo_calzado() {
            return tipo_calzado;
        }

        public void setTipo_calzado(String tipo_calzado) {
            this.tipo_calzado = tipo_calzado;
        }

        public int getTalla() {
            return talla;
        }

        public void setTalla(int talla) {
            this.talla = talla;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        
    }
    //creamos punteros raiz y auxiliar
    Nodo inicio,fin;
    //metodo constructor
    public ColaconLista(){
        inicio= null ; fin= null;
    }
    //1.- metodo validar si la cola esta vacia o no
    public boolean ColaVacia(){
        if(inicio==null){
            return true;
        }
        else{
            return false;
        }
    }
    //2.- metodo insertar nodos a la cola en forma de lista
    public void InsertarCola(int id,String p,String c,String m,int t,String ma,String tip){
        //a.-crear el nuevo nodo y pasarle la informacion respectiva 
        Nodo nuevo = new Nodo(id,p,c,m,ma,tip,t,null);
        //b.-insertar el nodo a la cola en fondo de lista
        if(ColaVacia()){
            inicio = nuevo;
            fin = nuevo;
        }
        else{
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    //3.- metodo eliminar nodo de la cola en forma de lista
    
    // metodo que es lista la cola auxiliar para recoger la cola
    public void LlenarTabla(){
        //creacion de un nodo auxiliar para recoger la cola
        DefaultTableModel modelo = (DefaultTableModel) Lista_Productos.tab.getModel();
        Nodo tep= inicio;
        Object [] tabla = new Object[7];
        while(tep!=null){
                
                    tabla[0] = tep.id_producto;
                    tabla[1] = tep.precio;
                    tabla[2] = tep.color;
                    tabla[3] = tep.marca;
                    tabla[4] = tep.talla;
                    tabla[5] = tep.material;
                    tabla[6] = tep.tipo_calzado;
                    tep= tep.siguiente;
                    modelo.addRow(tabla);
                }
                tab.setModel(modelo);
                            
            
           
    }
    
}
