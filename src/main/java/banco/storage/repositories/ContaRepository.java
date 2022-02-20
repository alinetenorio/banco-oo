package banco.storage.repositories;

import java.math.BigDecimal;
import java.util.List;

import banco.domain.conta.Conta;
import banco.domain.pessoa.Cliente;
import banco.storage.dao.ContaDAO;

public class ContaRepository {
  private ContaDAO DAO = new ContaDAO();

  public void atualizarSaldo(Conta conta, BigDecimal novoSaldo) throws Exception {
    DAO.atualizarSaldo(conta, novoSaldo);
  }

  public void adicionarTitular(Conta conta, Cliente titular) throws Exception {
    DAO.adicionarTitular(conta, titular);
  }

  public void removerTitular(Conta conta, Cliente titular) throws Exception {
    DAO.removerTitular(conta, titular);
  }

}
