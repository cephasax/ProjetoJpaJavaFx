package br.ufrn.imd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_MOTOR", initialValue = 1, allocationSize = 1, sequenceName = "seq_motor")
public class Motor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_MOTOR")
	private Long id;
	
	private String NumeroSerie;
	private int PotenciaCavalos;
	
	private int qtdCilindros;
	
	@OneToOne
	@JoinColumn(name = "idCarro")
	Carro carro;
	
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return NumeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		NumeroSerie = numeroSerie;
	}

	public int getPotenciaCavalos() {
		return PotenciaCavalos;
	}

	public void setPotenciaCavalos(int potenciaCavalos) {
		PotenciaCavalos = potenciaCavalos;
	}

	public int getQtdCilindros() {
		return qtdCilindros;
	}

	public void setQtdCilindros(int qtdCilindros) {
		this.qtdCilindros = qtdCilindros;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
