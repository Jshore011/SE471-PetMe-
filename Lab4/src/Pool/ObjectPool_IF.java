package Pool;

public interface ObjectPool_IF {

    public int getSize();
    public int getCapacity();
    public int setCapacity(int c);
    public Object getObject();
    public Object waitForObject() throws InterruptedException;
    public void release(Object o);


}
