package fachada;

//import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.DAOCliente;
import dao.DAOItem;
import dao.DAOMotorista;
import dao.DAOPedido;
import dao.DAOPessoa;
import dao.DAOProduto;
import dao.DAOVendedor;
import modelo.Cliente;
import modelo.Item;
import modelo.Motorista;
import modelo.Pedido;
import modelo.Pessoa;
import modelo.Produto;
import modelo.Vendedor;


public class Fachada {
	
	private static DAOProduto daoproduto = new DAOProduto();
	private static DAOItem daoitem = new DAOItem();
	private static DAOPedido daopedido = new DAOPedido();
	private static DAOPessoa daopessoa = new DAOPessoa();
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOVendedor daovendedor = new DAOVendedor();
	private static DAOMotorista daomotorista = new DAOMotorista();
	
	

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Pessoa cadastrarPessoa(String nome, String telefone,String endereco,String email) throws  Exception{
		DAO.begin();	
		Pessoa pessoa= daopessoa.read(telefone);
		if(pessoa != null)
			throw new Exception("Cadastrar Pessoa  - Pessoa já cadastrada:" + nome);

		pessoa = new Pessoa(nome,telefone,endereco,email);
		daopessoa.create(pessoa);	
		DAO.commit();
		return pessoa;
	}	

	
	
	public static Cliente cadastrarCliente(String nome, String telefone,String endereco,String email) throws  Exception{
		DAO.begin();	
		Pessoa pessoa= daopessoa.read(telefone);
		if(pessoa != null)
			throw new Exception("Cadastrar Cliente  - Pessoa já cadastrada:" + nome);

		pessoa = new Cliente(nome,telefone,endereco,email);
		daopessoa.create(pessoa);	
		DAO.commit();
		return (Cliente) pessoa;
	}	
	
	
	
	public static Vendedor cadastrarVendedor(String nome, String telefone,String endereco,String email) throws  Exception{
		DAO.begin();	
		Pessoa pessoa= daopessoa.read(telefone);
		if(pessoa != null)
			throw new Exception("Cadastrar Vendedor  - Pessoa já cadastrada:" + nome);

		pessoa = new Vendedor(nome,telefone,endereco,email);
		daopessoa.create(pessoa);	
		DAO.commit();
		return (Vendedor) pessoa;
	}	
	
	public static Motorista cadastrarMotorista(String nome, String telefone,String endereco,String email) throws  Exception{
		DAO.begin();	
		Pessoa pessoa= daopessoa.read(telefone);
		if(pessoa != null)
			throw new Exception("Cadastrar Motorista  - Pessoa já cadastrada:" + nome);

		pessoa = new Motorista(nome,telefone,endereco,email);
		daopessoa.create(pessoa);	
		DAO.commit();
		return (Motorista) pessoa;
	}	
	
	
	
	public static Produto cadastrarProduto(String nome, double preco, int estoque) throws  Exception{
		DAO.begin();	
		Produto p = daoproduto.read(nome);
		if(p != null)
			throw new Exception("Cadastrar Produto - Produto " + nome + " já está cadastrado");

		p = new Produto(nome,estoque,preco);
		daoproduto.create(p);	
		DAO.commit();
		return p;
	}

	public static Pedido abrirPedido(String telefonecliente, String telefoneVendedor)throws  Exception{
		
		DAO.begin();	
		//procura cliente
		Cliente cliente = daocliente.read(telefonecliente);
		//verifica se cliente existe
		if(cliente == null) {
			throw new Exception("Abrir pedido -> Cliente não está cadastrado");
		}
		
		
		Pedido ped = daopedido.localizaPedidoAbertoCliente(cliente);
		
		if(ped != null) {
			throw new Exception("Abrir pedido -> Cliente possui pedido que não foi entregue, não é possível abrir outro pedido!");
		}
		
		
		Vendedor vendedor = daovendedor.read(telefoneVendedor);
		if(vendedor == null) {
			throw new Exception("Abrir pedido -> Vendedor não está cadastrado!");
		}
		ped = new Pedido(cliente,vendedor);
		daopedido.create(ped);
		cliente.addPedido(ped);
		daocliente.update(cliente);
		vendedor.addVenda(ped);
		daovendedor.update(vendedor);
		DAO.commit();
		return ped;
	}

