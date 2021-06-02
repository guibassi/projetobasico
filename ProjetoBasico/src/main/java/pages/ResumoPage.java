package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ResumoPage extends BasePage {
	
	public void setSelecionarMes(String... valores) {
		for(String valor: valores)
			selecionarCombo("mes", valor);
	}
	
	public void setSelecionarAno(String... valores) {
		for(String valor: valores)
			selecionarCombo("ano", valor);
	}
	
	public void buscar() {
		clicarBotao(By.xpath("//input[@class='btn btn-primary']"));
	}
	
	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

}
