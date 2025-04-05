package main;

import caixa.Caixa;
import model.Cliente;

public class Main {
    public static void main(String[] args) {
        Caixa caixa = new Caixa();

        caixa.registrarCliente(new Cliente("Bruno", 3));
        caixa.registrarCliente(new Cliente("Augusto", 2));
        caixa.registrarCliente(new Cliente("Ana", 4));
        caixa.registrarCliente(new Cliente("Andrey", 1));

        System.out.println("Iniciando atendimento...");

        caixa.processarClientes();

        System.out.println("Total de clientes atendidos: " + caixa.getClientesAtendidos());
        System.out.println("Clientes aguardando: " + caixa.getClientesAguardando());
        System.out.println("Todos os atendimentos foram concluídos.\n");
        caixa.exibirStatus();
    }
}
