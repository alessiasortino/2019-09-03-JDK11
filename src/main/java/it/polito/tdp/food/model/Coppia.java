package it.polito.tdp.food.model;

public class Coppia {
	private String a1;
	private String a2;
	private Integer peso;
	/**
	 * @param a1
	 * @param a2
	 * @param peso
	 */
	public Coppia(String a1, String a2, Integer peso) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.peso = peso;
	}
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Coppia [a1=" + a1 + ", a2=" + a2 + ", peso=" + peso + "]";
	}
	
	
		

}
