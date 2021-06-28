# Implementation of a Doubly LinkedList with a point of interest
A doubly linked list is a common type of list that is build with nodes that contain the data, a reference to the previous node and a reference to the next node in the list.  The list itself usually consists of two references to the initial and final nodes of the list.  In this implementation, an additional reference is added: the PDI (point of interest).  This reference points to one of the elements of the list and serves as the default position to add and remove elements from the list.  This functionality is explained exhaustively below.  Additionally, this list has been implemented with generics and has its own iterator.

![LinkedList graph](https://github.com/mireiagasco/LinkedList-Java/blob/main/images/LinkedList.png)


## Implementation Details
The nodes of the list consist of the three elements that have been mentioned before:
* `data`: information of the node.
* `next`: reference to the next node in the list.
* `previous`: reference to the previous node in the list.

This nodes are used to build the list, which consists of the following elements:
* `first`: reference to the first element of the list.
* `last`: reference to the last element of the list.
* `length`: number of elements contained in the list.
* `pdi`: point of interest.  Reference to one of the nodes of the list.  It can also be positioned before the list itself to facilitate the implementation of the `insertion()` method.

![PDI graph](https://github.com/mireiagasco/LinkedList-Java/blob/main/images/LinkedListPDI.png)


## Implemented Methods
The methods implemented for this list are:
* `Constructor`: creates an empty list.
* `iterator()`: can be used to iterate over the list with the `hasNext()` and `next()` methods from the interface.
* `size()`: returns the size of the list (number of elemets contained).
* `insert(data)`: inserts the data in the position after the PDI and the PDI is moved to the new node.  Can cause an `InsertionError` if the element cannot be inserted.
* `delete()`: deletes the node marked with the PDI, which moves to the next element of the list.  If the element removed was the last, the PDI stays in the last position of the list. Can cause a `DeletionError` if the element cannot be deleted.
* `delete(data)`: deletes the element that contains the data passed as an argument.  Can cause a `DeletionError` if the element cannot be deleted or a `NotFoundError` if the data is not in the list.

Moreover, some additional methods have been implemented to provide functionality to the PDI, so it can be freely moved through the list positions:
* `current()`: returns the data from the current PDI position.
* `PDIToStart()`: moves the PDI to the beginning of the list.
* `PDIToEnd()`: moves the PDI to the end of the list.
* `PDIToNext()`: moves the PDI to the next position.
* `PDIToPrev()`: moves the PDI to the previous position.

The `PDIToNext()` and `PDIToPrev()` methods can cause an `ErrorPDI` exception in case the PDI cannot be moved forwards or backwards (when it is already in the first or last position available).

## Implemented Exceptions
The exceptions used are:
* `DeleteError`: in case the delete methods cannot delete the element.
* `InsertionError`: in case the `insert()` method cannot successfully insert an element.
* `ErrorPDI`: in case the `PDIToNext()` or `PDIToPrev()` methods are called and the PDI cannot be moved tho the asked position.
* `NotFoundError`: in case the `delete(data)` method cannot find the data in the list.
