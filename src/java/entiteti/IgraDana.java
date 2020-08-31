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
@Table(name="igradana"
    ,catalog="kviskoteka")
public class IgraDana {
    private Integer id = 0;
    private Date datum;
    private Integer anagram_id;
    private Integer pehar_id;
    private Integer vesanje_id;
    
    @Id
    @Column(name="id", unique=true, nullable=false )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "datum", unique=true, nullable=false )
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Column(name = "anagram_id", nullable = false)
    public Integer getAnagram_id() {
        return anagram_id;
    }

    public void setAnagram_id(Integer anagram_id) {
        this.anagram_id = anagram_id;
    }

    @Column(name = "pehar_id", nullable = false)
    public Integer getPehar_id() {
        return pehar_id;
    }

    public void setPehar_id(Integer pehar_id) {
        this.pehar_id = pehar_id;
    }

    @Column(name = "vesanje_id", nullable = false)
    public Integer getVesanje_id() {
        return vesanje_id;
    }

    public void setVesanje_id(Integer vesanje_id) {
        this.vesanje_id = vesanje_id;
    }
    
}
