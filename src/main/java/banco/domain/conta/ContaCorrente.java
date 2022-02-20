package banco.domain.conta;

import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.pessoa.Cliente;
import banco.domain.pessoa.Pessoa;

public class ContaCorrente extends Conta{
  public ContaCorrente(Agencia agencia, String numero, List<Cliente> titulares){
    super(agencia, numero, titulares);
  }
}
