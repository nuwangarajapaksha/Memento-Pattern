/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Stack;

/**
 *
 * @author NUWAA
 */
public class TextDocHistory {

    private Stack<TextDoc.TextDocMemento> undoHistory = new Stack<>();
    private Stack<TextDoc.TextDocMemento> redoHistory = new Stack<>();

    public void save(TextDoc doc) {
        undoHistory.push(doc.saveState());
    }

    public void undo(TextDoc doc) {
        if (!undoHistory.isEmpty()) {
            TextDoc.TextDocMemento poped = undoHistory.pop();
            doc.restoreState(poped);
            redoHistory.push(poped);
        } else {
            System.out.println("Nothing left to Undo");
        }
    }

    public void redo(TextDoc doc) {
        if (!redoHistory.isEmpty()) {
            TextDoc.TextDocMemento poped = redoHistory.pop();
            doc.restoreState(poped);
            undoHistory.push(poped);
        } else {
            System.out.println("Nothing left to Redo");
        }
    }

}
