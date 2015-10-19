/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import Controlador.Operaciones;
import ModeloHibernate.ServiciosExtras;
import ModeloHibernate.Hoteles;

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
 * @author Michael
 */
@ManagedBean
@RequestScoped
public class MbServicioExtra implements  java.io.Serializable{

    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private String mensajeErrorNombre;
    private int idServicio;
    private String nombreServicio;
    private int valorDiario;
    
    private List<SelectItem> selectOneMenuNombreHotel;
    private List<ServiciosExtras> servicios;
    private ServiciosExtras selectedServExt;

    
        
    public List<ServiciosExtras> getServicios() {
        this.servicios = oper.listaServicios();
        return servicios;
    }

    public void setServicios(List<ServiciosExtras> servicios) {
        this.servicios = servicios;
    }

    public ServiciosExtras getSelectedServExt() {
        return selectedServExt;
    }

    public void setSelectedServExt(ServiciosExtras selectedServExt) {
        this.selectedServExt = selectedServExt;
    }
    
      
    public MbServicioExtra() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest =(HttpServletRequest)faceContext.getExternalContext().getRequest();
        this.selectedServExt = new ServiciosExtras();
        
    }

    public List<SelectItem> getSelectOneMenuNombreHotel() {// get de la variable selectonemenunombrehotel creo que esta wea pude hacerla en operaciones pero no estoy seguro xD lo weno que funca
        this.selectOneMenuNombreHotel = new ArrayList<SelectItem>();// esta wea dice regundante yo pensé lo mismo pero asi funca no tocar ctm xD
        List<Hoteles> hoteles = oper.listaHoteles();// llamo al metodo que retorna una lista y lo asigno en hoteles(lista)
        for (Hoteles hotel : hoteles) {//"foreach" que deja acceder a las variables del obj del metodo en operaciones creo xD
            SelectItem selectItem = new SelectItem(hotel.getIdHotel(),hotel.getNombreHotel());// se debe crear el obj para poder usar add lo vi en una pagina qla que ahora no encuentro xD
            this.selectOneMenuNombreHotel.add(selectItem);//esta wea agrega a la variable que es llamada en el xhtml ingresarServicios
        }
        return selectOneMenuNombreHotel;// pd: esta wea creo que se hace aquí por que lo carga altoque cuando ingresa a la pagina pero no estoy seguro xD
    }

    
    

    public void setSelectOneMenuNombreHotel(List<SelectItem> selectOneMenuNombreHotel) {
        this.selectOneMenuNombreHotel = selectOneMenuNombreHotel;
    }
    

    public String getMensajeErrorNombre() {
        return mensajeErrorNombre;
    }

    public void setMensajeErrorNombre(String mensajeErrorNombre) {
        this.mensajeErrorNombre = mensajeErrorNombre;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(int valorDiario) {
        this.valorDiario = valorDiario;
    }

    
    
    Operaciones oper = new Operaciones();
    boolean respuesta = false;
    public void insertar()
    {
        ServiciosExtras serExt = new ServiciosExtras(getIdServicio(), getSelectedServExt().getHoteles(), getNombreServicio(), getValorDiario());
        respuesta = oper.insertarSerExt(serExt);
        if(respuesta == true){
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Ingresado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
        }
        else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido ingresar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
                
    }
    
    public void modificarSerExt(ActionEvent actionEvent)
    {
        
        respuesta = oper.modificarSerExt(selectedServExt);
        if(respuesta == true){
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro modificado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
            
        }
        else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido modificar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
                
    }
    
    public void eliminarSerExt(ActionEvent actionEvent){
        respuesta = oper.eliminarSerExt(selectedServExt.getIdServExt());
        if (respuesta == true) {
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Eliminado Exitosamente", null);
            faceContext.addMessage(null, facesMessage);
        }else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, no se ha podido eliminar el registro", null);
            faceContext.addMessage(null, facesMessage);
        }
    }
    
}
