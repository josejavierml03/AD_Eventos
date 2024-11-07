package dominio;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import repositorio.Identificable;
@Entity
public class Evento implements Identificable{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private String id;
    private String nombre;
    @Lob
    private String descripcion;
    private String organizador;
    private int plazas;
    private boolean cancelado;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Embedded
    private Ocupacion ocupacion;

    public Evento(String id, String nombre, String descripcion, String organizador, int plazas, boolean cancelado, Categoria categoria, Ocupacion ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.organizador = organizador;
        this.plazas = plazas;
        this.cancelado = cancelado;
        this.categoria = categoria;
        this.ocupacion = ocupacion;
    }
    
    public Evento() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}
    
}
