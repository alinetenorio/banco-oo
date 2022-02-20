package banco.view.console;

import java.util.List;

import banco.controller.PessoaController;
import banco.domain.pessoa.Cliente;
import banco.domain.pessoa.Funcionario;
import banco.domain.pessoa.Pessoa;
import banco.util.Env;
import banco.util.Leitura;
import banco.util.enums.CargoEnum;

public class PessoaView {
  private static PessoaController pessoaController = new PessoaController();

  public static void exibirMenu() {
    int opcao;

    do {
      System.out.println(
        "\nDigite a opção desejada:\n" +
        "1 - Cadastrar novo funcionário\n" +
        "2 - Cadastrar novo cliente\n" +
        "3 - Editar dados de uma pessoa\n" +       
        "4 - Buscar uma pessoa\n" +
        "5 - Listar todos os clientes\n" +
        "6 - Listar todos os funcionários\n" +
        "7 - Sair"
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
          cadastrarFuncionario();         
          break;

        case 2:
          cadastrarCliente();         
          break;

        case 3:
          editarPessoa();         
          break;

        case 4:
          buscarPessoa();         
          break;

        case 5:        
          listarClientes();
          break;

        case 6:        
          listarFuncionarios();
          break;

        case 7:        
          System.out.println("\nAté mais!");
          break;

        default:
          System.out.println("Opção inválida. Escolha um número de 1 a 7");        
      }
    } while( opcao != 7 );
  }

  public static void cadastrarFuncionario() {
    System.out.println("\nMENU - Cadastrar novo funcionário");
    System.out.println("Para cadastrar um novo funcionário, insira os dados pedidos");

    System.out.print("Nome: ");    
    String nome = Leitura.readLine();
    System.out.print("CPF: ");    
    String cpf = Leitura.readLine();    
    System.out.print("Cargo, 1 - Gerente, 2 - Atendente, 3 - Caixa: ");  
    int cargoInt = Integer.parseInt(Leitura.readLine());
    CargoEnum cargo;
    if(cargoInt == 1) {
      cargo = CargoEnum.GERENTE;
    } else if(cargoInt == 2) {
      cargo = CargoEnum.ATENDENTE;
    } else {
      cargo = CargoEnum.CAIXA;
    } 

    try {
      pessoaController.cadastrarFuncionario(nome, cpf, cargo);
      System.out.println("Cadastro realizado com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }    
  }

  public static void cadastrarCliente() {
    System.out.println("\nMENU - Cadastrar novo cliente");
    System.out.println("Para cadastrar um novo cliente, insira os dados pedidos");

    System.out.print("Nome: ");    
    String nome = Leitura.readLine();
    System.out.print("CPF: ");    
    String cpf = Leitura.readLine();        

    try {
      pessoaController.cadastrarCliente(nome, cpf);
      System.out.println("Cadastro realizado com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }    
  }

  public static void buscarPessoa() {
    System.out.println("\nMENU - Buscar uma pessoa");
    System.out.println("Para buscar uma pessoa, você precisa inserir" +
        " o cpf dele.");

    System.out.print("CPF: ");    
    String cpf = Leitura.readLine();

    try {      
      Pessoa pessoa = pessoaController.buscar(cpf);
      if( pessoa != null ){
        System.out.println(pessoa.toString());
      } else {
        System.out.println("Erro na operação. Por favor, tente novamente.");
      }
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }  
      System.out.println(e.getMessage());
    }      
  }

  public static void editarPessoa() {
    System.out.println("\nMENU - Editar dados de uma pessoa");
    System.out.println("Para editar uma pessoa, você precisa inserir" +
        " o CPF da mesma e os novos dados.");

    System.out.print("CPF da pessoa: ");    
    String cpf = Leitura.readLine();
    System.out.print("Nome (Se não quiser atualizar o nome, digite '-1'): ");    
    String nome = Leitura.readLine();
    System.out.print("Email (Se não quiser atualizar o cnpj, digite '-1'): ");    
    String email = Leitura.readLine();    

    try {
      pessoaController.editarPessoa(cpf, nome, email);
      System.out.println("Edição realizada com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }    
  }
  
  public static void listarClientes() {
    System.out.println("\nMENU - Listar todos os clientes");

    try {
      List<Cliente> clientes = pessoaController.listarClientes();     
      for( Cliente cliente : clientes ) {
        if( cliente != null ) {
          System.out.println(cliente.toString());
        }
      }             
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }  
  }

  public static void listarFuncionarios() {
    System.out.println("\nMENU - Listar todos os funcionários");

    try {
      List<Funcionario> funcionarios = pessoaController.listarFuncionarios();     
      for( Funcionario funcionario : funcionarios ) {
        if( funcionario != null ) {
          System.out.println(funcionario.toString());
        }
      }             
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }  
  }

}
