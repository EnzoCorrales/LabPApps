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
import javax.persistence.OneToOne;


@Entity
public class ListaDeReproduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String Nombre;
    
    @Column(name="Defecto")
        private boolean Defecto;
    
    @Column(name="Privado")
        private boolean Privado;
    
    @OneToOne
    @JoinColumn(name="Categoria")
        private Categoria categoria;
    
    @OneToMany
    @JoinColumn(name="Videos_LDRP")
        private Collection<Video> videos;

    public ListaDeReproduccion() {
    }
    
    public ListaDeReproduccion(DtLR data){
        this.Nombre=data.getNombre();
        this.Defecto=data.getDefecto();
        this.Privado=data.getPrivado();
        this.videos = new ArrayList<>();
        this.categoria = data.getCategoria();
    }
    
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
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
    
    public DtLR getDataLR(){
        DtLR lr = new DtLR(this.Nombre,this.Defecto,this.Privado,this.categoria);
        lr.setVideos(this.ListaVideos());
        return lr;
    }
    
    public boolean getDefecto(){
        return this.Defecto;
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
    
    public void AgregarVideo(Video v){
        this.videos.add(v);
    }

    public void QuitarVideoLR(String nomVideo){
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                this.videos.remove(v);
            }
        }  
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
        if (!(object instanceof ListaDeReproduccion)) {
            return false;
        }
        ListaDeReproduccion other = (ListaDeReproduccion) object;
        if ((this.Nombre == null && other.Nombre != null) || (this.Nombre != null && !this.Nombre.equals(other.Nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo3.uytube.ListaDeReproduccion[ id=" + Nombre + " ]";
    }
    
}
