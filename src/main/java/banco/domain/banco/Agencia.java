package banco.domain.banco;

import java.util.ArrayList;
import java.util.List;
import banco.domain.conta.Conta;
import banco.util.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Agencia {
  private List<Conta> contas;
  private int numero;
  private Endereco endereco;
  private String telefone;

  public Agencia(int numero) {
    this.contas = new ArrayList<>();
    this.numero = numero;
  }

  public Agencia(int numero, Endereco endereco) {
    this.numero = numero;
    this.endereco = endereco;
  }

  public Agencia(int numero, Endereco endereco, String telefone) {
    this.numero = numero;
    this.endereco = endereco;
    this.telefone = telefone;
  }
}
