package servicioEventos;

import java.time.LocalDateTime;
import java.util.List;

import dominio.Categoria;

public class EventoResumen {

	private String nombre;
	private String descipcion;
	private LocalDateTime fechaInicio;
	private Categoria categoria;
	private String nombreEspacioFisico;
	private String direccionEspacioFisico;
	
	@Override
	public String toString() {
		return "EventoResumen [nombre=" + nombre + ", descipcion=" + descipcion + ", fechaInicio=" + fechaInicio
				+ ", categoria=" + categoria + ", nombreEspacioFisico=" + nombreEspacioFisico
				+ ", direccionEspacioFisico=" + direccionEspacioFisico + ", nombresEspaciosCercanos="
				+ nombresEspaciosCercanos + "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescipcion() {
		return descipcion;
	}
	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getNombreEspacioFisico() {
		return nombreEspacioFisico;
	}
	public void setNombreEspacioFisico(String nombreEspacioFisico) {
		this.nombreEspacioFisico = nombreEspacioFisico;
	}
	public String getDireccionEspacioFisico() {
		return direccionEspacioFisico;
	}
	public void setDireccionEspacioFisico(String direccionEspacioFisico) {
		this.direccionEspacioFisico = direccionEspacioFisico;
	}
	public List<String> getNombresEspaciosCercanos() {
		return nombresEspaciosCercanos;
	}
	public void setNombresEspaciosCercanos(List<String> nombresEspaciosCercanos) {
		this.nombresEspaciosCercanos = nombresEspaciosCercanos;
	}
	private List<String> nombresEspaciosCercanos;
	
}
