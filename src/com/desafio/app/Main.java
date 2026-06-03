package com.desafio.app;

import com.desafio.model.Celula;
import com.desafio.model.Status;
import com.desafio.model.Tabuleiro;
import com.desafio.service.SudokuService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro(new Celula[9][9]);
        SudokuService sudokuService = new SudokuService();
        tabuleiro.definirTabuleiro();
        var loop = true;
        while(loop){
            System.out.println("""
                    Selecione uma opcao:
                    1 - Iniciar um novo o jogo
                    2 - Colocar um novo número
                    3 - Remover um número
                    4 - Verificar jogo
                    5 - Verificar status do jogo
                    6 - Limpar
                    7 - finalizar o jogo
                    """);
            int option = Integer.parseInt(sc.nextLine());
            try{
                switch(option){
                    case 1 -> tabuleiro.iniciarTabuleiro(args);
                    case 2 -> {
                        System.out.println("Insira os dados de insercao (linha, coluna, valor)");
                        String[] valores = sc.nextLine().split(",");
                        tabuleiro.inserirNumero(valores);
                    }
                    case 3 -> {
                        System.out.println("Insira os dados da celula a ser deletada (linha, coluna)");
                        tabuleiro.excluirCelula(sc.nextLine().split(","));
                    }
                    case 4 -> tabuleiro.exibirTabuleiro();
                    case 5 -> sudokuService.verificarStatus(tabuleiro.getTabuleiro()).exibirStatus();
                    case 6 -> tabuleiro.limparTabuleiro();

                    case 7 -> {
                        if (sudokuService.verificarStatus(tabuleiro.getTabuleiro()) == Status.COMPLETO){
                            System.out.println("Jogo finalizado!\n");
                            loop = false;
                        } else {
                            System.out.println("Preencha todos os espaços com os números corretos.\n");
                        }
                    }

                    default -> System.out.println("Opção selecionad inválida\n");
                }
            } catch (IllegalArgumentException | IllegalStateException e){
                System.out.println(e.getMessage());
            }

        }

    }
}
