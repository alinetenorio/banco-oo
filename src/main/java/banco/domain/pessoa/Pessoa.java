package banco.domain.pessoa;

import java.time.LocalDate;
import banco.util.Endereco;
import banco.util.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
public abstract class Pessoa {
  private String nome;
  private String cpf;
  private LocalDate dataNascimento;
  private Endereco endereco;
  private String telefone;
  private String email;
  private RoleEnum role;

  public Pessoa(String nome, String cpf, RoleEnum role) {
    this.nome = nome;
    this.cpf = cpf;
    this.role = role;
  }
}
