package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.HomePage;
import pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menuPage.acessarTelaHome();
		
		Assert.assertEquals("500.00", homePage.obterSaldoConta("Conta do teste alterada"));
	}

}
