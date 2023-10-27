package controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import model.DadosLocalizacao;
import model.Usuario;
import service.ApiCorreios;

@ExtendWith(MockitoExtension.class)
public class CadastroUsuarioTest {

	@Mock
	private ApiCorreios apiCorreios;
	
	@InjectMocks
	private CadastroUsuario cadastrarUsuario;
	
	@Test
	void testCadastrarUsuario() {
		
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RJ", "Rio de Janeiro", "São Cristovão", "Apartamento", "Bairro");
		
		Mockito.when(apiCorreios.buscaDadosComBaseNoCep("22291140")).thenReturn(dadosLocalizacao);
		
		Usuario victor = cadastrarUsuario.cadastrarUsuario("Victor", "12345678", LocalDate.of(1996, 11, 26), "22291140");
		
		assertEquals("Victor", victor.getNome());
		assertEquals("12345678", victor.getDocumento());
		assertEquals("RJ", victor.getEndereco().getUf());
		assertEquals("Apartamento", victor.getEndereco().getComplemento());
	}
	
}
