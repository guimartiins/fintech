package fintech;

import java.sql.Date;
import java.util.Calendar;

public class InvestimentoDAO {
	private int id;
	private String tipo;
	private double valor;
	private Calendar data_criacao;
	private Calendar data_vencimento;
	private int usuario;
	
	public InvestimentoDAO() {
		super();
	}

	public InvestimentoDAO(int id, String tipo, double valor, Calendar data_criacao, Calendar data_vencimento,
			int usuario) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.data_criacao = data_criacao;
		this.data_vencimento = data_vencimento;
		this.usuario = usuario;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public Calendar getData_criacao() {
		return data_criacao;
	}



	public void setData_criacao(Calendar data_criacao) {
		this.data_criacao = data_criacao;
	}



	public Calendar getData_vencimento() {
		return data_vencimento;
	}



	public void setData_vencimento(Calendar data_vencimento) {
		this.data_vencimento = data_vencimento;
	}



	public int getUsuario() {
		return usuario;
	}



	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	
	
}
