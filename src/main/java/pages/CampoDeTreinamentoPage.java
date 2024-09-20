package pages;

import core.BasePage;

public class CampoDeTreinamentoPage extends BasePage{
	  
	public static final String CAMPO_NOME = "elementosForm:nome";
	public static final String CAMPO_SOBRENOME = "elementosForm:sobrenome";
	public static final String CAMPO_SUGESTOES = "elementosForm:sugestoes";
	public static final String RADIO_SEXO_MASCULINO = "elementosForm:sexo:0";
	public static final String RADIO_SEXO_FEMININO = "elementosForm:sexo:1";
	public static final String CHECKBOX_COMIDA_CARNE = "elementosForm:comidaFavorita:0";
	public static final String CHECKBOX_COMIDA_FRANGO = "elementosForm:comidaFavorita:1";
    public static final String CHECKBOX_COMIDA_PIZZA = "elementosForm:comidaFavorita:2";
    public static final String CHECKBOX_COMIDA_VEGETARIANO = "elementosForm:comidaFavorita:3";
    public static final String COMBO_ESCOLARIDADE = "elementosForm:escolaridade";
    public static final String COMBO_ESPORTE = "elementosForm:esportes";
    public static final String BOTAO_CADASTRAR = "elementosForm:cadastrar";
    public static final String RESULTADO = "resultado";
    public static final String BOTAO_CLIQUE_ME = "buttonSimple";
    public static final String LINK_VOLTAR = "Voltar";
    public static final String ALERTA = "Alert";
    public static final String CONFIRMA = "Confirm";
    public static final String PROMPT = "prompt";
    public static final String BOTAO_FRAME = "frameButton";
    public static final String FRAME_1 = "frame1";
    public static final String BOTAO_POPUP_COM_NOME = "buttonPopUpEasy";
    public static final String BOTAO_POPUP_SEM_NOME = "buttonPopUpHard";
	
    
    public void setNome (String nome) {
    	dsl.escrever(CAMPO_NOME, nome);
    }
    
    public String getNome() {
    	return dsl.obterValorCampo(CampoDeTreinamentoPage.CAMPO_NOME);
    }
    
    public void setSobrenome (String sobrenome) {
    	dsl.escrever(CAMPO_SOBRENOME, sobrenome);
    }
    
    public String getSobrenome() {
    	return dsl.obterValorCampo(CampoDeTreinamentoPage.CAMPO_SOBRENOME);
    }
    
    public void setSugestoes (String sugestoes) {
    	dsl.escrever(CAMPO_SUGESTOES, sugestoes);
    }
    
    public String getSugestoes() {
    	return dsl.obterValorCampo(CampoDeTreinamentoPage.CAMPO_SUGESTOES);
    }
    
    public void setSexoMasculino () {
    	dsl.clicar(RADIO_SEXO_MASCULINO);
    }
    
    public boolean getSexoMasculino() {
    	return dsl.estaMarcado(CampoDeTreinamentoPage.RADIO_SEXO_MASCULINO);
    }
    
    public void setSexoFeminino () {
    	dsl.clicar(RADIO_SEXO_FEMININO);
    }
        
    public boolean getSexoFeminnino() {
    	return dsl.estaMarcado(CampoDeTreinamentoPage.RADIO_SEXO_MASCULINO);
    }
    
    public void setComidaCarne () {
    	dsl.clicar(CHECKBOX_COMIDA_CARNE);
    }
    
    public boolean getComidaCarne() {
    	return dsl.estaMarcado(CampoDeTreinamentoPage.CHECKBOX_COMIDA_CARNE);
    }
    
    public void setComidaFrango () {
    	dsl.clicar(CHECKBOX_COMIDA_FRANGO);
    }
    
    public boolean getComidaFrango() {
    	return dsl.estaMarcado(CampoDeTreinamentoPage.CHECKBOX_COMIDA_FRANGO);
    }
    
    public void setComidaPizza () {
    	dsl.clicar(CHECKBOX_COMIDA_PIZZA);
    }
    
    public boolean getComidaPizza() {
    	return dsl.estaMarcado(CampoDeTreinamentoPage.CHECKBOX_COMIDA_PIZZA);
    }
    
    public void setComidaVegetariano () {
    	dsl.clicar(CHECKBOX_COMIDA_VEGETARIANO);
    }
    
    public boolean getComidaVegetariano() {
    	return dsl.estaMarcado(CampoDeTreinamentoPage.CHECKBOX_COMIDA_VEGETARIANO);
    }
    
    public void setEscolaridade (String... valor) {
    	dsl.selecionarCombo(COMBO_ESCOLARIDADE, valor);
    }
    
    public String getEscolaridade() {
    	return dsl.obterValorCombo(COMBO_ESCOLARIDADE);
    }
    
    public boolean getDaListaEscolaridade(String valor) {
    	return dsl.procurarValorCombo(CampoDeTreinamentoPage.COMBO_ESCOLARIDADE, valor);
    }
    
    public void setClickBotaoCliqueMe () {
    	dsl.clicar(BOTAO_CLIQUE_ME);
    }
    
    public String getBotaoCliqueMe () {
    	return dsl.obterValorCampo(BOTAO_CLIQUE_ME);
    }
    
    public void setClickLinkVoltar () {
    	dsl.clicarLink("Voltar");
    }
    
    public String getResultado () {
    	return dsl.obterTextoCampo(RESULTADO);
    }
    
    public void setEsporte (String... esportes) {
    	dsl.selecionarCombo(COMBO_ESPORTE, esportes);
    }
    
    public void setClickBotaoCadastrar () {
    	dsl.clicar(BOTAO_CADASTRAR);
    }
    
    public void setClickBotaoFrame () {
    	dsl.clicar(BOTAO_FRAME);
    }
    
    public void setFrame1 () {
    	dsl.trocaParaFrame(FRAME_1);
    }
    
    public void setClickBotaoAlerta () {
    	dsl.clicar(ALERTA);
    }
    
    public String getTextoAlerta () {
    	return dsl.obterTextoAlerta();
    }
    
    public void setClickOkAlerta () {
    	dsl.trocaEAceitaAlerta();;
    }
    
    public void setClickPopUpComNome () {
    	dsl.clicar(BOTAO_POPUP_COM_NOME);
    }
    
    public void setClickPopUpSemNome () {
    	dsl.clicar(BOTAO_POPUP_SEM_NOME);
    }
    
    public void setClickBotaoConfirma () {
    	dsl.clicar(CONFIRMA);
    }
    
    public void setClickBotaoPrompt () {
    	dsl.clicar(PROMPT);
    }

    
}
