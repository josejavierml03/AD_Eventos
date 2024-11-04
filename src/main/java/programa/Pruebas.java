package programa;

import dominio.Categoria;
import dominio.Evento;
import dominio.EspacioFisico;
import dominio.Estado;
import dominio.Ocupacion;
import dominio.PuntoDeInteres;
import repositorio.Repositorio;
import repositorio.RepositorioException;
import repositorio.EntidadNoEncontrada;
import repositorio.FactoriaRepositorios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Pruebas {
    public static void main(String[] args) throws Exception  {
        try {
        	
            Repositorio<Evento, String> repositorioEvento = FactoriaRepositorios.getRepositorio(Evento.class);
            Repositorio<EspacioFisico, String> repositorioEspacio = FactoriaRepositorios.getRepositorio(EspacioFisico.class);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos");

            List<PuntoDeInteres> puntosDeInteres = new ArrayList<>();
            puntosDeInteres.add(new PuntoDeInteres("Entrada principal", "Entrada ubicada al frente del edificio", 10.0, "https://es.wikipedia.org/wiki/Entrada_principal"));
            puntosDeInteres.add(new PuntoDeInteres("Salida de emergencia", "Salida en el lado norte del auditorio", 15.5, "https://es.wikipedia.org/wiki/Salida_de_emergencia"));
            EspacioFisico espacioFisico = new EspacioFisico(
                    "1",
                    "Auditorio",
                    "Universidad",
                    300,
                    "Av. Principal 123",
                    -58.37723,
                    -34.61315,
                    puntosDeInteres,
                    "Auditorio principal para eventos universitarios",
                    Estado.ACTIVO
                );
            repositorioEspacio.add(espacioFisico);

            LocalDateTime fechaInicio = LocalDateTime.of(2024, 11, 10, 15, 0);
            LocalDateTime fechaFin = LocalDateTime.of(2024, 11, 10, 18, 0);
            Ocupacion ocupacion = new Ocupacion(fechaInicio, fechaFin, espacioFisico);

            Evento evento = new Evento(null, "Concierto de Rock", "Concierto de banda local", "Juan Pérez", 200, false, Categoria.ACADEMICOS, ocupacion);

            String idGenerado = repositorioEvento.add(evento);
            System.out.println("Evento agregado con ID: " + idGenerado);

            Evento eventoRecuperado = repositorioEvento.getById(idGenerado);
            System.out.println("Evento recuperado: " + eventoRecuperado.getNombre());
            System.out.println("Ocupación en el espacio: " + eventoRecuperado.getOcupacion().getEspacioFisico().getNombre());

       
        } catch (Exception e) {
            System.err.println("Excepción inesperada: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
