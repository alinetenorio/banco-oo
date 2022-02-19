package banco.domain.banco;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Banco {
  private String nome; 
  private String cnpj;
  private int codigo;
  private List<Agencia> agencias;

  public Banco(String nome, String cnpj, int codigo) {
    this.agencias = new ArrayList<>();
    this.nome = nome;
    this.cnpj = cnpj;
    this.codigo = codigo;
  }
}