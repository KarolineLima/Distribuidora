package dao;

import java.util.List;

//import com.db4o.ObjectSet;
import com.db4o.query.Query;

//import modelo.Cliente;
//import modelo.Item;
//import modelo.Motorista;
import modelo.Pessoa;

public class DAOPessoa  extends DAO<Pessoa>{
	 
    //Leitura POR telefone
    public Pessoa read (Object chave) {
        String telefone = (String) chave;
        Query q = manager.query();
        q.constrain(Pessoa.class);
        q.descend("telefone").constrain(telefone);
        List<Pessoa> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }
    
    /*public static Motorista consultarMotoristaPedido(String telefoneCliente) {
    	Query q = manager.query();
    	q.constrain(Pessoa.class);
    	q.descend("telefone").constrain("telefoneCliente");
    	
    	ObjectSet<Cliente> cli = q.execute();
    	
    	cli.ge
    	
    
    }
   */	
    
}