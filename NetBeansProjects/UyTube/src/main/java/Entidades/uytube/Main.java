/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gabrixstar
 */
public class Main {
    public static void main(String[] args)
    {
        new Inicio();
        /*DtCanal dtc = new DtCanal("El Canal De Enzo", "Videos De Naruto",true);
        Canal c=new Canal(dtc);
        Usuario u;
        Fecha f = new Fecha(9, 4, 1998);
        u = new Usuario("Gabe", "Enzo", "Corrales", "gabrixstar@gmail.com",f);
        Categoria cat = new Categoria("Anime");
        Video v = new Video("RockLeeVsGaara", "Pelea de Naruto Epica", 5, f, "www.youtube.com/watch?v=ltn2YITCdFw", true);
        Comentario com = new Comentario("Enzo","Muy buen video guacho");
        DtLR datalr = new DtLR("Lista de Enzo", true, true, cat);
        ListaDeReproduccion Ldr = new ListaDeReproduccion(datalr);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
                em.persist(f);
                em.persist(u);
                em.persist(v);
                em.persist(c);
                em.persist(Ldr);
                em.persist(cat);
                em.persist(com);
            em.getTransaction().commit();
            System.out.println("Los Datos han sido ingresados!");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            em.close();
            System.out.println("Adios!");*/
           
    }
    
}
        