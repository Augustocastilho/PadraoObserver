package org.example;

import java.util.Observable;
import java.util.Observer;

public class Documento implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Documento(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void addDocumentoNoSistema(Sistema sistema) {
        sistema.addObserver(this);
    }

    @Override
    public void update(Observable sistema, Object arg) {
        this.ultimaNotificacao = "O documento " + this.nome + " foi inserido no sistema " + sistema.toString() + ".";
    }
}
