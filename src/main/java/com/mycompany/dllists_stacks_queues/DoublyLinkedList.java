
package com.mycompany.dllists_stacks_queues;

/**
 *
 * @author MoaathAlrajab
 */
class Node {
   public int data;
   public Node next;
   public Node previous;

   public Node(int initialData) {
      data = initialData;
      next = null;
      previous = null;
   }
}

public class DoublyLinkedList {
   private Node head;
   private Node tail;
   public int nodes = 0;
    
   public DoublyLinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
      
      nodes++;
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head.previous = newNode;
         head = newNode;
      }
      
      nodes++;
   }
   
   public void printList() {
      Node node = head;
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }
   
   public void printRevList(){
       Node node = tail;
       while (node != null) {
           System.out.print(node.data + " ");
           node = node.previous;
       }
       System.out.println();
   }
   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
      }
      else {
         Node successor = currentNode.next;
         newNode.next = successor;
         newNode.previous = currentNode;
         currentNode.next = newNode;
         successor.previous = newNode;
      }
      
      nodes++;
   }
   
   public void remove(Node currentNode) {
      Node successor = currentNode.next;
      Node predecessor = currentNode.previous;
      
      if (successor != null)
         successor.previous = predecessor;
         
      if (predecessor != null)
         predecessor.next = successor;
         
      if (currentNode == head)
         head = successor;
         
      if (currentNode == tail)
         tail = predecessor;
      
      nodes--;
   }
   
   public int size() {
       return nodes;
       
       /*while (node != null) {
           nodes += 1;
           node = node.next;
       }*/
       
   }
}

