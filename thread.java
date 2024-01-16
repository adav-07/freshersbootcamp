import java.util.*;

interface IObserver {
    public void update(String state);
}


class Observer implements IObserver{
    String state;
    public void update(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
}

class Thread{
    private int id,priority;
    private String state,culture;
    ArrayList<IObserver> observers;
    Thread(String id, String priority, String culture){
        this.id = id;
        this.state = "created";
        this.priority = priority;
        this.culture = culture;
        observers = new ArrayList<>();
    }
 
    private void notifyObservers(){
        for(IObserver observer: observers){
            observer.update(this.state);
        }
    }
    void start(){
        this.state = "running";
        notifyObservers();
    }
    void abort(){
        this.state = "aborted";
        notifyObservers();
    }
    void sleep(){
        this.state = "sleep";
        notifyObservers();
    }
    void waitThread(){
        this.state = "wait";
        notifyObservers();
    }
    void suspended(){
        this.state = "suspended";
        notifyObservers();
    }
    
    String getState(){
        return this.state;
    }
    public void subscribe(IObserver observer){
        observers.add(observer);
    }
    
    public void unsubscribe(IObserver observer){
        observers.remove(observer);
    }
}

class HelloWorld {
    public static void main(String[] args) {
        Thread thread = new Thread("firstThread", "10", "eg");
        IObserver observer=new Observer();
        thread.subscribe(observer);
        thread.start();
        thread.waitThread();
        System.out.println(observer.getState());
        thread.unsubscribe(observer);
    }
}
