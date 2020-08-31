/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entiteti.User;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
//import models.User;

/**
 *
 * @author Ana
 */
public class SessionUtils {
    
    public static void invalidateSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public static void putUser(User user) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
    }

    public static User getUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return (User) session.getAttribute("user");
    }

    public static String getUsername() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static void putUsername(String username) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
    }

}
