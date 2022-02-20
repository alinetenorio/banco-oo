package banco.view.console;

import java.util.List;

import banco.controller.BancoController;
import banco.domain.banco.Banco;
import banco.util.Env;
import banco.util.Leitura;

public abstract class BancoView {
  private static BancoController bancoController = new BancoController();

  public static void exibirMenu() {
    int opcao;

    do {
      System.out.println(
        "\nDigite a opção desejada:\n" +
        "1 - Cadastrar novo banco\n" +
        "2 - Editar dados de um banco\n" +
        "3 - Adicionar nova agência\n" +
        "4 - Remover agência\n" +
        "5 - Buscar um banco\n" +
        "6 - Listar todos os bancos\n" +
        "7 - Excluir um banco\n" +
        "8 - Sair"
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
          cadastrarBanco();         
          break;

        case 2:
          editarBanco();         
          break;

        case 3:
          adicionarAgencia();         
          break;

        case 4:
          removerAgencia();         
          break;

        case 5:        
          buscar();
          break;

        case 6:        
          listarTodos();
          break;

        case 7:        
          excluir();
          break;

        case 8:        
          System.out.println("\nAté mais!");
          break;

        default:
          System.out.println("Opção inválida. Escolha um número de 1 a 8");        
      }
    } while( opcao != 8 );
  }

  public static void cadastrarBanco() {
    System.out.println("\nMENU - Cadastrar novo banco");
    System.out.println("Para cadastrar um novo banco, você precisa inserir" +
        " o nome, o CNPJ e o código do banco.");

    System.out.print("Nome: ");    
    String nome = Leitura.readLine();
    System.out.print("CNPJ: ");    
    String cnpj = Leitura.readLine();
    System.out.print("Código: ");    
    int codigo = Integer.parseInt(Leitura.readLine());

    try {
      bancoController.cadastrarBanco(nome, cnpj, codigo);
      System.out.println("Cadastro realizado com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }    
  }

  public static void buscar() {
    System.out.println("\nMENU - Buscar um banco");
    System.out.println("Para buscar um banco, você precisa inserir" +
        " o código dele.");

    System.out.print("Código: ");    
    int codigo = Integer.parseInt(Leitura.readLine());

    try {      
      Banco banco = bancoController.buscarBanco(codigo);
      if( banco != null ){
        System.out.println(banco.toString());
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

  public static void editarBanco() {
    System.out.println("\nMENU - Editar dados de um banco");
    System.out.println("Para editar um banco, você precisa inserir" +
        " o código do banco a ser atualizado com o novo nome e/ou novo CNPJ.");

    System.out.print("Código do banco: ");    
    int codigo = Integer.parseInt(Leitura.readLine());
    System.out.print("Nome (Se não quiser atualizar o nome, digite '-1'): ");    
    String nome = Leitura.readLine();
    System.out.print("CNPJ(Se não quiser atualizar o cnpj, digite '-1'): ");    
    String cnpj = Leitura.readLine();
    

    try {
      bancoController.editarBanco(codigo, nome, cnpj);
      System.out.println("Edição realizada com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }    
  }

  public static void adicionarAgencia() {
    System.out.println("\nMENU - Adicionar nova agência a um banco");
    System.out.println("Para adicionar uma agência, você precisa inserir" +
        " o código do banco e o número da agência.");

    System.out.print("Código do banco: ");    
    int codigo = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da agência: ");    
    int numero = Integer.parseInt(Leitura.readLine());  

    try {
      bancoController.adicionarAgencia(codigo, numero);
      System.out.println("Agência adicionada com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }  
  }

  public static void removerAgencia() {
    System.out.println("\nMENU - Remover agência");
    System.out.println("Para remover uma agência, você precisa inserir" +
        " o código do banco e o número da agência.");

    System.out.print("Código do banco: ");    
    int codigo = Integer.parseInt(Leitura.readLine());
    System.out.print("Número da agência: ");    
    int numero = Integer.parseInt(Leitura.readLine());  

    try {
      bancoController.removerAgencia(codigo, numero);
      System.out.println("Agência removida com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }  
  }
  
  public static void listarTodos() {
    System.out.println("\nMENU - Listar todos os bancos");

    try {
      List<Banco> bancos = bancoController.listarBancos();     
      for( Banco banco : bancos ) {
        if( banco != null ) {
          System.out.println(banco.toString());
        }
      }             
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }  
  }

  public static void excluir() {
    System.out.println("\nMENU - Excluir um banco");
    System.out.println("Para excluir um banco, você precisa inserir" +
        " o código do mesmo.");

    System.out.print("Código do banco: ");    
    int codigo = Integer.parseInt(Leitura.readLine());      

    try {
      bancoController.excluirBanco(codigo);
      System.out.println("Banco removido com sucesso!");      
    } catch (Exception e) {
      if(Env.AMBIENTE.equals("dev")) {
        e.printStackTrace();
      }
      System.out.println(e.getMessage());
    }  
  }

}
