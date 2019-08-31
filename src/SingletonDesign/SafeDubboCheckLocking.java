package SingletonDesign;

public class SafeDubboCheckLocking {
    private static volatile Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDubboCheckLocking.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
