/*!\class Customer
 * The Class customer has contractor and methods
 * The contractor makes type customer 
 * the methods manipulate customer class behavior 
 * type integer groceries & bornTime are customer class fields 
 * */
public class Customer {
	
	private int groceries; 
    private int bornTime; 
    
    /*!\fn public Customer(int quantity, int time)
     * It is class contractor and which will be used to create customer class type
     * \@param quantity specifies how many number of groceries on the customer basket
     * \@param time specifies the time of new customer arrival  
     * */
    public Customer(int quantity, int time){
        this.groceries = quantity;
        this.bornTime = time; 
    }
    /*!\fn public int return_groceries()
     * The function return how many groceries a customer have in their basket
     * \return groceries 
     * */
    
    public int return_groceries(){
        return groceries; 
    }
    
    /*!\fn public int returnBorntime()
     * The function return new  customer arrival time
     * \return bornTime 
     * */
    public int returnBorntime(){
        return bornTime;  
    }
    
    /*!\fn public int serve()
     * The function decrease the number of groceries by one, if the groceries number is grater than zero
     * \return the remaining groceries in the basket 
     * */
     
    public int serve(){
        if(groceries != 0){
            groceries --;   
        }
        return groceries; 
    }  
    
    /*!\fn public boolean isDone()
     * The function checks the groceries basket is empty or not
     * \return true if the basket is empty else false
     * */
      
    public boolean isDone(){
        if(groceries == 0){
            return true;             
        }
        else {
            return false; 
        }
    }
    
    /*!\fn public String toString()
     * The function convert class object into the string format 
     * \return the string format of customer class object
      */
	public String toString() {
		String str = "";
		
		return str + this.groceries +  "," + this.bornTime;
	}
    
	public static void main(String [] args) {
      Customer customer1 = new Customer(20, 5); 
      int customer_served = customer1.serve();
      boolean customer_done = customer1.isDone(); 
      System.out.println("The groceries number is :" + customer_served); 
      System.out.println("The groceries registered is :" +  customer_done);
      
}

}
