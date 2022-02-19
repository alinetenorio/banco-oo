package banco.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import banco.domain.conta.Conta;
import banco.storage.repositories.ContaRepository;

public class ContaController {
  private ContaRepository repository = new ContaRepository();

  public void depositar(Conta conta, BigDecimal valor) throws Exception {
    if( conta == null || valor == null ){
      throw new Exception( "Os parâmetros não podem estar vazios." );
    } else if( valor.compareTo(BigDecimal.ZERO) <= 0 ) {    
      throw new Exception("Valor a ser depositado precisa ser maior que zero.");
    }

    conta.setSaldo(conta.getSaldo().add(valor));
  }

  public void sacar(Conta conta, BigDecimal valor) throws Exception{
    if( conta == null || valor == null ){
      throw new Exception( "Os parâmetros não podem estar vazios." );
    } else if( valor.compareTo(BigDecimal.ZERO) == 0 ) {
      throw new Exception("Valor a ser sacado precisa ser maior que zero.");
    } else if( conta.getSaldo().subtract(valor).compareTo(BigDecimal.ZERO) >= 0 ) {
      throw new Exception("Valor a ser sacado precisa ser maior que o saldo.");
    } 

    conta.setSaldo(conta.getSaldo().subtract(valor));  
  }

  public void transferir(Conta conta, Conta contaDestino, BigDecimal valor) throws Exception{
    if( conta == null || contaDestino == null || valor == null ){
      throw new Exception( "Os parâmetros não podem estar vazios." );
    } else if( valor.compareTo(BigDecimal.ZERO) == 0 ) {
      throw new Exception("Valor a ser sacado precisa ser maior que zero.");
    } else if( conta.getSaldo().subtract(valor).compareTo(BigDecimal.ZERO) >= 0 ) {
      throw new Exception("Valor a ser sacado precisa ser maior que o saldo.");
    } 

    conta.setSaldo( conta.getSaldo().subtract(valor) );
    contaDestino.setSaldo( contaDestino.getSaldo().add(valor) );
  }

  public String verSaldo(Conta conta) throws Exception {
    if( conta == null ) {
      throw new Exception("Conta não pode ser vazio");
    }

    return "Saldo: " + NumberFormat.getCurrencyInstance(new Locale("pt", "PT"))
                                    .format(conta.getSaldo());
  }

  /*
  public String verExtrato(LocalDate inicio, LocalDate fim) throws Exception {
    if( inicio == null || fim == null ) {
      throw new Exception( "Os parâmetros não podem estar vazios." );
    }
  
  }
  */
}
