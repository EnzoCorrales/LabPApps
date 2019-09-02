/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;

import java.util.*;

/**
 *
 * @author kangaru
 */
public class DtValoracion {
    private String Nick;
    private boolean Valoracion;
    
    public DtValoracion(String nick,boolean valoracion){
        this.Nick = nick;
        this.Valoracion = valoracion;
    }
    
    public String getNick(){
        return this.Nick;
    }
    
    public boolean getValoracion(){
        return this.Valoracion;
    }
    
}
