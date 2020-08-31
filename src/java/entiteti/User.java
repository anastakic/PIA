/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ana
 */
@Entity
@Table(name="user"
    ,catalog="kviskoteka")
public class User{
    
    private Integer id = 0;
    private String username;
    private String passwordHash;
    private String tajnoPitanje;
    private String odgovorHash;
    private String ime;
    private String prezime;
    private String email;
    private String jmbg;
    private String pol;
    private String zanimanje;
    private String tip;
    
    private Blob profilna;
    
    
    public User() {
    }

	
    public User(String username, String passwordHash, String tajnoPitanje, String odgovorHash, String ime, String prezime, String email, String jmbg, String pol, String zanimanje, String tip) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.tajnoPitanje = tajnoPitanje;
        this.odgovorHash = odgovorHash;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.jmbg = jmbg;
        this.pol = pol;
        this.zanimanje = zanimanje;
        this.tip = tip;
    }
    
    @Id
    //@GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="username", unique=true, nullable=false, length=45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password_hash", nullable=false, length=64)
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Column(name="tajnopitanje", nullable=false, length=245)
    public String getTajnoPitanje() {
        return tajnoPitanje;
    }

    public void setTajnoPitanje(String tajnoPitanje) {
        this.tajnoPitanje = tajnoPitanje;
    }

    @Column(name="odgovor_hash", nullable=false, length=64)
    public String getOdgovorHash() {
        return odgovorHash;
    }

    public void setOdgovorHash(String odgovorHash) {
        this.odgovorHash = odgovorHash;
    }

@Column(name="ime", nullable=false, length=45)
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    
    @Column(name="prezime", nullable=false, length=45)
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    
    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    @Column(name="jmbg", nullable=false, length=13)
    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    
    @Column(name="pol", nullable=false, length=45)
    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    
    @Column(name="zanimanje", nullable=false, length=45)
    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }    

    @Column(name = "tip")
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Column(name = "profilna")
    public Blob getProfilna() {
        return profilna;
    }

    public void setProfilna(Blob profilna) {
        this.profilna = profilna;
    }
        
    
    
    
}
