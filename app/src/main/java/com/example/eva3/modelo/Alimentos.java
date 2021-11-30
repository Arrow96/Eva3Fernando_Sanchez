package com.example.eva3.modelo;



public class Alimentos {

    private String nombre;
    private int id, energia, proteina, carbohidratos, grasas, sodio;

    
    public Alimentos(String nombre, int id, int energia, int proteina, int carbohidratos, int grasas, int sodio) {
        this.id = id;
        this.nombre = nombre;
        this.energia = energia;
        this.proteina = proteina;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        this.sodio = sodio;
    }

    public Alimentos(int anInt, String string) {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getProteina() {
        return proteina;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public int getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(int carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public int getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public int getSodio() {
        return sodio;
    }

    public void setSodio(int sodio) {
        this.sodio = sodio;
    }
}
