/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.uytube;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gabrixstar
 */
@Entity
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="Nick")
        private String Nick;
    
    @Column(name="Valor")
        private boolean Valoracion;

    public Valoracion() {
    }
    
    public Valoracion(String nick,boolean valoracion){
        this.Nick=nick;
        this.Valoracion=valoracion;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getNick() {
        return this.Nick;
    }
    
    public boolean getValoracion() {
        return this.Valoracion;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public DtValoracion getDataValoracion()
    {
        DtValoracion data = new DtValoracion(this.Nick,this.Valoracion);
        return data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.uytube.Valoracion[ id=" + id + " ]";
    }
    
}
