package multithreading;

public class Semafor {
    private boolean _stan = true;
    private int _czeka = 0;

    public Semafor() {}

    public synchronized void P() {
        try {
            if (_stan) {
                _stan = false;
            } else {
                _czeka++;
                wait();
            }
        } catch (Exception ex) {
        }
    }

    public synchronized void V() {
        if (_czeka > 0) {
            notify();
            _czeka--;
        } else {
            _stan = true;
        }
    }
}