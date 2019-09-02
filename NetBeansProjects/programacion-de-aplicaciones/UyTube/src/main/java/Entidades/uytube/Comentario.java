/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author gabrixstar
 */
@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
        private String Nick;
    
    @Column(name="Texto")
        private String Texto;
    
    @OneToMany
    @JoinColumn(name="Respuestas_Comentario")
        private Collection<Comentario> respuestas;

    public Comentario() {
    }
    
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
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Nick != null ? Nick.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.Nick == null && other.Nick != null) || (this.Nick != null && !this.Nick.equals(other.Nick))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.uytube.Comentario[ id=" + Nick + " ]";
    }
    
}
