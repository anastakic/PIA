/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entiteti.*;

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
import util.FacesUtil;
import util.HashFunction;
import util.HibernateUtil;
import util.PasswordValidator;
import util.SessionUtils;


/**
 *
 * @author Ana
 */
@ManagedBean 
@Named(value = "zanimljivaGeografijaController")
@SessionScoped
public class zanimljivaGeografijaController implements Serializable{
    
    public static String[] slova = {"DŽ","Đ","E","A","B","H","I","J","K","L","D","F","G","M","N","NJ","O","P","R","S","Š","T","U","V","LJ","C","Č","Ć","Z","Ž"};
  
    
    
    private String poruka;
    private String pomPoruka;
    
    private String poruka1;
    private String pomPoruka1;
    private boolean posaljiZahtev = false;
    
    private Integer brPoena = 0;
    private Integer brPoenaPosleZanimGeog;
    
    private String drzava = "";
    private String grad = "";
    private String reka = "";
    private String planina = "";
    private String jezero = "";
    private String biljka = "";
    private String zivotinja = "";
    private String muzickagrupa = "";
    
    private boolean dis = false;
    private boolean dis2 = true;
    private boolean disDugmePotvrdi = false;
    
    
    private String slovo;

    public zanimljivaGeografijaController() {
        int i = (int)(Math.random()*29);
        slovo = slova[i];
    }
    
    public void postaviDis(){
        dis = true;
    }
    
