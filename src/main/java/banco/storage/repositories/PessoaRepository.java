package banco.storage.repositories;

import java.util.List;

import banco.domain.pessoa.Cliente;
import banco.domain.pessoa.Funcionario;
import banco.domain.pessoa.Pessoa;
import banco.storage.dao.PessoaDAO;

public class PessoaRepository {
  private PessoaDAO DAO = new PessoaDAO();

  public void criar(Pessoa pessoa) throws Exception {
    DAO.criar(pessoa);
  }

  public Pessoa listar(String cpf) throws Exception {
    return DAO.listar(cpf);
  }

  public void atualizar(String cpf, String nome, String email) throws Exception {
    DAO.atualizar(cpf, nome, email);
  }

  public List<Cliente> listarTodosClientes() throws Exception {
    return DAO.listarTodosClientes();
  }

  public List<Funcionario> listarTodosFuncionarios() throws Exception {
    return DAO.listarTodosFuncionarios();
  }

  public Cliente listarCliente(String cpf) throws Exception {    
    return DAO.listarCliente(cpf);
  }

  public List<Cliente> listarClientesCpf(List<String> cpfs) throws Exception {    
    return DAO.listarClientesCpf(cpfs);
  }
}
