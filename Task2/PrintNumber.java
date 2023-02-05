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

public class PrintNumber  extends  Thread{
    private  int number;

    public PrintNumber(int number) {
        this.number = number;
        start();
    }

    @Override
    public void run() {
        System.out.println(number);
    }
}
