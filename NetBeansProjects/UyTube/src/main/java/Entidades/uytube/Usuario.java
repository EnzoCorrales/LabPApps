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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author gabrixstar
 */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    //COLUMNAS
    @Id
        private String Nick;
    
    @Column(name="Nombre")
        private String Nombre;
    
    @Column(name="Apellido")
        private String Apellido;
    
    @Column(name="Correo")
        private String Correo;
    
    @OneToOne
    @JoinColumn(name="FechaDeNacimientoUsuario")
        private Fecha Fecha;
    
    @OneToOne
    @JoinColumn(name="Canal_Usuario")
        private Canal canal;
    
    @OneToMany
    @JoinTable(name="ListasUsuario")
     private Collection<ListaDeReproduccion> listasrep;
    
    @OneToMany
    @JoinTable(name="VideosUsuario")
        private Collection<Video> Videos;
    
    @OneToMany
    @JoinTable (name = "Seguidores_Usuario",
            joinColumns = @JoinColumn (name = "SEGUIDOR"),
            inverseJoinColumns = @JoinColumn (name = "SIGUIENDO_A"))
            private Collection<Usuario> Seguidores;
    
    @OneToMany
        @JoinTable (name = "Seguidos_Usuario",
            joinColumns = @JoinColumn (name = "SEGUIDOR"),
            inverseJoinColumns = @JoinColumn (name = "SIGUIENDO_A"))
            private Collection<Usuario> Seguidos;
    
    public Usuario() {
    }
    
    public Usuario(String nick,String nombre, String apellido, String correo, Fecha f){
        this.Nick=nick;
        this.Nombre=nombre;
        this.Apellido=apellido;
        this.Correo=correo;
        this.Fecha = f;
        this.Seguidores = new ArrayList<>();
        this.Seguidos = new ArrayList<>();
        this.listasrep= new ArrayList<>();
        this.Videos = new ArrayList<>();
        
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
    
    public void setFecha(Fecha f){
        this.Fecha=f;
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
        return this.Fecha;
    }
    
    public void setSeguidores(List<Usuario> siguiendoCol){
        this.Seguidores = siguiendoCol;
    }
    public Collection<Usuario> getSeguidores() {
        return Seguidores;
    }
    
    
    
    public DtUsuario getDataUsuario(){
        DtUsuario data = new DtUsuario(this.Nick,this.Nombre,this.Apellido,this.Correo,this.Fecha);
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
        Iterator<Usuario> it = Seguidores.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            DtUsuario data = u.getDataUsuario();
            c.add(data);
        }
        return c;
    }
    
    public Collection<DtUsuario> ListaSeguidos(){
        Collection<DtUsuario> c = new ArrayList<>();
        Iterator<Usuario> it = Seguidos.iterator();
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
        Seguidos.add(u);
    }
    
    public void AgregarSeguidor(Usuario u){
        Seguidores.add(u);
    }
    
    public Video getVideo(String nomVideo){
        return this.canal.getVideo(nomVideo);
    }
    
    public void AgregarVideoListaReproduccion(Video v,String nombreLR){
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
    
    public void CrearListaDefecto(String nombre,Categoria categoria){
        DtLR dt = new DtLR(nombre,true,true,categoria);
        ListaDeReproduccion lr = new ListaDeReproduccion(dt);
        lr.setCategoria(null);
        listasrep.add(lr);
    }
    
    public void CrearListaParticular(String nombre,boolean privado,Categoria categoria){
        DtLR dt = new DtLR(nombre,false,privado,categoria);
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Nick != null ? Nick.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.Nick == null && other.Nick != null) || (this.Nick != null && !this.Nick.equals(other.Nick))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupo3.uytube.Usuario[ id=" + Nick + " ]";
    }
    
}
