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
    Banco banco = listar(codigo);
      
    if( !nome.equals("-1") ) {
      banco.setNome(nome);
    }
    if( !cnpj.equals("-1") ) {
      banco.setCnpj(cnpj);
    }       
  }

  public void adicionarAgencia(int codigo, Agencia agencia) throws Exception {
    Banco banco = listar(codigo);
    banco.getAgencias().add(agencia);
  }

  public void removerAgencia(int codigo, Agencia agencia) throws Exception {
    Banco banco = listar(codigo);
    banco.getAgencias().remove(agencia);
  }

  public void remover(int codigo) throws Exception {
    Banco banco = listar(codigo);
    bancos.remove(banco);
  }

  public List<Banco> listarTodos() throws Exception {
    if (bancos.size() == 0 ) {
      throw new Exception("Não existem bancos cadastrados.");
    }
    return bancos;
  }
}
