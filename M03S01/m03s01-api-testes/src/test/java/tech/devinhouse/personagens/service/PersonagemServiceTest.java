package tech.devinhouse.personagens.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.devinhouse.personagens.exception.RegistroExistenteException;
import tech.devinhouse.personagens.exception.RegistroNaoEncontradoException;
import tech.devinhouse.personagens.model.Personagem;
import tech.devinhouse.personagens.repository.PersonagemRepository;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) // configurando classe de teste para rodar com o Mockito
class PersonagemServiceTest {

    @Mock   // criar objeto mock da dependencia da classe testada
    private PersonagemRepository personagemRepo;

    @InjectMocks  // injeta os mocks criados na classe sendo testada
    private PersonagemService service;

    @Test
    @DisplayName("Quando existe personagem com o id informado, deve retornar o personagem")
    void consultar() {
        // given
        Long id = 1L;
        Personagem personagem = Personagem.builder().id(id).nome("Nome").cpf(12345678901L).build();
        Mockito.when(personagemRepo.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(personagem));
        // when
        Personagem resultado = service.consultar(id);
        // then
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
    }

    @Test
    @DisplayName("Quando nao existe personagem com o id informado, deve lancar excecao")
    void consultar_naoEncontrado() {
        Long id = 1L;
        // Nao eh necessario a instrucao abaixo pq o comportamento padrao do Mock eh nao retornar nada
//        Mockito.when(personagemRepo.findById(Mockito.anyLong()))
//                .thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> service.consultar(id));
    }

    @Test
    @DisplayName("Quando nao ha registros de personagens, deve retornar lista vazia")
    void consultar_semRegistros() {
        List<Personagem> lista = service.consultar();
        assertNotNull(lista);
        assertTrue(lista.isEmpty());
    }

    @Test
    @DisplayName("Quando ha registros de personagens, deve retornar lista com valores")
    void consultar_listaComRegistros() {
        // given
        List<Personagem> personagens = List.of(
            new Personagem(1L, 123456789L, "sapato", LocalDate.now().minusYears(20), "Serie do Sapato"),
            new Personagem(2L, 222222222L, "gato", LocalDate.now().minusYears(15), "Serie do Garfield")
        );
        Mockito.when(personagemRepo.findAll()).thenReturn(personagens);
        // when
        List<Personagem> lista = service.consultar();
        // then
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
        assertEquals(personagens.size(), lista.size());
    }

    @Test
    @DisplayName("Quando tentativa de inserir personagem com cpf já cadastrada, deve lancar excecao")
    void inserir_cpfJaExistente() {
        Personagem personagem = Personagem.builder().cpf(123L).nome("Nome").build();
        Mockito.when(personagemRepo.existsPersonagemByCpf(Mockito.anyLong()))
                .thenReturn(true);
        assertThrows(RegistroExistenteException.class, () -> service.inserir(personagem));
    }

    @Test
    @DisplayName("Quando tentativa de inserir personagem com cpf nao cadastrada, deve inserir personagem")
    void inserir() {
        // given
        Personagem personagemOriginal = Personagem.builder().cpf(123L).nome("Nome").build();
        Personagem personagemInserido = Personagem.builder().id(1L).cpf(123L).nome("Nome").build();
        Mockito.when(personagemRepo.existsPersonagemByCpf(Mockito.anyLong()))
                .thenReturn(false);
        Mockito.when(personagemRepo.save(Mockito.any(Personagem.class)))
                .thenReturn(personagemInserido);
        // when
        Personagem resultado = service.inserir(personagemOriginal);
        // then
        assertNotNull(resultado);
        assertEquals(personagemInserido.getId(), resultado.getId());
    }

    @Test
    @DisplayName("Quando existe personagem com o cpf informado, deve retornar o personagem")
    void consultar_cpfExistente() {
        // given
        Long cpf = 12345678901L;
        Personagem personagem = Personagem.builder().id(1L).nome("Nome").cpf(cpf).build();
        Mockito.when(personagemRepo.findByCpf(Mockito.anyLong()))
                .thenReturn(Optional.of(personagem));
        // when
        Personagem resultado = service.consultarPor(cpf);
        // then
        assertNotNull(resultado);
        assertEquals(cpf, resultado.getCpf());
    }

    @Test
    @DisplayName("Quando nao existe personagem com o cpf informado, deve lancar excecao")
    void consultarPorCpf_naoEncontrado() {
        assertThrows(RegistroNaoEncontradoException.class, () -> service.consultarPor(1L));
    }

    @Test
    @DisplayName("Quando existe personagem com o id indicado, deve excluir peersonagem")
    void excluir() {
        Long id = 1L;
        Personagem personagem = Personagem.builder().id(id).nome("Nome").cpf(123L).build();
        Mockito.when(personagemRepo.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(personagem));
        assertDoesNotThrow(() -> service.excluir(id));
    }

    @Test
    @DisplayName("Quando nao existe personagem com o id indicado, deve lacar excecao")
    void excluir_inexistente() {
        assertThrows(RegistroNaoEncontradoException.class, () -> service.excluir(1L));
    }

    //TODO: Implementar demais métodos de testes para as demais funcionalidades do service...

}