/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entiteti.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.sql.rowset.serial.SerialBlob;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import util.FacesUtil;
import util.HashFunction;
import util.HibernateUtil;
import util.PasswordValidator;

/**
 *
 * @author Ana
 */

@ManagedBean 
@Named(value = "registrationController")
@SessionScoped
public class registrationController implements Serializable{
    
    private String username;
    private String password;
    private String passwordPotvrda;
    private String ime;
    private String prezime;
    private String zanimanje;
    private String jmbg;
    private String email;
    private String pol;
    private String pitanje;
    private String odgovor;
    private String userType;    

    private File file;
    private byte[] profilna;
    private UploadedFile slikaZaProfil;
    private String slikaStringProfil;
    
    public static List<User> zahtevi;
   
    
    
    static{
        zahtevi = new ArrayList<User>();
    }

    public List<User> getZahtevi() {
        return zahtevi;
    }

    public void setZahtevi(List<User> zahtevi) {
        registrationController.zahtevi = zahtevi;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordPotvrda() {
        return passwordPotvrda;
    }

    public void setPasswordPotvrda(String passwordPotvrda) {
        this.passwordPotvrda = passwordPotvrda;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public String getUserType() {
        return userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    } 

    public byte[] getProfilna() {
        return profilna;
    }

    public void setProfilna(byte[] profilna) {
        this.profilna = profilna;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public UploadedFile getSlikaZaProfil() {
        return slikaZaProfil;
    }

    public void setSlikaZaProfil(UploadedFile slikaZaProfil) {
        this.slikaZaProfil = slikaZaProfil;
    }

    public String getSlikaStringProfil() {
        return slikaStringProfil;
    }

    public void setSlikaStringProfil(String slikaStringProfil) {
        this.slikaStringProfil = slikaStringProfil;
    }
    
    
    
    
    public registrationController(){
        
    }
    
    
    public String registracija() throws SQLException{
        
        if (!PasswordValidator.valid(password)) {
            FacesUtil.reportError("Lozinka treba da ima između 8 i 12 karaktera, od čega minimum: 3 mala slova, 1 veliko slovo, 1 cifru, 1 specijalan karakter, mora početi slovom, i jedno za drugim mogu biti najviše dva ista karaktera.");
            return null;
        }
        
        if(jmbg.length()!=13){
            FacesUtil.reportError("JMBG nije validan.");
            return null;
        }
        
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(User.class);
        User pom = (User)cr.add(Restrictions.eq("username", username)).uniqueResult();
        
        if(pom != null) {
            this.username = "";
            this.password = "";
            this.passwordPotvrda = "";
            this.ime = "";
            this.prezime = "";
            this.zanimanje = "";
            this.jmbg = "";
            this.email = "";
            this.pol = "";
            this.pitanje = "";
            this.odgovor = "";
            this.userType = "";
                //ima takav korisnik
            FacesUtil.reportError("Korisnik sa tim korisničkim imenom već postoji. Pokušajte neko drugo.");
            session.getTransaction().commit();
            session.close();
            return null;
        }
        
     //   if(slikaZaProfil == null){
     //       slikaZaProfil.getContents();
     //   }
        
     //   String fileName = slikaZaProfil.getFileName();
     //   String contentType = slikaZaProfil.getContentType();
     //   byte[] contents = slikaZaProfil.getContents();
        
    //    byte[] imageData = new byte[slikaZaProfil.getContents().length];
    //    Blob blob = new SerialBlob(imageData);
        
       
    /*    File file = new File(slikaStringProfil);
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        
        //Avatar avatar = new Avatar();
        //avatar.setImage(bFile);
        
        //session.save(avatar);
  */
        
        User u = new User();
        String passwordHash = HashFunction.getHashString(password);
        String odgovorHash = HashFunction.getHashString(odgovor);
        
        u.setEmail(email);
        u.setIme(ime);
        u.setJmbg(jmbg);
        u.setOdgovorHash(odgovorHash);
        u.setPasswordHash(passwordHash);
        u.setTajnoPitanje(pitanje);
        u.setPol(pol);
        u.setPrezime(prezime);
        u.setTip(userType);
        u.setUsername(username);
        u.setZanimanje(zanimanje);
        //u.setProfilna(blob);
        zahtevi.add(u);
        
        this.username = "";
        this.password = "";
        this.passwordPotvrda = "";
        this.ime = "";
        this.prezime = "";
        this.zanimanje = "";
        this.jmbg = "";
        this.email = "";
        this.pol = "";
        this.pitanje = "";
        this.odgovor = "";
        this.userType = "";
        
        session.getTransaction().commit();
        session.close();
        
        return Navigation.INDEX + Navigation.FACES_REDIRECT;
    }
    
    public void obrisiZahtev(User u){
        zahtevi.remove(u);
       
    }
    
    public String snimi(User u){
        //u bazu
        if(zahtevi.isEmpty()) return null;
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        
        
        try {
            session.beginTransaction();
            
            session.save(u);
            zahtevi.remove(u);
            return Navigation.ADMIN + Navigation.FACES_REDIRECT;
            
        } catch (Exception e) {
            e.printStackTrace();
            return Navigation.ERROR + Navigation.FACES_REDIRECT;
            
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        
    } 
    
    
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    
}
