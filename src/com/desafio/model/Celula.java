package com.desafio.model;

import java.util.Objects;

public class Celula {
    private int number;
    private final boolean fixed;

    public Celula(boolean fixed, int number) {
        this.fixed = fixed;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFixed() {
        return fixed;
    }

    @Override
    public String toString() {
        if (number != 0){
            return " " + getNumber() + " ";
        } else {
            return " . ";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Celula celula = (Celula) o;
        return number == celula.number && fixed == celula.fixed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, fixed);
    }
}
