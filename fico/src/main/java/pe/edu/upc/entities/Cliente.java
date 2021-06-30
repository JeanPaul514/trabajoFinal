package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "nameCliente", nullable = false, length = 50)
	private String nameCliente;
	
	@NotEmpty(message = "Ingrese email")
	@Email
	@Column(name = "emailCliente", nullable = false, length = 50)
	private String emailCliente;
	@ManyToOne
	@JoinColumn(name = "idTarjeta", nullable = false)
	private Tarjeta tarjeta;
	
	@NotEmpty(message = "Ingrese telefono")
	@Size(min = 9, max = 9)
	@Digits(integer = 9, fraction = 0)
	@Column(name = "telefonoCliente", nullable = false, length = 50)
	private String telefonoCliente;
	
	@NotEmpty(message = "Ingrese dni")
	@Size(min = 8, max = 8)
	@Digits(integer = 8, fraction = 0)
	@Column(name = "dniCliente", nullable = false, length = 50)
	private String dniCliente;
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, String nameCliente, Tarjeta tarjeta, String emailCliente,
			String telefonoCliente, String dniCliente) {
		super();
		this.idCliente = idCliente;
		this.nameCliente = nameCliente;
		this.emailCliente = emailCliente;
		this.telefonoCliente = telefonoCliente;
		this.dniCliente= dniCliente;
		this.tarjeta = tarjeta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNameCliente() {
		return nameCliente;
	}

	public void setNameCliente(String nameCliente) {
		this.nameCliente = nameCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

}
