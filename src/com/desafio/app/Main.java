package com.desafio.app;

import com.desafio.model.Celula;
import com.desafio.model.Status;
import com.desafio.model.Tabuleiro;
import com.desafio.service.SudokuService;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Tabuleiro tabuleiro = new Tabuleiro(new Celula[9][9]);
    private static final SudokuService sudokuService = new SudokuService();

    public static void main(String[] args) {


        tabuleiro.definirTabuleiro();
        var loop = true;
        while(loop){
            System.out.println("""
                    Selecione uma opção:
                    
                    1 - Iniciar um novo jogo
                    2 - Colocar um novo número
                    3 - Remover um número
                    4 - Exibir tabuleiro
                    5 - Verificar status do jogo
                    6 - Limpar tabuleiro
                    7 - Finalizar jogo
                    8 - Sair
                    """);
            int option = Integer.parseInt(sc.nextLine());
            try{
                switch(option){
                    case 1 -> tabuleiro.iniciarTabuleiro(args);
                    case 2 -> adicionarNumero();
                    case 3 -> removerNumero();
                    case 4 -> tabuleiro.exibirTabuleiro();
                    case 5 -> sudokuService.verificarStatus(tabuleiro.getTabuleiro()).exibirStatus();
                    case 6 -> tabuleiro.limparTabuleiro();
                    case 7 -> finalizarJogo();
                    case 8 -> {
                        System.out.println("Saindo do jogo.");
                        loop = false;
                    }
                    default -> System.out.println("Selecione uma opção presente no menu\n");
                }
            } catch (IllegalArgumentException | IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void adicionarNumero() {

        System.out.println("Insira os dados de insercao (linha, coluna, valor)");
        String[] valores = sc.nextLine().split(",");
        tabuleiro.inserirNumero(valores);
    }

    private static void removerNumero(){
        System.out.println("Insira os dados da celula a ser deletada (linha, coluna)");
        tabuleiro.excluirCelula(sc.nextLine().split(","));
    }

    private static void finalizarJogo(){
        if (sudokuService.verificarStatus(tabuleiro.getTabuleiro()) == Status.COMPLETO){
            System.out.println("Jogo completo!\n");
        } else {
            System.out.println("Preencha todos os espaços com os números corretos.\n");
        }
    }
}


