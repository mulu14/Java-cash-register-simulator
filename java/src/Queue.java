import java.util.*;
/*!\class Queue
 * The Class queue has contractor and methods
 * The contractor makes type customer 
 * the methods manipulate queue class behavior 
 * type Node first & last type int size queue class fields 
 * */

public class Queue {
	private  Node first;
	private Node last;
	private int size ;
	
	/*!\fn public Queue()
     * It is class constructor function and which will be used to create queue class type
     * the constructor  create empty queue
     * */

	public Queue (){
		this.first = null;
		this .last = null;
		this.size = 0;
	}
	/*!\fn public void enqueue()
     * the function that add customer at the end of the queue 
     * increase the size of the queue by one
     * \@param c  is type customer
     * */
	
	public void enqueue(Customer c){

		Node temp  = new Node(c);

		if(this.first == null){
			this.first = temp;
			this.last = temp;
			this.size +=1;
		}

		else {
			Node current = first;
			while(current.hasNext() != false){
				current = current.getNext();
			}
			current.next = temp;
			this.last = temp;
			this.size +=1;
		}
	}

	
	/*!\fn public Customer returnElement()
     * the function return the first customer on the queue
     * \return Customer type
     * */
	public Customer returnElement() {
		return first.element;
	}
	
	/*!\fn public Customer getCustomer(int index)
     * the function return customer at given index
     * \return Customer type
     * */
	public Customer getCustomer(int index) {
		Node current = this.first;
		for (int i= 0; i< index ; i++)
		current= current.next;
		return current.element;
	}

	/*!\fn public Customer dequeue()
     * the function  remove the first element from the queue and return 
     * \return is Customer type
     * */
	public Customer dequeue() {
		Customer temp = first.element;
		this.first = this.first.next;
		this.size -=1;
		return temp;
	}
	/*!\class Node
	 * The Class Node is subclass of \class Queue and it own constructor and methods
	 * The constructor makes type Linked list
	 * the methods manipulate Node class behavior 
     * type Customer element and pointer to next Node on the linked list
	 */
    


	private class Node {
		Customer element;
		Node next;

		/*!\fn private Node()
	     * It is class constructor function and which will be used to create Node class type
	     * the constructor  create empty node
	     * */
		private Node(){
			this.element = null;
			this.next  =  null;
		}
		
		/*!\fn private Node()
	     * It is class constructor function and which will be used to create Node class type
	     * the constructor  create a node with customer as node element 
	     * \@param  c is Customer type 
	      */

		private Node(Customer c){
			this.element = c;
			this.next  =  null;
		}

		/*!\fn private Node getNext()
	     * The function return the next node on the linked list
	      */
		private Node getNext(){
			return this.next;

		}
		/*!\fn private boolean hasNext()
	     * The function check if the next element in the linked list is empty 
	     * \return true if there is no node else false  
	      */

		private boolean hasNext(){
			return this.next != null;
		}

		/*!\fn private void setNext()
	     * The function take Node type and set as next on the linked list
	     * \@param Node next 
	      */
		private void setNext(Node next){
			this.next = next;
		}

	}

	/*!\fn public int length()
     * The function return the length of linked list
      */

	public int length(){
		return this.size;
	}
	/*!\fn public Customer first()
     * The function return the first element on the linked list
     * \return Customer 
      */

	public Customer first() {
		return this.first.element;

	}

	public static void main(String [] args) {

		Customer customer1 = new Customer(2, 6);
		Customer customer2 = new Customer(30, 7);
		Customer customer3 = new Customer(25, 15);
		Customer customer4 = new Customer(60, 30);
		Customer customer5 = new Customer(100,55);
		Queue one = new Queue();
		//System.out.println("The number of customer in the queue :" + one.length());
		one.enqueue(customer1);
		//System.out.println("The number of customer in the queue :" + one.length());
		one.enqueue(customer2);
		one.enqueue(customer3);
		one.enqueue(customer4);
		one.enqueue(customer5);
		System.out.println(one.getCustomer(0).toString());
		System.out.println(one.getCustomer(4).toString());
		System.out.println("The number of customer in the queue :" + one.length());

		//one.dequeue();
		//System.out.println("The number of customer in the queue :" + one.length());
		//System.out.println("The number of customer in the queue :" + one.first().return_groceries());

	}

}

