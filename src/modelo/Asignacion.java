package modelo;

import java.sql.Date;

public class Asignacion {

    private int cod_alumno;
    private int cod_empresas;
    private int cod_tutor;
    private Date fecha_asignacion;

    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public Asignacion(int cod_alumno, int cod_empresas, int cod_tutor, Date fecha_asignacion) {
        this.cod_alumno = cod_alumno;
        this.cod_empresas = cod_empresas;
        this.cod_tutor = cod_tutor;
        this.fecha_asignacion = fecha_asignacion;
    }

    public Asignacion(){}

    public int getCod_alumno() {
        return cod_alumno;
    }

    public void setCod_alumno(int cod_alumno) {
        this.cod_alumno = cod_alumno;
    }

    public int getCod_empresas() {
        return cod_empresas;
    }

    public void setCod_empresas(int cod_empresas) {
        this.cod_empresas = cod_empresas;
    }

    public int getCod_tutor() {
        return cod_tutor;
    }

    public void setCod_tutor(int cod_tutor) {
        this.cod_tutor = cod_tutor;
    }
}
