package SingletonDesign;

public class DubboCheckLocking {
    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (DubboCheckLocking.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
