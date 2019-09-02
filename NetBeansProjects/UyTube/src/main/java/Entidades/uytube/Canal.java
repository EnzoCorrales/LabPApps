/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author gabrixstar
 */

@Entity
public class Canal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
        private String Nombre;
 
    @Column(name="Descripcion")
        private String Descripcion;
    
    @Column(name="Privado")
        private boolean Privado;
    
    @OneToMany
    @JoinColumn(name="Videos_Del_Canal")
        private Collection<Video> videos;
    

    public Canal() {
    }
    
    public Canal(DtCanal data){
        this.Nombre=data.getNombre();
        this.Descripcion=data.getDescripcion();
        //this.Privado=p;
        this.videos = new ArrayList<>();
    }
    
    //SETTERS
    public void setNombre(String nom){
        this.Nombre=nom;
    }
    
    public void setDescripcion(String Descripcion){
        this.Descripcion=Descripcion;
    }
    
    public boolean setPrivado(boolean Privado){
        this.Privado=Privado;
    return false;
    }
    
    //GETTERS
    public String getNombre(){
        return this.Nombre;
    }
    
    public String getDescripcion(){
        return this.Descripcion;
    }
    
    public boolean getPrivado(){
        return this.Privado;
    }
    
    public Collection<DtVideo> ListaVideos(){
        Collection<DtVideo> l = new ArrayList<>();
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            DtVideo vv = v.getDataVideo();
            l.add(vv);
        }   
        return l;
    }
    
    public DtVideo getDataVideo(String nomVideo){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                return v.getDataVideo();
            }
        }
        return null;
    }
    
    public DtCanal getDataCanal(){
        DtCanal dt = new DtCanal(this.Nombre, this.Descripcion,this.Privado);
        return dt;
    }
    
    public void ModificarNomVideo(String nombreV,String newNombre){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setNomVideo(newNombre);
            }
        }
    }
    
    public void ModificarDescVideo(String nombreV,String desc){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setDescVideo(desc);
            }
        }
    }
    
    public void ModificarDurVideo(String nombreV,String duracion){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setDurVideo(duracion);
            }
        }
    }
    
    public void ModificarFechaVideo(String nombreV,Fecha fecha){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setFecPub(fecha);
            }
        }
    }
    
    public void ModificarPrivVideo(String nombreV,boolean priv){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setPrivate(priv);
            }
        }
    }
    
    public void ModificarURLVideo(String nomVideo,String url){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                v.setUrl(url);
            }
        }
    }
    
    public void ModificarCatVideo(String nomVideo,Categoria cat){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                v.setCategoria(cat);
            }
        }
    }

    public void ValorarVideo(String nick,String nomVideo,boolean valoracion){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                Valoracion data = new Valoracion(nick,valoracion);
                v.AgregarValoracion(data);
            }
        }
    }
    
    public void AltaVideo(String nombre, String duracion,String url,String descripcion,Fecha f,Categoria categoria){
        Video v = new Video(nombre,descripcion,duracion,f,url,true);
        if(categoria != null)
            v.setCategoria(categoria);
        videos.add(v);
    }
    
    public Video getVideo(String nomVideo){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                return v;
            }
        }
        return null;
    }
    
    public boolean VideoPertenece(String nomVideo){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                return true;
            }
        }
        return false;
    }
    
    public Collection<DtComentario> ListaComentarios(String nomVideo){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo() == nomVideo){
                return v.ListaComentarios();
            }
        }
        return null;
    }  
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Nombre != null ? Nombre.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canal)) {
            return false;
        }
        Canal other = (Canal) object;
        if ((this.Nombre == null && other.Nombre != null) || (this.Nombre != null && !this.Nombre.equals(other.Nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo3.uytube.Canal[ id=" + Nombre + " ]";
    }
    
}
