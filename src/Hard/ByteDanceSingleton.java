package Hard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.Scanner;




public class ByteDanceSingleton {
    private static volatile ByteDanceSingleton instance;

    private ByteDanceSingleton() {};
    public ByteDanceSingleton getInstance() {
        if(instance == null) {
            synchronized (ByteDanceSingleton.class) {
                if(instance == null) {
                    instance = new ByteDanceSingleton();
                }
                return instance;
            }
        } else {
            return instance;
        }
    }

}






