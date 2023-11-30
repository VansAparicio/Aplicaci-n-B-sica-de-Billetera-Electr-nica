/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentabancaria;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.commons.codec.binary.Hex;
/**
 *
 * @author vans
 */
public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double monto) {
        this.saldo += monto;
        System.out.println("El saldo actual es " + this.saldo);
    }

    public void retirar(double monto) {
        if (this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("El saldo actual es " + this.saldo);
        } else {
            System.out.println("No hay saldo suficiente para realizar el retiro");
        }
    }
    

    public List<Transaccion> obtenerHistorial() {
        List<Transaccion> historial = new ArrayList<>();
        historial.add(new Transaccion("Depósito", this.saldo));
        return historial;
    }
    
    public void depositarSeguro(double monto) {
        try {
            String montoEncriptado = new String(Hex.encodeHex(MessageDigest.getInstance("SHA-256").digest(Double.toString(monto).getBytes())));
            depositar(Double.parseDouble(montoEncriptado));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error al encriptar el monto");
        }
    }
    
 

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 1000.00);

        cuenta.depositar(500.00);
        cuenta.retirar(400.00);

        System.out.println("Historial de transacciones:");
        for (Transaccion transaccion : cuenta.obtenerHistorial()) {
            System.out.println(transaccion);
        }
    }

}

