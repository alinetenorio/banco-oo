package banco.storage.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import banco.domain.conta.Conta;
import banco.domain.pessoa.Cliente;

public class ContaDAO {
  List<Conta> contas = new ArrayList<>();

  public void atualizarSaldo(Conta conta, BigDecimal novoSaldo) throws Exception {
   conta.setSaldo(novoSaldo); 
  }

  public void adicionarTitular(Conta conta, Cliente titular) {
    conta.getTitulares().add(titular);
  }

  public void removerTitular(Conta conta, Cliente titular) throws Exception {
    if(conta.getTitulares().size() == 1) {
      throw new Exception("A conta precisa ter pelo menos um titular.");
    }
    conta.getTitulares().remove(titular);
  }

}
