package com.learning.designpatterns.behavioral.memento;

public class Client {
    public static void main(String[] args){
        TextEditor editor = new TextEditor();
        editor.write("Like");
        editor.showContent();
        editor.write("Like and");
        editor.showContent();
        editor.write("Like and do");
        editor.showContent();
        editor.undo();
        editor.showContent();
    }
}
