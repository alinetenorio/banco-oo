package banco.models;

import java.util.ArrayList;
import java.util.List;
import banco.models.conta.Conta;
import banco.models.conta.ContaInterface;
import banco.util.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
public class Agencia {
  private List<ContaInterface> contas;
  private Endereco endereco;

  // public Agencia(Endereco endereco) {
  //   this.contas = new ArrayList<>();
  //   this.endereco = endereco;
  // }
}
