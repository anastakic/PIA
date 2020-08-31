/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.el.lang.ExpressionBuilder;
import entiteti.Rezultati;
import entiteti.User;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.el.Expression;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.primefaces.expression.impl.ThisExpressionResolver;
import sun.security.action.PutAllAction;
import util.HibernateUtil;

/**
 *
 * @author Ana
 */
@ManagedBean 
@Named(value = "mojBrojController")
@SessionScoped
public class mojBrojController implements Serializable{
    private Integer brPoena = 0;
    private Integer brPoenaPosleMojBroj;
    
    public static Integer[] nizJedn = {1,2,3,4,5,6,7,8,9};
    public static Integer[] nizDvocif = {10,15,20};
    public static Integer[] nizDvTr = {25,50,75,100};
    public static List<Integer> nizMojBr = new ArrayList<Integer>();
    static{
        for(int i = 1; i<=999; i++){
            nizMojBr.add(i);
        }
    }
    
    private List<String> izrazPoElementima = new ArrayList<String>();
    
    private Integer mojBr = 0;
    
    private Integer br1 = 0;
    private Integer br2 = 0;
    private Integer br3 = 0;
    private Integer br4 = 0;
    private Integer br5 = 0;
    private Integer br6 = 0;
    
    private String podeljeno = "/";
    private String puta = "*";
    private String plus = "+";
    private String minus = "-";
    private String otvZagrada = "(";
    private String zatvZagrada = ")";
    private String obrisi = "<<";
    
    private int timerValue = 60;
    
    
    private boolean br1dis = true;
    private boolean br2dis = true;
    private boolean br3dis = true;
    private boolean br4dis = true;
    private boolean br5dis = true;
    private boolean br6dis = true;
    private boolean operacije = true;

    private boolean pritBr1 = false;
    private boolean pritBr2;
    private boolean pritBr3;
    private boolean pritBr4;
    private boolean pritBr5;
    private boolean pritBr6;
    
    private boolean dis = false;
    
    
    private String izraz = "";

    public mojBrojController() {
    }
    
    
    public void timer(){
        if(--timerValue<0){
            timerValue = 0;
          //  timerReset = false;
        }
        
    }
    
    
    public void stop(){
        br1dis = true;
        br2dis = true;
        br3dis = true;
        br4dis = true;
        br5dis = true;
        br6dis = true;
        operacije = true;
        dis = true;
    }
    
    public void generisi(){
        
        int d = (int)(Math.random()*998);
        
        int a1 = (int)(Math.random()*8);
        int a2 = (int)(Math.random()*8);
        int a3 = (int)(Math.random()*8);
        int a4 = (int)(Math.random()*8);
        
        int b = (int)(Math.random()*2);
        int c = (int)(Math.random()*3);
        
        br1 = nizJedn[a1];
        br2 = nizJedn[a2];
        br3 = nizJedn[a3];
        br4 = nizJedn[a4];
        
        br5 = nizDvocif[b];
        
        br6 = nizDvTr[c];
        
        mojBr = nizMojBr.get(d);
        
        br1dis = false;
        br2dis = false;
        br3dis = false;
        br4dis = false;
        br5dis = false;
        br6dis = false;
        operacije = false;
        dis = true;
       
    }

