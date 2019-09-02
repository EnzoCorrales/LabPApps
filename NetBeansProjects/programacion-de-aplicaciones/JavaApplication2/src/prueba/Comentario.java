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
public class Comentario {
    private String Nick;
    private String Texto;
    private Collection<Comentario> respuestas;
    
    public Comentario(String nick,String texto){
        this.Nick = nick;
        this.Texto = texto;
        this.respuestas = new TreeSet<>();
    }
    
    public void setNick(String nick){
        this.Nick = nick;
    }
    
    public void setTexto(String texto){
        this.Texto = texto;
    }
    
    public String getNick(){
        return this.Nick;
    }
    
    public String getTexto(){
        return this.Texto;
    }
    
    public Collection<DtComentario> ListaRespuestas(){
        return null;
    }
    
    public DtComentario getDataComentario(){
        DtComentario data = new DtComentario(this.Nick,this.Texto);
        data.setRespuestas(this.ListaRespuestas());
        return data;
    }
    
   public Comentario BuscoComentario(String nick,String texto){
       Iterator<Comentario> it = respuestas.iterator();
       while(it.hasNext()){
           Comentario c = it.next();
           if(c.getNick() == nick || c.getTexto() == texto){
               return c;
           }
           else{
               c = c.BuscoComentario(nick, texto);
               if(c != null)
                   return c;
           }
       }
       return null;
   }
}
