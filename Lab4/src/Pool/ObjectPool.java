package Pool;

public class ObjectPool implements ObjectPool_IF{
    private final Object lockObject = new Object();
    private int size;
    private int instanceCount;
    private final int maxInstances;
    private static ObjectPool poolInstance = null;
    private Object[] pool;
    private final ObjectCreation_IF creator;
    
    private ObjectPool(ObjectCreation_IF c, int max)
    {
        instanceCount=0;
        creator = c;
        maxInstances=max;
        size = 0;
        pool = new Object[maxInstances];
    }

    public static ObjectPool getPoolInstance(ObjectCreation_IF c, int max){
        if (poolInstance==null)
            poolInstance = new ObjectPool(c, max);
        return poolInstance;
    }


    public int getInstanceCount()
    {
        return this.instanceCount;
    }

    public int getMaxInstances() {
        return maxInstances;
    }

    @Override
    public int getSize()
    {
        return size;
    }
    @Override
    public int getCapacity()
    {
        return maxInstances;
    }
    @Override
    public void setCapacity(int c)
    {
        if (c <= 0) {
            String msg = "Capacity must be greater than zero";
            throw new IllegalArgumentException(msg);
        }
        synchronized (lockObject) {
            Object[] newPool = new Object[c];
            System.arraycopy(pool, 0, newPool, 0, c);
            pool = newPool;
        }
    }
    @Override
    public Object getObject()
    {
        synchronized (lockObject)
        {
            if (size > 0)
            {
                return removeObject();
            }
            else if (getInstanceCount() < getMaxInstances())
            {
                return createObject();
            }
            else
            {
                return null;
            }
        }
    }


    @Override
    public Object waitForObject() throws InterruptedException
    {
        synchronized (lockObject) {
            if (size > 0) {
                return removeObject();
            }
            if (instanceCount < maxInstances) {
                return removeObject();
            }
            else {
                do {
                    lockObject.wait();
                }
                while (size <= 0);
                return removeObject();
            }
        }
    }

    private Object removeObject()
    {
        size--;

        return pool[size];
    }

    @Override
    public void release(Object o) {
        if(o==null)
        {
            throw new NullPointerException();
        }
        synchronized (lockObject)
        {
            if(size < maxInstances)
            {
                pool[size]=o;
                size++;
                lockObject.notify();
            }
        }
    }
    private Object createObject()
    {
        Object newObject = creator.create();
        instanceCount++;
        return newObject;

    }
}
