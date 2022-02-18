package banco.models;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Banco {
  private String nome; 
  private int codigo;
  private List<Agencia> agencias;

  /*
  public Banco(String nome, int codigo) {
    this.agencias = new ArrayList<>();
    this.nome = nome;
    this.codigo = codigo;
  }
  */
}