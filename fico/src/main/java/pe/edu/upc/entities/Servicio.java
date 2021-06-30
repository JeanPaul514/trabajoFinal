package pe.edu.upc.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "Servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "nameServicio", nullable = false, length = 50)
	private String nameServicio;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "categoriaServicio", nullable = false, length = 50)
	private String categoriaServicio;

	public Servicio(int idServicio, String nameServicio, String categoriaServicio) {
		super();
		this.idServicio = idServicio;
		this.nameServicio = nameServicio;
		this.categoriaServicio = categoriaServicio;
	}

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNameServicio() {
		return nameServicio;
	}

	public void setNameServicio(String nameServicio) {
		this.nameServicio = nameServicio;
	}

	public String getCategoriaServicio() {
		return categoriaServicio;
	}

	public void setCategoriaServicio(String categoriaServicio) {
		this.categoriaServicio = categoriaServicio;
	}

	
}
