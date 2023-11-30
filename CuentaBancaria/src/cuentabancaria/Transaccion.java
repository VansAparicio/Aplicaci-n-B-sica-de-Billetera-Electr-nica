/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuentabancaria;

/**
 *
 * @author vans
 */
class Transaccion {
    
    private String tipo;
    private double monto;

    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Transacción{" +
                "tipo='" + tipo + '\'' +
                ", monto=" + monto +
                '}';
    }
}
