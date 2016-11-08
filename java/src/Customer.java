
public class Customer {
	
	private int groceries; 
    private int bornTime; 
    
    public Customer(int quantity, int time){
        this.groceries = quantity;
        this.bornTime = time; 
    }
    
    public int return_groceries(){
        return groceries; 
    }
    
     
    public int serve(){
        if(groceries != 0){
            groceries --; 
            //register++; 
        }
        return groceries; 
    }  
    
      
    public boolean isDone(){
        if(groceries == 0){
            return true;             
        }
        else {
            return false; 
        }
    }
    
    
    
    
	public static void main(String [] args) {
      Customer customer1 = new Customer(20, 5); 
      int customer_served = customer1.serve();
      boolean customer_done = customer1.isDone(); 
      System.out.println("The groceries number is :" + customer_served); 
      System.out.println("The groceries registered is :" +  customer_done);
      
}

}
