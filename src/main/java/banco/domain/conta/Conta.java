package banco.domain.conta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.pessoa.Cliente;
import banco.domain.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public abstract class Conta {
  private static int SEQUENCIAL = 1;

  private Agencia agencia;
  private String numero;
  private BigDecimal saldo;
  private List<Cliente> titulares;
  private int codigo;

  {
    this.codigo = SEQUENCIAL++;
  }

  public Conta(Agencia agencia, String numero, List<Cliente> titulares) {
    this.agencia = agencia;
    this.numero = numero;
    this.saldo = BigDecimal.ZERO;
    this.titulares = titulares;
  }
}