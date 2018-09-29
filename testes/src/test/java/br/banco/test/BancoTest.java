package br.banco.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.banco.builder.ContaBuilder;
import br.banco.dao.ContaDao;
import br.banco.dao.ContaDaoFalso;
import br.banco.dao.Dao;
import br.banco.dominio.Banco;
import br.banco.dominio.Conta;
import br.banco.dominio.Usuario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BancoTest {
	private Conta c1;
	private Conta c2;
	private Conta c3;
	private Conta c4;
	private Usuario joao;
	private Usuario manoel;
	private Usuario josuel;
	private Usuario maria;

	@Before
	public void criarAmbiente() {
		c1 = new Conta(100.0, "Basica");
		c2 = new Conta(200.0, "Prime");
		c3 = new Conta(300.0, "Ultra");
		c4 = new Conta(400.0, "Master");

		joao = new Usuario("Joao da Silva", "111111111", "joaosilva@mailinator.com");
		manoel = new Usuario("Manoel da Silva", "22222222", "manoelsilva@mailinator.com");
		josuel = new Usuario("Josuel da Silva", "33333333", "josuelsilva@mailinator.com");
		maria = new Usuario("Maria da Silva", "44444444", "mariasilva@mailinator.com");
	}

	@Test
	public void deveSomarTodasAsContasTrazendoOSaldoDoBanco() {

		List<Conta> contas = new ContaBuilder().addConta(c1, joao).addConta(c2, manoel).constroi();

		Dao dao = mock(ContaDao.class);
		when(dao.getContas()).thenReturn(contas);

		dao.salvaConta(contas.get(0));
		dao.salvaConta(contas.get(1));

		Banco banco = new Banco(dao);
		banco.atualizaJuros(5);

		// verificando que o metodo atualizaConta foi realmente invocado!
		verify(dao).atualizaConta(contas.get(0));

		assertEquals(615.0, banco.totalSaldo(), 0.00001);

		assertEquals(2, banco.getContas().size(), 0.00001);
	}
	
	@Test
	public void deveAtualizarAsContasComJurosAplicados(){
		
		List<Conta> contas = new ContaBuilder()
			.addConta(c1, joao)
			.addConta(c2, manoel)
			.constroi();
		
		ContaDao dao = mock(ContaDao.class);
		when(dao.getContas()).thenReturn(contas);
		
		Banco banco = new Banco(dao);
		banco.atualizaJuros(5);
		
		// verificando que o metodo atualizaConta foi realmente invocado!
		verify(dao, times(1)).atualizaConta(contas.get(0));
		
		assertEquals(615.0, banco.totalSaldo(), 0.00001);
	}
	
	@Test
	public void deveContinuarAExecucaoMesmoQuandoDaoFalha(){
			
		List<Conta> contas = new ContaBuilder()
			.addConta(c1, joao)
			.addConta(c2, manoel)
			.addConta(c3, josuel)
			.addConta(c4, maria)
			.constroi();
			
		ContaDao dao = mock(ContaDao.class);
		when(dao.getContas()).thenReturn(contas);
			
		doThrow(new RuntimeException()).when(dao).atualizaConta(c3);
		doThrow(new RuntimeException()).when(dao).atualizaConta(c4);
			
		Banco banco = new Banco(dao);
		banco.atualizaJuros(1);
			
		verify(dao, times(1)).atualizaConta(c1);
		verify(dao, times(1)).atualizaConta(c2);
		verify(dao, times(1)).atualizaConta(c3);
		verify(dao, times(1)).atualizaConta(c4);
			
	}
}
