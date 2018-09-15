package br.alef.salario;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SalarioLiquidoTest {
	
	SalarioLiquido salarioBaixo;
	SalarioLiquido salarioMedio;
	SalarioLiquido salarioAlto;
	
	@Before
	public void mock() {
		salarioBaixo = new SalarioLiquido(20, 10, 2);
		salarioMedio = new SalarioLiquido(20, 40, 2);
		salarioAlto = new SalarioLiquido(40, 40, 2);

	}

	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeOBruto(){
		double salarioBrutoBaixo = salarioBaixo.salarioBruto();
		double salarioBrutoBaixoEsperado = 300;
		
		Assert.assertEquals(salarioBrutoBaixoEsperado, salarioBrutoBaixo);
		
		double salarioBrutoMedio = salarioMedio.salarioBruto();
		double salarioBrutoMedioEsperado = 900;
		
		Assert.assertEquals(salarioBrutoMedioEsperado, salarioBrutoMedio);
		
		double salarioBrutoAlto = salarioAlto.salarioBruto();
		double salarioBrutoAltoEsperado = 1700;
		Assert.assertEquals(salarioBrutoAltoEsperado, salarioBrutoAlto);
	}
	
	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeODescontoINSS(){
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
	}
	
	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeODescontoIR(){
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
	}

	@Test
	public void dadoHorasValorDeHorasEDependentesCalculeOSalarioLiquido(){
		double salarioLiquido = salarioBaixo.salarioLiquido();
		double salarioLiquidoEsperado = 274.5;

		Assert.assertEquals(salarioLiquidoEsperado, salarioLiquido, 0.0001);
	}
	
}
