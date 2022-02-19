package banco.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Endereco {
  private String logradouro;
  private int numero;
  private String complemento;
  private String pontoReferencia;
  private String bairro;
  private String cidade;
  private String estado;
  private String cep;

  {
    this.numero = -1;
    this.complemento = "Não preenchido";
    this.pontoReferencia = "Não preenchido";
    this.cep = "Não preenchido";
  }

  public Endereco(String logradouro, String bairro, String cidade, String estado) {
    this.logradouro = logradouro;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
  }

  public String toString() {
    return "\nDados do endereço:\n" +
            "Logradouro: " + this.getLogradouro() + "\n" +
            "Número: " + this.getNumero() + "\n" +
            "Complemento: " + this.getComplemento() + "\n" +
            "Ponto de referência: " + this.getPontoReferencia() + "\n" +
            "Bairro: " + this.getBairro() + "\n" +
            "Cidade: " + this.getCidade() + "\n" + 
            "Estado: " + this.getEstado() + "\n" +
            "CEP: " + this.getCep() + "\n";
  }
}
