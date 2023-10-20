package controller;

import java.time.LocalDate;

import service.ApiCorreios;
import model.DadosLocalizacao;
import model.Usuario;

public class CadastroUsuario {

	private ApiCorreios apiCorreios;

	public CadastroUsuario(final ApiCorreios apiDosCorreios) {
		this.apiCorreios = apiDosCorreios;
	}

	public Usuario cadastrarUsuario(String nome, String documento, LocalDate nascimento, String cep) {
		Usuario usuario = new Usuario(nome, documento, nascimento);
		DadosLocalizacao dadosLocalizacao = apiCorreios.buscaDadosComBaseNoCep(cep);
		usuario.adicionaDadosDeEndereco(dadosLocalizacao);
		return usuario;
	}

}
