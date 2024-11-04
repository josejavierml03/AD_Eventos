package dominio;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ocupacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    // Falta la relacion
    private EspacioFisico espacioFisico;
    private boolean activa;
    
    public Ocupacion(LocalDateTime fechaInicio, LocalDateTime fechaFin, EspacioFisico espacioFisico) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.espacioFisico = espacioFisico;
        this.activa = calcularActiva(); 
    }
    
    private boolean calcularActiva() {
        LocalDateTime ahora = LocalDateTime.now();
        return !fechaInicio.isAfter(ahora) && !fechaFin.isBefore(ahora);
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

	public EspacioFisico getEspacioFisico() {
		return espacioFisico;
	}

	public void setEspacioFisico(EspacioFisico espacioFisico) {
		this.espacioFisico = espacioFisico;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	
	
}
