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
public class DtComentario {
    private String Nick;
    private String Texto;
    private Collection<DtComentario> respuestas;
    
    public DtComentario(String nick,String texto){
        this.Nick = nick;
        this.Texto = texto;
        this.respuestas = new TreeSet<>();
    }
    
    public String getNick(){
        return this.Nick;
    }
    
    public String getTexto(){
        return this.Texto;
    }
    
    public void setRespuestas(Collection<DtComentario> respuestas){
        this.respuestas = respuestas;
    }
    
    public boolean hayRespuestas(){
        if(respuestas == null)
            return false;
        else
            return true;
    }
    
    public Collection<DtComentario> getRespuetas(){
        return this.respuestas;
    }
    
}
