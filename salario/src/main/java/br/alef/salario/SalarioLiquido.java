package br.alef.salario;

public class SalarioLiquido {

	private double quantidadeHoras;
	private double salarioHora;
	private double quantidadeDependentes;

	public SalarioLiquido(double quantidadeHoras, double salarioHora, double quantidadeDependentes) {
		this.quantidadeHoras = quantidadeHoras;
		this.salarioHora = salarioHora;
		this.quantidadeDependentes = quantidadeDependentes;
	}

	public double salarioBruto() {
		return (quantidadeHoras * salarioHora) + (50 * quantidadeDependentes);
	}

	public double descontoINSS(double salarioBruto) {
		double descontoINSS = 0;
		if (salarioBruto > 1000.0) {
			descontoINSS = salarioBruto * (9.0 / 100);
		} else {
			descontoINSS = salarioBruto * (8.5 / 100);
		}

		return descontoINSS;
	}

	public double descontoIR(double salarioBruto) {
		double descontoIR = 0;

		if (salarioBruto <= 500) {
			descontoIR = 0;
		} else if (salarioBruto > 500 && salarioBruto <= 1000) {
			descontoIR = salarioBruto * (5.0 / 100);
		} else {
			descontoIR = salarioBruto * (7.0 / 100);
		}

		return descontoIR;
	}

	public double salarioLiquido() {
		double salarioBruto = this.salarioBruto();
		double salarioLiquido = 0;
		salarioLiquido = salarioBruto - this.descontoINSS(salarioBruto) - this.descontoIR(salarioBruto);
		return salarioLiquido;
	}
}
