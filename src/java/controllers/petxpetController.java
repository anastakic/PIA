/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entiteti.Anagram;
import entiteti.IgraDana;
import entiteti.Rezultati;
import entiteti.User;
import entiteti.Vesanje;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Ana
 */
@ManagedBean 
@Named(value = "petxpetController")
@SessionScoped
public class petxpetController implements Serializable{
    
    
    public static String[] slovaGoreNiz = {"A","B","C","Č","Ć","D","Dž","Đ","E","F","G","H","I","J","K"};
    public static String[] slovaDoleNiz = {"L","Lj","M","N","Nj","O","P","R","S","Š","T","U","V","Z","Ž"};
  
    private List<String> pritisnuto = new ArrayList<>();
    
    private List<String> slovaGore = new ArrayList<>();
    private List<String> slovaDole = new ArrayList<>();
  
    
    private List<String> trazenaRec = new ArrayList<>();
    private List<String> pom = new ArrayList<>();
    
    private String rec;
    private int duzina;
    private Integer brPoena = 0;
    private Integer brPoenaPoslePetxpet;
    private int brPogodjenih = 0;
    
    private boolean greska1 = false;
    private boolean greska2 = false;
    private boolean greska3 = false;
    private boolean greska4 = false;
    
    
    public petxpetController() {
        
        Integer id = VesanjeIzIgreDana();
        
        for(int i = 0; i<15; i++){
            slovaGore.add(slovaGoreNiz[i]);
            slovaDole.add(slovaDoleNiz[i]);
        }
        
        SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        
        Criteria cr = session.createCriteria(Vesanje.class);
       
        Vesanje v = (Vesanje)cr.add(Restrictions.eq("id", id)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        
        
        if(v!=null){
            rec = v.getRec();
        }
        rec = rec.toUpperCase();
        duzina = rec.length();
        int i = rec.length();
        while(i!=0){
            trazenaRec.add("__");//String.valueOf(rec.charAt(--i)));
            i--;
            
        }
        while(i<duzina){
            pom.add(String.valueOf(rec.charAt(i)));
            i++;
        }
    }
    
    
    public Integer VesanjeIzIgreDana(){
        Date datum = Date.valueOf(LocalDate.now());
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
        Criteria cr = session.createCriteria(IgraDana.class);
        IgraDana i = (IgraDana)cr.add(Restrictions.eq("datum", datum)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
            
        if(i==null){
            return 2;
        }  
        else{
            return i.getVesanje_id();}
    }
    
    
    
    public void pritisnutoSlovo(String slovo){
        pritisnuto.add(slovo);
        int i = 0;
        int ima = 0;
        for(String s: pom){
            if(s.equals(slovo)){
                trazenaRec.set(i, slovo);
                brPogodjenih++;
                ima++;
            }
            i++;
        }
        if(ima==0){
                if(!greska1){greska1=true;}
                else if(!greska2){greska2=true;}
                else if(!greska3){greska3=true;}
                else if(!greska4){greska4=true;}
            }
        
        
    }
    
    
    
    public boolean disable(String slovo){
        if(brPogodjenih==rec.length()){
            brPoena = 20;
            return true;
        }
        if(greska4){
            brPoena = 0;
            return true;
        }
        if(pritisnuto.contains(slovo)) return true;
        return false;
    }
    

    
    public String potvrdi(){
        if(brPogodjenih != rec.length()){
            if(brPogodjenih > rec.length()/2){brPoena = 10;}
        }
        
        Date datum = Date.valueOf(LocalDate.now());
        
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);

            User ulogovan = (User) s.getAttribute("user");

            Criteria cr = session.createCriteria(Rezultati.class);
            Rezultati r = (Rezultati)cr.add(Restrictions.eq("datum", datum)).add(Restrictions.eq("username", ulogovan.getUsername())).uniqueResult();

            int pom = r.getPoeni();
            pom+=brPoena;

            brPoenaPoslePetxpet = pom;

            r.setPoeni(pom);

            session.update(r);


            session.getTransaction().commit();
            session.close();
        
        return Navigation.ZANIMLJIVAGEOGRAFIJA + Navigation.FACES_REDIRECT;
    }
    
    
    public Integer getBrPoena() {
        return brPoena;
    }

    public void setBrPoena(Integer brPoena) {
        this.brPoena = brPoena;
    }

    public List<String> getTrazenaRec() {
        return trazenaRec;
    }

    public void setTrazenaRec(List<String> trazenaRec) {
        this.trazenaRec = trazenaRec;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public int getDuzina() {
        return duzina;
    }

    public void setDuzina(int duzina) {
        this.duzina = duzina;
    }

    public static String[] getSlovaGoreNiz() {
        return slovaGoreNiz;
    }

    public static void setSlovaGoreNiz(String[] slovaGoreNiz) {
        petxpetController.slovaGoreNiz = slovaGoreNiz;
    }

    public static String[] getSlovaDoleNiz() {
        return slovaDoleNiz;
    }

    public static void setSlovaDoleNiz(String[] slovaDoleNiz) {
        petxpetController.slovaDoleNiz = slovaDoleNiz;
    }

    public List<String> getSlovaGore() {
        return slovaGore;
    }

    public void setSlovaGore(List<String> slovaGore) {
        this.slovaGore = slovaGore;
    }

    public List<String> getSlovaDole() {
        return slovaDole;
    }

    public void setSlovaDole(List<String> slovaDole) {
        this.slovaDole = slovaDole;
    }

    public boolean isGreska1() {
        return greska1;
    }

    public void setGreska1(boolean greska1) {
        this.greska1 = greska1;
    }

    public boolean isGreska2() {
        return greska2;
    }

    public void setGreska2(boolean greska2) {
        this.greska2 = greska2;
    }

    public boolean isGreska3() {
        return greska3;
    }

    public void setGreska3(boolean greska3) {
        this.greska3 = greska3;
    }

    public boolean isGreska4() {
        return greska4;
    }

    public void setGreska4(boolean greska4) {
        this.greska4 = greska4;
    }

    public Integer getBrPoenaPoslePetxpet() {
        return brPoenaPoslePetxpet;
    }

    public void setBrPoenaPoslePetxpet(Integer brPoenaPoslePetxpet) {
        this.brPoenaPoslePetxpet = brPoenaPoslePetxpet;
    }
    
    

    
    
    
    
    
}
