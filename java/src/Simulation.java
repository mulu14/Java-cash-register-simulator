import java.util.ArrayList;
import java.util.Random;
import java.util.*;

/*!\class Simulation
 * The Class Simulation has contractor and method
 * The contractor makes type  Simulator
 * the methods manipulate simulator class behavior 
 *  class fields are Store, time, intensity, maxGroceries, thresholdsForNewRegister, 
 *       numberOfCustomerserved, maxWaittime, totalWaittime,  averageWaittime; 
 * */

public class Simulation {
    private Store store;
    private int time;
    private int intensity;
    private int maxGroceries;
    private int thresholdForNewRegister;
    private int numberofCustomerserved;
    private int maxWaittime;
    private int totalWaittime;
    private int averageWaittime;

    /*!\fn public Simulation(int intensity, int max, int treshold)
     * It is class contractor and which will be used to create Simulation
     * \@param intensity specifies the probability of new customer will arrive in each step  
     * \@param max specifies the maximum groceries the customer could have 
     * \@param treshold specifies the average length of time,  new register open 
     * */
    
    public Simulation(int intensity, int max, int treshold)
    {
        this.store= new Store();
        this.time= 0;
        this.intensity = intensity;
        this.maxGroceries = max;
        this.thresholdForNewRegister = treshold;
        this.numberofCustomerserved = 0;
        this.maxWaittime = 0;
    }

    /*!\fn public String toString()
     * The function convert class Simulation into the string format 
     * \return the string format of Simulation class
      */


	public String toString() {
		String customers = "Number of customer served: " + this.numberofCustomerserved + "\n";
	    String Time = "\nThe time passed: " + this.time+ "\n";
	    String Total = "Total wait time: " + this.totalWaittime+ "\n";
	    String Maxtime = "Max wait time: " + this.maxWaittime + "\n";
	    String average = "Average wait time: " + this.averageWaittime + "\n";
	    return store.toString() +  Time + customers + Total+ Maxtime + average;
	}

    //one time step in Store
    //randomInt to compare with intensity
    //randomGroceries to get random number of groceries for new customer

    public void step(){
    	this.time ++;
        this.store.step();
        ArrayList<Customer> doneList = this.store.getDoneCustomers();
        updateData(doneList);
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        int randomGroceries = randomGenerator.nextInt(maxGroceries);
        int average = store.getAverageQueueLength();
        if (randomInt < intensity) {
            Customer c = new Customer(randomGroceries, time);
            if (average> thresholdForNewRegister) {
                store.openNewRegister();
                store.newCustomer(c);
            }
            else {
            	if (this.store.returnSize() == 0)
            	{store.openNewRegister();}
            	store.newCustomer(c);
            }
        }

        }


    public int returnServedCustomers(){
    	return numberofCustomerserved;

    }

    public void updateServed(ArrayList<Customer> arr){
      this.numberofCustomerserved += arr.size();

      }

    public int getMaxTime(ArrayList<Customer> arr){
    	for(int i= 0; i<arr.size(); i++)
    	{
    		Customer c = arr.get(i);
    		int t =time-c.returnBorntime();
    		if (t> this.maxWaittime){
    		this.maxWaittime = t;
    		}
    	}
    return maxWaittime;
    }

    public int getTotalTime(ArrayList<Customer> arr){
      int total= 0;
      for(int i= 0; i<arr.size(); i++)
      {
        Customer c = arr.get(i);
        int t =time-c.returnBorntime();
        total= total+ t;
        }
    this.totalWaittime += total;
    return total;
    }

    public int getAverageTime(ArrayList<Customer> arr){
      int average;
      if (this.numberofCustomerserved ==0)
      {return 0;}
      average = this.totalWaittime /this.numberofCustomerserved;
      this.averageWaittime = average;
      return average;
    }


    public void updateData(ArrayList<Customer> arr){
    updateServed(arr);
    getMaxTime(arr);
    getTotalTime(arr);
    getAverageTime(arr);
    }
//===========================================
//===========================================

	public static void main(String [] args) {



            Simulation S = new Simulation(30, 10, 5);
            S.step();
            S.step();
            S.step();
            S.step();
            System.out.println("The number of customer in the queue = " + S.store.getAverageQueueLength());
        }
}
