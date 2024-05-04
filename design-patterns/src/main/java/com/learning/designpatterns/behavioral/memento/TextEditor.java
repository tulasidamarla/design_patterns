package com.learning.designpatterns.behavioral.memento;

import java.util.Deque;
import java.util.LinkedList;

import static com.learning.designpatterns.behavioral.memento.TextArea.Memento;

public class TextEditor {
    private Deque<Memento> stateHistory;
    private TextArea textArea;

    public TextEditor(){
        stateHistory = new LinkedList<>();
        textArea = new TextArea();
    }

    public void write(String text){
        //System.out.println("Writing text: " + text);
        textArea.setText(text);
        stateHistory.add(textArea.takeSnapshot());
    }

    public void undo(){
        stateHistory.removeLast();
        Memento memento = stateHistory.getLast();
        System.out.println("Undoing to previous state...");
        textArea.restore(memento);
    }

    public void showContent() {
        System.out.println("TextEditor: Current Content: " + textArea.getContent());
    }
}

