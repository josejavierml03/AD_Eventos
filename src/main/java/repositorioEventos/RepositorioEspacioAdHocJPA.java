package repositorioEventos;

import java.time.LocalDateTime;
import java.util.List;

import dominio.EspacioFisico;

public class RepositorioEspacioAdHocJPA extends RepositorioEspacioJPA implements RepositorioEspacioAdHoc{

	@Override
	public List<EspacioFisico> buscarEspaciosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidadMinima) {
		return null;
	}

	
}
