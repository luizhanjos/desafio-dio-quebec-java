
public class Main {

	public static void main(String[] args) {
		
		Cliente loa = new Cliente();
		loa.setNomeCliente("Luiz Henrique");
		
		Conta cc = new ContaCorrente(loa);
		cc.depositar(999);
		
		Conta poupanca = new ContaPoupanca(loa);
		
		cc.transferir(50, poupanca);
		
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}
}