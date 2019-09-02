/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.*;



/**
 *
 * @author luke
 */
public class Canal {
    private String nombre;
    private String Descripcion;
    private boolean Privado;
    private Collection<Videos> videos;
    
    public Canal(DtCanal data){
        this.setDescripcion(data.getDescripcion());
        this.setNombre(data.getNombre());
        this.setPrivado(data.getPrivado());
        this.videos = new ArrayList<>();
    }
    
    //SETTERS
    public void setNombre(String nom){
        this.nombre=nom;
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
        return this.nombre;
    }
    
    public String getDescripcion(){
        return this.Descripcion;
    }
    
    public boolean getPrivado(){
        return this.Privado;
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
    
    public DtVideo getDataVideo(String nomVideo){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                return v.getDataVideo();
            }
        }
        return null;
    }
    
    public DtCanal getDataCanal(){
        DtCanal dt = new DtCanal(this.nombre, this.Descripcion,this.Privado);
        return dt;
    }
    
    public void ModificarNomVideo(String nombreV,String newNombre){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setNomVideo(newNombre);
            }
        }
    }
    
    public void ModificarDescVideo(String nombreV,String desc){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setDescVideo(desc);
            }
        }
    }
    
    public void ModificarDurVideo(String nombreV,String duracion){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setDurVideo(duracion);
            }
        }
    }
    
    public void ModificarFechaVideo(String nombreV,Fecha fecha){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setFecPub(fecha);
            }
        }
    }
    
    public void ModificarPrivVideo(String nombreV,boolean priv){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nombreV)){
                v.setPrivate(priv);
            }
        }
    }
    
    public void ModificarURLVideo(String nomVideo,String url){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                v.setUrl(url);
            }
        }
    }
    
    public void ModificarCatVideo(String nomVideo,Categoria cat){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                v.setCategoria(cat);
            }
        }
    }
    
    public void ValorarVideo(String nick,String nomVideo,boolean valoracion){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                DtValoracion data = new DtValoracion(nick,valoracion);
                v.AgregarValoracion(data);
            }
        }
    }
    
    public void AltaVideo(String nombre, String duracion,String url,String descripcion,Fecha f,Categoria categoria){
        Videos v = new Videos(nombre,descripcion,duracion,f,url,true);
        if(categoria != null)
            v.setCategoria(categoria);
        videos.add(v);
    }
    
    public Videos getVideo(String nomVideo){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                return v;
            }
        }
        return null;
    }
    
    public boolean VideoPertenece(String nomVideo){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo().equalsIgnoreCase(nomVideo)){
                return true;
            }
        }
        return false;
    }
    
    public Collection<DtComentario> ListaComentarios(String nomVideo){
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            if(v.getNomVideo() == nomVideo){
                return v.ListaComentarios();
            }
        }
        return null;
    }  
}
