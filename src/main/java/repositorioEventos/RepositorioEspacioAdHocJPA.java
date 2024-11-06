package repositorioEventos;

import java.util.List;

import dominio.EspacioFisico;

public class RepositorioEspacioAdHocJPA extends RepositorioEspacioJPA implements RepositorioEspacioAdHoc{

	@Override
	public List<EspacioFisico> eventoMes(int año, int mes) {
		return null;
	}

}
