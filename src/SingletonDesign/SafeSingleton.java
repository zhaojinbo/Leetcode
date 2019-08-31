package SingletonDesign;

public class SafeSingleton {
    private static class InstanceHolder{
        static Instance instance = new Instance();
    }

    public static Instance getInstance(){
        return InstanceHolder.instance;
    }
}
