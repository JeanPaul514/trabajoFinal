package pe.edu.upc.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "TipoMembresia")
public class TipoMembresia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoMembresia;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "nameTipoMembresia", nullable = false, length = 50)
	private String nameTipoMembresia;
	@Positive
	@Column(name = "priceTipoMembresia", columnDefinition = "Decimal(8,2)", nullable = false)
	private Double priceTipoMembresia;
	


	public TipoMembresia(int idTipoMembresia, String nameTipoMembresia, Double priceTipoMembresia) {
		super();
		this.idTipoMembresia = idTipoMembresia;
		this.nameTipoMembresia = nameTipoMembresia;
		this.priceTipoMembresia = priceTipoMembresia;

	}

	public TipoMembresia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoMembresia() {
		return idTipoMembresia;
	}

	public void setIdTipoMembresia(int idTipoMembresia) {
		this.idTipoMembresia = idTipoMembresia;
	}

	public String getNameTipoMembresia() {
		return nameTipoMembresia;
	}

	public void setNameTipoMembresia(String nameTipoMembresia) {
		this.nameTipoMembresia = nameTipoMembresia;
	}
	public Double getPriceTipoMembresia() {
		return priceTipoMembresia;
	}

	public void setPriceTipoMembresia(Double priceTipoMembresia) {
		this.priceTipoMembresia = priceTipoMembresia;
	}
	
}
