package banco.view.console;

import banco.util.Leitura;

public class InicioView {  
  
  public static void exibirMenu() {
    int opcao;

    do {
      System.out.println(
        "\nDigite a opção desejada:\n" +
        "1 - Operações bancárias\n" +
        "2 - Gerenciar bancos\n" +
        "3 - Gerenciar pessoas\n" +
        "4 - Sair\n"       
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
          ContaView.exibirMenu();     
          break;

        case 2:
          BancoView.exibirMenu();         
          break;

        case 3:
          PessoaView.exibirMenu();
          break;

        case 4:             
          System.out.println("\nAté mais!");
          break;

        default:
          System.out.println("Opção inválida. Escolha um número de 1 a 4");        
      }
    } while( opcao != 4 );
  }
}
