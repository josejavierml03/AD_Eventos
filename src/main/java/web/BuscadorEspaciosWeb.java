package web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dto.EspacioFisicoDTO;
import servicioEventos.IServicioEspacios;
import servicio.FactoriaServicios;

@SuppressWarnings("serial")
@Named("buscadorEspaciosWeb")
@ViewScoped
public class BuscadorEspaciosWeb implements Serializable {

    private IServicioEspacios servicioEspacios;
    private List<EspacioFisicoDTO> espacios;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer capacidadMinima;
    
    @Inject
    private FacesContext facesContext;

    public BuscadorEspaciosWeb() {
        servicioEspacios = FactoriaServicios.getServicio(IServicioEspacios.class);
    }

    @PostConstruct
    public void init() {
        espacios = new ArrayList<>();
    }

    public void buscarEspacios() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (fechaInicio != null && fechaFin != null && fechaInicio.isAfter(fechaFin)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error en las fechas", "La fecha de inicio no puede ser posterior a la fecha de fin."));
            return;
        }

        try {
            espacios = servicioEspacios.buscarEspaciosFisicosLibres(fechaInicio, fechaFin, capacidadMinima);
            if (espacios == null || espacios.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Sin resultados", "No se encontraron espacios disponibles para los criterios dados."));
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al buscar espacios", "Hubo un problema al intentar realizar la búsqueda."));
        }
    }

    public List<EspacioFisicoDTO> getEspacios() {
        return espacios;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCapacidadMinima() {
        return capacidadMinima;
    }

    public void setCapacidadMinima(Integer capacidadMinima) {
        this.capacidadMinima = capacidadMinima;
    }
}
