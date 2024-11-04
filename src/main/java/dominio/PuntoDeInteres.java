package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PuntoDeInteres {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nombre;
    private String descripcion;
    private double distancia;
    private String urlAWikipedia;
    
    public PuntoDeInteres(String nombre, String descripcion, double distancia, String urlAWikipedia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.distancia = distancia;
        this.urlAWikipedia = urlAWikipedia;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getUrlAWikipedia() {
		return urlAWikipedia;
	}

	public void setUrlAWikipedia(String urlAWikipedia) {
		this.urlAWikipedia = urlAWikipedia;
	}
    
}
