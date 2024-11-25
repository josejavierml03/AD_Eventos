package repositorioEventos;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import dominio.EspacioFisico;
import dominio.Estado;
import utils.EntityManagerHelper;

public class RepositorioEspacioAdHocJPA extends RepositorioEspacioJPA implements RepositorioEspacioAdHoc{

	@Override
	public List<EspacioFisico> buscarEspaciosLibres(LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int capacidadMinima) {
		EntityManager em = EntityManagerHelper.getEntityManager();
	    
		String queryString = "SELECT e " +
                "FROM EspacioFisico e " +
                "LEFT JOIN Evento ev ON ev.ocupacion.espacioFisico = e " +
                "WHERE e.capacidad >= :capacidadMinima " +
                "AND (ev IS NULL OR ev.ocupacion.fechaFin <= :fechaInicio OR ev.ocupacion.fechaInicio >= :fechaFin) " ;

		TypedQuery<EspacioFisico> query = em.createQuery(queryString, EspacioFisico.class);
		query.setParameter("capacidadMinima", capacidadMinima);
		query.setParameter("fechaInicio", fechaInicio);
		query.setParameter("fechaFin", fechaFin);

	    return query.getResultList();
	}

	@Override
    public boolean espacioConOcupacionesActivas(String id) {
        EntityManager em = EntityManagerHelper.getEntityManager();

        String queryString = "SELECT COUNT(e) " +
                             "FROM Evento e " +
                             "WHERE e.fechaInicio <= :now " +
                             "AND e.fechaFin >= :now " +
                             "AND e.espacioFisico.id = :id";

        TypedQuery<Long> query = em.createQuery(queryString, Long.class);
        query.setParameter("id", id);
        query.setParameter("now", LocalDateTime.now());

        Long count = query.getSingleResult();

        return count > 0;
    }

}
