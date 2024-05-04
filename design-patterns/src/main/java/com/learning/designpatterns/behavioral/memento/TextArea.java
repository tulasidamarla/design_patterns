package com.learning.designpatterns.behavioral.memento;

public class TextArea{
    private String text;
    public void setText(String text){
        this.text = text;
    }

    public String getContent() {
        return this.text;
    }

    public Memento takeSnapshot(){
        return new Memento(this.text);
    }

    public void restore(Memento memento){
        System.out.println("Retrieved text from memento is: " + memento.getSavedText());
        this.text = memento.getSavedText();
    }

    public static class Memento{
        private final String text;
        private Memento(String textToSave){
            text = textToSave;
        }

        private String getSavedText(){
            return text;
        }

    }
}