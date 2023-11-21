package com.example.ferreteriaapp;

public class Cliente {

    private int Cedula;
    private String Nombre;
    private String Telefono;
    private String Direccion;

    public Cliente() {}

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public Cliente(int Cedula, String Nombre, String Telefono, String Direccion) {
        this.setCedula(Cedula);
        this.setNombre(Nombre);
        this.setTelefono(Telefono);
        this.setDireccion(Direccion);
    }



}
