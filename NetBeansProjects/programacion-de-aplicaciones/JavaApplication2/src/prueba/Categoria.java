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
public class Categoria {
    private String Categoria;
    private Collection<Videos> videos;
    private Collection<ListaDeReproduccion> listasrep;
    
    public Categoria(String categoria){
        this.Categoria = categoria;
        this.videos = new ArrayList<>();
        this.listasrep = new ArrayList<>();
    }
    
    public void setCategoria(String categoria){
        this.Categoria = categoria;
    }
    
    public String getCategoria(){
        return this.Categoria;
    }
    
    public DtCategoria getDataCategoria(){
        DtCategoria data = new DtCategoria(this.Categoria);
        return data;
    }
    
    public void AgregarVideo(Videos v){
        this.videos.add(v);
    }
    
    public void AgregarLR(ListaDeReproduccion lr){
        this.listasrep.add(lr);
    }
    
    public Collection<DtVideo> ListaVideosxCategoria(){
        Collection<DtVideo> c = new ArrayList<>();
        Iterator<Videos> it = videos.iterator();
        while(it.hasNext()){
            Videos v = it.next();
            DtVideo data = v.getDataVideo();
            c.add(data);
        }
        return c;
    }
    
    public Collection<DtLR> ListaLRxCategoria(){
        Collection<DtLR> c = new ArrayList<>();
        Iterator<ListaDeReproduccion> it = listasrep.iterator();
        while(it.hasNext()){
            ListaDeReproduccion v = it.next();
            DtLR data = v.getDataLR();
            c.add(data);
        }
        return c;
    }
    
}
