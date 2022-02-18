package banco.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @AllArgsConstructor
public class Endereco {
  private String logradouro;
  private int numero;
  private String complemento;
  private String pontoReferencia;
  private String bairro;
  private String cidade;
  private String estado;

  public Endereco(String logradouro, String bairro, String cidade, String estado) {
    this.logradouro = logradouro;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
  }
}
