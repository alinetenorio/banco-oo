package banco;

import java.math.BigDecimal;
import java.time.LocalDate;

import banco.domain.banco.Agencia;
import banco.domain.banco.Banco;
import banco.domain.conta.Conta;
import banco.domain.conta.ContaCorrente;
import banco.domain.pessoa.Funcionario;
import banco.domain.pessoa.Pessoa;
import banco.util.Endereco;
import banco.util.enums.CargoEnum;
import banco.view.console.BancoView;
import banco.view.console.InicioView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       InicioView.exibirMenu();
    }
}
