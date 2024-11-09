package programa;

import dominio.Evento;
import dominio.EspacioFisico;
import repositorioEventos.RepositorioEspacioAdHoc;
import repositorioEventos.RepositorioEventosAdHoc;
import repositorio.FactoriaRepositorios;
import java.time.LocalDateTime;
import java.util.List;

public class Pruebas {
    public static void main(String[] args) throws Exception  {
    	RepositorioEventosAdHoc ea=  FactoriaRepositorios.getRepositorio(Evento.class);
    	RepositorioEspacioAdHoc eb=  FactoriaRepositorios.getRepositorio(EspacioFisico.class);
        try {
        	LocalDateTime fecha = LocalDateTime.of(2024, 11, 10, 10, 0);
        	LocalDateTime fechab = LocalDateTime.of(2024, 11, 10, 12, 0);
            List<EspacioFisico> a = eb.buscarEspaciosLibres(fecha, fechab, 50);
            if (a.isEmpty()) {
            	System.out.println("No hay espacios fisicos disponibles");
            }else {
            	System.out.println(a.get(0).getDescripcion());
            }
            List<Evento> b = ea.getEventosDelMes(10,2024);
            if (b.isEmpty()) {
            	System.out.println("No hay eventos este mes");
            }else {
            	System.out.println(b.get(0).getOcupacion().getEspacioFisico().getId());
            }
        } catch (Exception e) {
            System.err.println("Excepción inesperada: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
