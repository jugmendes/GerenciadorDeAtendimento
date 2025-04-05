package model;

public class Cliente {
    private final String nome;
    private final int tempoAtendimento;

    public Cliente(String nome, int tempoAtendimento) {
        this.nome = nome;
        this.tempoAtendimento = tempoAtendimento;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }
}


