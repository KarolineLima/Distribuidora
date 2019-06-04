package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Item;

public class DAOItem  extends DAO<Item>{
	 
    //Leitura POR nomeproduto
    public Item read (Object chave) {
        String nomeproduto = (String) chave;
        Query q = manager.query();
        q.constrain(Item.class);
        q.descend("nomeproduto").constrain(nomeproduto);
        List<Item> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }
    
   
}