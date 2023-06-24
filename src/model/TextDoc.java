/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NUWAA
 */
public class TextDoc {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextDocMemento saveState() {
        return new TextDocMemento(text);
    }

    public void restoreState(TextDocMemento memento) {
        text = memento.getText();
    }

    public static class TextDocMemento {

        private final String text;

        public TextDocMemento(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

    }

}
