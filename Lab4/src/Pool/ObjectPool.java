package Pool;

public class ObjectPool implements ObjectPool_IF{
    private Object lockObject;
    private int size;
    private int instanceCount;
    private int maxinstances;
    private ObjectPool poolInstance;
    private Object pool[];
    
    ObjectPool(ObjectCreation_IF c, int max)
    {
        
    }
    
    public static final ObjectPool getPoolInstance(ObjectCreation_IF c, int max)
    {
        // TODO: 2/26/2021 need to fill this in 

        return null;
    }
    public int getSize()
    {
        return size;
    }
    
    //gets how many objects that have been created
    public int getCapacity()
    {

        return maxinstances;
    }
    //set's how many objects can be created
    public int setCapacity(int c)
    {
        return this.maxinstances;//i think this is right
    }
    
    public Object getObject()
    {
        return lockObject;//not sure about this
    }
    
    public Object waitForObject()
    {
// TODO: 2/26/2021 need to fill this in, until then return null 
        return null;
    }
    
    private Object removeObject()
    {
        // TODO: 2/26/2021 need to fill in 
        return null;
    }

    @Override
    public void release(Object o) {
        
    }
    private Object createObject()
    {
        // TODO: 2/26/2021 need to fill in this. 
        return null;
    }
}
