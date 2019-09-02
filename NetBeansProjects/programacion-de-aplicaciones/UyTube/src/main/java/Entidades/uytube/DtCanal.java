/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;

/**
 *
 * @author kangaru
 */
public class DtCanal {
    private String Nombre;
    private String Descripcion;
    private boolean Privado;
    
    public DtCanal(String nombre,String descripcion,boolean privado){
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Privado = privado;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public String getDescripcion(){
        return this.Descripcion;
    }
    
    public boolean getPrivado(){
        return this.Privado;
    }
}
