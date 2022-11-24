
public abstract class Conta implements IConta{
	
	protected static final int AGENCIA_PADRAO = 01;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
		
	}

	@Override
	public void depositar(double valor) {
		
		if(valor > 1000) {
			limiteDeposito();
		}else {
			this.saldo += valor;
		}
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		
		if(saldo < valor) {
			transferenciaNegada();
		}else {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: " + this.cliente.getNomeCliente()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	protected void transferenciaNegada() {
		System.out.println("@@@ Transferencia negada, saldo insuficiente!!! @@@");
		System.out.println();
		System.out.println("#### Extrato Atualizado: ####");
		System.out.println();
	}
	
	protected void limiteDeposito() {
		System.out.println("Limite de deposito alcançado!!!");
	}
}