import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SkipList implements ISkipList {
    private No inicio;
    private No fim;
    private int altura;
    private int tamanho;
    private final Object menosInfinito = Integer.MIN_VALUE;
    private final Object maisInfinito = Integer.MAX_VALUE;

    public SkipList() {
        inicio = new No(menosInfinito);
        fim = new No(maisInfinito);
        this.altura = 0;
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }

    @Override
    public Object buscar(Object chave) {
        No atual = inicio;

        while (atual.getInferior() != null) {
            atual = atual.getInferior();
            while ((int) chave >= (int) atual.getProximo().getChave()) {
                if (chave == atual.getChave()) {
                    return atual.getChave();
                }
                atual = atual.getProximo();
            }
        }
        if (atual.getChave() == chave) {
            return atual.getChave();
        }
        return null;
    }
    @Override
    public void inserir(Object chave) {
        No noBaixo = null;
        No noMaisProximo = buscaPosicaoPerto(chave);
        int nivel = randomico();

        for (int i = 0; i <= nivel; i++) {
            No proximo = noMaisProximo.getProximo();
            No novoNo = new No(chave);

            noMaisProximo.setProximo(novoNo);
            proximo.setAnterior(novoNo);
            novoNo.setAnterior(noMaisProximo);
            novoNo.setProximo(proximo);

            if (noBaixo != null) {
                noBaixo.setSuperior(novoNo);
                novoNo.setInferior(noBaixo);
            }

            // Verificar se há um nó superior antes de acessá-lo
            if (noMaisProximo.getSuperior() != null) {
                while ((int) chave >= (int) noMaisProximo.getProximo().getChave()) {
                    noMaisProximo = noMaisProximo.getProximo();
                }
            } else {
                break;  // Se não houver um nó superior, saia do loop
            }

            noBaixo = novoNo;
        }

        tamanho++;
    }


    private void novoNivel(int nivel) {
        if (nivel >= altura) {
            No novoInicio = new No(menosInfinito);
            No novoFim = new No(maisInfinito);
            novoInicio.setProximo(novoFim);
            novoInicio.setInferior(inicio);
            inicio.setSuperior(novoInicio);
            novoFim.setAnterior(novoInicio);
            novoFim.setInferior(fim);
            fim.setSuperior(novoFim);
            inicio = novoInicio;
            fim = novoFim;
            altura++;
        }
    }

    private int randomico() {
        Random randomico = new Random();
        int nivel = 0;
        while (randomico.nextDouble() < 0.5) {
            nivel++;
        }
        return nivel;
    }

    @Override
    public Object remover(Object chave) {
        No noTemp = buscaPosicaoPerto(chave);

        // Verificar se o nó inicial é o nó que precisa ser removido
        if (noTemp.getChave() == chave) {
            while (noTemp != null) {
                No proximo = noTemp.getProximo();
                No anterior = noTemp.getAnterior();
                //Verifica se o anterior é diferente de null, se for, o anterior aponta para o proximo
                //Ele aponta para o próximo para que o nó seja removido

                if (anterior != null) {
                    anterior.setProximo(proximo);
                }
//Verifica se o proximo é diferente de null, se for, o proximo aponta para o anterior
                //Ele aponta para o anterior para que o nó seja removido
                if (proximo != null) {
                    proximo.setAnterior(anterior);
                }

                noTemp = noTemp.getSuperior();
            }
            tamanho--;
            return chave;
        }

        return null;
    }


    private No buscaPosicaoPerto(Object chave) {
        No noInicial = inicio;
        while (noInicial.getInferior() != null) {
            noInicial = noInicial.getInferior();
            while ((int) noInicial.getProximo().getChave() < (int) chave) {
                noInicial = noInicial.getProximo();
            }
        }
        return noInicial.getProximo().getChave() .equals( (int) chave )? noInicial.getProximo() : noInicial;
    }

    @Override
    public void imprimir() {
        System.out.println("Conteúdo da Skip List:");

        No nivelAtual = inicio;

        while (nivelAtual != null) {
            No atual = nivelAtual;
            while (atual != null) {
                System.out.print(atual.getChave() + " ");
                atual = atual.getProximo();
            }
            System.out.println();  // Nova linha para separar os níveis
            nivelAtual = nivelAtual.getInferior();
        }
    }
    }

