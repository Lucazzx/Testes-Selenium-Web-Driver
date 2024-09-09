package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteCampoTreinamentoRegrasDeNegocio extends DSLBaseTeste {
		
	@Test
	public void testeRegraDeNegocioNome() {
		clicar(BOTAO_CADASTRAR);
		assertEquals("Nome eh obrigatorio", obterTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioSobrenome() {
		escrever(CAMPO_NOME	,"ExemploNome");
		
		clicar(BOTAO_CADASTRAR);
		
		assertEquals("Sobrenome eh obrigatorio", obterTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioSexo() {
		escrever(CAMPO_NOME	,"ExemploNome");
		
		escrever(CAMPO_SOBRENOME,"ExemploSobrenome");
		
		clicar(BOTAO_CADASTRAR);
		
		assertEquals("Sexo eh obrigatorio", obterTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioComida() {
		escrever(CAMPO_NOME	,"ExemploNome");
		
		escrever(CAMPO_SOBRENOME,"ExemploSobrenome");
		
		clicar(RADIO_SEXO_MASCULINO);
		
		clicar(CHECKBOX_COMIDA_CARNE);
		clicar(CHECKBOX_COMIDA_VEGETARIANO);
		
		clicar(BOTAO_CADASTRAR);
		
		assertEquals("Tem certeza que voce eh vegetariano?", obterTextoAlerta());
	}
	
	@Test
	public void testeRegraDeNegocioEsporte() {
		escrever(CAMPO_NOME	,"ExemploNome");
		
		escrever(CAMPO_SOBRENOME,"ExemploSobrenome");
		
		clicar(RADIO_SEXO_MASCULINO);
		
		clicar(CHECKBOX_COMIDA_CARNE);
		
		selecionarCombo(COMBO_ESPORTE, "Natacao");
		selecionarCombo(COMBO_ESPORTE, "O que eh esporte?");
		
		clicar(BOTAO_CADASTRAR);
		
		assertEquals("Voce faz esporte ou nao?", obterTextoAlerta());
	}



	
	
}
