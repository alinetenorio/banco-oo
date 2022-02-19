package banco.controller;

import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.banco.Banco;
import banco.storage.repositories.BancoRepository;

public class BancoController {
  private BancoRepository repository = new BancoRepository();

  public boolean cadastrarBanco(String nome, String cnpj, int codigo) throws Exception {
    if( nome.isEmpty() || nome == null || cnpj.isEmpty() || cnpj == null || codigo < 0 ) {
      throw new Exception("Complete todos os dados para o cadastro");
    }

    Banco banco = new Banco(nome, cnpj, codigo);
    try {
      repository.criar(banco);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }    
  }

  public boolean editarBanco(int codigo, String nome) throws Exception {
    if( codigo < 0 || nome.isEmpty() || nome == null ) {
      throw new Exception("Dados inválidos");
    }

    try {
      repository.atualizar(codigo, nome);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }    
  }

  public boolean editarBanco(int codigo, String nome, String cnpj) throws Exception {
    if( codigo < 0 || nome.isEmpty() || nome == null || cnpj.isEmpty() || cnpj == null  ) {
      throw new Exception("Dados inválidos");
    }

    try {
      repository.atualizar(codigo, nome, cnpj);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }    
  }

  public boolean adicionarAgencia(int codigo, int numero) throws Exception {
    if( codigo < 0 || numero < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    Agencia agencia = new Agencia(numero);
    try {
      repository.adicionarAgencia(codigo, agencia);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }           
  }

  public boolean removerAgencia(int codigo, int numero) throws Exception {
    if( codigo < 0 || numero < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    Agencia agencia = new Agencia(numero);
    try {
      repository.removerAgencia(codigo, agencia);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }      
  }

  public boolean excluirBanco(int codigo) throws Exception {
    if( codigo < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    try {
      repository.remover(codigo);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }       
  }

  public Banco buscarBanco(int codigo) throws Exception {
    if( codigo < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    try {
      return repository.listar(codigo);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }   
  }

  public List<Banco> listarBancos() throws Exception {
    try {
      return repository.listarTodos();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }       
  }
}
