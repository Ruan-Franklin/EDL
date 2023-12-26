public class Teste {
    public static void main(String[] args) {
        System.out.println("Tabela Hash");
        TabelaHash<String, Integer> tabelaHash = new TabelaHash<>();
        tabelaHash.inserir("A", 1);
        tabelaHash.inserir("B", 2);
        tabelaHash.inserir("C", 3);
        tabelaHash.inserir("D", 4);
        //Mostra a tabela
        tabelaHash.mostrarTabela();
        //Remove elemento
        tabelaHash.remover("B");
        //Mostra a tabela
        tabelaHash.mostrarTabela();

    }

}