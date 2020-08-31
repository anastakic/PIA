/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ana
 */
@Entity
@Table(name="rezultati"
    ,catalog="kviskoteka")
public class Rezultati {
    private Integer id = 0;
    private Date datum;
    private String username;
    private Integer poeni;

    @Id
    @Column(name="id", unique=true, nullable=false )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "datum", nullable=false )
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "poeni", nullable = false)
    public Integer getPoeni() {
        return poeni;
    }

    public void setPoeni(Integer poeni) {
        this.poeni = poeni;
    }
    
    
}
