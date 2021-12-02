public class multi_example {
    public static void main(String[] args) {
        // MultiThreadThing myThing = new MultiThreadThing();
        // MultiThreadThing myThing2 = new MultiThreadThing();
        

        // // When doing multithreading you need to use the start method in order to do both at once, if you just call the method you are using, in this case run(), it will do one of the calls finish then start the other instead of doing them at the same time 
        // myThing.start();
        // myThing2.start();
        
        // You can also create multiple threads by using a for loop 
        for (int i = 0; i < 5; i++) {
            MultiThreadThing myThing = new MultiThreadThing(i);
            Thread myThread = new Thread(myThing); //This is the line of code that you need so you can implament runnable
            myThread.start();
            // Other useful commands 
            try {
                myThread.join(); // waits for previous thread to finish then it starts the next one. it staggers the threads so 1 thread is executed at a time oooooooooh
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
            } 
            myThread.isAlive(); //This is a boolean that checks to see if the thread is still running 
        }
    }
}


// The better way to do it is to impliment the Runnable if you do it this way then you are still able to extend into a differnent class so you can implement and extend instead of just extending threads
class MultiThreadThing implements Runnable {
    private int threadNumber;
    public MultiThreadThing (int threadNumber) {
        this.threadNumber = threadNumber;
    }

    // Indicating that we are overriding the run() method 
    @Override
    public void run() {
        // With the thread number you can see that 0 is not printed first, what this tells us is that there is no order on which thread goes first or nex. they occur at the same time. If one thread gets blown up in an expection that does not affect the other threads 
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "From thread" + threadNumber);
            // if (threadNumber == 3) {
            //     throw new RuntimeException();
            // }
            try {
                Thread.sleep(1000);
            //TODO: handle exception
            } catch (InterruptedException e) {
                
            }
        }
    }
}


// class MultiThreadThing extends Thread {
//     private int threadNumber;
//     public MultiThreadThing (int threadNumber) {
//         this.threadNumber = threadNumber;
//     }

//     // Indicating that we are overriding the run() method 
//     @Override
//     public void run() {
//         // With the thread number you can see that 0 is not printed first, what this tells us is that there is no order on which thread goes first or nex. they occur at the same time. If one thread gets blown up in an expection that does not affect the other threads 
//         for (int i = 1; i <= 5; i++) {
//             System.out.println(i + "From thread" + threadNumber);
//             if (threadNumber == 3) {
//                 throw new RuntimeException();
//             }
//             try {
//                 Thread.sleep(1000);
//             //TODO: handle exception
//             } catch (InterruptedException e) {
                
//             }
//         }
//     }
// }