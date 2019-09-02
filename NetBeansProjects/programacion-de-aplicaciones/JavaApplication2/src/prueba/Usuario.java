/**
 *
 * @author guillermo
 */
package prueba;
import java.util.*;



public class Usuario {
     private String Nick;
     private String Nombre;
     private String Apellido;
     private String Correo;
     private Fecha fecha;
     private Canal canal;
     private Collection<ListaDeReproduccion> listasrep;
     private Collection<Usuario> seguidos;
     private Collection<Usuario> seguidores;
    // Falta la foto
    
    public Usuario(String nick,String nombre, String apellido, String correo, Fecha f){
        this.setNick(nick);
        this.setNom(nombre);
        this.setApe(apellido);
        this.setMail(correo);
        this.fecha = f;
        this.listasrep = new ArrayList<>();
        this.seguidos = new ArrayList<>();
        this.seguidores = new ArrayList<>();
    }
    
    public void setNick(String nick){
        this.Nick=nick;
    }
    
    public void setNom(String nom){
        this.Nombre=nom;
    }
    
    public void setApe(String ape){
        this.Apellido=ape;
    }
    
    public void setMail(String mail){
        this.Correo=mail;
    }
    
    public void setFecha(Fecha d){
        this.fecha.setDia(d.getDia());
        this.fecha.setMes(d.getMes());
        this.fecha.setAnio(d.getAnio());
    }
    
    public String getNick(){
        return this.Nick;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public String getApellido(){
        return this.Apellido;
    }
    
    public String getMail(){
        return this.Correo;
    }
    
    public Fecha getFecha(){
        return this.fecha;
    }
    
    public DtUsuario getDataUsuario(){
        DtUsuario data = new DtUsuario(this.Nick,this.Nombre,this.Apellido,this.Correo,this.fecha);
        data.setLista(this.ListaListaReproduccion());
        data.setVideos(this.ListaVideos());
        DtCanal c = new DtCanal(this.canal.getNombre(),this.canal.getDescripcion(),this.canal.getPrivado());
        data.setCanal(c);
        return data;
    }
    
    public Collection<DtVideo> ListaVideos(){
        return this.canal.ListaVideos();
    }
    
    public Collection<DtUsuario> ListaSeguidores(){
        Collection<DtUsuario> c = new ArrayList<>();
        Iterator<Usuario> it = seguidores.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            DtUsuario data = u.getDataUsuario();
            c.add(data);
        }
        return c;
    }
    
    public Collection<DtUsuario> ListaSeguidos(){
        Collection<DtUsuario> c = new ArrayList<>();
        Iterator<Usuario> it = seguidos.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            DtUsuario data = u.getDataUsuario();
            c.add(data);
        }
        return c;
    }
    
    public Collection<DtLR> ListaListaReproduccion(){
        Collection<DtLR> lr = new ArrayList<>();
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion lis = it.next();
            DtLR dt = lis.getDataLR();
            lr.add(dt);
        }   
        return lr;
    }
    
    public DtLR getDataLR(String nombre){
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion lis = it.next();
            if (lis.getNombre().equalsIgnoreCase(nombre)){
                return lis.getDataLR();
            }
        }
        return null;
    }
    
    public DtVideo getDataVideo(String nomVideo){
        return this.canal.getDataVideo(nomVideo);
    }
    
    public void AgregarListaRep(DtLR data){
        ListaDeReproduccion l = new ListaDeReproduccion(data);
        this.listasrep.add(l);
    }
    
    public void AgregarCanal(DtCanal data){
        Canal c = new Canal(data);
        this.canal = c;
    }
    
    public void ModificarNomVideo(String nombreV,String newNombre){
        this.canal.ModificarNomVideo(nombreV,newNombre);
    }
    
    public void ModificarDescVideo(String nombreV,String desc){
        this.canal.ModificarDescVideo(nombreV,desc);
    }
    
    public void ModificarDurVideo(String nombreV,String duracion){
        this.canal.ModificarDurVideo(nombreV,duracion);
    }
    
    public void ModificarFechaVideo(String nombreV,Fecha fecha){
        this.canal.ModificarFechaVideo(nombreV,fecha);
    }
    
    public void ModificarPrivVideo(String nombreV,boolean priv){
        this.canal.ModificarPrivVideo(nombreV,priv);
    }
    
    public void ModificarURLVideo(String nomVideo,String url){
        this.canal.ModificarURLVideo(nomVideo,url);
    }
    
    public void ModificarCatVideo(String nomVideo,Categoria cat){
        this.canal.ModificarCatVideo(nomVideo,cat);
    }
    
    public void ValorarVideo(String nick,String nomVideo,boolean valoracion){
        this.canal.ValorarVideo(nick,nomVideo,valoracion);
    }
    
    public void AltaVideo(String nombre,String duracion,String url,String descripcion,Fecha f,Categoria categoria){
        this.canal.AltaVideo(nombre,duracion,url,descripcion,f,categoria);
    }
    
    public void SeguirUsuario(Usuario u){
        seguidos.add(u);
    }
    
    public void AgregarSeguidor(Usuario u){
        seguidores.add(u);
    }
    
    public Videos getVideo(String nomVideo){
        return this.canal.getVideo(nomVideo);
    }
    
    public void AgregarVideoListaReproduccion(Videos v,String nombreLR){
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion lr = it.next();
            if(lr.getNombre().equalsIgnoreCase(nombreLR)){
                lr.AgregarVideo(v);
            }
        }
    }
    
    public boolean VideoPertenece(String nomVideo){
        return this.canal.VideoPertenece(nomVideo);
    }
    
    public boolean LRPertenece(String nomLR){
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion lr = it.next();
            if(lr.getNombre().equalsIgnoreCase(nomLR)){
                return true;
            }
        }
        return false;
    }
    
    public Collection<DtComentario> ListaComentarios(String nomVideo){
        return this.canal.ListaComentarios(nomVideo);
    }
    
    public void CrearListaDefecto(String nombre){
        DtLR dt = new DtLR(nombre,true,true);
        ListaDeReproduccion lr = new ListaDeReproduccion(dt);
        lr.setCategoria(null);
        listasrep.add(lr);
    }
    
    public void CrearListaParticular(String nombre,boolean privado,Categoria categoria){
        DtLR dt = new DtLR(nombre,false,privado);
        ListaDeReproduccion lr = new ListaDeReproduccion(dt);
        lr.setCategoria(categoria);
        listasrep.add(lr);
    }
    
    public void QuitarVideoLR(String nomLista,String nomVideo){
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion lr = it.next();
            if(lr.getNombre().equalsIgnoreCase(nomLista)){
                lr.QuitarVideoLR(nomVideo);
            }
        }
    }
    
    public boolean ExisteLista(String nombre){
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion lr = it.next();
            if(lr.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public DtCanal getDataCanal(){
        DtCanal dt = new DtCanal(this.canal.getNombre(),this.canal.getDescripcion(),this.canal.getPrivado());
        return dt;
    }
    
    public void ModificarNombreC(String nombre){
        canal.setNombre(nombre);
    }
    
    public void ModificarDescC(String desc){
        canal.setDescripcion(desc);
    }
    
    public void ModificarPrivC(boolean priv){
        canal.setPrivado(priv);
    }
    
    public boolean HayListasDefecto(){
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion lr = it.next();
            if(lr.getDefecto() == true)
                return true;
        }
        return false;
    }
}
