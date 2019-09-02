/**
 *
 * @author guillermo
 */
package prueba;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    
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
}
