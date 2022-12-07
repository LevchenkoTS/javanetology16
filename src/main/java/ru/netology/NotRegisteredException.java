package ru.netology;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String name) {
        super("Gamer " + name + " not found");
    }

}
