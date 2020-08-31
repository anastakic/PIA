/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import com.sun.javafx.logging.PulseLogger;
import entiteti.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.PrimeFaces;
import sun.util.calendar.BaseCalendar;
import util.FacesUtil;
import util.HashFunction;
import util.HibernateUtil;
import util.PasswordValidator;

/**
 *
 * @author Ana
 */

@ManagedBean 
@Named(value = "adminController")
@SessionScoped
public class adminController implements Serializable{
    
    private List<Anagram> anagramList = new ArrayList<>();
    private List<Pehar> peharList = new ArrayList<>();
    private List<Vesanje> vesanjeList = new ArrayList<>();

    private List<Rezultati> rez = new ArrayList<>();

    private List<IgraDana> datumiSaIgrama = new ArrayList<>();
    private List<Date> datumi = new ArrayList<>();
    
    private java.util.Date minDate;
    private java.util.Date maxDate;
    
    private boolean prikaziPoruku = false;
    private String greska="";
    private boolean greskaDis=false;
    
    private Integer anagram_id;
    private Integer pehar_id;
    private Integer vesanje_id;
    private java.util.Date datum;
    
    private String datString;
    private Date datumDB;
    
    public adminController() {
        java.util.Date today = new java.util.Date();
        long oneDay = 24*60*60*1000;
        dohvatiAnagrame();
        dohvatiPehare();
        dohvatiVesanja();
        minDate = new Date(today.getTime());
        maxDate = new Date(today.getTime()+(365*oneDay));
        
    }
    
    public void dohvatiAnagrame(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Anagram.class);
        
        anagramList = cr.list();
        session.getTransaction().commit();
        session.close();
   }

    public void dohvatiPehare(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Pehar.class);
        
        peharList = cr.list();
        session.getTransaction().commit();
        session.close();
   }
    
    public void dohvatiVesanja(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Vesanje.class);
        
        vesanjeList = cr.list();
        session.getTransaction().commit();
        session.close();
   }
    
    
    public void dohvatiDatume(){
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(IgraDana.class);
        
        
        datumiSaIgrama = cr.list();
        
        session.getTransaction().commit();
        session.close();    
        
        
   }
    
    public boolean daLiJeNekoIgrao(){
        
        datumDB = new Date(datum.getTime());
       
        
        SessionFactory sessionF = util.HibernateUtil.getSessionFactory();
        Session session = sessionF.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Rezultati.class);
        
        rez = cr.list();
        
        
        session.getTransaction().commit();
        session.close(); 
        
        if(rez.isEmpty())return false;
        Date d;
        for(int i=0; i<rez.size(); i++){
            d = rez.get(i).getDatum();
            
            if(d.toString().equals(datumDB.toString())){
                return true;
            }
            
        }
        return false;
   }

    public void provera(){
        boolean m = daLiJeNekoIgrao();//true je ako je igrao danas 
        if(m){
            greskaDis = false;
            greska = "Ne može se menjati igra za ovaj datum.";
            FacesUtil.reportError("Ne može se menjati igra za ovaj datum.");
            return;}
        greska="";
        dohvatiDatume();
        datumDB = new Date(datum.getTime());
        Date d;
        
        for(int i=0; i<datumiSaIgrama.size(); i++){
            d = datumiSaIgrama.get(i).getDatum();
            
            if(d.toString().equals(datumDB.toString())){
                this.prikaziPoruku = true;
                return;
            }
            
        }
        
        this.prikaziPoruku = false;
        IgraDana igradana = new IgraDana();
        igradana.setAnagram_id(anagram_id);
        igradana.setPehar_id(pehar_id);
        igradana.setVesanje_id(vesanje_id);
        igradana.setDatum(datumDB);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        
        session.beginTransaction();
            
        session.save(igradana);
            
        
        session.getTransaction().commit();
        session.close();
        
        
        greska="Uspešno dodato!";
        greskaDis = true;
       
        
    }
    
    public void neAzuriraj(){
        greska="";
        this.prikaziPoruku = false;
    }

    public void azuriraj(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);

        
        Criteria cr = session.createCriteria(IgraDana.class);
        IgraDana igradana = (IgraDana)cr.add(Restrictions.eq("datum", datumDB)).uniqueResult();

        igradana.setAnagram_id(anagram_id);
        igradana.setPehar_id(pehar_id);
        igradana.setVesanje_id(vesanje_id);
        
        session.update(igradana);


        session.getTransaction().commit();
        session.close();

        greska="Uspešno ažurirano!";
        this.prikaziPoruku = false;
        
        greskaDis = true;
    
    }
    
    
    public void osveziListe(){
        dohvatiAnagrame();
        dohvatiPehare();
        dohvatiVesanja();
    }
    
    
    
    public List<Anagram> getAnagramList() {
        return anagramList;
    }

    public void setAnagramList(List<Anagram> anagramList) {
        this.anagramList = anagramList;
    }

    public List<Pehar> getPeharList() {
        return peharList;
    }

    public void setPeharList(List<Pehar> peharList) {
        this.peharList = peharList;
    }

    public List<Vesanje> getVesanjeList() {
        return vesanjeList;
    }

    public void setVesanjeList(List<Vesanje> vesanjeList) {
        this.vesanjeList = vesanjeList;
    }

    public List<IgraDana> getDatumiSaIgrama() {
        return datumiSaIgrama;
    }

    public void setDatumiSaIgrama(List<IgraDana> datumiSaIgrama) {
        this.datumiSaIgrama = datumiSaIgrama;
    }

    public List<Date> getDatumi() {
        return datumi;
    }

    public void setDatumi(List<Date> datumi) {
        this.datumi = datumi;
    }

   
    public Integer getAnagram_id() {
        return anagram_id;
    }

    public void setAnagram_id(Integer anagram_id) {
        this.anagram_id = anagram_id;
    }

    public Integer getPehar_id() {
        return pehar_id;
    }

    public void setPehar_id(Integer pehar_id) {
        this.pehar_id = pehar_id;
    }

    public Integer getVesanje_id() {
        return vesanje_id;
    }

    public void setVesanje_id(Integer vesanje_id) {
        this.vesanje_id = vesanje_id;
    }

    public java.util.Date getDatum() {
        return datum;
    }

    public void setDatum(java.util.Date datum) {
        this.datum = datum;
    }

    public boolean isPrikaziPoruku() {
        return prikaziPoruku;
    }

    public void setPrikaziPoruku(boolean prikaziPoruku) {
        this.prikaziPoruku = prikaziPoruku;
    }

    public java.util.Date getMinDate() {
        return minDate;
    }

    public void setMinDate(java.util.Date minDate) {
        this.minDate = minDate;
    }

    public java.util.Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(java.util.Date maxDate) {
        this.maxDate = maxDate;
    }

    public Date getDatumDB() {
        return datumDB;
    }

    public void setDatumDB(Date datumDB) {
        this.datumDB = datumDB;
    }

    public String getDatString() {
        return datString;
    }

    public void setDatString(String datString) {
        this.datString = datString;
    }

    public String getGreska() {
        return greska;
    }

    public void setGreska(String greska) {
        this.greska = greska;
    }

    public boolean isGreskaDis() {
        return greskaDis;
    }

    public void setGreskaDis(boolean greskaDis) {
        this.greskaDis = greskaDis;
    }
    
    
        
     
        
        
}
