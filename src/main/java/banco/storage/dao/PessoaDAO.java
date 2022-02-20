package banco.storage.dao;

import java.util.ArrayList;
import java.util.List;

import banco.domain.pessoa.Cliente;
import banco.domain.pessoa.Funcionario;
import banco.domain.pessoa.Pessoa;
import banco.util.enums.RoleEnum;

public class PessoaDAO {
  List<Pessoa> pessoas;

  public PessoaDAO() {
    pessoas = new ArrayList<>();
  }

  public void criar(Pessoa pessoa) throws Exception{
    if( pessoa == null ){
      throw new Exception("Pessoa não pode estar vazio");
    }
    pessoas.add(pessoa);
  }

  public Pessoa listar(String cpf) throws Exception {
    for( Pessoa pessoa : pessoas ) {
      if( pessoa.getCpf().equals(cpf) ) {
        return pessoa;
      }
    }
    throw new Exception("A pessoa não foi encontrada no sistema.");
  }

  public void atualizar(String cpf, String nome, String email) throws Exception {
    Pessoa pessoa = listar(cpf);
      
    if( !cpf.equals("-1") ) {
      pessoa.setCpf(cpf);
    }
    if( !nome.equals("-1") ) {
      pessoa.setNome(nome);
    }    
    if( !email.equals("-1") ) {
      pessoa.setEmail(email);
    }       
  }

  public List<Cliente> listarTodosClientes() throws Exception {
    List<Cliente> clientes = new ArrayList<>();
    for( Pessoa pessoa : pessoas ) {
      if( pessoa.getRole() == RoleEnum.CLIENTE ) 
        clientes.add((Cliente)pessoa);
    }
   
    if (clientes.size() == 0 ) {
      throw new Exception("Não existem clientes cadastrados.");
    }
    return clientes;
  }

  public List<Funcionario> listarTodosFuncionarios() throws Exception {
    List<Funcionario> funcionarios = new ArrayList<>();
    for( Pessoa pessoa : pessoas ) {
      if( pessoa.getRole() == RoleEnum.FUNCIONARIO ) 
        funcionarios.add((Funcionario)pessoa);
    }
   
    if (funcionarios.size() == 0 ) {
      throw new Exception("Não existem Funcionarios cadastrados.");
    }
    return funcionarios;
  }

  public Cliente listarCliente(String cpf) throws Exception {    
   
    Pessoa pessoa = listar(cpf);
    if(pessoa.getRole() == RoleEnum.CLIENTE) {
      return (Cliente) pessoa;
    }
    
    return null;
  }

  public List<Cliente> listarClientesCpf(List<String> cpfs) throws Exception {    
    List<Cliente> res = new ArrayList<>();
    
    for(String cpf : cpfs) {
      res.add(listarCliente(cpf));     
    }
    return res;
  }
}
