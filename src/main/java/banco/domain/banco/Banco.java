package banco.domain.banco;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Banco {
  private String nome; 
  private int codigo;
  private List<Agencia> agencias;

  public Banco(String nome, int codigo) {
    this.agencias = new ArrayList<>();
    this.nome = nome;
    this.codigo = codigo;
  }
}