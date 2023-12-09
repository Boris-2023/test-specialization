package Model;

/**
 * Class counter intended to count animals in the Register
 */
public class Counter {
    private int counter;

    /**
     * @apiNote initialization of the counter with set of start value
     * @param basicValue initial value for the counter
     */
    public Counter(int basicValue){
        counter = basicValue;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * method to iterate counter
     */
    public void add(){
        counter++;
    }
}
