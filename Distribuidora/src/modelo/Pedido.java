package modelo;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.IDInterface;

public class Pedido implements IDInterface {
	
	private int id;
	//private LocalDate datapedido = LocalDate.now();;
	private boolean entregue = false;
	private Cliente cliente;
	private Vendedor vendedor;
	private Motorista motorista;
	private double total;
	private ArrayList<Item>itens = new ArrayList<Item>();

	
	public Pedido(Cliente cliente, Vendedor vendedor) {
		 
		this.cliente = cliente;
		this.vendedor = vendedor;
		
	}

	// ----------------Getters/Setters---------------------//
	
	public int getId() {
		return id;
	}	
	
	public void setId(int id) {
		this.id = id;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	//---------------Relacionamento--------------//
	 
	//Pedido -> Item
	public void adicionar(Item item) {
		itens.add(item);
	}
	public void remover(Item item) {
		itens.remove(item);
	}


	public Item localizar(Produto nomeproduto) {
		for(Item it: itens) {
			if(it.getProduto().equals(nomeproduto)) {
				return it;
			}
		}
		return null;	
	}

	
	// -------- ToString ------- //
	
	public String toString() {
		String texto =  "Pedido -> id = " + id + "{\n Cliente = " + cliente.getNome() + ", \n Vendedor = " + vendedor.getNome();
		if(motorista == null) {
			texto += ", \n Motorista = Não entregue"; 
		}
		else {
			texto += ",\n Motorista = " + motorista.getNome();
		}
		texto += ", \n Produtos ->";
		if(itens == null) {
			texto += " vazio } ";
		}
		else {
		for(Item i: itens) {
			texto += " (" + i.getProduto().getNome() + ", Quantidade = " + i.getQuantidade();
		}
		texto+= ") \n Total = " + total;
		texto += "}\n";
		}
		return texto;
		}

		
	

}

