package suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import pages.LoginPage;
import tests.ContaTest;
import tests.MovimentacaoTest;
import tests.RemoverMovimentacaoContaTest;
import tests.ResumoTest;
import tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("gbcunha7@gmail.com");
		page.setSenha("240615");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza(){
		DriverFactory.killDriver();
	}
}
