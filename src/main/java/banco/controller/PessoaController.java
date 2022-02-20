package banco.controller;

import java.util.List;

import banco.domain.pessoa.Cliente;
import banco.domain.pessoa.Funcionario;
import banco.domain.pessoa.Pessoa;
import banco.storage.repositories.PessoaRepository;
import banco.util.enums.CargoEnum;

public class PessoaController {
  private PessoaRepository repository = new PessoaRepository();

  public void cadastrarFuncionario(String nome, String cpf, CargoEnum cargo) throws Exception {
    if( nome.isEmpty() || nome == null || cpf.isEmpty() || cpf == null || cargo == null ) {
      throw new Exception("Complete todos os dados para o cadastro");
    }

    Funcionario funcionario = new Funcionario(nome, cpf, cargo);
    repository.criar(funcionario);   
  }

  public void cadastrarCliente(String nome, String cpf) throws Exception {
    if( nome.isEmpty() || nome == null || cpf.isEmpty() || cpf == null ) {
      throw new Exception("Complete todos os dados para o cadastro");
    }

    Cliente cliente = new Cliente(nome, cpf);
    repository.criar(cliente);   
  }

  public void editarPessoa(String cpf, String nome, String email) throws Exception {
    if( cpf.isEmpty() || cpf == null || nome.isEmpty() || nome == null || email.isEmpty() || email == null  ) {
      throw new Exception("Dados inválidos");
    }

    repository.atualizar(cpf, nome, email);
  }

  public Pessoa buscar(String cpf) throws Exception {
    if( cpf == null || cpf.isEmpty() ) {
      throw new Exception("Dados inválidos.");
    }

    return repository.listar(cpf);    
  }

  public List<Cliente> listarClientes() throws Exception {   
    return repository.listarTodosClientes(); 
  }

  public List<Funcionario> listarFuncionarios() throws Exception {   
    return repository.listarTodosFuncionarios(); 
  }
}
