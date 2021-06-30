package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "MembresiaDetails")
public class MembresiaDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembresiaDetails;

	@ManyToOne
	@JoinColumn(name = "idTipoMembresia", nullable = false)
	private TipoMembresia tipoMembresia;

	@Positive(message = "El monto debe de ser positivo")
	@Column(name = "quantity", nullable = false)
	private int quantity;

	public Double calcularSubTotal() {
		return quantity * tipoMembresia.getPriceTipoMembresia();
	}

	public Long getIdMembresiaDetails() {
		return idMembresiaDetails;
	}

	public void setIdMembresiaDetails(Long idMembresiaDetails) {
		this.idMembresiaDetails = idMembresiaDetails;
	}

	public TipoMembresia getTipoMembresia() {
		return tipoMembresia;
	}

	public void setTipoMembresia(TipoMembresia tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
