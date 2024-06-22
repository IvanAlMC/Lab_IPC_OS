package com.grupo1;

import java.util.Random;

public class Producer implements Runnable {
    private final Random random;
    private final Container container;
    private final int idProducer;
    private static final int WAIT_TIME = 1500;

    /**
     * Constructor de la clase
     *
     * @param container  Contenedor común a los consumidores y el productor
     * @param idProducer Identificador del productor
     */
    public Producer(Container container, int idProducer) {
        this.container = container;
        this.idProducer = idProducer;
        random = new Random();
    }

    @Override
    /**
     * Implementación de la hebra
     */ public void run() {
        while (Boolean.TRUE) {
            int poner = random.nextInt(300);
            container.put(poner);
            System.out.println("El productor " + idProducer + " pone: " + poner);
            try {
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException e) {
                System.err.println("Productor " + idProducer + ": Error en run -> " + e.getMessage());
            }
        }
    }
}
