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
public class DtVideo {
    private String nomVideo;
    private String Descripcion;
    private DtCategoria Categoria;
    private String Duracion;
    private Fecha fechaPub;
    private String Url;
    private boolean Privado;
    private Collection<DtValoracion> valoraciones;
    private Collection<DtComentario> comentarios;
    
    public DtVideo(String nom,String descripcion,String duracion,Fecha f,String url,boolean privado){
        this.nomVideo = nom;
        this.Descripcion = descripcion;
        this.Duracion = duracion;
        this.fechaPub = f;
        this.Url = url;
        this.Privado = privado;
        this.valoraciones = new ArrayList<>();
        this.comentarios = new TreeSet<>();
        
    }
    
    public String getNomVideo(){
        return this.nomVideo;
    }
    
    public String getDescripcion(){
        return this.Descripcion;
    }
    
    public String getDuracion(){
        return this.Duracion;
    }
    
    public String getCategoria(){
        if(Categoria != null)
            return this.Categoria.getCategoria();
        return null;
    }
    
    public Fecha getFecha(){
        return this.fechaPub;
    }
    
    public String getURL(){
        return this.Url;
    }
    
    public boolean getPrivado(){
        return this.Privado;
    }
    
    public Collection<DtValoracion> getValoraciones(){
        return this.valoraciones;
    }
    
    public Collection<DtComentario> getComentarios(){
        return this.comentarios;
    }
    
    public void setValoraciones(Collection<DtValoracion> valoraciones){
        this.valoraciones = valoraciones;
    }
    
    public void setCategoria(DtCategoria categoria){
        this.Categoria = categoria;
    }
}
