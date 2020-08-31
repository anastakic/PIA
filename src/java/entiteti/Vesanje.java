/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ana
 */
@Entity
@Table(name="vesanje"
    ,catalog="kviskoteka")
public class Vesanje {
    private Integer id = 0;
    private String rec;

    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="rec", nullable=false )
    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }
    
    
}
