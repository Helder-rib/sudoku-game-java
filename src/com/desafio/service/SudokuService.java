package com.desafio.service;

import com.desafio.model.Celula;
import com.desafio.model.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuService {
    public SudokuService() {

    }
    private boolean validarLinhas(Celula[][] tabuleiro){
        long numbers0;
        long nummbersNoRepetion;
        for(Celula[] linha : tabuleiro){
            numbers0 = Arrays.stream(linha).map(Celula::getNumber).filter(n -> n == 0).count();
            nummbersNoRepetion = Arrays.stream(linha).map(Celula::getNumber).filter(n -> n != 0).distinct().count();
            if(numbers0 + nummbersNoRepetion < 9){
                return false;
            }
        }
        return true;
    }

    private boolean validarColunas(Celula[][] tabuleiro){
        long numbers0;
        long numbersNoRepetion;
        for(int c = 0; c < tabuleiro.length; c++){
            List<Integer> columnNumbers = new ArrayList<>();
            for (int l = 0; l < tabuleiro.length; l++){
                columnNumbers.add(tabuleiro[l][c].getNumber());
            }
            numbers0 = columnNumbers.stream().filter(n -> n == 0).count();
            numbersNoRepetion = columnNumbers.stream().filter(n -> n != 0).distinct().count();
            if(numbers0 + numbersNoRepetion < 9){
                return false;
            }
        }
        return true;
    }

    public Status verificarStatus(Celula[][] tabuleiro){
        int celulasVazias = 0;
        int celulasFixadas = 0;
        boolean contemErro = !validarQuadrante(tabuleiro) || !validarLinhas(tabuleiro) || !validarColunas(tabuleiro);
        for (Celula[] linha : tabuleiro){
            for (Celula celula : linha){
                if(celula.isFixed()){
                    celulasFixadas++;
                }
                if (celula.getNumber() == 0){
                    celulasVazias++;
                }
            }
        }
        if (celulasVazias + celulasFixadas == 81){
            return Status.NAO_INICIADO;
        }
        if (celulasVazias > 0 && contemErro){
            return Status.INCOMPLETO_COM_ERRO;
        } else if(celulasVazias > 0){
            return Status.INCOMPLETO;
        }
        if (celulasVazias == 0 && !contemErro){
            return Status.COMPLETO;
        } else {
            return Status.COMPLETO_COM_ERRO;
        }

    }

    private boolean validarQuadrante(Celula[][] tabuleiro){

        for (int iniLine = 0; iniLine < tabuleiro.length;iniLine+=3){
            for (int iniCol = 0; iniCol < tabuleiro.length; iniCol+=3){
                List<Integer> numbersQ = new ArrayList<>();
                long numbers0;
                long numbersNoRepetion;
                for(int line = iniLine; line < iniLine + 3;line++){
                    for (int column = iniCol;column < iniCol+3; column++){
                        numbersQ.add(tabuleiro[line][column].getNumber());
                    }
                }
                numbers0 = numbersQ.stream().filter(n -> n == 0).count();
                numbersNoRepetion = numbersQ.stream().filter(n -> n != 0).distinct().count();
                if (numbers0 + numbersNoRepetion<9){
                    return false;
                }
            }
        }
        return true;
    }
}
