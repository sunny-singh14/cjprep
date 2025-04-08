package coder.shy.designpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {

    public static void main(String[] args) {
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        User user4 = new User(4);

        SalePromo salePromo = new SalePromo();
        salePromo.subscribe(user1);
        salePromo.subscribe(user2);
        salePromo.subscribe(user4);

        salePromo.notify("New Sale is Live");

        salePromo.unSubscribe(user2);
        salePromo.subscribe(user3);
        salePromo.notify("Sale ending soon");
    }
}

interface Observer {
    void update(String message);
}

class User implements Observer {
    private int id;

    User(int id) {
        this.id = id;
    }

    public void update(String message) {
        System.out.println("message received by " + this);
    }

    public String toString(){
        return "[ " + id + " ]";
    }
}

class SalePromo implements Subject {

    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notify(String message){
        for (Observer observer: subscribers) {
            observer.update(message);
        }
    }
}

interface Subject {
    void subscribe(Observer observer);
    void unSubscribe(Observer observer);
    void notify(String message);
}
