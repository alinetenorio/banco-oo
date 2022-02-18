package banco.domain.conta;

import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.pessoa.Cliente;

public class ContaCorrente extends Conta{
  public ContaCorrente(Agencia agencia, String numero, Cliente titular){
    super(agencia, numero, titular);
  }
  public ContaCorrente(Agencia agencia, String numero, List<Cliente> titulares){
    super(agencia, numero, titulares);
  }
}
