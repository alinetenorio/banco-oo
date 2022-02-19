package banco.controller;

import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.banco.Banco;
import banco.storage.repositories.BancoRepository;
import banco.util.Env;

public class BancoController {
  private BancoRepository repository = new BancoRepository();

  public void cadastrarBanco(String nome, String cnpj, int codigo) throws Exception {
    if( nome.isEmpty() || nome == null || cnpj.isEmpty() || cnpj == null || codigo < 0 ) {
      throw new Exception("Complete todos os dados para o cadastro");
    }

    Banco banco = new Banco(nome, cnpj, codigo);
    repository.criar(banco);   
  }

  public void editarBanco(int codigo, String nome, String cnpj) throws Exception {
    if( codigo < 0 || nome.isEmpty() || nome == null || cnpj.isEmpty() || cnpj == null  ) {
      throw new Exception("Dados inválidos");
    }

    repository.atualizar(codigo, nome, cnpj);
  }

  public void adicionarAgencia(int codigo, int numero) throws Exception {
    if( codigo < 0 || numero < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    Agencia agencia = new Agencia(numero);
    repository.adicionarAgencia(codigo, agencia);       
  }

  public void removerAgencia(int codigo, int numero) throws Exception {
    if( codigo < 0 || numero < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    Agencia agencia = new Agencia(numero);
    repository.removerAgencia(codigo, agencia);     
  }

  public void excluirBanco(int codigo) throws Exception {
    if( codigo < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    repository.remover(codigo);      
  }

  public Banco buscarBanco(int codigo) throws Exception {
    if( codigo < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    return repository.listar(codigo);    
  }

  public List<Banco> listarBancos() throws Exception {   
    return repository.listarTodos(); 
  }
}
