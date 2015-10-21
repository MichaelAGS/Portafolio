package ModeloHibernate;
// Generated 20-10-2015 20:40:28 by Hibernate Tools 4.3.1



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pasajeros generated by hbm2java
 */
public class Pasajeros  implements java.io.Serializable {


     private int idPas;
     private Pais pais;
     private String rutPas;
     private String nombrePas;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String sexo;
     private String nacionalidad;
     private String residenciaActual;
     private Date fechaNacimiento;
     private String regionNacimiento;
     private int telefono;
     private String email;
     private Set habitacioneses = new HashSet(0);

    public Pasajeros() {
        this.idPas = 0;
        this.pais = new Pais();
    }

	
    public Pasajeros(int idPas, String rutPas, String nombrePas, String apellidoPaterno, String apellidoMaterno, String sexo, String nacionalidad, String residenciaActual, Date fechaNacimiento, String regionNacimiento, int telefono, String email) {
        this.idPas = idPas;
        this.rutPas = rutPas;
        this.nombrePas = nombrePas;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.residenciaActual = residenciaActual;
        this.fechaNacimiento = fechaNacimiento;
        this.regionNacimiento = regionNacimiento;
        this.telefono = telefono;
        this.email = email;
    }
    public Pasajeros(int idPas, Pais pais, String rutPas, String nombrePas, String apellidoPaterno, String apellidoMaterno, String sexo, String nacionalidad, String residenciaActual, Date fechaNacimiento, String regionNacimiento, int telefono, String email, Set habitacioneses) {
       this.idPas = idPas;
       this.pais = pais;
       this.rutPas = rutPas;
       this.nombrePas = nombrePas;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.sexo = sexo;
       this.nacionalidad = nacionalidad;
       this.residenciaActual = residenciaActual;
       this.fechaNacimiento = fechaNacimiento;
       this.regionNacimiento = regionNacimiento;
       this.telefono = telefono;
       this.email = email;
       this.habitacioneses = habitacioneses;
    }
   
    public int getIdPas() {
        return this.idPas;
    }
    
    public void setIdPas(int idPas) {
        this.idPas = idPas;
    }
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public String getRutPas() {
        return this.rutPas;
    }
    
    public void setRutPas(String rutPas) {
        this.rutPas = rutPas;
    }
    public String getNombrePas() {
        return this.nombrePas;
    }
    
    public void setNombrePas(String nombrePas) {
        this.nombrePas = nombrePas;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getResidenciaActual() {
        return this.residenciaActual;
    }
    
    public void setResidenciaActual(String residenciaActual) {
        this.residenciaActual = residenciaActual;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getRegionNacimiento() {
        return this.regionNacimiento;
    }
    
    public void setRegionNacimiento(String regionNacimiento) {
        this.regionNacimiento = regionNacimiento;
    }
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getHabitacioneses() {
        return this.habitacioneses;
    }
    
    public void setHabitacioneses(Set habitacioneses) {
        this.habitacioneses = habitacioneses;
    }




}


