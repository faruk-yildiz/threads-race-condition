import java.util.ArrayList;

public class EvenOrOddThread implements Runnable {

    private int i = 1;
    private final Object LOCK = new Object();
    private ArrayList<Integer> evenList=new ArrayList<>();
    private ArrayList<Integer> oddList=new ArrayList<>();

    public EvenOrOddThread() {

    }

    public ArrayList<Integer> getEvenList() {
        return evenList;
    }

    public ArrayList<Integer> getOddList() {
        return oddList;
    }

    @Override
    public void run() {
        synchronized (LOCK) {

            if (checkNumber(i)) {
                evenList.add(i);
            } else {
                oddList.add(i);
            }
            this.i++;
        }
    }

    public boolean checkNumber(int number){
        if(number%2==0)
            return true;
        else
            return false;
    }
}
