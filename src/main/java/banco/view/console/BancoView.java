package banco.view.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class BancoView {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public static void exibirMenu() {
    System.out.println(
      "1 - Cadastrar novo banco\n" +
      "2 - Editar dados de um banco\n" +
      "3 - Adicionar nova agência\n" +
      "4 - Remover agência\n" +
      "5 - Buscar um banco\n" +
      "6 - Listar todos os bancos\n" +
      "7 - Excluir um banco\n"
    );

    char opcao;
    try {
      opcao = (char)reader.read();
      System.out.println("opcao: " + opcao);
    } catch (Exception e) {
      System.out.println("Entrada inválida");
      return;
    }
    
    switch( opcao ) {
      case '1':
        cadastrarBanco();
        break;
    }
  }

  public static void cadastrarBanco() {
    System.out.println("Cadastrar banco");
  }

}
