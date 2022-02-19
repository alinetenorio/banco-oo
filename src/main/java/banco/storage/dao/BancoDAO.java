package banco.storage.dao;

import java.util.ArrayList;
import java.util.List;

import banco.domain.banco.Agencia;
import banco.domain.banco.Banco;

public class BancoDAO {
  List<Banco> bancos;

  public BancoDAO() {
    bancos = new ArrayList<>();
  }

  public void criar(Banco banco) throws Exception{
    if( banco == null ){
      throw new Exception("O banco não pode estar vazio");
    }
    bancos.add(banco);
  }

  public Banco listar(int codigo) throws Exception {
    for( Banco b : bancos ) {
      if( codigo == b.getCodigo() ) {
        return b;
      }
    }
    throw new Exception("O banco não foi encontrado no sistema.");
  }

  public void atualizar(int codigo, String nome, String cnpj) throws Exception {
    for( Banco b : bancos ) {
      if( codigo == b.getCodigo() ) {
        if( !nome.equals("-1") ) {
          b.setNome(nome);
        }
        if( !cnpj.equals("-1") ) {
          b.setCnpj(cnpj);
        }
        return;
      }
    }
    throw new Exception("O banco não foi encontrado no sistema.");
  }

  public void adicionarAgencia(int codigo, Agencia agencia) throws Exception {
    for( Banco b : bancos ) {
      if( codigo == b.getCodigo() ) {
        b.getAgencias().add(agencia);
        return;
      }
    }
    throw new Exception("O banco não foi encontrado no sistema.");
  }

  public void removerAgencia(int codigo, Agencia agencia) throws Exception {
    for( Banco b : bancos ) {
      if( codigo == b.getCodigo() ) {
        b.getAgencias().remove(agencia);
        return;
      }
    }
    throw new Exception("O banco não foi encontrado no sistema.");
  }

  public void remover(int codigo) throws Exception {
    for( Banco b : bancos ) {
      if( codigo == b.getCodigo() ) {
        bancos.remove(b);
        return;
      }
    }
    throw new Exception("O banco não foi encontrado no sistema.");
  }

  public List<Banco> listarTodos() throws Exception {
    if (bancos.size() == 0 ) {
      throw new Exception("Não existem bancos cadastrados.");
    }
    return bancos;
  }
}
