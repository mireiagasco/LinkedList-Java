# Implementation of a Doubly LinkedList with a point of interest
A doubly linked list is a common type of list that is build with nodes that contain the data, a reference to the previous node and a reference to the next node in the list.  The list itself usually consists of two references to the initial and final nodes of the list.  In this implementation, an additional reference is added: the PDI (point of interest).  This reference points to one of the elements of the list and serves as the default position to add and remove elements from the list.  This functionality is explained exhaustively below.

![alt text](https://github.com/mireiagasco/LinkedList-Java/blob/main/images/LinkedList.png)


## Implementation Details
The nodes of the list consist of the three elements that have been mentioned before:
* `data`: information of the node.
* `next`: reference to the next node in the list.
* `previous`: reference to the previous node in the list.

This nodes are used to build the list, which consists of the following elements:
* `first`: reference to the first element of the list.
* `last`: reference to the last element of the list.
* `pdi`: point of interest.  Reference to one of the nodes of the list.  It can also be positioned before the list itself to facilitate the implementation of the `insertion()` method.
* `length`: number of elements contained in the list.

![alt text](https://github.com/mireiagasco/LinkedList-Java/blob/main/images/LinkedList.png)
