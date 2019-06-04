package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Cliente;


public class DAOCliente extends DAO<Cliente>{
    //Leitura POR telefone
    public Cliente read (Object chave) {
        String telefone = (String) chave;
        Query q = manager.query();
        q.constrain(Cliente.class);
        q.descend("telefone").constrain(telefone);
        List<Cliente> resultados = q.execute();
        if (resultados.size()>0)
            return resultados.get(0);
        else
            return null;
    }

}
