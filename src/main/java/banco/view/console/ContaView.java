package banco.view.console;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import banco.controller.ContaController;
import banco.domain.conta.Conta;
import banco.util.Env;
import banco.util.Leitura;
import banco.util.enums.TipoContaEnum;

public class ContaView {
  private static ContaController contaController = new ContaController();

  public static void exibirMenu() {
    int opcao;

    do {
      System.out.println(
        "\nDigite a opção desejada:\n" +
        "1 - Cadastrar nova conta\n" +
        "2 - Buscar conta\n" +
        "3 - Saldo\n" +
        "4 - Saque\n" +
        "5 - Transferência\n" +
        "6 - Depósito\n" +
        "7 - Adicionar titular em conta conjunta\n" +
        "8 - Remover titular em conta conjunta\n" +
        "9 - Sair"
      );    
    
      try {
        opcao = Integer.parseInt(Leitura.readLine());
        System.out.println("opcao: " + opcao);
      } catch (Exception e) {
        System.out.println("Entrada inválida");
        return;
      }
      
      switch( opcao ) {
        case 1:
          cadastrarConta();         
          break;

        case 2:
          buscarConta();         
          break;

        case 3:
          verSaldo();         
          break;

        case 4:
          sacar();         
          break;

        case 5:
          transferir();         
          break;

        case 6:        
          depositar();
          break;

        case 7:        
          adicionarTitular();
          break;

        case 8:        
          removerTitular();
          break;

        case 9:        
          System.out.println("\nAté mais!");
          break;

        default:
          System.out.println("Opção inválida. Escolha um número de 1 a 9");        
      }
    } while( opcao != 9 );
  }

  public static void cadastrarConta() {
    System.out.println("\nMENU - Cadastrar nova conta");
    System.out.println("Para cadastrar uma nova conta, você precisa inserir" +
        " o número da agência, o número da conta e o(s) titular(es).");

    System.out.print("Número da agência: ");    
    int numeroAgencia = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da conta: ");    
    String numeroConta = Leitura.readLine();
    System.out.print("Tipo da conta, 1 - Corrente, 2 - Poupança: ");    
    int tipoConta = Integer.parseInt(Leitura.readLine());
    TipoContaEnum tipo =  tipoConta == 1 ? TipoContaEnum.CORRENTE : TipoContaEnum.POUPANCA; 
    System.out.print("Quantidade de titulares: ");    
    int quantidadeTitulares = Integer.parseInt(Leitura.readLine());
    
    if(quantidadeTitulares <= 0) {
      System.out.println("Erro: Uma conta precisa ter pelo menos um titular.");
      return;
    }

    List<String> cpfTitulares = new ArrayList<>();   

    for(int i = 0; i < quantidadeTitulares; i++) {   
      System.out.println("Digite o CPF do titular:");
      String cpf = Leitura.readLine();

      cpfTitulares.add(cpf);
    }

    try {
      contaController.cadastrarConta(numeroAgencia, numeroConta, cpfTitulares, tipo);
      System.out.println("Cadastro realizado com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }    
  }

  public static void buscarConta() {
    System.out.println("\nMENU - Buscar uma conta");
    System.out.println("Para buscar uma conta, você precisa inserir" +
        " a agência e número.");

    System.out.print("Agência: ");    
    int numeroAgencia = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da conta: ");    
    String numeroConta = Leitura.readLine();

    try {      
      Conta conta = contaController.buscarConta(numeroAgencia, numeroConta);
      System.out.println(conta.toString());     
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

  public static void verSaldo() {    
    System.out.println("\nMENU - Ver saldo da conta");
    System.out.println("Para ver o saldo de uma conta, você precisa inserir" +
        " a agência e número.");

    System.out.print("Agência: ");    
    int numeroAgencia = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da conta: ");    
    String numeroConta = Leitura.readLine();

    try {      
      BigDecimal saldo = contaController.verSaldo(numeroAgencia, numeroConta);
      System.out.println("Saldo: " + NumberFormat.getCurrencyInstance(new Locale("pt", "PT"))
                                    .format(saldo) );           
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

  public static void sacar() {
    System.out.println("\nMENU - Saque");
    System.out.println("Para sacar dinheiro de uma conta, você precisa inserir" +
        " a agência, o número e o valor desejado.");

    System.out.print("Agência: ");    
    int numeroAgencia = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da conta: ");    
    String numeroConta = Leitura.readLine();
    System.out.print("Valor do saque: ");    
    BigDecimal valor = new BigDecimal(Leitura.readLine());

    try {      
      contaController.sacar(numeroAgencia, numeroConta, valor);
      System.out.println("Saque realizado com sucesso!");     
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

  public static void transferir() {
    System.out.println("\nMENU - Transferência");
    System.out.println("Para transferir dinheiro entre contas, você precisa inserir" +
        " a agência e o número das contas e o valor desejado.");

    System.out.print("Sua agência: ");    
    int numeroAgencia = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da sua conta: ");    
    String numeroConta = Leitura.readLine();
    System.out.print("Agência de destino: ");    
    int numeroAgenciaDestino = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da conta de destino: ");    
    String numeroContaDestino = Leitura.readLine();
    System.out.print("Valor da transferência: ");    
    BigDecimal valor = new BigDecimal(Leitura.readLine());

    try {      
      contaController.transferir(numeroAgencia, numeroConta, numeroAgenciaDestino, numeroContaDestino, valor);
      System.out.println("Transferência realizada com sucesso!");     
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

  public static void depositar() {
    System.out.println("\nMENU - Depósito");
    System.out.println("Para depositar dinheiro em uma conta, você precisa inserir" +
        " a agência, o número e o valor desejado.");

    System.out.print("Agência: ");    
    int numeroAgencia = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da conta: ");    
    String numeroConta = Leitura.readLine();
    System.out.print("Valor do depósito: ");    
    BigDecimal valor = new BigDecimal(Leitura.readLine());

    try {      
      contaController.depositar(numeroAgencia, numeroConta, valor);
      System.out.println("Depósito realizado com sucesso!");     
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

  public static void adicionarTitular() {
    System.out.println("\nMENU - Adicionar titular");
    System.out.println("Para adicionar um titular à conta, você precisa inserir" +
        " o código da conta e o CPF do titular.");

    System.out.print("Código: ");    
    int codigo = Integer.parseInt(Leitura.readLine());
    System.out.print("CPF: ");    
    String cpf = Leitura.readLine();

    try {      
      contaController.adicionarTitular(codigo, cpf);
      System.out.println("Titular adicionado com sucesso!");     
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

  public static void removerTitular() {
    System.out.println("\nMENU - Remover titular");
    System.out.println("Para remover um titular da conta, você precisa inserir" +
        " o código da conta e o CPF do titular.");

    System.out.print("Código: ");    
    int codigo = Integer.parseInt(Leitura.readLine());
    System.out.print("CPF: ");    
    String cpf = Leitura.readLine();

    try {      
      contaController.removerTitular(codigo, cpf);
      System.out.println("Titular removido com sucesso!");     
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

}
