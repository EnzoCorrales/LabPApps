/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;
import java.util.*;
/**
 *
 * @author kangaru
 */
public class DtLR {
    private String Nombre;
    private boolean Defecto;
    private boolean Privado;
    private Categoria Categoria;
    private Collection<DtVideo> videos;
    
    public DtLR(String nombre,boolean defecto,boolean privado,Categoria categoria){
        this.Nombre = nombre;
        this.Defecto = defecto;
        this.Privado = privado;
        this.Categoria = categoria;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public boolean getDefecto(){
        return this.Defecto;
    }
    
    public Categoria getCategoria(){
        return this.Categoria;
    }
    
    public boolean getPrivado(){
        return this.Privado;
    }
    
    public void setVideos(Collection<DtVideo> videos){
        this.videos = videos;
    }
    
}
