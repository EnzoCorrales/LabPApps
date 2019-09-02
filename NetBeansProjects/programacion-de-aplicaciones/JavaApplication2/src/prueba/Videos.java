/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;
import java.util.*;
/**
 *
 * @author tecnologo
 */
public class Videos {
    
    private String nomVideo;
    private String Descripcion;
    private Categoria Categoria;
    private String Duracion;
    private Fecha fechaPub;
    private String Url;
    private boolean privado;
    private Collection<DtValoracion> valoraciones;
    private Collection<Comentario> comentarios;
    
    //Setters
    public Videos(String nom,String desc,String dur,Fecha f,String u,boolean p){
        this.setNomVideo(nom);
        this.setDescVideo(desc);
        this.setDurVideo(dur);
        this.fechaPub = f;
        this.setUrl(u);
        this.setPrivate(p);
        this.valoraciones = new ArrayList<>();
        this.comentarios = new TreeSet<>();
    }
    
    public void setDescVideo(String desc){
        this.Descripcion=desc; 
    }
    
    public void setNomVideo(String nom){
        this.nomVideo=nom; 
    }
    
    public void setDurVideo(String dur){
        this.Duracion=dur; 
    }
    
    public void setFecPub(Fecha fecPub){
        this.fechaPub.setDia(fecPub.getDia());
        this.fechaPub.setMes(fecPub.getMes());
        this.fechaPub.setAnio(fecPub.getAnio()); 
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
        return this.nomVideo;
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
    
    public void AgregarValoracion(DtValoracion data){
        this.valoraciones.add(data);
    }
    
    public Collection<DtValoracion> ListaValoraciones(){
        Collection<DtValoracion> val = new ArrayList<>();
        Iterator<DtValoracion> it = valoraciones.iterator();
        while(it.hasNext()){
            DtValoracion dt = it.next();
            val.add(dt);
        }   
        return val;
    }
    
    public DtVideo getDataVideo(){
        DtVideo v = new DtVideo(this.nomVideo,this.Descripcion,this.Duracion,this.fechaPub,this.Url,this.privado);
        v.setValoraciones(this.ListaValoraciones());
        v.setCategoria(this.getCategoria());
        return v;
    }
    
    public DtCategoria getCategoria(){
        if(this.Categoria != null){
            DtCategoria data = new DtCategoria(this.Categoria.getCategoria());
            return data;
        }
        return null;  
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
 
}