package br.com;

public class Registro {
    private int idRegistro;
    private String descricaoRegistro;
	private double valorRegistro;

	public Registro(int idRegistro, String descricaoRegistro, double valorRegistro) {
		super();
        this.idRegistro = idRegistro;
        this.descricaoRegistro = descricaoRegistro;
		this.valorRegistro = valorRegistro;
	}

    public int getIdRegistro() {
        return idRegistro;
    }

    public String getDescricaoRegistro() {
        return descricaoRegistro;
    }

	public void setDescricaoRegistro(String descricaoRegistro) {
		this.descricaoRegistro = descricaoRegistro;
	}

	public double getValorRegistro() {
		return valorRegistro;
	}

	public void setValorRegistro(double valorReceita) {
		this.valorRegistro = valorReceita;
	}


}