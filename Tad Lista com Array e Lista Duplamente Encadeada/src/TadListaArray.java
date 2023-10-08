public class TadListaArray implements ILista{
    private Object[] lista;
    private int tamanho;
    //Construtor da classe
    public TadListaArray(int capacidade){
        lista = new Object[capacidade];
        tamanho = 0;

    }
    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public boolean estaNaCabeca(Object elemento) {
        if(tamanho > 0 && lista[0].equals(elemento)){
            return true;
        }
        return false;
    }

    @Override
    public boolean estaNaCauda(Object elemento) {
        if(tamanho > 0 && lista[tamanho-1].equals(elemento)){
            return true;
        }
        return false;
    }

    @Override
    public Object antes(Object elemento) {
        for(int i = 1 ; i < tamanho ; i++){
            if(lista[i].equals(elemento)){
                return lista[i-1];
            }
        }
        return null;
    }

    @Override
    public Object depois(Object elemento) {
        for(int i = 0 ; i < tamanho-1 ; i++){
            if(lista[i].equals(elemento)){
                return lista[i+1];
            }
        }
        return null;
        }

    private void redimensionar(){
        int novaCapacidade = (lista.length == 0) ? 2 : lista.length * 2;
        Object[] novaLista = new Object[novaCapacidade];
        // Copiar os elementos do array antigo para o novo
        for (int i = 0; i < tamanho; i++){
            novaLista[i] = lista[i];
        }
        lista = novaLista;
    }
    @Override
    public void insereCabeca(Object elemento) {
        if(tamanho >= lista.length){
            redimensionar();
        }
        //Deslocar os elementos para a direita
        for(int i = tamanho ; i > 0 ; i--){
            lista[i] = lista[i-1];
        }
        //Inserir o elemento na cabeça
        lista[0] = elemento;
        tamanho++;
    }



    @Override
    public void insereCauda(Object elemento) {
        if(tamanho >= lista.length){
            redimensionar();
        }
        //Inserir o elemento na cauda
        lista[tamanho] = elemento;
        tamanho++;
    }


    @Override
    public Object substitui(Object elemento, Object novoElemento) {
        //Percorre a lista para encontrar o elemento
        for(int i = 0; i < tamanho ; i++){
            if (lista[i].equals(elemento)) {
                //Guarda o elemento antigo
                Object elementoAntigo = lista[i];
                //Substitui o elemento
                lista[i] = novoElemento;
                return elementoAntigo;
            }
        }
        //Se não encontrar o elemento, lança a exceção
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }

    @Override
    public Object insereAntes(Object elemento, Object novoElemento) {
        //Percorre a lista para encontrar o elemento
        for(int i = 0 ; i < tamanho ; i++){
            if(lista[i].equals(elemento)){
                //Verifica se a lista está cheia
                if(tamanho >= lista.length){
                    //Redimensiona a lista caso esteja cheia
                    redimensionar();
                }
                //Desloca os elementos para a direita a partir da posição em que está inserido
                for(int j = tamanho ; j > i ; j--){
                    lista[j] = lista[j-1];
                }
                //Insere o novo elemento na posição correta
                lista[i] = novoElemento;
                tamanho++;
                return novoElemento;
            }
        }
        //Se não encontrar o elemento, lança a exceção
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }
    @Override
    public Object insereDepois(Object elemento, Object novoElemento) {
        //Percorre a lista para encontrar o elemento
        for(int i = 0 ; i<tamanho ; i++){
            if(lista[i].equals(elemento)){
                if(tamanho >= lista.length){
                    redimensionar();
                }
                //Desloca os elementos para a direita a partir da posição em que está inserido
                for (int j = tamanho; j > i + 1; j--) {
                    lista[j] = lista[j-1];
                }
                //Insere o novo elemento na posição correta
                lista[i+1] = novoElemento;
                tamanho++;
                return novoElemento;
            }
            }
        //Se não encontrar o elemento, lança a exceção
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }

    @Override
    public void troca(Object elemento1, Object elemento2) {
        int primeiroIndice = -1;
        int segundoIndice = -1;
        //Percorre a lista para encontrar os elementos
        for(int i = 0; i < tamanho ; i++){
            if (lista[i].equals(elemento1)) {
                primeiroIndice = i;
            } else if (lista[i].equals(elemento2)) {
                segundoIndice = i;
            }

            }
        if( primeiroIndice != -1  && segundoIndice != -1){
            //Troca os elementos de posição
            Object elementoTemporario = lista[primeiroIndice];
            lista[primeiroIndice] = lista[segundoIndice];
            lista[segundoIndice] = elementoTemporario;
        }
        else{
            //Se não encontrar o elemento, lança a exceção
            throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
        }

    }

    @Override
    public Object remove(Object elemento) {
        //Percorre a lista para encontrar o elemento
        for(int i = 0 ; i < tamanho ; i++){
            if(lista[i].equals(elemento)){
                //Guarda o elemento que será removido
                Object elementoRemovido = lista[i];
                //Desloca os elementos para a esquerda a partir da posição em que está inserido
                for(int j = i ; j < tamanho-1; j++){
                    lista[j] = lista[j+1];
                }
                //Limpa a última posição
                lista[tamanho-1] = null;
                tamanho--;
                return elementoRemovido;
            }
        }
        //Se não encontrar o elemento, lança a exceção
        throw new ElementoNaoEncontradoExcecao("Elemento não encontrado");
    }
    @Override
    public String mostrar(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        //Percorre a lista para encontrar o elemento
        for(int i = 0 ; i < tamanho ; i++){
            sb.append(lista[i]);
            if(i < tamanho-1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
