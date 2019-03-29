import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

public class Assert {
    static boolean not_false(boolean cond){
        if (cond){
            return true;
        }
        throw new NoSuchElementException("Error");
    }
}