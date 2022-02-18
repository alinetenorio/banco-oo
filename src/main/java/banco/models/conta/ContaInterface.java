package banco.models.conta;

import java.math.BigDecimal;

public interface ContaInterface {
  int depositar(BigDecimal valor);
  int sacar(BigDecimal valor);
  int transferir(BigDecimal valor, ContaInterface contaDestino);
  String verSaldo();
   
}
