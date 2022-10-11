/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ivanm
 * 
 * Para poder tener el objeto al que meterle los datos para posteriormente añadirlo a la base de datos.
 */
public class Empresa {
    private String cif;
    private String nombre;
    private String direccion;
    private int cp;
    private String localidad;
    private String jornada;
    private String modalidad;
    private String mail;

    public Empresa(String cif, String nombre, String direccion, int cp, String localidad, String jornada, String modalidad, String mail) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.localidad = localidad;
        this.jornada = jornada;
        this.modalidad = modalidad;
        this.mail = mail;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public TableModel getTablaProducto(Conexion cbd) {

        String[] columNames = {"CIF", "Nombre", "Direccion", "CP", "Localidad", "Jornada", "Modalidad", "Mail",};
        TableModel model = null;
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rsAux = s.executeQuery("select count(*) from empresas");
            rsAux.next();
            int rows = rsAux.getInt(1); // Conseguir número de filas de la tabla Empresas

            ResultSet rs = s.executeQuery("select CIF, Nombre, Direccion, CP ,Localidad, Jornada, Modalidad, Mail, Cod_Empresas from empresas");
            Object[][] resultSet = new Object[rows][9];
            int row = 0;
            while (rs.next()) {
                for (int i = 0; i < 9; i++) {
                    resultSet[row][i] = rs.getObject(i + 1);
                }
                row++;
            }

            model = new AbstractTableModel() {
                public int getColumnCount() {
                    return columNames.length;
                }

                public int getRowCount() {
                    return resultSet.length;
                }

                public Object getValueAt(int row, int col) {
                    return resultSet[row][col];
                }

                public String getColumnName(int column) {
                    return columNames[column];
                }

                public Class getColumnClass(int col) {
                    return getValueAt(0, col).getClass();
                }

                public void setValueAt(Object aValue, int row, int column) {
                    resultSet[row][column] = aValue;
                }
            };


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }
}
