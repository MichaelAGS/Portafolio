/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Controlador.Operaciones;
import ModeloHibernate.Pais;
import ModeloHibernate.Pasajeros;
import ModeloHibernate.Usuario;
import java.util.ArrayList;
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
public class MbPasajeros implements java.io.Serializable{

   private Pasajeros selectedPasajero;
   private List<SelectItem> selectOneMenuPais;
   private List<Pasajeros> pasajero;
   private final HttpServletRequest httpServletRequest;
   private final FacesContext faceContext;
   private FacesMessage facesMessage;
   
   
   Operaciones oper = new Operaciones();
   
    public MbPasajeros() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest =(HttpServletRequest)faceContext.getExternalContext().getRequest();
        this.selectedPasajero = new Pasajeros();
    }

    public Pasajeros getSelectedPasajero() {
        return selectedPasajero;
    }

    public void setSelectedPasajero(Pasajeros selectedPasajero) {
        this.selectedPasajero = selectedPasajero;
    }

    public List<SelectItem> getSelectOneMenuPais() {
        this.selectOneMenuPais = new ArrayList<SelectItem>();
        List<Pais> paises = oper.listaPaises();
        for(Pais pa : paises)
        {
            SelectItem selectItem = new SelectItem(pa.getIdPais(),pa.getNombrePais());
           this.selectOneMenuPais.add(selectItem);
        }
        
        return selectOneMenuPais;
    }

    public void setSelectOneMenuPais(List<SelectItem> selectOneMenuPais) {
        this.selectOneMenuPais = selectOneMenuPais;
    }

    public List<Pasajeros> getPasajero() {
        this.pasajero = oper.listaPasajeros();
        return pasajero;
    }

    public void setPasajero(List<Pasajeros> pasajero) {
        this.pasajero = pasajero;
    }
    
    
    boolean respuesta = true;
    public void insertarPasajero()
    {
       
        respuesta = oper.insertarPasajero(selectedPasajero);
        if(respuesta == true){
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
            
        }
        else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido insertar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
    }
    
    
    public void eliminarPasajeros(ActionEvent actionEvent){
        respuesta = oper.eliminarPasajero(selectedPasajero.getIdPas());
        if (respuesta == true) {
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Eliminado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
        }else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido eliminar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
    }
    
    
    public void modificarPasajero(ActionEvent actionEvent)
    {
        
        respuesta = oper.modificarPasajeros(selectedPasajero);
        if(respuesta == true){
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro modificado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
            
        }
        else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido modificar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
                
    }
    
}
