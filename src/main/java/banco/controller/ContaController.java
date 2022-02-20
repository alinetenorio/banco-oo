package banco.controller;

import java.math.BigDecimal;
import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.conta.Conta;
import banco.domain.conta.ContaCorrente;
import banco.domain.conta.ContaPoupanca;
import banco.domain.pessoa.Cliente;
import banco.storage.repositories.AgenciaRepository;
import banco.storage.repositories.ContaRepository;
import banco.storage.repositories.PessoaRepository;
import banco.util.enums.TipoContaEnum;

public class ContaController {
  private ContaRepository repository = new ContaRepository();
  private AgenciaRepository agenciaRepository = new AgenciaRepository();
  private PessoaRepository pessoaRepository = new PessoaRepository();

  public void depositar(int numeroAgencia, String numeroConta, BigDecimal valor) throws Exception {
    if( numeroAgencia < 0 || numeroConta == null || numeroConta.isEmpty() || valor == null ){
      throw new Exception( "Os parâmetros não podem estar vazios." );
    } else if( valor.compareTo(BigDecimal.ZERO) <= 0 ) {    
      throw new Exception("Valor a ser depositado precisa ser maior que zero.");
    }

    Conta conta = agenciaRepository.listarConta(numeroAgencia, numeroConta);

    repository.atualizarSaldo(conta, conta.getSaldo().add(valor));   
  }

  public void sacar(int numeroAgencia, String numeroConta, BigDecimal valor) throws Exception{
    if( numeroAgencia < 0 || numeroConta == null || numeroConta.isEmpty() || valor == null ){
      throw new Exception( "Os parâmetros não podem estar vazios." );
    } else if( valor.compareTo(BigDecimal.ZERO) == 0 ) {
      throw new Exception("Valor a ser sacado precisa ser maior que zero.");
    } 

    Conta conta = agenciaRepository.listarConta(numeroAgencia, numeroConta);
    if( conta.getSaldo().subtract(valor).compareTo(BigDecimal.ZERO) >= 0 ) {
      throw new Exception("Saldo insuficiente.");
    } 

    repository.atualizarSaldo(conta, conta.getSaldo().subtract(valor));     
  }

  public void transferir(int numeroAgencia, String numeroConta, int numeroAgenciaDestino,
                          String numeroContaDestino, BigDecimal valor) throws Exception{
    if( numeroAgencia < 0 || numeroAgenciaDestino < 0 || numeroConta == null || 
        numeroContaDestino == null || numeroConta.isEmpty() || numeroContaDestino.isEmpty() || 
        valor == null ){
      throw new Exception( "Os parâmetros não podem estar vazios." );
    } else if( valor.compareTo(BigDecimal.ZERO) == 0 ) {
      throw new Exception("Valor a ser transferido precisa ser maior que zero.");
    } 
    
    Conta conta = agenciaRepository.listarConta(numeroAgencia, numeroConta);
    Conta contaDestino = agenciaRepository.listarConta(numeroAgenciaDestino, numeroContaDestino);

    if( conta.getSaldo().subtract(valor).compareTo(BigDecimal.ZERO) >= 0 ) {
      throw new Exception("Saldo insuficiente.");
    } 

    repository.atualizarSaldo(conta, conta.getSaldo().subtract(valor));
    repository.atualizarSaldo(contaDestino, contaDestino.getSaldo().add(valor));    
  }

  public BigDecimal verSaldo(int numeroAgencia, String numeroConta) throws Exception {
    if( numeroAgencia < 0 || numeroConta == null || numeroConta.isEmpty() ) {
      throw new Exception("Dados inválidos");
    }

    Conta conta = agenciaRepository.listarConta(numeroAgencia, numeroConta);

    return conta.getSaldo();
  }

  public void adicionarTitular(int codigo, String cpf) throws Exception {
    if( codigo < 0 || cpf == null || cpf.isEmpty()  ) {
      throw new Exception("Dados inválidos.");
    }

    Conta conta = agenciaRepository.listarContaPorCodigo(codigo);
    Cliente cliente = pessoaRepository.listarCliente(cpf);

    repository.adicionarTitular(conta, cliente);       
  }

  public void removerTitular(int codigo, String cpf) throws Exception {
    if( codigo < 0 || cpf == null || cpf.isEmpty()  ) {
      throw new Exception("Dados inválidos.");
    }

    Conta conta = agenciaRepository.listarContaPorCodigo(codigo);
    Cliente cliente = pessoaRepository.listarCliente(cpf);

    repository.removerTitular(conta, cliente);       
  }

  public void cadastrarConta(int numeroAgencia, String numeroConta, List<String> cpfTitulares, 
                              TipoContaEnum tipo) throws Exception {
    if( numeroAgencia < 0 || numeroConta == null || numeroConta.isEmpty() || cpfTitulares.isEmpty() || cpfTitulares == null 
        || tipo == null ) {
      throw new Exception("Complete todos os dados para o cadastro");
    }

    Agencia agencia = agenciaRepository.listar(numeroAgencia);
    List<Cliente> titulares = pessoaRepository.listarClientesCpf(cpfTitulares);

    Conta conta = null;
    if( tipo == TipoContaEnum.CORRENTE ) {
      conta = new ContaCorrente(agencia, numeroConta, titulares);
    } else if( tipo == TipoContaEnum.POUPANCA ) {
      conta = new ContaPoupanca(agencia, numeroConta, titulares);
    }

    agenciaRepository.adicionarConta(agencia, conta); 
  }

  public Conta buscarConta(int numeroAgencia, String numeroConta) throws Exception {
    if( numeroAgencia < 0 || numeroConta == null || numeroConta.isEmpty() ) {
      throw new Exception("Dados inválidos.");
    }

    return agenciaRepository.listarConta(numeroAgencia, numeroConta);    
  }
  
}
