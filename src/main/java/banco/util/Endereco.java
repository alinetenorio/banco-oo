package banco.util;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Endereco {
  private String logradouro;
  private int numero;
  private String complemento;
  private String pontoReferencia;
  private String bairro;
  private String cidade;
  private String estado;
}
