package tests;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1RemoverMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.setSelecionarMes("Janeiro");
		resumoPage.setSelecionarAno("2020");
		resumoPage.buscar();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimenta��o removida com sucesso!", 
				resumoPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2ResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
				//ctrl shift M - import static
		
		List<WebElement> elementosEncontrados = 
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
				//conferir se no menu Resumo a busca ser� vazia
	}

}
