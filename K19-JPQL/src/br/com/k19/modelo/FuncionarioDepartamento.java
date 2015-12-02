package br.com.k19.modelo;

public class FuncionarioDepartamento {
	private String funcionario;
	private String departamento;
	
	public FuncionarioDepartamento(String funcionario, String departamento) {
		this.funcionario = funcionario;
		this.departamento = departamento;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}
