package banco.domain.pessoa;

import java.time.LocalDate;
import banco.util.Endereco;
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
}
