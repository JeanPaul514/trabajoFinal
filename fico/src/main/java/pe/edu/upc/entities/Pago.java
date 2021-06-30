package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MedicCenter")
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "namePago", nullable = false, length = 50)
	private String namePago;

	@NotNull(message = "Ingrese nombre")
	@Past(message = "La fecha de creación debe ser pasada")
	@Temporal(TemporalType.DATE)
	@Column(name = "birthDateMedicCenter")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDatePago;


	@Positive
	@Column(name = "montoPago", columnDefinition = "Decimal(8,2)", nullable = false)
	private Double montoPago;

	public Pago(int idPago, String namePago, Date birthDatePago, Double montoPago) {
		super();
		this.idPago = idPago;
		this.namePago = namePago;
		this.birthDatePago = birthDatePago;
		this.montoPago = montoPago;
	}

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public String getNamePago() {
		return namePago;
	}

	public void setNamePago(String namePago) {
		this.namePago = namePago;
	}

	public Date getBirthDatePago() {
		return birthDatePago;
	}

	public void setBirthDatePago(Date birthDatePago) {
		this.birthDatePago = birthDatePago;
	}

	

	public Double getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

}
