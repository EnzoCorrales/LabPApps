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
public class Main {
    public static void main(String[] args) {
        Sistema s = Sistema.getInstance();
        Fecha f = new Fecha(30,12,1997);
        Fecha f2 = new Fecha(28,8,2019);
        // Alta categoria funcionando
        s.AltaCategoria("Humor");
        s.AltaCategoria("Terror");
        s.AltaCategoria("IRL");
        // Alta usuario funcionando
        //s.AltaUsuario("JUANITO", "JUAN", "PEREZ", "JUANCITO@GMAIL.COM",f,true,"Mi canal");
        //s.AltaUsuario("TINCHO", "MARTIN","RODRIGUEZ","MARTINCITO@HOTMAIL.COM",f,false,null);
        // Alta Video funcionando
        //s.AltaVideo("MiVideo",60,"www.this.com","test",f2,"JUANITO","Humor");
        //s.AltaVideo("Tutorial Java",60,"www.this.com","test",f2,"TINCHO","Humor");
        // Valorar video funcionando
        s.ValorarVideo("TINCHO","MiVideo","JUANITO", true);
        Collection<DtVideo> videos = s.ListaVideos("JUANITO");
        Collection<DtValoracion> valoraciones;
        Collection<DtCategoria> categorias = s.ListaCategorias();
        Iterator<DtVideo> it2 = videos.iterator();
        //proando Valorar video
        while(it2.hasNext()){
            DtVideo v = it2.next();
            valoraciones = v.getValoraciones();
            Iterator<DtValoracion> it3 = valoraciones.iterator();
            while(it3.hasNext()){
                DtValoracion data = it3.next();
                System.out.println(data.getNick());
                if(data.getValoracion() == true)
                    System.out.println("Me gusta");
                else
                    System.out.println("No me gusta");
            }
        }
        // probando Listar categorias existentes, funcionando bien
        Iterator<DtCategoria> it4 = categorias.iterator();
        while(it4.hasNext()){
            DtCategoria datacat = it4.next();
            System.out.println(datacat.getCategoria());
        }
        // probando Consulta categorias, funcionando bien
        videos = s.ListaVideosxCategoria("Humor");
        it2 = videos.iterator();
        while(it2.hasNext()){
            DtVideo vv = it2.next();
            DtUsuario datauser = s.getDataUsuarioVideo(vv.getNomVideo());
            System.out.println(vv.getNomVideo() + "\t" + datauser.getNick());
        }
    }
    
    /*public void ListaRespuestas(DtComentario c){
        Collection<DtComentario> cc = c.getRespuetas();
        Iterator<DtComentario> it = cc.iterator();
        while(it.hasNext()){
            DtComentario data = it.next();
            System.out.println("(" + data.getNick() + ")" + data.getTexto());
            ListaRespuestas(data);
        }
    }*/
}
