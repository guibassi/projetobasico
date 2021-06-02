package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Arrays;
import core.BaseTest;
import pages.MenuPage;
import pages.MovimentacaoPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("01/01/2020");
		movPage.setDataPagamento("02/01/2020");
		movPage.setDescricao("Movimentação do teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do teste alterada");
		movPage.setStatusPago();
		
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório", 
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("01/01/2220");
		movPage.setDataPagamento("02/01/2220");
		movPage.setDescricao("Movimentação do teste");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do teste alterada");
		movPage.setStatusPago();
		
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(
				erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}
	
	

}
