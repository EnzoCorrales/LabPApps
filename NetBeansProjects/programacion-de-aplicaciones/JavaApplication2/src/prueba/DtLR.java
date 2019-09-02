/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.*;
/**
 *
 * @author kangaru
 */
public class DtLR {
    private String Nombre;
    private boolean Defecto;
    private boolean Privado;
    private Collection<DtVideo> videos;
    
    /*public DtLR(String nombre,boolean defecto,boolean privado){
        this.Nombre = nombre;
        this.Defecto = defecto;
    }*/
    
    public DtLR(String nombre,boolean defecto,boolean privado){
        this.Nombre = nombre;
        this.Defecto = defecto;
        this.Privado = privado;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public boolean getDefecto(){
        return this.Defecto;
    }
    
    public boolean getPrivado(){
        return this.Privado;
    }
    
    public void setVideos(Collection<DtVideo> videos){
        this.videos = videos;
    }
    
}
