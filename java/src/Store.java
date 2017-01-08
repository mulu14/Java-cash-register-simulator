/*!\class Store
 * The Class store has contractor and methods
 * The contractor makes type store
 * the methods manipulate store class behavior 
 * ArrayList of queue is store class fields 
 * */
import java.util.ArrayList;
public class Store {

	private ArrayList<Register>registers;

	
	 /*!\fn public Store()
     * The function is Class constructor, it create a store with array of register 
     * */

	public Store(){
		this.registers = new ArrayList<Register>();

	}
	/*!\fn public int getAverageQueueLangth()
     * The function calculate the average length of the queue at the store
     * if the length is zero, it return zero
     * It loop each array of queue and it sum each queue length and divide by the size of array 
     * \return average length of the q queue
     * */

	public int getAverageQueueLength(){
		int lengthofeachQueue = 0;
		int registerLength = registers.size();
		if (registerLength == 0) {return 0;}
		for(Register r : this.registers) {
			lengthofeachQueue += r.getQueueLength();
			}
		return (lengthofeachQueue/registerLength);
	}
	
	
	/*!\fn public int returnSize()
     * The function calculate the average length of the queue at the store
     * \return  the size of queue
     * */
	public int returnSize(){
		int x = registers.size();
		return x ;
	}

	/*!\fn public Register returnShortQueue()
     * The function loop  the register list and return the shortest register list 
     * \return the shortest register list from array of register 
     * */

	public Register returnShortQueue(){
		Register min = registers.get(0);
		for(int i = 0; i < registers.size(); ++i) {
			if(registers.get(i).getQueueLength() < min.getQueueLength()){
				min = registers.get(i);
			}
			}
		return min;
	}

	/*!\fn public void newCustomer()
     * The function add the customer on the shortest register queue in the store
     * */
	public void newCustomer(Customer c){
		Register one = returnShortQueue();
		one.addToQueue(c);

	}


	/*!\fn public void step()
     * The function decrease one groceries from each first customer the register queue
     * the queue of the register must be grater than zero
     * */


	public void step(){
			for(Register r : this.registers) {
				if(r.getQueueLength() > 0){
				r.step();
				}
			}

	}


	/*!\fn public void openNewRegister()
     * The function open a new register and add to the register array list
     * */


	public void openNewRegister(){
	     Register one = new Register(true);
	     registers.add(one);
	}

	 /*!\fn public String toString()
	    * The function get each customers groceries and convert into string format 
	    * \return string 
	     */


	public String toString() {
		String str = "";
		for (Register r : registers) {
			str += r.toString()+"\n";
		}
		return str;
	}
	
	 /*!\fn public ArrayList<Customer> getDoneCustomer()
	    * The function remove all the customer whose groceries basket is empty from the queue
	    * It add all the removed customers into customer array list
	    * \return array list of removed customer 
	     */

	public ArrayList<Customer> getDoneCustomers(){
		ArrayList<Customer> done = new ArrayList<Customer>();

		for(Register r : this.registers) {
			if(r.getQueueLength() > 0 && r.currentCustomerIsDone()){
			Customer temp = r.removeCurrentCustomer();
			done.add(temp);
			}
		}

		return done;
	}




	public static void main(String [] args) {

		
	}

}

	
	