	public static Item adicionarItemPedido( String nomeproduto,int quantidade, String telefoneCliente) throws  Exception{
		DAO.begin();	
		Produto prod = daoproduto.read(nomeproduto);
		if(prod == null) {
			throw new Exception("Produto:" + nomeproduto + "não está cadastrado");
		}
		
		Cliente cli = daocliente.read(telefoneCliente);
		if(cli == null) {
			throw new Exception("Cliente não cadastrado!");
		}
		System.out.println("cliente:" + cli);

		
		Pedido pedido = daopedido.localizaPedidoAbertoCliente(cli);
		System.out.println(pedido);
		
		if(pedido == null) {
			throw new Exception("Não existe pedido aberto");
		}
	
		
		Item it = new Item( prod, quantidade, pedido );
		
		pedido.adicionar(it);
		daopedido.update(pedido);	
		DAO.commit();
		return it;
	}

	//Alterações
	public static void alterarEndereco(String telefone, String novoendereco) throws Exception{
		DAO.begin();
		Pessoa pessoa = daopessoa.read(telefone);
		if(pessoa == null) {
            throw new Exception("Alterar endereço - Pessoa inexistente");
		}
		pessoa.setEndereco(novoendereco);
		pessoa = daopessoa.update(pessoa);
		DAO.commit();
	}
	
	public static void alterarTelefone(String telefone, String novotelefone) throws Exception{
		DAO.begin();
		Pessoa pessoa = daopessoa.read(telefone);
		if(pessoa == null) {
            throw new Exception("Alterar telefone - Pessoa inexistente");
		}
		pessoa.setTelefone(novotelefone);
		pessoa = daopessoa.update(pessoa);
		DAO.commit();
	}
	//Exclusões
	
	public static void excluirItemPedido (Produto nomeproduto, String telefoneCliente) throws  Exception{
		DAO.begin();
		
		Pedido pedido = daopedido.read(telefoneCliente);
		
		if(pedido == null) {
			throw new Exception("Não existe pedido aberto!");
		}
		
		
		Produto prod = daoproduto.read(nomeproduto);
		if(prod == null) {
			throw new Exception("Produto:" + nomeproduto + "não está cadastrado");
		}
		

		Item it = pedido.localizar(nomeproduto);		
		if(it == null)
			throw new Exception("Item" + nomeproduto + "não está na venda" );

		/*int quant = it.getQuantidade() - quantidade;
		it.setQuantidade(quant);
		*/
		pedido.remover(it);
		
		
		daopedido.update(pedido);	
		daoitem.delete(it);	//excluir orfao
		DAO.commit();
		
	}

	
	public static void excluirPedido(String telefoneCliente) throws Exception {
		DAO.begin();
		Pedido pedido = daopedido.read(telefoneCliente);
		
		if (pedido == null) 
			throw new Exception("Excluir pedido - pedido inexistente");

		if(pedido.isEntregue() != false) {
			throw new Exception("Excluir pessoa - pedido já entregue, você não pode excluí-lo!");
		}
		
		daopedido.delete(pedido);
		DAO.commit();
	}

	public static void excluirPessoa(String telefone) throws Exception {
		DAO.begin();
		Pessoa pessoa = daopessoa.read(telefone);
		if(pessoa == null) {
			throw new Exception("Excluir Pessoa - Pessoa não cadastrado");
		}
		
		daopessoa.delete(pessoa);
		DAO.commit();
	}

