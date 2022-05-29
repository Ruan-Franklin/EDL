package Fila;
//O primeiro elemento a entrar na fila é o primeiro elemento a deixar a fila.
public class banco {
    public static void main(String[] args) {
		FilaImplementa f;
		int e;
		f = new FilaImplementa();
		//Inserindo senha na fila
		f.Inserir(176);
		f.Inserir(914);
		f.Inserir(12);
		f.Inserir(1817);
		f.Inserir(100);
		System.out.println("Teste da implementação da fila");
		System.out.println("Senhas:");
		while(!f.IsEmpty()) { //Enquanto a fila não for vazia, faça:
			e=f.remover(); //Remove da fila
			System.out.println("Elemento removido: "+e);
			
			
		}
		
		// TODO Auto-generated method stub

	}
    
}
