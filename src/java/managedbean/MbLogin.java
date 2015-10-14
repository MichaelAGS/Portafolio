/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Controlador.Operaciones;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@RequestScoped
public class MbLogin {

    private String usuario;
    private String pass;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private String mensajeErrorNombre;
    
    

    public String getMensajeErrorNombre() {
        return mensajeErrorNombre;
    }

    public void setMensajeErrorNombre(String mensajeErrorNombre) {
        this.mensajeErrorNombre = mensajeErrorNombre;
    }
   
    public MbLogin() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest =(HttpServletRequest)faceContext.getExternalContext().getRequest();
    }
    
    
    
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    
    public void validateEmail(AjaxBehaviorEvent evento) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(usuario);
        if(matcher.matches() == false){
            mensajeErrorNombre = "Ejemplo : aaaaaaa@aaaaaa.aa";
        }
        else{
            mensajeErrorNombre="";
        }
 
    }
    
    /*
    public void validarNombre(AjaxBehaviorEvent evento) {
        if (usuario.length() < 1) {
            mensajeErrorNombre = "El nombre tiene que tener como minimo 2 caracteres";
        } else {
            if (usuario.length() > 10) {
                mensajeErrorNombre = "El nombre puede tener como maximo 10 caracteres";
            } else {
                mensajeErrorNombre = "";
            }
        }
    }*/
   
    Operaciones oper = new Operaciones();
    boolean respuesta = false;
    public String login()
    {
        respuesta = oper.validarUsuario(usuario, pass);
        
        if(respuesta == true)
        {
            httpServletRequest.getSession().setAttribute("sessionUSuario",usuario);
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
            faceContext.addMessage(null, facesMessage);
            return "index";
        }
        else
        {
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecta", null);
            faceContext.addMessage(null, facesMessage);
            return "login";
        }
    }
    
    
 
    
 

    

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
