package application;

import datamodel.Actor;
import persistence.PersistenceManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PersistenceManager persistencia = new PersistenceManager();
        ArrayList<Actor> data = persistencia.getActor();
        System.out.println("Hello world!");
    }
}