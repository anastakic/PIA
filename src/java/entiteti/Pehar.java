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
@Table(name="pehar"
    ,catalog="kviskoteka")
public class Pehar {
    
    private Integer id = 0;
    
    private String pitanje1;
    private String odgovor1;
    
    private String pitanje2;
    private String odgovor2;
    
    private String pitanje3;
    private String odgovor3;
    
    private String pitanje4;
    private String odgovor4;
    
    private String pitanje5;
    private String odgovor5;
    
    private String pitanje6;
    private String odgovor6;
    
    private String pitanje7;
    private String odgovor7;
    
    private String pitanje8;
    private String odgovor8;
    
    private String pitanje9;
    private String odgovor9;
    
    private String pitanje10;
    private String odgovor10;
    
    private String pitanje11;
    private String odgovor11;
    
    private String pitanje12;
    private String odgovor12;
    
    private String pitanje13;
    private String odgovor13;

    
    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="pitanje1", nullable=false )
    public String getPitanje1() {return pitanje1;}
    public void setPitanje1(String pitanje1) {this.pitanje1 = pitanje1;}
    
    @Column(name="odgovor1", nullable=false )
    public String getOdgovor1() {return odgovor1;}
    public void setOdgovor1(String odgovor1) {this.odgovor1 = odgovor1;}

    @Column(name="pitanje2", nullable=false )
    public String getPitanje2() {return pitanje2;}
    public void setPitanje2(String pitanje2) {this.pitanje2 = pitanje2;}

    @Column(name="odgovor2", nullable=false )
    public String getOdgovor2() {return odgovor2;}
    public void setOdgovor2(String odgovor2) {this.odgovor2 = odgovor2;}

    @Column(name="pitanje3", nullable=false )
    public String getPitanje3() {return pitanje3;}
    public void setPitanje3(String pitanje3) {this.pitanje3 = pitanje3;}

    @Column(name="odgovor3", nullable=false )
    public String getOdgovor3() {return odgovor3;}
    public void setOdgovor3(String odgovor3) {this.odgovor3 = odgovor3;}

    @Column(name="pitanje4", nullable=false )
    public String getPitanje4() {return pitanje4;}
    public void setPitanje4(String pitanje4) {this.pitanje4 = pitanje4;}

    @Column(name="odgovor4", nullable=false )
    public String getOdgovor4() {return odgovor4;}
    public void setOdgovor4(String odgovor4) {this.odgovor4 = odgovor4;}

    @Column(name="pitanje5", nullable=false )
    public String getPitanje5() {return pitanje5;}
    public void setPitanje5(String pitanje5) {this.pitanje5 = pitanje5;}

    @Column(name="odgovor5", nullable=false )
    public String getOdgovor5() {return odgovor5;}
    public void setOdgovor5(String odgovor5) {this.odgovor5 = odgovor5;}

    @Column(name="pitanje6", nullable=false )
    public String getPitanje6() {return pitanje6;}
    public void setPitanje6(String pitanje6) {this.pitanje6 = pitanje6;}

    @Column(name="odgovor6", nullable=false )
    public String getOdgovor6() {return odgovor6;}
    public void setOdgovor6(String odgovor6) {this.odgovor6 = odgovor6;}

    @Column(name="pitanje7", nullable=false )
    public String getPitanje7() {return pitanje7;}
    public void setPitanje7(String pitanje7) {this.pitanje7 = pitanje7;}

    @Column(name="odgovor7", nullable=false )
    public String getOdgovor7() {return odgovor7;}
    public void setOdgovor7(String odgovor7) {this.odgovor7 = odgovor7;}

    @Column(name="pitanje8", nullable=false )
    public String getPitanje8() {return pitanje8;}
    public void setPitanje8(String pitanje8) {this.pitanje8 = pitanje8;}

    @Column(name="odgovor8", nullable=false )
    public String getOdgovor8() {return odgovor8;}
    public void setOdgovor8(String odgovor8) {this.odgovor8 = odgovor8;}

    @Column(name="pitanje9", nullable=false )
    public String getPitanje9() {return pitanje9;}
    public void setPitanje9(String pitanje9) {this.pitanje9 = pitanje9;}

    @Column(name="odgovor9", nullable=false )
    public String getOdgovor9() {return odgovor9;}
    public void setOdgovor9(String odgovor9) {this.odgovor9 = odgovor9;}

    @Column(name="pitanje10", nullable=false )
    public String getPitanje10() {return pitanje10;}
    public void setPitanje10(String pitanje10) {this.pitanje10 = pitanje10;}

    @Column(name="odgovor10", nullable=false )
    public String getOdgovor10() {return odgovor10;}
    public void setOdgovor10(String odgovor10) {this.odgovor10 = odgovor10;}

    @Column(name="pitanje11", nullable=false )
    public String getPitanje11() {return pitanje11;}
    public void setPitanje11(String pitanje11) {this.pitanje11 = pitanje11;}

    @Column(name="odgovor11", nullable=false )
    public String getOdgovor11() {return odgovor11;}
    public void setOdgovor11(String odgovor11) {this.odgovor11 = odgovor11;}

    @Column(name="pitanje12", nullable=false )
    public String getPitanje12() {return pitanje12;}
    public void setPitanje12(String pitanje12) {this.pitanje12 = pitanje12;}

    @Column(name="odgovor12", nullable=false )
    public String getOdgovor12() {return odgovor12;}
    public void setOdgovor12(String odgovor12) {this.odgovor12 = odgovor12;}

    @Column(name="pitanje13", nullable=false )
    public String getPitanje13() {return pitanje13;}
    public void setPitanje13(String pitanje13) {this.pitanje13 = pitanje13;}

    @Column(name="odgovor13", nullable=false )
    public String getOdgovor13() {return odgovor13;}
    public void setOdgovor13(String odgovor13) {this.odgovor13 = odgovor13;}
    
  
    
    
}
