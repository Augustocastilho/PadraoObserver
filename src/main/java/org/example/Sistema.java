package org.example;

import java.util.Observable;

public class Sistema extends Observable {

    private String nome;

    public Sistema(String nome) {
        this.nome = nome;
    }

    public void lancarDocumento() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
