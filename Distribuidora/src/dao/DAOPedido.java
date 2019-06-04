package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Cliente;
//import modelo.Item;
import modelo.Pedido;

public class DAOPedido  extends DAO<Pedido>{
    //Leitura POR id
	
	public Pedido read (Object chave) {
		int id = (Integer)chave;
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("id").constrain(id);
		List<Pedido> resultados = q.execute();
		if (resultados.size() != 0)
            return resultados.get(0);
        else
           return null;
	}
    public Pedido localizaPedidoAbertoCliente (Cliente cli) {
        Query q = manager.query();
        q.constrain(Pedido.class);
        q.descend("cliente").constrain(cli);
        q.descend("entregue").constrain(false);
        List<Pedido> resultados = q.execute();
        
        
        
        if (resultados.size()>0)
            return resultados.get(0);
        else
           return null;
    }
 
    
    
    /*public static Cliente consultarPedido(String telefonecliente) throws Exception {
    	Query q = manager.query();
    	q.constrain(Pedido.class);
    	q.descend("pedido").constrain("telefone");
    	List<Item> resultados = q.execute();
    	return resultados;
	}*/
}