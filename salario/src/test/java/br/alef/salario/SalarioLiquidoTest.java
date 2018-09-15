package br.alef.salario;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SalarioLiquidoTest {

	SalarioLiquido salarioBaixo;
	SalarioLiquido salarioMedio;
	SalarioLiquido salarioAlto;
	SalarioLiquido salarioCubas;

	@Before
	public void mock() {
		salarioBaixo = new SalarioLiquido(20, 10, 2);
		salarioMedio = new SalarioLiquido(20, 40, 2);
		salarioAlto = new SalarioLiquido(40, 40, 2);
		salarioCubas = new SalarioLiquido(160, 150, 3);

	}

	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeOBruto() {
		double salarioBrutoBaixo = salarioBaixo.salarioBruto();
		double salarioBrutoBaixoEsperado = 300;

		Assert.assertEquals(salarioBrutoBaixoEsperado, salarioBrutoBaixo);

		double salarioBrutoMedio = salarioMedio.salarioBruto();
		double salarioBrutoMedioEsperado = 900;

		Assert.assertEquals(salarioBrutoMedioEsperado, salarioBrutoMedio);

		double salarioBrutoAlto = salarioAlto.salarioBruto();
		double salarioBrutoAltoEsperado = 1700;
		Assert.assertEquals(salarioBrutoAltoEsperado, salarioBrutoAlto);

		double salarioBrutoCubas = salarioCubas.salarioBruto();
		double salarioBrutoCubasEsperado = 24150;
		Assert.assertEquals(salarioBrutoCubasEsperado, salarioBrutoCubas);

	}

	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeODescontoINSS() {
		double salarioBrutoBaixo = salarioBaixo.salarioBruto();
		double descontoINSSBaixo = salarioBaixo.descontoINSS(salarioBrutoBaixo);
		double descontoINSSBaixoEsperado = 25.5;

		Assert.assertEquals(descontoINSSBaixoEsperado, descontoINSSBaixo, 0.0001);

		double salarioBrutoMedio = salarioMedio.salarioBruto();
		double descontoINSSMedio = salarioMedio.descontoINSS(salarioBrutoMedio);
		double descontoINSSMedioEsperado = 76.5;

		Assert.assertEquals(descontoINSSMedioEsperado, descontoINSSMedio, 0.0001);

		double salarioBrutoAlto = salarioAlto.salarioBruto();
		double descontoINSSAlto = salarioAlto.descontoINSS(salarioBrutoAlto);
		double descontoINSSAltoEsperado = 153.0;

		Assert.assertEquals(descontoINSSAltoEsperado, descontoINSSAlto, 0.0001);

		double salarioBrutoCubas = salarioCubas.salarioBruto();
		double descontoINSSCubas = salarioCubas.descontoINSS(salarioBrutoCubas);
		double descontoINSSCubasEsperado = 2173.5;

		Assert.assertEquals(descontoINSSCubasEsperado, descontoINSSCubas, 0.0001);
	}

	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeODescontoIR() {
		double salarioBrutoBaixo = salarioBaixo.salarioBruto();
		double descontoIRBaixo = salarioBaixo.descontoIR(salarioBrutoBaixo);
		double descontoIRBaixoEsperado = 0;

		Assert.assertEquals(descontoIRBaixoEsperado, descontoIRBaixo, 0.0001);

		double salarioBrutoMedio = salarioMedio.salarioBruto();
		double descontoIRMedio = salarioMedio.descontoIR(salarioBrutoMedio);
		double descontoIRMedioEsperado = 45.0;

		Assert.assertEquals(descontoIRMedioEsperado, descontoIRMedio, 0.0001);

		double salarioBrutoAlto = salarioAlto.salarioBruto();
		double descontoIRAlto = salarioAlto.descontoIR(salarioBrutoAlto);
		double descontoIRAltoEsperado = 119.0;

		Assert.assertEquals(descontoIRAltoEsperado, descontoIRAlto, 0.0001);

		double salarioBrutoCubas = salarioCubas.salarioBruto();
		double descontoIRCubas = salarioCubas.descontoIR(salarioBrutoCubas);
		double descontoIRCubasEsperado = 1690.5;

		Assert.assertEquals(descontoIRCubasEsperado, descontoIRCubas, 0.0001);
	}

	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeOSalarioLiquido() {
		double salarioLiquidoBaixo = salarioBaixo.salarioLiquido();
		double salarioLiquidoBaixoEsperado = 274.5;

		Assert.assertEquals(salarioLiquidoBaixoEsperado, salarioLiquidoBaixo, 0.0001);

		double salarioLiquidoMedio = salarioMedio.salarioLiquido();
		double salarioLiquidoMedioEsperado = 778.5;

		Assert.assertEquals(salarioLiquidoMedioEsperado, salarioLiquidoMedio, 0.0001);

		double salarioLiquidoAlto = salarioAlto.salarioLiquido();
		double salarioLiquidoAltoEsperado = 1428;

		Assert.assertEquals(salarioLiquidoAltoEsperado, salarioLiquidoAlto, 0.0001);

		double salarioLiquidoCubas = salarioCubas.salarioLiquido();
		double salarioLiquidoCubasEsperado = 20286;

		Assert.assertEquals(salarioLiquidoCubasEsperado, salarioLiquidoCubas, 0.0001);

	}

}
