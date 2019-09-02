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
public class Sistema {

    private Sistema() {};
    private static Sistema instancia = null;
    private SortedMap<String,Usuario> usuarios = new TreeMap<>();
    private SortedMap<String,Categoria> categorias = new TreeMap<>();

    public static Sistema getInstance() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }
    
    public void AltaUsuario(String n, String nom, String a, String m, Fecha f,boolean priv,String descripcion,String nomC){
        Usuario u = new Usuario(n, nom, a, m, f);
        usuarios.put(n,u);
        DtCanal dt = new DtCanal(nomC,descripcion,priv);
        u.AgregarCanal(dt);
        if(HayListasDefecto()){
            
        }
            
    }
    
    public boolean HayListasDefecto(){
        Collection<Usuario> c = usuarios.values();
        Iterator<Usuario> it = c.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            if(u.HayListasDefecto() == true)
                return true;
        }
        return false;
    }
    
    public Collection<DtUsuario> ListaUsuarios(){
        Collection<DtUsuario> l = new ArrayList<>();
        Collection<Usuario> c = usuarios.values();
        Iterator<Usuario> it = c.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            DtUsuario uu = u.getDataUsuario();
            l.add(uu);
        }   
        return l;
    }
    
    public Collection<DtLR> ListaListaReproducion(String nick){
        Usuario u = usuarios.get(nick);
        if(u != null)
            return u.ListaListaReproduccion();
        return null;
    }
    
    public Collection<DtVideo> ListaVideos(String nick){
        Usuario u = usuarios.get(nick);
        if(u != null)
            return u.ListaVideos();
        return null;
    }
    
    public void ModificarNomVideo(String nick, String nombreV,String newNombre){
        Usuario u = usuarios.get(nick);
        if(u != null)
            u.ModificarNomVideo(nombreV, newNombre);
    }
    
    public void ModificarDescVideo(String nick, String nombreV,String desc){
        Usuario u = usuarios.get(nick);
        if(u != null)
            u.ModificarDescVideo(nombreV,desc);
    }
    
    public void ModificarDurVideo(String nick, String nombreV,String duracion){
        Usuario u = usuarios.get(nick);
        if(u != null)
            u.ModificarDurVideo(nombreV,duracion);
    }
    
    public void ModificarFechaVideo(String nick, String nombreV,Fecha fecha){
        Usuario u = usuarios.get(nick);
        if(u != null)
            u.ModificarFechaVideo(nombreV,fecha);
    }
    
    public void ModificarPrivVideo(String nick, String nombreV,boolean priv){
        Usuario u = usuarios.get(nick);
        if(u != null)
            u.ModificarPrivVideo(nombreV,priv);
    }
    
    public void ModificarURLVideo(String nick,String nomVideo,String url){
        Usuario u = usuarios.get(nick);
        u.ModificarURLVideo(nomVideo,url);
    }
    
    public void ModificarCatVideo(String nick,String nomVideo,String cat){
        Usuario u = usuarios.get(nick);
        Categoria cat1 = categorias.get(cat);
        u.ModificarCatVideo(nomVideo,cat1);
    }
    
    public DtUsuario getDataUsuario(String nick){
        Usuario u = usuarios.get(nick);
        if(u != null){
            DtUsuario dt = u.getDataUsuario();
            return dt;
        }
        else
            return null;
    }
            
    public void ValorarVideo(String nick,String nomVideo,String usuario,boolean valoracion){
        Usuario u = usuarios.get(usuario);
        if(u != null)
            u.ValorarVideo(nick,nomVideo,valoracion);
    }
    
    public DtVideo getDataVideo(String nomVideo,String nick){
        Usuario u = usuarios.get(nick);
        if(u != null)
            return u.getDataVideo(nomVideo);
        return null;
    }
    
    public void AltaVideo(String nombre,String duracion,String url,String descripcion,Fecha f,String nick,String cat){
        Usuario u = usuarios.get(nick);
        if(u != null){
            Categoria categoria = this.getCategoria(cat);
            u.AltaVideo(nombre,duracion,url,descripcion,f,categoria);
            Videos v = u.getVideo(nombre);
            if(categoria != null)
                categoria.AgregarVideo(v);
        }
    } 
    
    public Categoria getCategoria(String categoria){
        Collection<Categoria> c = categorias.values();
        Iterator<Categoria> it = c.iterator();
        while(it.hasNext()){
            Categoria ca = it.next();
            if(ca.getCategoria().equalsIgnoreCase(categoria))
                return ca;
        }
        return null;
    }
    
    public void SeguirUsuario(String uSeguidor,String uSeguir){
        Usuario u = usuarios.get(uSeguir);
        Usuario u2 = usuarios.get(uSeguidor);
        u2.SeguirUsuario(u);
        u.AgregarSeguidor(u2);
    }
    
    public void AgregarVideoListaReproduccion(String nick,String nomVideo,String usuario,String nombreLR){
        Usuario u = usuarios.get(nick);
        Videos v = u.getVideo(nomVideo);
        Usuario u2 = usuarios.get(usuario);
        u2.AgregarVideoListaReproduccion(v,nombreLR);
    }
    
    public Collection<DtCategoria> ListaCategorias(){
        Collection<DtCategoria> cat = new ArrayList<>();
        Collection<Categoria> c = categorias.values();
        Iterator<Categoria> it = c.iterator();
        while(it.hasNext()){
            Categoria cate = it.next();
            DtCategoria dt = cate.getDataCategoria();
            cat.add(dt);
        }
        return cat;
    }
    
    public void AltaCategoria(String categoria){
        Categoria c = new Categoria(categoria);
        categorias.put(categoria, c);
    }
    
    public Collection<DtVideo> ListaVideosxCategoria(String categoria){
        Categoria c = this.getCategoria(categoria);
        Collection<DtVideo> videos = c.ListaVideosxCategoria();
        return videos;
    }
    
    public Collection<DtLR> ListaLRxCategoria(String categoria){
        Categoria c = this.getCategoria(categoria);
        Collection<DtLR> listasrep = c.ListaLRxCategoria();
        return listasrep;
    }
    
    public DtUsuario getDataUsuarioVideo(String nomVideo){
        Collection<Usuario> c = usuarios.values();
        Iterator<Usuario> it = c.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            if(u.VideoPertenece(nomVideo)){
                DtUsuario data = u.getDataUsuario();
                return data;
            }
        }
        return null;
    }
    
    public DtUsuario getDataUsuarioLR(String nomLR){
        Collection<Usuario> c = usuarios.values();
        Iterator<Usuario> it = c.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            if(u.LRPertenece(nomLR)){
                DtUsuario data = u.getDataUsuario();
                return data;
            }
        }
        return null;
    }
    
    public Collection<DtComentario> ListaComentarios(String nick,String nomVideo){
        Usuario u = usuarios.get(nick);
        if(u != null)
            return u.ListaComentarios(nomVideo);
        return null;
    }
    
    public boolean ExisteCategoria(String categoria){
        Categoria c = categorias.get(categoria);
        if(c == null)
            return false;
        else
            return true;
    }
    
    public Collection<DtUsuario> ListaSeguidores(String nick){
        Usuario u = usuarios.get(nick);
        if(u != null)
            return u.ListaSeguidores();
        return null;
    }
    
    public Collection<DtUsuario> ListaSeguidos(String nick){
        Usuario u = usuarios.get(nick);
        if(u != null)
            return u.ListaSeguidos();
        return null;
    }
    
    public void CrearListaDefecto(String nombre){
        Collection<Usuario> c = usuarios.values();
        Iterator<Usuario> it = c.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            u.CrearListaDefecto(nombre);
        }
    }
    
    public void CrearListaParticular(String nick,String nombre,boolean privado,String categoria){
        Usuario u = usuarios.get(nick);
        Categoria c = categorias.get(categoria);
        u.CrearListaParticular(nombre,privado,c);
    }
    
    public void QuitarVideoLR(String nick,String nomLista,String nomVideo){
        Usuario u = usuarios.get(nick);
        u.QuitarVideoLR(nomLista,nomVideo);
    }
    
    public boolean ExisteLista(String nick,String nombre){
        Usuario u = usuarios.get(nick);
        return u.ExisteLista(nombre);
    }
    
    public void ModificarNombreU(String nick,String nombre){
        Usuario u = usuarios.get(nick);
        u.setNom(nombre);
    }
    
    public void ModificarApellidoU(String nick,String apellido){
        Usuario u = usuarios.get(nick);
        u.setApe(apellido);
    }
    
    public void ModificarFechaU(String nick,Fecha f){
        Usuario u = usuarios.get(nick);
        u.setFecha(f);
    }
    
    public DtCanal getDataCanal(String nick){
        Usuario u = usuarios.get(nick);
        return u.getDataCanal();
    }
    
    public void ModificarNomC(String nick,String nombre){
        Usuario u = usuarios.get(nick);
        u.ModificarNombreC(nombre);
    }
    
    public void ModificarDescC(String nick,String desc){
        Usuario u = usuarios.get(nick);
        u.ModificarDescC(desc);
    }
    
    public void ModificarPrivC(String nick,boolean priv){
        Usuario u = usuarios.get(nick);
        u.ModificarPrivC(priv);
    }
}
