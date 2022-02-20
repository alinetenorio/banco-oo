package banco.controller;


import banco.domain.banco.Agencia;
import banco.storage.repositories.AgenciaRepository;
import banco.util.Endereco;

public class AgenciaController {
  AgenciaRepository agenciaRepository = new AgenciaRepository();
  
  public void editarAgencia(int numero, Endereco endereco, String telefone) throws Exception {
    if( numero < 0 || endereco == null || telefone == null || telefone.isEmpty() ) {
      throw new Exception("Dados inválidos");
    }

    agenciaRepository.atualizar(numero, endereco, telefone);
  }

  public Agencia buscarAgencia(int numero) throws Exception {
    if( numero < 0 ) {
      throw new Exception("Dados inválidos.");
    }

    return agenciaRepository.listar(numero);    
  }

}
