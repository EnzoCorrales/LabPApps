/**
 *
 * @author guillermo
 */
package Entidades.uytube;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fecha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="Dia_Fecha")
        private int dia;
    @Column(name="Mes_Fecha")
        private int mes;
    @Column(name="Anio_Fecha")
        private int anio;

    public Fecha() {
    }
    
    public Fecha(int dia, int mes, int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio; 
    }
    
    public void setDia(int d){
        this.dia=d;
    }
    public void setMes(int m){
        this.mes=m;
    }
    public void setAnio(int a){
        this.anio=a;
    }
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAnio(){
        return this.anio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
