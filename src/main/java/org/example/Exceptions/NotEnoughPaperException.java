package org.example.Exceptions;

public class NotEnoughPaperException extends Exception {
    private String papersInStock;

    public NotEnoughPaperException(String message, String  papersInStock) {
        super(message);
        this.papersInStock = papersInStock;
    }

    @Override
    public String toString() {
        return "NotEnoughPaperException{" +
                "papersInStock=" + papersInStock +
                '}';
    }
}
