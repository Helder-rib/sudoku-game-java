package com.desafio.model;

public class Tabuleiro {
    private Celula[][] tabuleiro = new Celula[9][9];

    public Tabuleiro(Celula[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Celula[][] getTabuleiro() {
        return tabuleiro;
    }

    private void setTabuleiro(Celula[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void iniciarTabuleiro(String[] info){
        definirTabuleiro();
        removerEspacos(info);
        validarArrayEntrada(info);

        for (String s : info) {
            String[] coordenadas = s.split(",");
            removerEspacos(coordenadas);
            validarArrayEntrada(coordenadas);
            if ( coordenadas.length != 3){
                throw new IllegalArgumentException("Formato dos dados incorretos\n");
            }
            validarValoresIndices(coordenadas);
            int linha = Integer.parseInt(coordenadas[0]);
            int coluna = Integer.parseInt(coordenadas[1]);
            int valor = Integer.parseInt(coordenadas[2]);


            if (tabuleiro[linha-1][coluna-1].getNumber() != 0){
                throw new IllegalStateException("Célula já preenchida\n");
            }
            tabuleiro[linha-1][coluna-1] = new Celula(true, valor);
        }
    }

    public void excluirCelula(String[] dados){
        removerEspacos(dados);
        validarArrayEntrada(dados);
        if (dados.length != 2){
            throw new IllegalArgumentException("é preciso fornecer exatamente dois valores\n");
        }
        validarValoresIndices(dados);
        int linha = Integer.parseInt(dados[0]);
        int coluna = Integer.parseInt(dados[1]);

        if(tabuleiro[linha-1][coluna-1].isFixed()){
            throw new IllegalStateException("Nao é possivel excluir uma celula fixada\n");
        } else {
            tabuleiro[linha-1][coluna-1].setNumber(0);
        }

    }

    public void inserirNumero(String[] info){
        if(info.length != 3){
            throw new IllegalArgumentException("é preciso informar exatamente 3 valores\n");
        }
        removerEspacos(info);
        validarArrayEntrada(info);
        int linha = Integer.parseInt(info[0]);
        int coluna = Integer.parseInt(info[1]);
        int valor = Integer.parseInt(info[2]);
        validarValoresIndices(info);
        Celula celula = tabuleiro[linha-1][coluna-1];
        if (celula.getNumber() == 0 && !celula.isFixed()){
            celula.setNumber(valor);
        } else if (celula.isFixed()) {
            throw new IllegalStateException ("essa célula é fixa\n");
            // irei criar excessao personalizada posteriormente
        } else {
            throw new IllegalStateException ("essa célula já possui valor\n");
            // irei criar excessao personalizada posteriormente
        }
    }

    private void validarValoresIndices(String[] dados) {
        for (String dado : dados) {
            int dadoInt = Integer.parseInt(dado);
            if (dadoInt < 1 || dadoInt > 9) {
                throw new IllegalArgumentException("Valor invalido\n");
            }
        }
    }


    public void validarArrayEntrada(String[] arrayString){
        for (String string : arrayString){
            if (string.isBlank()){
                throw new IllegalArgumentException("Erro: Entrada com valor vazio\n");
            }
        }
    }

    public void limparTabuleiro(){
        for (Celula[] linha: tabuleiro){
            for(Celula celula: linha){
                if(!celula.isFixed()){
                    celula.setNumber(0);
                }
            }
        }
    }

    public void definirTabuleiro(){
       for (int l = 0; l < tabuleiro.length; l++){
           for (int c = 0; c < tabuleiro.length;c++){
               tabuleiro[l][c] = new Celula(false, 0);
           }
       }
    }

    public void exibirTabuleiro(){
        for (int l = 0; l < tabuleiro.length; l++){
            if (l == 0){
                System.out.print("\n┌─────────┬─────────┬─────────┐\n");
            }
            for (int c = 0; c < tabuleiro.length;c++){
                if (c == 0){
                    System.out.print("│");
                }
                System.out.print(tabuleiro[l][c]);
                if (c == 2 || c == 5 || c == 8){
                    System.out.print("│");
                }
                }
            if (l == 2|| l == 5){
                System.out.print("\n├─────────┼─────────┼─────────┤");
            }
            if (l == 8){
                System.out.print("\n└─────────┴─────────┴─────────┘");
            }
            System.out.println();
        }
    }

    private void removerEspacos(String[] arrayDeString){
        for(int i = 0; i < arrayDeString.length; i++){
            arrayDeString[i] = arrayDeString[i].trim();
        }
    }
}

