package LinkedList;

import Exceptions.ErrorPDI;
import Exceptions.InsertionError;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

    private LinkedList<T> llista;

    public LinkedListIterator(LinkedList<T> llista) throws InsertionError {

        this.llista = llista;

    }

    @Override
    public boolean hasNext() {
        boolean hasNext = true;
        try {
            llista.PDIToNext();
            llista.PDIToPrev();
        }
        catch (ErrorPDI e){
            hasNext = false;
        }
        return hasNext;
    }

    @Override
    public T next(){
        try {
            llista.PDIToNext();
            return llista.current();
        }
        catch (ErrorPDI e){ }
        return null;
    }
}
