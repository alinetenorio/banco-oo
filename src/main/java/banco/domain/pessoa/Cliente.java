package banco.domain.pessoa;

import java.time.LocalDate;

import banco.util.Endereco;
import banco.util.enums.RoleEnum;

public class Cliente extends Pessoa {
  public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereco endereco,
                  String telefone, String email) {
    super(nome, cpf, dataNascimento, endereco, telefone, email, RoleEnum.CLIENTE);
  }

  public Cliente(String nome, String cpf) {
    super(nome, cpf, RoleEnum.CLIENTE);   
  }
}