	public static void fecharPedido(String telefoneCliente, String telefoneMotorista) throws Exception {
		DAO.begin();	
		//procura cliente
		Cliente cliente = daocliente.read(telefoneCliente);
		//verifica se cliente existe
		if(cliente == null) {
			throw new Exception("Fechar pedido -> Cliente não está cadastrado");
		}
		Pedido pedido = daopedido.localizaPedidoAbertoCliente(cliente);
		
		if (pedido == null) 
			throw new Exception("Fechar pedido -> cliente não possui pedido aberto!" );
		
		
		Motorista motorista = daomotorista.read(telefoneMotorista);
		if(motorista == null) {
			throw new Exception("Fechar pedido -> Motorista não cadastrado!");
		}
		
		double total = 0;
		for(Item it: pedido.getItens() ) {
			total += it.getValor();
		}
		
		
		pedido.setTotal(total);
		pedido.setMotorista(motorista);
		pedido.setEntregue(true);
		daopedido.update(pedido);
		motorista.addEntrega(pedido);
		daomotorista.update(motorista);
		DAO.commit();
	}
	
	
	public static void excluirProduto(String nomeproduto) throws Exception {

		DAO.begin();

		Produto p = daoproduto.read(nomeproduto);
		if(p == null)
			throw new Exception("Excluir Produto - Produto "  + nomeproduto + " inexistente");

		daoproduto.delete(p);
		DAO.commit();

	}
	
	public static Pedido visualizarPedidoAbertoCliente(String telefoneCliente) throws Exception{
		DAO.begin();	
		//procura cliente
		Cliente cliente = daocliente.read(telefoneCliente);
		//verifica se cliente existe
		if(cliente == null) {
			throw new Exception("Visualizar pedido -> Cliente não está cadastrado");
		}
		Pedido pedido = daopedido.localizaPedidoAbertoCliente(cliente);
		
		if (pedido == null) 
			throw new Exception("Fechar pedido -> cliente não possui pedido aberto!" );
		return pedido;
		
	}
	
	public static Motorista visualizarMotoristaPedidoCliente(int id) throws Exception{
		DAO.begin();
		Pedido pedido = daopedido.read(id);
		if(pedido == null) {
			throw new Exception("Visualizar pedido -> Pedido inexistente!");
		}
		
		Motorista motorista = daomotorista.localizaMotoristaPedidoCliente(id);
		if(motorista == null) {
			throw new Exception("Visualizar pedido -> Motorista não localizado!");
		}
		return motorista;
	}
	
	public static Motorista visualizarEntregasMotorista(String telefoneMotorista) throws Exception {
		DAO.begin();
		Motorista motorista = daomotorista.read(telefoneMotorista);
		if(motorista == null) {
			throw new Exception("Visualizar entregas do Motorista -> Motorista não localizado!");
		}
		return motorista;
	}
	
	
//Listagens 
	
	public static String listarProdutos(){
		List<Produto> produto = daoproduto.readAll();
		String texto="-----------Listagem de Produtos-----------\n";
		for (Produto p : produto) {
			texto += p +"\n";
		}
		return texto;
	}

	public static String listarPessoas() { 	
		List<Pessoa> pessoas = daopessoa.readAll();
		String texto="-----------Listagem de Usuarios---------\n";
		for(Pessoa user: pessoas) {
			texto += "\n" + user; 
		}
		return texto;
	}
	
	public static String listarClientes() { 	
		List<Cliente> cliente = daocliente.readAll();
		String texto="-----------Listagem de Clientes---------\n";
		for(Pessoa user: cliente) {
			texto += "\n" + user; 
		}
		return texto;
	}
	
	public static String listarVendedores() { 	
		List<Vendedor> vendedores = daovendedor.readAll();
		String texto="-----------Listagem de Vendedores---------\n";
		for(Pessoa user: vendedores) {
			texto += "\n" + user; 
		}
		return texto;
	}
	
	public static String listarMotorista() { 	
		List<Motorista> motoristas = daomotorista.readAll();
		String texto="-----------Listagem de Motoristas---------\n";
		for(Pessoa user: motoristas) {
			texto += "\n" + user; 
		}
		return texto;
	}
	
	public static String listarPedidos() { 	
		List<Pedido> pedidos = daopedido.readAll();
		String texto="-----------Listagem de Pedidos---------\n";
		for(Pedido vend : pedidos) {
			texto += "\n" + vend; 
		}
		return texto;
	}
	

	 

//Consultas	
	
	
	public static String consultarProdutoPorParteNome(String nome) {
        List<Produto> result = daoproduto.consultarProdutoPorParteNome(nome);
 
        String texto = "\nConsultar pessoas por parte do nome: " + nome;
        if (result.isEmpty())  
            texto += "consulta vazia";
        else
            for(Produto p: result)texto += "\n" + p;
        return texto;
    }
	
	
	
	
}