    public void pritisnutBr1(){
        pritBr1 = true;
        br1dis = pritBr1 || true;
        br2dis = pritBr2 || true;
        br3dis = pritBr3 || true;
        br4dis = pritBr4 || true;
        br5dis = pritBr5 || true;
        br6dis = pritBr6 || true;
        
        izraz+=br1.toString();    
        izrazPoElementima.add(br1.toString());
    }
    public void pritisnutBr2(){
        pritBr2 = true;
        br1dis = pritBr1 || true;
        br2dis = pritBr2 || true;
        br3dis = pritBr3 || true;
        br4dis = pritBr4 || true;
        br5dis = pritBr5 || true;
        br6dis = pritBr6 || true;
        
        izraz+=br2.toString();
        izrazPoElementima.add(br2.toString());
    }
    public void pritisnutBr3(){
        pritBr3 = true;
        br1dis = pritBr1 || true;
        br2dis = pritBr2 || true;
        br3dis = pritBr3 || true;
        br4dis = pritBr4 || true;
        br5dis = pritBr5 || true;
        br6dis = pritBr6 || true;
        
        izraz+=br3.toString();    
        izrazPoElementima.add(br3.toString());
    }
    public void pritisnutBr4(){
        pritBr4 = true;
        br1dis = pritBr1 || true;
        br2dis = pritBr2 || true;
        br3dis = pritBr3 || true;
        br4dis = pritBr4 || true;
        br5dis = pritBr5 || true;
        br6dis = pritBr6 || true;
        
        izraz+=br4.toString();   
        izrazPoElementima.add(br4.toString());
    }
    public void pritisnutBr5(){
        pritBr5 = true;
        br1dis = pritBr1 || true;
        br2dis = pritBr2 || true;
        br3dis = pritBr3 || true;
        br4dis = pritBr4 || true;
        br5dis = pritBr5 || true;
        br6dis = pritBr6 || true;
        
        izraz+=br5.toString();    
        izrazPoElementima.add(br5.toString());
    }
    public void pritisnutBr6(){
        pritBr6 = true;
        br1dis = pritBr1 || true;
        br2dis = pritBr2 || true;
        br3dis = pritBr3 || true;
        br4dis = pritBr4 || true;
        br5dis = pritBr5 || true;
        br6dis = pritBr6 || true;
        
        izraz+=br6.toString();    
        izrazPoElementima.add(br6.toString());
    }
    public void pritisnutoPuta(){
        br1dis = pritBr1;
        br2dis = pritBr2;
        br3dis = pritBr3;
        br4dis = pritBr4;
        br5dis = pritBr5;
        br6dis = pritBr6;
        
        izraz+=puta;    
        izrazPoElementima.add(puta);
    }
    public void pritisnutoPodeljeno(){
        br1dis = pritBr1;
        br2dis = pritBr2;
        br3dis = pritBr3;
        br4dis = pritBr4;
        br5dis = pritBr5;
        br6dis = pritBr6;
       
        izraz+=podeljeno;
        izrazPoElementima.add(podeljeno);
    }
    public void pritisnutoPlus(){
        br1dis = pritBr1;
        br2dis = pritBr2;
        br3dis = pritBr3;
        br4dis = pritBr4;
        br5dis = pritBr5;
        br6dis = pritBr6;
       
        izraz+=plus;   
        izrazPoElementima.add(plus);
    }
    public void pritisnutoMinus(){
        br1dis = pritBr1;
        br2dis = pritBr2;
        br3dis = pritBr3;
        br4dis = pritBr4;
        br5dis = pritBr5;
        br6dis = pritBr6;
       
        izraz+=minus;  
        izrazPoElementima.add(minus);
    }
    public void pritisnutaOtvZagrada(){
        br1dis = pritBr1;
        br2dis = pritBr2;
        br3dis = pritBr3;
        br4dis = pritBr4;
        br5dis = pritBr5;
        br6dis = pritBr6;
       
        izraz+=otvZagrada;  
        izrazPoElementima.add(otvZagrada);
    }
    public void pritisnutaZatvZagrada(){
        br1dis = pritBr1;
        br2dis = pritBr2;
        br3dis = pritBr3;
        br4dis = pritBr4;
        br5dis = pritBr5;
        br6dis = pritBr6;
       
        izraz+=zatvZagrada;    
        izrazPoElementima.add(zatvZagrada);
    }
    
    public void pritisnutoObrisi(){
        
        
        if(izraz.length() == 0) {return;}
        
        String posl = izrazPoElementima.remove(izrazPoElementima.size()-1);
        
        
        //int pom = izrazPoElementima.size();
        
        //izraz = pom+" "+izrazPoElementima.toString();
        
        
        switch(posl){
            case "+":{izraz = izraz.substring(0, izraz.length()-1); return;}
            case "-":{izraz = izraz.substring(0, izraz.length()-1); return;}
            case "*":{izraz = izraz.substring(0, izraz.length()-1); return;}
            case "/":{izraz = izraz.substring(0, izraz.length()-1); return;}
            case "(":{izraz = izraz.substring(0, izraz.length()-1); return;}
            case ")":{izraz = izraz.substring(0, izraz.length()-1); return;}
            case "10":{izraz = izraz.substring(0, izraz.length()-2);sveKaoPre(); br5dis = false; pritBr5 = false; return;}
            case "15":{izraz = izraz.substring(0, izraz.length()-2);sveKaoPre(); br5dis = false; pritBr5 = false; return;}
            case "20":{izraz = izraz.substring(0, izraz.length()-2);sveKaoPre(); br5dis = false; pritBr5 = false; return;}
            case "25":{izraz = izraz.substring(0, izraz.length()-2);sveKaoPre(); br6dis = false; pritBr6 = false; return;}
            case "50":{izraz = izraz.substring(0, izraz.length()-2);sveKaoPre(); br6dis = false; pritBr6 = false; return;}
            case "75":{izraz = izraz.substring(0, izraz.length()-2);sveKaoPre(); br6dis = false; pritBr6 = false; return;}
            case "100":{izraz = izraz.substring(0, izraz.length()-3);sveKaoPre(); br6dis = false; pritBr6 = false; return;}
            
        
        }
        
        if(posl.equals(br1.toString())){
            String substring = izraz.substring(0, izraz.length()-1); 
            sveKaoPre();
            br1dis = false;
            pritBr1 = false;
            izraz = substring;
            return;
        }
        if(posl.equals(br2.toString())){
            izraz = izraz.substring(0, izraz.length()-1); 
            sveKaoPre();
            br2dis = false;
            pritBr2 = false;
            return;
        }
        if(posl.equals(br3.toString())){
            izraz = izraz.substring(0, izraz.length()-1); 
            sveKaoPre();
            br3dis = false;
            pritBr3 = false;
            return;
        }
        if(posl.equals(br4.toString())){
            izraz = izraz.substring(0, izraz.length()-1); 
            sveKaoPre();
            br4dis = false;
            pritBr4 = false;
            return;
        }
        
        
    }
    
