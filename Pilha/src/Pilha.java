import java.util.Arrays;

public class Pilha implements IPilha{
    //Atributos
    private int maxSize;
    private int stackArray[];
    private int top;

    public Pilha(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    @Override
    public void push(int v) {
        //Método para inserir um elemento na pilha
        if(isFull()){
            System.out.println("Pilha cheia!");
    }
        else{
            stackArray[++top] = v;
        }
    }

    @Override
    public int pop() {
        if(isEmpty()){
            System.out.println("Pilha vazia, não 'possível remover!");
            return -1;
        }
        else{
            return stackArray[top--];
        }
        }

    @Override
    public int top() {
            if(isEmpty()){
                System.out.println("Não há elementos na pilha!");
                return -1;
            }else{
                return stackArray[top];
            }
        }


    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }
    @Override
    public String toString(){
        return "Pilha: " + Arrays.toString(stackArray);
    }



}
