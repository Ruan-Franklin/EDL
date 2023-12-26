import java.util.Iterator;

public class TabelaHash<Chave, Valor> implements IHash<Chave, Valor> {
    // Atributos
    private static final double fator_carga = 0.7;
    private int tamanho;
    private Vetor<Entrada<Chave, Valor>>[] tabela;

    // Construtor
    public TabelaHash() {
        this.tabela = new Vetor[10]; 
        this.tamanho = 0;
    }

    private int hash(Chave chave) {
        return chave.hashCode() % this.tabela.length;
    }

    private void rehash() {
        Vetor<Entrada<Chave, Valor>>[] tabelaAntiga = tabela; 
        int novoTamanho = tabela.length * 2;
        tabela = new Vetor[novoTamanho];
        tamanho = 0;
        for (Vetor<Entrada<Chave, Valor>> lista : tabelaAntiga) { 
            if (lista != null) {
                for (Entrada<Chave, Valor> entrada : lista) {
                    inserir(entrada.getChave(), entrada.getValor());
                }
            }
        }
    }

    @Override
    public void inserir(Chave chave, Valor valor) {
        if ((double) tamanho / tabela.length > fator_carga) {
            rehash();
        }
        int indice = hash(chave);
        if (tabela[indice] == null) {
            tabela[indice] = new Vetor<>(1); 
        }
        for (Entrada<Chave, Valor> entrada : tabela[indice]) {
            if (entrada.getChave().equals(chave)) {
                entrada.setValor(valor);
                return;
            }
        }
        tabela[indice].inserirElementoNaPosicao(tabela[indice].tamanho(), new Entrada<>(chave, valor)); 
        tamanho++;
    }

    @Override
    public Valor listar(Chave chave) {
        int indice = hash(chave);
        if (tabela[indice] != null) {
            for (Entrada<Chave, Valor> entrada : tabela[indice]) {
                if (entrada.getChave().equals(chave)) {
                    return entrada.getValor();
                }
            }
        }
        return null;
    }

    public void remover(Chave chave) {
        int indice = hash(chave);
        if (tabela[indice] != null) {
            for (int i = 0; i < tabela[indice].tamanho(); i++) {
                Entrada<Chave, Valor> entrada = tabela[indice].elementoNaPosicao(i);
                if (entrada.getChave().equals(chave)) {
                    tabela[indice].removerUltimoElemento();
                    tamanho--;
                    return;
                }
            }
        }
    }

    @Override
    public boolean contemChave(Chave chave) {
        return listar(chave) != null;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void mostrarTabela() {
        System.out.println("Tabela Hash");
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null && !tabela[i].estaVazio()) {
                System.out.print("Índice " + ": ");
                for (Entrada<Chave, Valor> entrada : tabela[i]) {
                    System.out.print("[" + entrada.getChave() + " - " + entrada.getValor() + "] ");
                }
                System.out.println();
            }
        }
    }

    private static class Entrada<Chave, Valor> {
        private Chave chave;
        private Valor valor;

        public Entrada(Chave chave, Valor valor) {
            this.chave = chave;
            this.valor = valor;
        }

        public Chave getChave() {
            return chave;
        }

        public Valor getValor() {
            return valor;
        }

        public void setValor(Valor valor) {
            this.valor = valor;
        }
    }
}
