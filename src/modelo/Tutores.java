/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ivanm
 * 
 * Para poder tener el objeto al que meterle los datos para posteriormente añadirlo a la base de datos.
 */
public class Tutores {
    private int cod;
    private String NombreCompleto, CorreoElectronico, Telefono;

    public Tutores(int cod, String NombreCompleto, String CorreoElectronico, String Telefono) {
        this.cod = cod;
        this.NombreCompleto = NombreCompleto;
        this.CorreoElectronico = CorreoElectronico;
        this.Telefono = Telefono;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    
}