    private void sveKaoPre(){
        br1dis = pritBr1;
        br2dis = pritBr2;
        br3dis = pritBr3;
        br4dis = pritBr4;
        br5dis = pritBr5;
        br6dis = pritBr6;
        
    }
        
    
    public void izracunajPoene(){
        try {
            br1dis = true;
            br2dis = true;
            br3dis = true;
            br4dis = true;
            br5dis = true;
            br6dis = true;
            operacije = true;
            dis = true;
            double rezultat = Counter.eval(izraz);
            
            int pom = (int)rezultat;
            if((rezultat - pom)!=0){
                brPoena = 0; //nije ceo broj
                return;
            }
            if((mojBr - pom)==1 || (pom - mojBr)==1){
                brPoena = 5;
                return;
            }
            if(mojBr == pom){
                brPoena = 10;
                return;
                
            }
            brPoena = 0;
           
            
        } catch (Exception ex) {
            //nevalidan izraz
            brPoena = 0;
 
        }       
    }
    
    public String potvrdi(){
        Date datum = Date.valueOf(LocalDate.now());
        izracunajPoene();
        
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

        brPoenaPosleMojBroj = pom;
        r.setPoeni(pom);

        session.update(r);

        session.getTransaction().commit();
        session.close();
        return Navigation.PETXPET + Navigation.FACES_REDIRECT;
    }
    
    
    public String getIzraz() {
        return izraz;
    }

    public void setIzraz(String izraz) {
        this.izraz = izraz;
    }
    
    public Integer getBr1() {
        return br1;
    }

    public void setBr1(Integer br1) {
        this.br1 = br1;
    }

    public Integer getBr2() {
        return br2;
    }

    public void setBr2(Integer br2) {
        this.br2 = br2;
    }

    public Integer getBr3() {
        return br3;
    }

    public void setBr3(Integer br3) {
        this.br3 = br3;
    }

    public Integer getBr4() {
        return br4;
    }

    public void setBr4(Integer br4) {
        this.br4 = br4;
    }

    public Integer getBr5() {
        return br5;
    }

    public void setBr5(Integer br5) {
        this.br5 = br5;
    }

    public Integer getBr6() {
        return br6;
    }

    public void setBr6(Integer br6) {
        this.br6 = br6;
    }

    public String getPodeljeno() {
        return podeljeno;
    }

    public void setPodeljeno(String podeljeno) {
        this.podeljeno = podeljeno;
    }

    public String getPuta() {
        return puta;
    }

    public void setPuta(String puta) {
        this.puta = puta;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    public String getOtvZagrada() {
        return otvZagrada;
    }

    public void setOtvZagrada(String otvZagrada) {
        this.otvZagrada = otvZagrada;
    }

    public String getZatvZagrada() {
        return zatvZagrada;
    }

    public void setZatvZagrada(String zatvZagrada) {
        this.zatvZagrada = zatvZagrada;
    }

    public String getObrisi() {
        return obrisi;
    }

    public void setObrisi(String obrisi) {
        this.obrisi = obrisi;
    }

    public boolean isBr1dis() {
        return br1dis;
    }

    public void setBr1dis(boolean br1dis) {
        this.br1dis = br1dis;
    }

    public boolean isBr2dis() {
        return br2dis;
    }

    public void setBr2dis(boolean br2dis) {
        this.br2dis = br2dis;
    }

    public boolean isBr3dis() {
        return br3dis;
    }

    public void setBr3dis(boolean br3dis) {
        this.br3dis = br3dis;
    }

    public boolean isBr4dis() {
        return br4dis;
    }

    public void setBr4dis(boolean br4dis) {
        this.br4dis = br4dis;
    }

    public boolean isBr5dis() {
        return br5dis;
    }

    public void setBr5dis(boolean br5dis) {
        this.br5dis = br5dis;
    }

    public boolean isBr6dis() {
        return br6dis;
    }

    public void setBr6dis(boolean br6dis) {
        this.br6dis = br6dis;
    }

    public boolean isOperacije() {
        return operacije;
    }

    public void setOperacije(boolean operacije) {
        this.operacije = operacije;
    }
    
    public Integer getBrPoena() {
        return brPoena;
    }

    public void setBrPoena(Integer brPoena) {
        this.brPoena = brPoena;
    }

    public boolean isDis() {
        return dis;
    }

    public void setDis(boolean dis) {
        this.dis = dis;
    }
   
    public Integer getMojBr() {
        return mojBr;
    }

    public void setMojBr(Integer mojBr) {
        this.mojBr = mojBr;
    }

    public Integer getBrPoenaPosleMojBroj() {
        return brPoenaPosleMojBroj;
    }

    public void setBrPoenaPosleMojBroj(Integer brPoenaPosleMojBroj) {
        this.brPoenaPosleMojBroj = brPoenaPosleMojBroj;
    }

    public int getTimerValue() {
        return timerValue;
    }

    public void setTimerValue(int timerValue) {
        this.timerValue = timerValue;
    }
    
    
}
