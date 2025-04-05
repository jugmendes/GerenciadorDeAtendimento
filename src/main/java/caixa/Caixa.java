package caixa;
import model.Cliente;
import java.util.LinkedList;
import java.util.Queue;

public class Caixa {
    private final Queue<Cliente> filaClientes = new LinkedList<>();
    private int clientesAtendidos = 0;

    public synchronized void registrarCliente(Cliente cliente) {
        filaClientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNome());
    }

    public void processarClientes() {
        while (true) {
            Cliente cliente;
            synchronized (this) {
                if (filaClientes.isEmpty()) break;
                cliente = filaClientes.poll();
            }
            Cliente finalCliente = cliente;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Atendendo " + finalCliente.getNome());
                    Thread.sleep(finalCliente.getTempoAtendimento() * 1000L);
                    System.out.println("Finalizado atendimento: " + finalCliente.getNome());
                    synchronized (this) {
                        clientesAtendidos++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            thread.start();

            try {
                thread.join(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public synchronized int getClientesAguardando() {
        return filaClientes.size();
    }
}

