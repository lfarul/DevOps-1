package app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity // encja
@Table(name="projekt") // tutaj okreœlam nazwê tabeli - projekt

public class Projekt {
	
	@Id // To jest primary key
	@GeneratedValue
	@Column(name="projekt_id") // tutaj okreœlam nazwê kolumny kiedy jest inna ni¿ okreœlona w zmiennej
	private Integer projektId;
	
	@Column(nullable = false, length = 50)
	private String nazwa;
	
	@Column(length = 1000)
	private String opis;
	
	@Column(nullable = false)
	private LocalDateTime dataczas_utworzenia;
	
	@Column
	private LocalDate data_oddania;
	
	public Integer getProjektId() {
		return projektId;
	}

	public void setProjektId(Integer projektId) {
		this.projektId = projektId;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public LocalDateTime getDataczas_utworzenia() {
		return dataczas_utworzenia;
	}

	public void setDataczas_utworzenia(LocalDateTime dataczas_utworzenia) {
		this.dataczas_utworzenia = dataczas_utworzenia;
	}

	public LocalDate getData_oddania() {
		return data_oddania;
	}

	public void setData_oddania(LocalDate data_oddania) {
		this.data_oddania = data_oddania;
	}
	
	@OneToMany(mappedBy = "projekt")
	private List <Zadanie> zadania;
	
	@ManyToMany
	@JoinTable(name = "projekt_student",
	joinColumns = {@JoinColumn(name="projekt_id")},
	inverseJoinColumns = {@JoinColumn(name="student_id")})
	private Set<Student> studenci;

	public List<Zadanie> getZadania() {
		return zadania;
	}

	public void setZadania(List<Zadanie> zadania) {
		this.zadania = zadania;
	}

	public Set<Student> getStudenci() {
		return studenci;
	}

	public void setStudenci(Set<Student> studenci) {
		this.studenci = studenci;
	}
	
	

}
