package dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import repositorio.Identificable;
@Entity
public class EspacioFisico implements Identificable {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private String id;
    private String nombre;
    private String propietario;
    private int capacidad;
    private String direccion;
    private double longitud;
    private double latitud;
    @OneToMany
    private List<PuntoDeInteres> puntosDeInteres;
    @Lob
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public EspacioFisico(String id, String nombre, String propietario, int capacidad, String direccion,
    		double longitud, double latitud, List<PuntoDeInteres> puntosDeInteres,
                         String descripcion, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.capacidad = capacidad;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.puntosDeInteres = puntosDeInteres;
        this.descripcion = descripcion;
        this.estado = estado;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public List<PuntoDeInteres> getPuntosDeInteres() {
		return puntosDeInteres;
	}

	public void setPuntosDeInteres(List<PuntoDeInteres> puntosDeInteres) {
		this.puntosDeInteres = puntosDeInteres;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
    
}
