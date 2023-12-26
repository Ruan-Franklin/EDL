    public class Teste {
        public static void main(String[] args) {
            System.out.println("############### SKIPLIST #####################################!");
            SkipList skipList = new SkipList();
            skipList.inserir(1);
            skipList.inserir(2);
            skipList.inserir(3);
            skipList.inserir(4);
            System.out.println("Testando para ver se o LOOP começa aqui");
            skipList.imprimir();
    System.out.println("############### SKIPLIST #####################################!");
            skipList.remover(4);
            skipList.imprimir();
    
    
    
        }
    }
