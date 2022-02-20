package banco.storage.repositories;

import banco.domain.banco.Agencia;
import banco.domain.conta.Conta;
import banco.storage.dao.AgenciaDAO;
import banco.util.Endereco;

public class AgenciaRepository {
  private AgenciaDAO DAO = new AgenciaDAO();

  public Agencia listar(int numero) throws Exception {
    return DAO.listar(numero);
  }

  public Conta listarConta(int numeroAgencia, String numeroConta) throws Exception {
    return DAO.listarConta(numeroAgencia, numeroConta);
  }

  public Conta listarContaPorCodigo(int codigo) throws Exception {
    return DAO.listarConta(codigo);
  }

  public void atualizar(int numero, Endereco endereco, String telefone) throws Exception {
    DAO.atualizar(numero, endereco, telefone);
  }

  public void adicionarConta(Agencia agencia, Conta conta) throws Exception {    
    DAO.adicionarConta(agencia, conta);
  }

}
