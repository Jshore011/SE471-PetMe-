package Pool;

public class ObjectPool implements ObjectPool_IF{
    private final Object lockObject = new Object();
    private int size;
    private int instanceCount;
    private final int maxInstances;
    private static ObjectPool poolInstance = null;
    private Object[] pool;
    private final ObjectCreation_IF creator;
    
    ObjectPool(ObjectCreation_IF c, int max)
    {
        instanceCount=0;
        creator = c;
        maxInstances=max;
        pool = new Object[maxInstances];
    }
    
    public synchronized static ObjectPool getPoolInstance(ObjectCreation_IF c, int max)
    {
        if (poolInstance==null)
        {
            synchronized (ObjectPool.class) {
                if (poolInstance == null) {
                    poolInstance = new ObjectPool(c, max);
                }
            }
        }return poolInstance;
    }

    public int getInstanceCount()
    {
        return instanceCount;
    }

    public int getMaxInstances() {
        return maxInstances;
    }

    public int getSize()
    {
        return size;
    }
    
    //gets how many objects that have been created
    public int getCapacity()
    {
        return pool.length;
    }
    //set's how many objects can be created
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



    public Object waitForObject() throws InterruptedException
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
                while (size <=0);
                wait();
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
            if(getSize()<getCapacity())
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
