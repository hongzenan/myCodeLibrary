package ze.nan.hong.practices;

import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 123;
    }

}
