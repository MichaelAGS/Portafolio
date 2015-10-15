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
public class MbServicioExtra {

    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private String mensajeErrorNombre;
    private int idServicio;
    private String nombreServicio;
    private int valorDiario;
    private int idHotel;
    
    
    public MbServicioExtra() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest =(HttpServletRequest)faceContext.getExternalContext().getRequest();
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

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    
    
}