    public void potvrdi(){
        pomPoruka ="Ukupno poena: ";
        poruka="Poeni: ";
        dis = true;
        Zahtev zahtev;
        zahtev = new Zahtev();
        int i = 1;
        if(slovo.length()==2){i = 2;}
        if(drzava.length()!=0){
            if(String.valueOf(drzava.substring(0, i)).toUpperCase().equals(slovo)){
                drzava = drzava.toLowerCase();
                
                
                SessionFactory sessionFactory = util.HibernateUtil.getSessionFactory();
                Session session= sessionFactory.openSession();
                session.beginTransaction();

                Criteria cr = session.createCriteria(Drzava.class);

                Drzava pom = (Drzava)cr.add(Restrictions.eq("drzava", drzava)).uniqueResult();

                session.getTransaction().commit();
                session.close();

                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setDrzava("/");
                    poruka+="država 2; ";
                }
                else{
                    zahtev.setDrzava(drzava);
                    posaljiZahtev = true;
                    
                }
            }   else{
                zahtev.setDrzava("/");
                poruka+="država 0;";}
            
        }else{
            zahtev.setDrzava("/");
            poruka+="država 0;";}
        
        
        if(grad.length()!=0){
            if(String.valueOf(grad.substring(0, i)).toUpperCase().equals(slovo)){
                grad = grad.toLowerCase();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Criteria cr = session.createCriteria(Grad.class);
                Grad pom = (Grad)cr.add(Restrictions.eq("grad", grad)).uniqueResult();
                
                session.getTransaction().commit();
                session.close();
                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setGrad("/");
                    poruka+="grad 2; ";
                }
                else{
                    zahtev.setGrad(grad);
                    posaljiZahtev = true;
                }
            }else{
                zahtev.setGrad("/");
                poruka+="grad 0;";}
        }else{
            zahtev.setGrad("/");
            poruka+="grad 0;";}
        
        if(planina.length()!=0){
            if(String.valueOf(planina.substring(0, i)).toUpperCase().equals(slovo)){
                planina = planina.toLowerCase();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Criteria cr = session.createCriteria(Planina.class);
                Planina pom = (Planina)cr.add(Restrictions.eq("planina", planina)).uniqueResult();
                
                session.getTransaction().commit();
                session.close();
                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setPlanina("/");
                    poruka+="planina 2; ";
                }
                else{
                    zahtev.setPlanina(planina);
                    posaljiZahtev = true;
                }
            }else{
                zahtev.setPlanina("/");
                poruka+="planina 0;";}
        }else{
            zahtev.setPlanina("/");
            poruka+="planina 0;";}
        
        if(jezero.length()!=0){
            if(String.valueOf(jezero.substring(0, i)).toUpperCase().equals(slovo)){
                jezero = jezero.toLowerCase();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Criteria cr = session.createCriteria(Jezero.class);
                Jezero pom = (Jezero)cr.add(Restrictions.eq("jezero", jezero)).uniqueResult();
                
                session.getTransaction().commit();
                session.close();
                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setJezero("/");
                    poruka+="jezero 2; ";
                }
                else{
                    zahtev.setJezero(jezero);
                    posaljiZahtev = true;
                }
            }else{
                zahtev.setJezero("/");
                poruka+="jezero 0;";}
        }else{
            zahtev.setJezero("/");
            poruka+="jezero 0;";}
        
        if(reka.length()!=0){
            if(String.valueOf(reka.substring(0, i)).toUpperCase().equals(slovo)){
                reka = reka.toLowerCase();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Criteria cr = session.createCriteria(Reka.class);
                Reka pom = (Reka)cr.add(Restrictions.eq("reka", reka)).uniqueResult();
                
                session.getTransaction().commit();
                session.close();
                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setReka("/");
                    poruka+="reka 2; ";
                }
                else{
                    zahtev.setReka(reka);
                    posaljiZahtev = true;
                }
            }else{
                zahtev.setReka("/");
                poruka+="reka 0;";}
        }else{
            zahtev.setReka("/");
            poruka+="reka 0;";}
        
        if(muzickagrupa.length()!=0){
            if(String.valueOf(muzickagrupa.substring(0, i)).toUpperCase().equals(slovo)){
                muzickagrupa = muzickagrupa.toLowerCase();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Criteria cr = session.createCriteria(MuzickaGrupa.class);
                MuzickaGrupa pom = (MuzickaGrupa)cr.add(Restrictions.eq("muzickagrupa", muzickagrupa)).uniqueResult();
                
                session.getTransaction().commit();
                session.close();
                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setMuzickagrupa("/");
                    poruka+="muzička grupa 2; ";
                }
                else{
                    
                    zahtev.setMuzickagrupa(muzickagrupa);
                    posaljiZahtev = true;
                }
            }else{
                zahtev.setMuzickagrupa("/");
                poruka+="muzička grupa 0;";}
        }else{
            zahtev.setMuzickagrupa("/");
            poruka+="muzička grupa 0;";}
        
        if(zivotinja.length()!=0){
            if(String.valueOf(zivotinja.substring(0, i)).toUpperCase().equals(slovo)){
                zivotinja = zivotinja.toLowerCase();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Criteria cr = session.createCriteria(Zivotinja.class);
                Zivotinja pom = (Zivotinja)cr.add(Restrictions.eq("zivotinja", zivotinja)).uniqueResult();
                
                session.getTransaction().commit();
                session.close();
                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setZivotinja("/");
                    poruka+="životinja 2; ";
                }
                else{
                    zahtev.setZivotinja(zivotinja);
                    posaljiZahtev = true;
                }
            }else{
                zahtev.setZivotinja("/");
                poruka+="životinja 0 ;";}
        }else{
            zahtev.setZivotinja("/");
            poruka+="životinja 0;";}
        
        if(biljka.length()!=0){
            if(String.valueOf(biljka.substring(0, i)).toUpperCase().equals(slovo)){
                biljka = biljka.toLowerCase();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Criteria cr = session.createCriteria(Biljka.class);
                Biljka pom = (Biljka)cr.add(Restrictions.eq("biljka", biljka)).uniqueResult();
                
                session.getTransaction().commit();
                session.close();
                
                if(pom!=null){
                    brPoena+=2;
                    zahtev.setBiljka("/");
                    poruka+="biljka 2;";
                }
                else{
                    zahtev.setBiljka(biljka);
                    posaljiZahtev = true;
                }
            }else{
                zahtev.setBiljka("/");
                poruka+="biljka 0;";}
        }else{
            zahtev.setBiljka("/");
            poruka+="biljka 0;";}
        
        if(posaljiZahtev){
            zahtev.setTakmicar(SessionUtils.getUser().getUsername());
            supervizorController.zahtevi.add(zahtev);
        }
        
        dis = true;
        disDugmePotvrdi = true;
        
            
    }

    public void cekajSupervizora(){
        
        boolean iskoci = false;
        
        if(posaljiZahtev){
            if(!supervizorController.pregledaniZahtevi.isEmpty()){
                for(Zahtev z: supervizorController.pregledaniZahtevi){
                    if(z.getTakmicar()==SessionUtils.getUser().getUsername()){
                        if(z.isOdobrenoDrzava()){poruka+="drzava 4; "; brPoena+=4;}
                        if(z.isOdobrenoGrad()){poruka+="grad 4; "; brPoena+=4;}
                        if(z.isOdobrenoPlanina()){poruka+="planina 4; "; brPoena+=4;}
                        if(z.isOdobrenoReka()){poruka+="reka 4; "; brPoena+=4;}
                        if(z.isOdobrenoJezero()){poruka+="jezero 4; "; brPoena+=4;}
                        if(z.isOdobrenoZivotinja()){poruka+="životinja 4; "; brPoena+=4;}
                        if(z.isOdobrenoBiljka()){poruka+="biljka 4; "; brPoena+=4;}
                        if(z.isOdobrenoMuzickaGrupa()){poruka+="muzička grupa 4; "; brPoena+=4;}
                        iskoci = true;
                        posaljiZahtev = false;
                        break;
                    }
                }
            }    
            
        }else{
                if(disDugmePotvrdi){
                    dis2 = false;
                    poruka1 = poruka;
                    pomPoruka1 = pomPoruka; 
                    pomPoruka1+=brPoena + ".";
                }
        }
    }
    
    public String sledecaigra(){
        
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

        brPoenaPosleZanimGeog = pom;
        peharController.brPoenaPoslePehar = pom;
        r.setPoeni(pom);

        session.update(r);

        session.getTransaction().commit();
        session.close();
        return Navigation.PEHAR + Navigation.FACES_REDIRECT;
        
    }
    
    
    public Integer getBrPoena() {
        return brPoena;
    }

    public void setBrPoena(Integer brPoena) {
        this.brPoena = brPoena;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getReka() {
        return reka;
    }

    public void setReka(String reka) {
        this.reka = reka;
    }

    public String getPlanina() {
        return planina;
    }

    public void setPlanina(String planina) {
        this.planina = planina;
    }

    public String getJezero() {
        return jezero;
    }

    public void setJezero(String jezero) {
        this.jezero = jezero;
    }

    public String getBiljka() {
        return biljka;
    }

    public void setBiljka(String biljka) {
        this.biljka = biljka;
    }

    public String getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(String zivotinja) {
        this.zivotinja = zivotinja;
    }

    public String getMuzickagrupa() {
        return muzickagrupa;
    }

    public void setMuzickagrupa(String muzickagrupa) {
        this.muzickagrupa = muzickagrupa;
    }

    public String getSlovo() {
        return slovo;
    }

    public void setSlovo(String slovo) {
        this.slovo = slovo;
    }

    public boolean isDis() {
        return dis;
    }

    public void setDis(boolean dis) {
        this.dis = dis;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getPomPoruka() {
        return pomPoruka;
    }

    public void setPomPoruka(String pomPoruka) {
        this.pomPoruka = pomPoruka;
    }

    public boolean isDis2() {
        return dis2;
    }

    public void setDis2(boolean dis2) {
        this.dis2 = dis2;
    }

    public String getPoruka1() {
        return poruka1;
    }

    public void setPoruka1(String poruka1) {
        this.poruka1 = poruka1;
    }

    public String getPomPoruka1() {
        return pomPoruka1;
    }

    public void setPomPoruka1(String pomPoruka2) {
        this.pomPoruka1 = pomPoruka2;
    }

    public boolean isDisDugmePotvrdi() {
        return disDugmePotvrdi;
    }

    public void setDisDugmePotvrdi(boolean disDugmePotvrdi) {
        this.disDugmePotvrdi = disDugmePotvrdi;
    }

    public Integer getBrPoenaPosleZanimGeog() {
        return brPoenaPosleZanimGeog;
    }

    public void setBrPoenaPosleZanimGeog(Integer brPoenaPosleZanimGeog) {
        this.brPoenaPosleZanimGeog = brPoenaPosleZanimGeog;
    }

   
    
    
    
    
    
    
    
}
