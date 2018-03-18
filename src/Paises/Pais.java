package Paises;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*  b. Crie uma classe Pais com os atributos id (int), nome (String), populacao (long) e area
(double). */
@SuppressWarnings({ "unused", "serial" })
public class Pais implements Serializable {
	int id;
	String nome;
	long populacao;
	double area;
	public Pais() {}
/* c. Crie um construtor com os campos, um construtor padrão, gets e sets. */
	public Pais(int id, String nome, long populacao, double area) {
		// Método Construtor
		super();
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
							// Get e Set *** ID ***
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
							// Get e Set *** Nome ***
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
							// Get e Set *** Populacao ***
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
						// Get e Set *** Area ***
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
						// 	   		*** toString ***
	@Override
	public String toString() {
		return "Id: " + getId() + " Nome: "+getNome()+" População: "+getPopulacao()+" Area: "+getArea();
	}
	

}
