package banco.storage.dao;

import java.util.ArrayList;
import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.banco.Banco;
import banco.domain.conta.Conta;
import banco.util.Endereco;

public class AgenciaDAO {
  BancoDAO bancoDAO = new BancoDAO();
  List<Agencia> agencias = new ArrayList<>();

  public Agencia listar(int numero) throws Exception {
    List<Banco> bancos = bancoDAO.listarTodos();
    List<Agencia> agencias;
    for( Banco b : bancos ) {
      agencias = b.getAgencias();
      for( Agencia a : agencias ) {
        if( a.getNumero() == numero ) {
          return a;
        }
      }
    }
    throw new Exception("A agência não foi encontrada no sistema.");
  }

  public Conta listarConta(int numeroAgencia, String numeroConta) throws Exception {
    Agencia agencia = listar(numeroAgencia);
    for( Conta conta : agencia.getContas() ) {
      if( conta.getNumero() == numeroConta ) {
        return conta;
      }
    }

    throw new Exception("A conta não foi encontrada no sistema.");
  }

  public Conta listarConta(int codigo) throws Exception {    
    for( Agencia agencia : agencias ) {
      for( Conta conta : agencia.getContas() ) {
        if( conta.getCodigo() == codigo ) {
          return conta;
        }
      }
    }

    throw new Exception("A conta não foi encontrada no sistema.");
  }

  public void atualizar(int numero, Endereco endereco, String telefone) throws Exception {
    Agencia agencia = listar(numero);
  
    if( agencia != null ) {
      if( endereco != null ) {
        agencia.setEndereco(endereco);
      }
      if( telefone != null ) {
        agencia.setTelefone(telefone);
      }
      return;
    }
    
    throw new Exception("A agência não foi encontrada no sistema.");
  }

  public void adicionarConta(Agencia agencia, Conta conta) throws Exception {
    if( conta == null ) {
      throw new Exception("A conta não pode estar vazia.");
    }
    agencia.getContas().add(conta);        
  }

}
