package banco.domain.conta;

import java.math.BigDecimal;
import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.pessoa.Cliente;
import banco.util.Env;
import lombok.Getter;

@Getter
public class ContaPoupanca extends Conta{
  private static final BigDecimal jurosMensais;

  static {
    if( Env.SELIC > 8.5 ) {
      jurosMensais = new BigDecimal(0.005);
    } else {
      jurosMensais = new BigDecimal(0.7 * Env.SELIC / 12);
    }
  }

  public ContaPoupanca(Agencia agencia, String numero, List<Cliente> titulares){
    super(agencia, numero, titulares);
  }
}