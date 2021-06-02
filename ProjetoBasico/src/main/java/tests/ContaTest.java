package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import pages.ContasPage;
import pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
		
	@Test
	public void test1Inserirconta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do teste");
		contasPage.setNome("Conta do teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test3InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("J� existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
		

}
