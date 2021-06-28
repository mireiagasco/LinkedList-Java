import Exceptions.DeleteError;
import Exceptions.ErrorPDI;
import Exceptions.InsertionError;
import Exceptions.NotFoundError;
import LinkedList.LinkedList;

public class Main {

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        System.out.println("\n>>>Inserting numbers from 0 to 9...");
        try {
            for (int i = 0; i < 10; i++){
                linkedList.insert(i);
            }
        }
        catch (InsertionError e){
            System.out.println(e);
        }
        System.out.println("Done.  List obtained:");
        System.out.println(linkedList);
        System.out.println("Position of the PDI: " + linkedList.current());


        System.out.println("\n>>>Deleting numbers from 5 to 9...");
        try {
            for (int i = 5; i < 10; i++){
                linkedList.delete(i);
            }
        }
        catch (DeleteError | NotFoundError e){
            System.out.println(e);
        }
        System.out.println("Done.  List obtained:");
        System.out.println(linkedList);
        System.out.println("Position of the PDI: " + linkedList.current());

        try {
            System.out.println("\n>>>Moving the PDI...");
            System.out.print("Backwards: ");
            linkedList.PDIToPrev();
            System.out.println("PDI position -> " + linkedList.current());
            System.out.print("Forward: ");
            linkedList.PDIToNext();
            System.out.println("PDI position -> " + linkedList.current());
            System.out.print("Start: ");
            linkedList.PDIToStart();
            System.out.println("PDI position -> " + linkedList.current());
            System.out.print("End: ");
            linkedList.PDIToEnd();
            System.out.println("PDI position -> " + linkedList.current());
        }
        catch (ErrorPDI e){
            System.out.println(e);
        }


        System.out.println("\n>>>Deleting number 2...");

        try {
            linkedList.delete(2);
        }
        catch (DeleteError | NotFoundError e){
            System.out.println(e);
        }

        System.out.println("Done.  List obtained:");
        System.out.println(linkedList);
        System.out.println("Position of the PDI: " + linkedList.current());

    }
}
