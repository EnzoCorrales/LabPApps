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
public class DtUsuario {
      private String Nick;
      private String Nombre;
      private String Apellido;
      private String Correo;
      private Fecha fecha;
      private Collection<DtLR> listas;
      private Collection<DtVideo> videos;
      private DtCanal canal;
      
      public DtUsuario(String nick,String nombre, String apellido,String correo,Fecha f){
          this.Nick = nick;
          this.Nombre = nombre;
          this.Apellido = apellido;
          this.Correo = correo;
          this.fecha = f;
          this.listas = new ArrayList<>();
          this.videos = new ArrayList<>();
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
      
      public String getCorreo(){
          return this.Correo;
      }
      
      public Fecha getFecha(){
          return this.fecha;
      }
      
      public void setLista(Collection<DtLR> lista){
          this.listas = lista;
      }
      
      public void setVideos(Collection<DtVideo> videos){
          this.videos = videos;
      }
      
      public void setCanal(DtCanal c){
          this.canal = c;
      }
      
      public Collection<DtVideo> getDtVideos(){
          return this.videos;
     }
      
      public DtCanal getDataCanal(){
          return this.canal;
      }
      
}
