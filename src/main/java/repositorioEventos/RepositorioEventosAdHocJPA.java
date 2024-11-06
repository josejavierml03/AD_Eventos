package repositorioEventos;

import java.time.LocalDateTime;
import java.util.List;

import dominio.EspacioFisico;

public class RepositorioEventosAdHocJPA extends RepositorioEventosJPA implements RepositorioEventosAdHoc {

	@Override
	public List<EspacioFisico> buscarEspaciosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidadMinima) {
		return null;
	}

}
