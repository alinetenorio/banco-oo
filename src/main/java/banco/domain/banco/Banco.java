package banco.domain.banco;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

  public String toString() {
    String res = "\nDados do banco:\n" +
            "Nome: " + this.getNome() + "\n" +
            "CNPJ: " + this.getCnpj() + "\n" +
            "Código: " + this.getCodigo() + "\n" +
            "Lista de agências: \n";
            
            for( Agencia a : agencias ) {
              res += a.toString();
            }
            
    return res;
  }
}