/**********************************************
Workshop 9
Course: JAC 444 - Summer 2022
Last Name: Himanshu
First Name: Himanshu
ID: 146109202
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature  Himanshu
Date: 08/07/2022
**********************************************/

public class Counter extends Thread {
    private int number;

    public Counter(int number) {
        this.number = number;
    }

    @Override
    public synchronized void start() {
        int i = 0;
        while (i <= number) {
            StoreNumber storeNumber = new StoreNumber(i);
            PrintNumber p = new PrintNumber(storeNumber.getNumber());
            i++;
        }
    }


    public static void main(String[] args) {
        Counter counter = new Counter(16);
        counter.start();
    }

}
