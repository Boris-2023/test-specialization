package Model;

public class Counter {
    private int counter;
    public Counter(int basicValue){
        counter = basicValue;
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void add(){
        counter++;
    }
}
