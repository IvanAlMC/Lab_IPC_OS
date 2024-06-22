package com.grupo1.run;

import com.grupo1.Consumer;
import com.grupo1.Container;
import com.grupo1.Producer;

public class Runner {
    private static Container container;
    private static Thread producer;
    private static Thread[] consumers;
    private static final int CONSUMER_QUANTITY = 5;

    public static void main(String[] args) {
        System.out.println("-- Código basado en la siguiente referencia --");
        System.out.println(
            "https://programaressencillo.wordpress" + ".com/2014/11/25/java-monitores-ejemplo-productor-consumidor/\n\n");

        System.out.println("-------------------------------------------");
        System.out.println("-- Para parar el programa presiones CTRL + C --");
        System.out.println("-------------------------------------------");
        System.out.println("Iniciando ejecución...");
        container = new Container();
        producer = new Thread(new Producer(container, 1));
        consumers = new Thread[CONSUMER_QUANTITY];
        for (int i = 0; i < CONSUMER_QUANTITY; i++) {
            consumers[i] = new Thread(new Consumer(container, i + 2));
        }
        producer.start();
        for (int i = 0; i < CONSUMER_QUANTITY; i++) {
            consumers[i].start();
        }
    }

}