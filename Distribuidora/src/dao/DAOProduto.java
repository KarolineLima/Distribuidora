package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Produto;


public class DAOProduto  extends DAO<Produto>{

	//Leitura POR nome 
	public Produto read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(nome);
		List<Produto> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}


	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE PRODUTO
	 * 
	 **********************************************************/
	public  List<Produto> consultarProdutoPorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(caracteres).like();
		List<Produto> result = q.execute(); 
		return result;
	}

	public int consultarTotalProdutos() {
		Query q = manager.query();
		q.constrain(Produto.class);
		int total = q.execute().size(); 
		return total;
	}


}

