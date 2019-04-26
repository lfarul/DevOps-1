package app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import java.util.Set;
import javax.persistence.Column;

@Entity // encja
@Table(name="student") // tutaj okre�lam nazw� tabeli - student

public class Student {
	
	// Tworz� tabel�
	
	// Dodaj� do tabeli student kolumn� - student_id - primary key
	@Id // to b�dzie primary key
	@GeneratedValue
	@Column(name = "student_id")
	private String studentId;
	
	// Dodaj� do tabeli student kolumn� - imi�. Kolumna nie mo�eby� pusta i ma d�ugo�� 50 znak�w
	@Column (nullable = false, length = 50)
	private String imie;
	
	// Dodaj� do tabeli kolumn� - nazwisko. Kolumna nie mo�e by� pusta i ma d�ugo�� 100 znak�w
	@Column(nullable = false, length = 100)
	private String nazwisko;
	
	// Dodaj� do tabeli kolumn� - nr_indeksu. Kolumna nie mo�e by� pusta i ma d�ugo�� 20 znak�w
	@Column(name = "nr_indeksu", nullable = false, length = 20)
	private String nrIndeksu; 
	
	// Dodaj� do tabeli kolumn� - email. Pole ma do 50 znak�w.
	@Column(length = 50)
	private String email;
	
	// Dodaj� do tabeli kolumn� - stacjonarny. Kolumna nie mo�e by� pusta.
	@Column(nullable = false)
	private boolean stacjonarny;
	
	// Dodaje gettery i settery - source - generate getters i setters
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getNrIndeksu() {
		return nrIndeksu;
	}
	public void setNrIndeksu(String nrIndeksu) {
		this.nrIndeksu = nrIndeksu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isStacjonarny() {
		return stacjonarny;
	}
	public void setStacjonarny(boolean stacjonarny) {
		this.stacjonarny = stacjonarny;
	}
	
	public Student() {	
	}
	public Student(String imie, String nazwisko, String nrIndeksu) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrIndeksu = nrIndeksu;
	}
	public Student(String imie, String nazwisko, String nrIndeksu, String email,
			Boolean stacjonarny) {
			this.imie = imie;
			this.nazwisko = nazwisko;
			this.nrIndeksu = nrIndeksu;
			this.email = email;
			this.stacjonarny = stacjonarny;
	}
	
	@ManyToMany(mappedBy = "studenci")
	private Set<Projekt> projekty;

	public Set<Projekt> getProjekty() {
		return projekty;
	}
	public void setProjekty(Set<Projekt> projekty) {
		this.projekty = projekty;
	}
	
}
