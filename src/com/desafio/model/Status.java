package com.desafio.model;

public enum Status {
    NAO_INICIADO{
        @Override
        public void exibirStatus(){
            System.out.println("Jogo não iniciado");
        }
    },
    INCOMPLETO{
        @Override
        public void exibirStatus(){
            System.out.println("Jogo incompleto");
        }
    },
    INCOMPLETO_COM_ERRO{
        @Override
        public void exibirStatus(){
            System.out.println("Jogo incompleto e com erro(s)");
        }
    },
    COMPLETO{
        @Override
        public void exibirStatus(){
            System.out.println("Jogo completo");
        }
    },
    COMPLETO_COM_ERRO{
        @Override
        public void exibirStatus(){
            System.out.println("Jogo completo com erro(s)");
        }
    };

    public abstract void exibirStatus();
}
