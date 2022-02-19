package banco.storage.repositories;

import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.banco.Banco;
import banco.storage.dao.BancoDAO;

public class BancoRepository {
  private BancoDAO DAO = new BancoDAO();

  public void criar(Banco banco) throws Exception {
    DAO.criar(banco);
  }

  public Banco listar(int codigo) throws Exception {
    return DAO.listar(codigo);
  }

  public void atualizar(int codigo, String nome, String cnpj) throws Exception {
    DAO.atualizar(codigo, nome, cnpj);
  }

  public void adicionarAgencia(int codigo, Agencia agencia) throws Exception {
    DAO.adicionarAgencia(codigo, agencia);
  }

  public void removerAgencia(int codigo, Agencia agencia) throws Exception {
    DAO.removerAgencia(codigo, agencia);
  }

  public void remover(int codigo) throws Exception {
    DAO.remover(codigo);
  }

  public List<Banco> listarTodos() throws Exception {
    return DAO.listarTodos();
  }
}
