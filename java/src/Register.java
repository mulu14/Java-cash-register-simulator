import java.util.*;
/*!\class Register
 * The Class Register has contractor and methods
 * The contractor makes type Register
 * the methods manipulate Register class behavior 
 * type Boolean and Queue are register fields 
 * */
public class Register {
	 private boolean open;
	 private Queue queue;
	 
	 /*!\fn public Register()
	     * It is class constructor function and which will be used to create Register class type
	     * Constructor create empty queue and state the status of the register. 
	     * register status could be true if it is open otherwise false 
	     * \@param status is boolean
	     * */
  
	 
	public Register(boolean status){
		this.open = status;
		this.queue = new Queue();
	}
	 /*!\fn public boolean open()
     * It is a function set the status of the register true
     * \return true
     * */


	public boolean open(){
		return open = true;
	}
     
	/*!\fn public boolean close()
     * The function set the status of the register false
     * \return false
     * */

	public boolean close(){
		return open = false;
	}

	/*!\fn public boolean isOpen()
     * The function checks if the register is open or not
     * \return return true if the register is open else \return false 
     * */
	public boolean isOpen(){
		if(open== true)
			return true;
		else
			return false;
	}

	/*!\fn public void step()
     * The function remove one groceries from first customer on the register queue
     * */

	public void step(){
			Customer c = queue.first();
			c.serve();

		}

	/*!\fn public boolean hasCustomer()
     * The function checks there are any customer on the register queue
     * \return true if there is customer else \return false 
     * */
	 public boolean hasCustomer(){ 
	        if (queue.length()>0)
	            {return true;}
	        else
	            {return false;}
	    }

	 /*!\fn public boolean hasCustomer()
	     * The function checks there are any customer on the register queue
	     * \return true if there is customer else \return false 
	     * */
	 public boolean currentCustomerIsDone(){
	        Customer cust= queue.first();
	        return cust.isDone();
	    }
	 
	 /*!\fn public void addToQueue()
	     * The function  add customer at the end of queue
	     * \@param  c is Customer
	     * */

	 public void addToQueue(Customer c) {
         queue.enqueue(c);
   }

	 /*!\fn public Customer removeCurrentCustomer()
	     * The function  remove customer from the beginning of queue and return
	     * \return Customer
	     * */

   public Customer removeCurrentCustomer(){
       return queue.dequeue();

   }
   /*!\fn public int getQueueLangth()
    * The function return the length of the queue
    * \return int
    * */
  
   public int getQueueLength(){
       return this.queue.length();
   }
   /*!\fn public String toString()
    * The function get each customers groceries and convert into string format 
    * \return string 
     */
	public String toString(){
		if (queue.length() == 0)
		{return "";}
		String str = " [" + queue.first().return_groceries() +"]";
		for (int i = 1; i < queue.length(); ++i)
		{
			str += "(" + this.queue.getCustomer(i).return_groceries() + ")";
		}
		return str;
	}


	public static void main(String [] args) {

		
	}

}
