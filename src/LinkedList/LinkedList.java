package LinkedList;

import Exceptions.DeleteError;
import Exceptions.ErrorPDI;
import Exceptions.InsertionError;
import Exceptions.NotFoundError;

import java.util.Iterator;

/**
 * LinkedList implementation
 * @author Mireia Gasco Agorreta
 * @version 1.0
 */
public class LinkedList<T> {

    //Node Class
    private class Node<T> {

        //Attributes
        private T data;
        private Node next, previous;

        public Node(T data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        @Override
        public String toString(){
            return this.data.toString();
        }
    }

    //Attributes
    private Node first, last, pdi;  //first element on the list, last element on the list and pdi (point of interest) references
    private int length;

    //Constructor
    public LinkedList(){
        this.first = null;
        this.last = null;
        this.pdi = null;
        this.length = 0;
    }

    //Methods

    public Iterator<T> iterator(){
        try {
            return new LinkedListIterator<T>(this);
        }
        catch (InsertionError e){
            return null;
        }
    }

    /**
     * Size method.
     * @return the size of the list.
     */
    public int size(){
        return this.length;
    }

    /**
     * Insert method.  Inserts a new element after the pdi.
     * @param data data to be added to the list.
     * @throws InsertionError if the insertion fails.
     */
    public <T extends Comparable> void insert(T data) throws InsertionError{
        Node newNode = new Node(data);

        try {
            if (this.length == 0){
                first = last = newNode;
                last.next = null;
            }
            else{
                if (pdi == null){
                    newNode.next = first;
                    newNode.previous = null;
                    first.previous = newNode;
                    first = newNode;
                }
                else {
                    newNode.previous = pdi;
                    newNode.next = pdi.next;

                    if (pdi.next != null) pdi.next.previous = newNode;
                    else last = newNode;
                    pdi.next = newNode;
                }
            }
        }
        catch (Exception e){
            throw new InsertionError();
        }

        pdi = newNode;
        this.length++;
    }

    /**
     * Delete method.  Deletes the element pointed by the pdi
     * @throws DeleteError in case there's no element to delete (pdi == null)
     */
    public void delete() throws DeleteError{

        //if the pdi is not pointing to an actual node
        if (length == 0 || pdi == null){
            throw new DeleteError("The element selected with the PDI is null");
        }

        //if the pdi point to a node
        else{
            if (pdi.previous != null){  //if the pdi is not in the first position of the list
                pdi.previous.next = pdi.next;
            }
            else{   //if the pdi is in the first position of the list
                first = pdi.next;
                if (first != null) first.previous = null;
            }

            if (pdi.next != null){  //if the pdi is not in the last position of the list
                pdi.next.previous = pdi.previous;
            }
            else {  //if it is not
                last = pdi.previous;
                if (last != null) last.next = null;
            }

            //anyways, update the pdi and the length of the list
            if (pdi.next != null) pdi = pdi.next;
            else pdi = pdi.previous;
            length--;
        }
    }

    /**
     * Delete method.  Deletes the element indicated as an argument.
     * @param data element to be removed.
     * @throws DeleteError if the element could not be removed.
     * @throws NotFoundError if the element does not exist on the list.
     */
    public <T extends Comparable> void delete(T data) throws DeleteError, NotFoundError{
        Node aux = first;
        boolean found = false;

        //while we do not find the element
        while (!found && aux != null){
            found = data == aux.data;
            if (!found) aux = aux.next;
        }

        if (aux == null) throw new NotFoundError();

        if (aux == pdi) delete();
        else{
            Node pdiAux = pdi;
            pdi = aux;
            delete();
            pdi = pdiAux;
        }
    }



    //Methods to operate with the pdi
    public T current(){
        return (T)pdi.data;
    }

    public void PDIToStart(){
        pdi = first;
    }

    public void PDIToEnd(){
        pdi = last;
    }

    public void PDIToNext() throws ErrorPDI{
        if (pdi != last) pdi = pdi.next;
        else throw new ErrorPDI("The PDI is in the last position of the list, it cannot go further");
    }

    public void PDIToPrev() throws ErrorPDI{
        if (pdi != null) pdi = pdi.previous;
        else throw new ErrorPDI("The PDI is already in the first position available");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: ");

        Node auxPdi = pdi;
        this.PDIToStart();

        sb.append(this.pdi.toString() + "-");

        while (this.iterator().hasNext()){
            sb.append(iterator().next().toString());
            if (iterator().hasNext()) sb.append("-");
        }

        pdi = auxPdi;

        return sb.toString();
    }
}
