package com.grupo1;


public class Consumer implements Runnable {
    private final Container container;
    private final int idConsumer;

    /**
     * @param container  Contenedor común a los consumidores y el productor
     * @param idConsumer Identificador del consumidor
     */
    public Consumer(Container container, int idConsumer) {
        this.container = container;
        this.idConsumer = idConsumer;
    }

    public void run() {
        while (true) {
            System.out.println("El consumidor " + idConsumer + " consume: " + container.get());
        }
    }
}