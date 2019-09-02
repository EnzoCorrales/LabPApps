/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


/**
 *
 * @author gabrixstar
 */
@Entity
public class Video implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private String Nombre;

    @Column(name="Descripcion")
        private String Descripcion;
    
    @Column(name="Duracion")
        private String Duracion;
    
    @Column(name="Url")
        private String Url;
    
    @Column(name="Privado")
        private boolean privado;
    
    @OneToOne
    @JoinColumn(name="FechaPublicacion")
        private Fecha fechaPub;
    
    @OneToMany
    @JoinColumn(name="Valoraciones_Video")
        private Collection<Valoracion> valoraciones;
    
    @OneToOne
    @JoinColumn(name="Categoria_Video")
        private Categoria Categoria;
    
    @OneToMany
    @JoinColumn(name="Comentarios_Video")
        private Collection<Comentario> comentarios;
    
    public Video() {
    }
    
    
    public Video(String nom,String desc,String dur,Fecha f,String u,boolean p){
        this.Nombre = nom;
        this.Descripcion = desc;
        this.Duracion = dur;
        this.fechaPub = f;
        this.Url = u;
        this.privado = p;
        this.valoraciones = new ArrayList<>();
        this.comentarios = new TreeSet<>();
    }
    
    public void setDescVideo(String desc){
        this.Descripcion=desc; 
    }
    
    public void setNomVideo(String nom){
        this.Nombre=nom; 
    }
    
    public void setDurVideo(String dur){
        this.Duracion=dur; 
    }
    
    public void setFecPub(Fecha fecPub){
        this.fechaPub=fecPub;
        
    }
    
    public void setUrl(String url){
        this.Url=url; 
    }
    
    public void setPrivate(boolean privado){
        this.privado=privado; 
    }
    
    public void setCategoria(Categoria categoria){
        this.Categoria = categoria;
    }
    
    //Getters
    public String getNomVideo(){
        return this.Nombre;
    }
    
    public String getDescVideo(){
        return this.Descripcion;
    }
    
    public String getDurVideo(){
        return this.Duracion;
    }
    
    public Fecha getFecPub(){
        return this.fechaPub;
    }
    
    public String getUrl(){
        return this.Url;
    }
    
    public boolean getPrivate(){
        return this.privado;
    }

    public DtCategoria getCategoria(){
        if(this.Categoria != null){
            DtCategoria data = new DtCategoria(this.Categoria.getCategoria());
            return data;
        }
        return null;  
    }
    
    public void AgregarValoracion(Valoracion data){
        this.valoraciones.add(data);
    }
    
    public Collection<DtValoracion> ListaValoraciones(){
        Collection<DtValoracion> val = new ArrayList<>();
        Iterator<Valoracion> it = valoraciones.iterator();
        while(it.hasNext()){
            Valoracion v = it.next();
            DtValoracion dt = v.getDataValoracion();
            val.add(dt);
        }   
        return val;
    }
    
    public DtVideo getDataVideo(){
        DtVideo v = new DtVideo(this.Nombre,this.Descripcion,this.Duracion,this.fechaPub,this.Url,this.privado);
        v.setValoraciones(this.ListaValoraciones());
        return v;
    }
    
    public Collection<DtComentario> ListaComentarios(){
        Collection<DtComentario> c = new ArrayList<>();
        Iterator<Comentario> it = comentarios.iterator();
        while(it.hasNext()){
            Comentario com = it.next();
            DtComentario data = com.getDataComentario();
            c.add(data);
        }
        return c;
    }
    
    public void ComentarVideo(String nick,String texto){
        if(this.comentarios == null){
            Comentario c = new Comentario(nick,texto);
            comentarios.add(c);
        }
        else{
            
        }
    }
    
    public Comentario BuscarComentario(String nick,String texto){
        Comentario com;
        Iterator<Comentario> it = comentarios.iterator();
        while(it.hasNext()){
            Comentario c = it.next();
            com = c.BuscoComentario(nick,texto);
            if(com != null)
                return com;
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
        if (!(object instanceof Video)) {
            return false;
        }
        Video other = (Video) object;
        if ((this.Nombre == null && other.Nombre != null) || (this.Nombre != null && !this.Nombre.equals(other.Nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo3.uytube.Video[ id=" + Nombre + " ]";
    }
    
}
