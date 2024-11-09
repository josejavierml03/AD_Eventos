package servicioEventos;

import java.time.LocalDateTime;
import java.util.List;

import dominio.EspacioFisico;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import dominio.Categoria;

public interface IServicioEventos {
	
	void altaEvento (String nombre, String descripcion, String organizador, Categoria categoria, LocalDateTime fechaInicio, LocalDateTime fechaFin, int plazas, String idEspacio) throws RepositorioException, EntidadNoEncontrada;
	
	void modificarEvento(String id,LocalDateTime fechaInicio, LocalDateTime fechaFin, int plazas, EspacioFisico espacioFisico) throws RepositorioException, EntidadNoEncontrada;
	
	void cancelarEvento(String id) throws RepositorioException, EntidadNoEncontrada;
	
	List<EventoResumen> eventosDelMes(int mes, int año) throws RepositorioException;

}
