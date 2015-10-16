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
import javax.faces.model.SelectItem;
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
    private Hoteles hotel;
    private String nombreServicio;
    private int valorDiario;
    private String nombreHotel;
    private List<SelectItem> selectOneMenuNombreHotel;
    
    
    
    public MbServicioExtra() {
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest =(HttpServletRequest)faceContext.getExternalContext().getRequest();
    }

    public List<SelectItem> getSelectOneMenuNombreHotel() {// get de la variable selectonemenunombrehotel creo que esta wea pude hacerla en operaciones pero no estoy seguro xD lo weno que funca
        this.selectOneMenuNombreHotel = new ArrayList<SelectItem>();// esta wea dice regundante yo pensé lo mismo pero asi funca no tocar ctm xD
        List<Hoteles> hoteles = oper.listaHoteles();// llamo al metodo que retorna una lista y lo asigno en hoteles(lista)
        for (Hoteles hotel : hoteles) {//"foreach" que deja acceder a las variables del obj del metodo en operaciones creo xD
            SelectItem selectItem = new SelectItem(hotel.getNombreHotel());// se debe crear el obj para poder usar add lo vi en una pagina qla que ahora no encuentro xD
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

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }
    
    Operaciones oper = new Operaciones();
    boolean respuesta = false;
    public void insertar()
    {
        ServiciosExtras serExt = new ServiciosExtras(idServicio, hotel, nombreServicio, valorDiario);
        respuesta = oper.insertarSerExt(serExt);
        if(respuesta == true){
            mensajeErrorNombre = "Ingresado correctamente";
        }
        else{
            mensajeErrorNombre = "no se ingreso";
        }
                
    }
    
}
