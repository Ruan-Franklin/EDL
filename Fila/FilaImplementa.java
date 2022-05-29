//Como acontece o controle da fila?
package Fila;

//- Variáveis de INÍCIO E FIM
// Variável total
// Quando a fila está cheia?
// Total = tamanho do vetor
// Quando a fila está vazia?
 //Total = 0
//Parei o vídeo em 8:12

public class FilaImplementa {
	//Atributos
	private int valores [];
	private int inicio;
	private int fim;
	private int total;

//Construtor para começar do início da criação do objeto
public FilaImplementa(){
	valores=new int[10];
	inicio = 0;  //O início aponta para a primeira posição
    fim = 0;  //O fim vai apontar para a primeira posição
    total = 0; //O total vai apontar para a primeira posição.
}
	


public void Inserir(int elemento) {
	//Os valores correspondentes na posição de fim devem receber o elemento novo
	valores[fim]=elemento;
	//Se fizermos o módulo do fim pelo número total de elementos, teremos como resto o próprio número, permitindo assim uma volta aos índices iniciais.
	fim=(++fim)%valores.length;
	//Após isso, adiciona o elemento, usando total++
	total++;
	
}

public int remover() {
	//Para remover, o elemento deve receber os valores dos índices na posição de início
	int elemento = valores[inicio];
	//inicio++%10 permite que o array fique em modo circular
	inicio = (++inicio)%valores.length;
	//Total -- é usado para retirar o elemento
	total--;
	//Retorna o novo valor de elemento
	return elemento;
	
}

public boolean IsEmpty() {
	return total == 0;  //Se o total for igual a 0, retorna verdadeiro. Se não, retorna falso.
	
	
	
}

public boolean IsFull() {
	return total==valores.length; //Total guarda o NÚMERO de elementos, não a posição
}

}