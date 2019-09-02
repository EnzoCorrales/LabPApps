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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author gabrixstar
 */
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String Categoria;
    
    @OneToMany
    @JoinColumn(name="Videos")
        private Collection<Video> videos;
    
    @OneToMany
    @JoinColumn(name="ListasReproduccion_De_Categoria")
        private Collection<ListaDeReproduccion> listasrep;
    
    
    public Categoria() {
    }
    
    public Categoria(String categoria){
        this.Categoria = categoria;
        this.videos = new ArrayList<>();
        this.listasrep = new ArrayList<>();
    }
    
    public void setCategoria(String categoria){
        this.Categoria = categoria;
    }
    
    public String getCategoria(){
        return this.Categoria;
    }
    
    public DtCategoria getDataCategoria(){
        DtCategoria data = new DtCategoria(this.Categoria);
        return data;
    }
    
    public void AgregarVideo(Video v){
        this.videos.add(v);
    }
    
    public void AgregarLR(ListaDeReproduccion lr){
        this.listasrep.add(lr);
    }
    
    public Collection<DtVideo> ListaVideosxCategoria(){
        Collection<DtVideo> c = new ArrayList<>();
        Iterator<Video> it = videos.iterator();
        while(it.hasNext()){
            Video v = it.next();
            DtVideo data = v.getDataVideo();
            c.add(data);
        }
        return c;
    }
    
    public Collection<DtLR> ListaLRxCategoria(){
        Collection<DtLR> c = new ArrayList<>();
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion v = it.next();
            DtLR data = v.getDataLR();
            c.add(data);
        }
        return c;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Categoria != null ? Categoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.Categoria == null && other.Categoria != null) || (this.Categoria != null && !this.Categoria.equals(other.Categoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.uytube.Categoria[ id=" + Categoria + " ]";
    }
    
}
