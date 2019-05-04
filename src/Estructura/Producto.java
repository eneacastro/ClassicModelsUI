/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author Tarda
 */
public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    
    public String toStringJPane() {
        return "Artículo: " + nombre + "\n cantidad: " + cantidad + "\n precio: " + precio+" c/u.";
    }

    public double getPrecio() {
        return precio;
    }

    
    public String toStringFactura() {
        return nombre+","+cantidad+","+precio;
        
        
    }

    public Producto(String nombre, int cantidad,double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio=precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
