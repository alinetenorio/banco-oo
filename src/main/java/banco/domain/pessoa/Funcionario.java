package banco.domain.pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

import banco.util.CargoEnum;
import banco.util.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Funcionario extends Pessoa {
  private Enum<CargoEnum> cargo;
  private BigDecimal salario;

  public Funcionario(String nome, String cpf, LocalDate dataNascimento, Endereco endereco,
                      String telefone, String email, CargoEnum cargo, BigDecimal salario) {
    super(nome, cpf, dataNascimento, endereco, telefone, email);
    this.cargo = cargo;
    this.salario = salario;
  }
}
