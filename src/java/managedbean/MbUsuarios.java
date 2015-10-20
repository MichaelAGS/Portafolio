/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Controlador.Operaciones;
import ModeloHibernate.Perfil;
import ModeloHibernate.ServiciosExtras;
import ModeloHibernate.Usuario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Snackill
 */
@ManagedBean
@RequestScoped
public class MbUsuarios implements  java.io.Serializable{

 
    private Usuario selectedUsuario;
    private List<SelectItem> selectOneMenuNombrePerfil;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private List<Usuario> Usuarios;

    public List<Usuario> getUsuarios() {
        this.Usuarios = oper.listaUsuarios();
        return Usuarios;
    }

    public void setUsuarios(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }
    
    
    Operaciones oper = new Operaciones();
    public MbUsuarios() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest =(HttpServletRequest)faceContext.getExternalContext().getRequest();
        this.selectedUsuario = new Usuario();
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public List<SelectItem> getSelectOneMenuNombrePerfil() {
        this.selectOneMenuNombrePerfil = new ArrayList<SelectItem>();// esta wea dice regundante yo pensé lo mismo pero asi funca no tocar ctm xD
        List<Perfil> perfiles = oper.listaPerfiles();// llamo al metodo que retorna una lista y lo asigno en hoteles(lista)
        for (Perfil per : perfiles) {//"foreach" que deja acceder a las variables del obj del metodo en operaciones creo xD
            SelectItem selectItem = new SelectItem(per.getIdPerfil(),per.getTipoPerfil());// se debe crear el obj para poder usar add lo vi en una pagina qla que ahora no encuentro xD
            this.selectOneMenuNombrePerfil.add(selectItem);//esta wea agrega a la variable que es llamada en el xhtml ingresarServicios
        }
        return selectOneMenuNombrePerfil;
    }

    public void setSelectOneMenuNombrePerfil(List<SelectItem> selectOneMenuNombrePerfil) {
        this.selectOneMenuNombrePerfil = selectOneMenuNombrePerfil;
    }
    
    boolean respuesta = true;
    public void insertarUsuario()
    {
       
        respuesta = oper.insertarUsuario(selectedUsuario);
        if(respuesta == true){
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
            
        }
        else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido insertar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
               
        
        
    }
    
     public void modificarUsuarios(ActionEvent actionEvent)
    {
        
        respuesta = oper.modificarUsuarios(selectedUsuario);
        if(respuesta == true){
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro modificado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
            
        }
        else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido modificar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
                
    }
   
    public void eliminarUser(ActionEvent actionEvent){
        respuesta = oper.eliminarUsuario(selectedUsuario.getIdUsuario());
        if (respuesta == true) {
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Eliminado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
        }else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido eliminar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
    }
    
}
