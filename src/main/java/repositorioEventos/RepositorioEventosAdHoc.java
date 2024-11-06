package repositorioEventos;

import java.time.LocalDateTime;
import java.util.List;
import dominio.EspacioFisico;

public interface RepositorioEventosAdHoc {
	
	public List<EspacioFisico> buscarEspaciosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin, int capacidadMinima);
}
