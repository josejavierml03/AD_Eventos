package servicioEventos;

import java.time.LocalDateTime;
import java.util.List;

import dominio.EspacioFisico;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import dominio.Categoria;

public interface IServicioEventos {
	
	void altaEvento (String nombre, String desciprcion, String organizador, Categoria categoria, LocalDateTime fechaIncio, LocalDateTime fechaFin, int plazas, String id) throws RepositorioException;
	
	void modificarEvento(String id,LocalDateTime fechaInicio, LocalDateTime fechaFin, int plazas, EspacioFisico espacioFisico) throws RepositorioException, EntidadNoEncontrada;
	
	void cancelarEvento(String id) throws RepositorioException, EntidadNoEncontrada;
	
	List<EventoResumen> eventosDelMes(int mes, int año) throws RepositorioException;

}
