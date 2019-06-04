package dao;

import java.util.List;

//import com.db4o.ObjectSet;
import com.db4o.query.Query;

//import modelo.Cliente;
import modelo.Motorista;
//import modelo.Pedido;

public class DAOMotorista extends DAO<Motorista> {
	//Leitura POR telefone
    public Motorista read (Object chave) {
        String telefone = (String) chave;
        Query q = manager.query();
        q.constrain(Motorista.class);
        q.descend("telefone").constrain(telefone);
        List<Motorista> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
        	return null;
    }
    
    public Motorista localizaMotoristaPedidoCliente(int idpedido) {
    	Query q = manager.query();
        q.constrain(Motorista.class);
        q.descend("entregas").descend("id").constrain(idpedido);
        //q.descend("Motorista");
        List<Motorista> res = q.execute();
        if (res.size()>0)
            return res.get(0);
        else
           return null;
        
    }
    
    
    
}
