package pe.edu.upc.entities;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Membresia")
public class Membresia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembresia;

	@Column(name = "requestDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;// cuando se pidio

	@NotNull(message = "La fecha es obligatoria")
	@Future(message = "La fecha debe estar en el futuro")
	@Column(name = "deliveryDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;// cuando se quiere que se entrege

	@Column(name = "shippedDate", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippedDate;// dia de entrega

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idTipoMembresia", nullable = true)
	private List<MembresiaDetails> membresiaDetails;

	@PrePersist
	public void prePersist() {
		this.requestDate = new Date();
	}

	public Double getTotal() {
		return membresiaDetails.stream().collect(Collectors.summingDouble(MembresiaDetails::calcularSubTotal));
	}

	public void addDetailMembresia(MembresiaDetails item) {
		this.membresiaDetails.add(item);
	}

	public Long getIdMembresia() {
		return idMembresia;
	}

	public void setIdMembresia(Long idMembresia) {
		this.idMembresia = idMembresia;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public List<MembresiaDetails> getMembresiaDetails() {
		return membresiaDetails;
	}

	public void setMembresiaDetails(List<MembresiaDetails> membresiaDetails) {
		this.membresiaDetails = membresiaDetails;
	}

}
