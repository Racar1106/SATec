package project.modelo;

import java.util.ArrayList;

public class Servicio {
    private int código;
    private String nombre;
    private double precio;
    private ArrayList<Double> historialPrecios;

    public Servicio(int c,String n,double p){
        this.código = c;
        this.nombre = n;
        this.precio = p;
        this.historialPrecios =new ArrayList<>();
        historialPrecios.add(p);
    }

    public int getCódigo(){
        return código;
    }
    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }

    public void setCódigo(int c){
        this.código = c;
    }
    public void setNombre(String n){
        this.nombre = n;
    }
    public void setPrecio(double p){
        if(this.precio != p){
            historialPrecios.add(p);
        }
        this.precio= p;
    }

    public ArrayList<Double> getHistorialPrecios() {
        return historialPrecios;
    }
    
    public String toString(){
        return String.format("%-10s %-20s %-10s", código, nombre, precio);
    }
}
