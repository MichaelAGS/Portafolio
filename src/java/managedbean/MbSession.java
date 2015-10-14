/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 */
@ManagedBean
@RequestScoped
public class MbSession {

    /**
     * Creates a new instance of MbSession
     */
    private String usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    
    public MbSession() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest =(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUSuario") != null)
        {
            usuario = httpServletRequest.getSession().getAttribute("sessionUSuario").toString();
        }
    }
    
    public String cerrarSession()
    {
        httpServletRequest.getSession().removeAttribute("sessionUSuario");
        facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada correctamente", null);
            faceContext.addMessage(null, facesMessage);
        return "login.xhtml";
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    
}
