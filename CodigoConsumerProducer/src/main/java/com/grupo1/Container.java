package com.grupo1;

public class Container {
    private int content;
    private boolean isContainerFull = Boolean.FALSE;

    /**
     * Obtiene de forma concurrente o síncrona el elemento que hay en el contenedor
     *
     * @return Contenido el contenedor
     */
    public synchronized int get() {
        while (!isContainerFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        isContainerFull = Boolean.FALSE;
        notify();
        return content;
    }

    /**
     * Introduce de forma concurrente o síncrona un elemento en el contenedor
     *
     * @param value Elemento a introducir en el contenedor
     */
    public synchronized void put(int value) {
        while (isContainerFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        content = value;
        isContainerFull = Boolean.TRUE;
        notify();
    }
}