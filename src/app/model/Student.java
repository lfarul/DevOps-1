package app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import java.util.Set;
import javax.persistence.Column;

@Entity // encja
@Table(name="student") // tutaj okreœlam nazwê tabeli - student

public class Student {
	
	// Tworzê tabelê
	
	// Dodajê do tabeli student kolumnê - student_id - primary key
	@Id // to bêdzie primary key
	@GeneratedValue
	@Column(name = "student_id")
	private String studentId;
	
	// Dodajê do tabeli student kolumnê - imiê. Kolumna nie mo¿ebyæ pusta i ma d³ugoœæ 50 znaków
	@Column (nullable = false, length = 50)
	private String imie;
	
	// Dodajê do tabeli kolumnê - nazwisko. Kolumna nie mo¿e byæ pusta i ma d³ugoœæ 100 znaków
	@Column(nullable = false, length = 100)
	private String nazwisko;
	
	// Dodajê do tabeli kolumnê - nr_indeksu. Kolumna nie mo¿e byæ pusta i ma d³ugoœæ 20 znaków
	@Column(name = "nr_indeksu", nullable = false, length = 20)
	private String nrIndeksu; 
	
	// Dodajê do tabeli kolumnê - email. Pole ma do 50 znaków.
	@Column(length = 50)
	private String email;
	
	// Dodajê do tabeli kolumnê - stacjonarny. Kolumna nie mo¿e byæ pusta.
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
