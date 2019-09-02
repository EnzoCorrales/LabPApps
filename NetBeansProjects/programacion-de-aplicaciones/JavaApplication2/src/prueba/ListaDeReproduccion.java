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
public class ListaDeReproduccion {
    private String Nombre;
    private boolean Defecto;
    private boolean Privado;
    private Categoria Categoria;
    private Collection<Videos> videos;
    
    public ListaDeReproduccion(DtLR data){
        this.setNombre(data.getNombre());
        this.setDefecto(data.getDefecto());
        this.videos = new ArrayList<>();
    }
    
    /*public ListaDeReproduccion(DtLR data){
        this.setURL(data.getURL());
        this.setNombre(data.getNombre());
        this.setDefecto(data.getDefecto());
        this.setPrivado(data.getPrivado());
        this.setCategoria(data.getCategoria());
    }*/
    
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    
    public void setCategoria(Categoria categoria){
        this.Categoria = categoria;
    }
    
    public void setDefecto(boolean defecto){
        this.Defecto = defecto;
    }
    
    public void setPrivado(boolean privado){
        if(this.Defecto == true){
            this.Privado = true;
        }
        else{
            this.Privado = privado;
        }
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public boolean getDefecto(){
        return this.Defecto;
    }
    
    public DtLR getDataLR(){
        DtLR lr = new DtLR(this.Nombre,this.Defecto,this.Privado);
        lr.setVideos(this.ListaVideos());
        return lr;
    }
    
    public Collection<DtVideo> ListaVideos(){
        Collection<DtVideo> l = new ArrayList<>();
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            DtVideo vv = v.getDataVideo();
            l.add(vv);
        }   
        return l;
    }
    
    public void AgregarVideo(Videos v){
        this.videos.add(v);
    }

    public void QuitarVideoLR(String nomVideo){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                this.videos.remove(v);
            }
        }  
    }
}
