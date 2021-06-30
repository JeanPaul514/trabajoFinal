package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Asesor")
public class Asesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsesor;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "nameAsesor", nullable = false, length = 50)
	private String nameAsesor;


	@NotEmpty(message = "Ingrese email")
	@Email
	@Column(name = "emailAsesor", nullable = false, length = 50)
	private String emailAsesor;

	@NotEmpty(message = "Ingrese Telefono")
	@Size(min = 9, max = 9)
	@Digits(integer = 9, fraction = 0)
	@Column(name = "telefonoAsesor", nullable = false, length = 50)
	private String telefonoAsesor;

	public Asesor(int idAsesor, String nameAsesor, String emailAsesor,
			String telefonoAsesor) {
		super();
		this.idAsesor = idAsesor;
		this.nameAsesor = nameAsesor;
		this.emailAsesor = emailAsesor;
		this.telefonoAsesor = telefonoAsesor;
	}

	public Asesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAsesor() {
		return idAsesor;
	}

	public void setIdAsesor(int idAsesor) {
		this.idAsesor = idAsesor;
	}

	public String getNameAsesor() {
		return nameAsesor;
	}

	public void setNameAsesor(String nameAsesor) {
		this.nameAsesor = nameAsesor;
	}

	

	public String getEmailAsesor() {
		return emailAsesor;
	}

	public void setEmailAsesor(String emailAsesor) {
		this.emailAsesor = emailAsesor;
	}

	public String getTelefonoAsesor() {
		return telefonoAsesor;
	}

	public void setTelefonoAsesor(String telefonoAsesor) {
		this.telefonoAsesor = telefonoAsesor;
	}

}
