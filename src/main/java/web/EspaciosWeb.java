package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import servicioEventos.IServicioEspacios;
import dominio.EspacioFisico;
import servicio.FactoriaServicios;

@SuppressWarnings("serial")
@Named("espaciosWeb")
@ViewScoped
public class EspaciosWeb implements Serializable {
	
	private IServicioEspacios servicioEspacios;
    private List<EspacioFisico> espacios;
    private String propietario;
    
    public EspaciosWeb() {
    	servicioEspacios = FactoriaServicios.getServicio(IServicioEspacios.class);
    }
    
    @PostConstruct
    public void init() {
        propietario = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("propietario");

        System.out.println("Propietario recibido: " + propietario);

        if (propietario != null && !propietario.isEmpty()) {
            cargarEspacios();
        } else {
            espacios = new ArrayList<>();
        }
    }


    
    public void cargarEspacios() {
        try {
            espacios = servicioEspacios.obtenerEspaciosPorPropietario(propietario);
            if (espacios == null) {
                espacios = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar espacios: " + e.getMessage());
        }
    }
    
    public void darDeBaja(EspacioFisico espacio) {
        try {
            servicioEspacios.darDeBajaEspacioFisico(espacio.getId());
            cargarEspacios();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al dar de baja el espacio: " + e.getMessage());
        }
    }

    public void activar(EspacioFisico espacio) {
        try {
            servicioEspacios.activarEspacioFisico(espacio.getId());
            cargarEspacios();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al activar el espacio: " + e.getMessage());
        }
    }


    public List<EspacioFisico> getEspacios() {
        return espacios;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getPropietario() {
        return propietario;
    }
}
