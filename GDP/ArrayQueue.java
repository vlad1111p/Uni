public class ArrayQueue<T> implements Queue<T>{

    private int front;
    private int rear;
    int size;
    T[] queue;

    @SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
        this.size = size;
        queue = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public void add(T e) throws QueueFullException, ElementNullException {
        if ((rear+1)%size==front) {
            throw new QueueFullException();

        } else if (e==null) {
        	throw new ElementNullException();
        
    	} else if (isEmpty()) {
            front++;
            rear++;
            queue[rear] = e;

        } else {
            rear=(rear+1)%size;
            queue[rear] = e;

        }
    }

    public T remove() throws QueueEmptyException {
        T e = null;
        if (isEmpty()) {
            throw new QueueEmptyException();
        } else if (front == rear) {
            e = queue[front];
            front = -1;
            rear = -1;

        } else {
            e = queue[front];
            front=(front+1)%size;

        }
        return e;

    }
    
    public T element() throws QueueEmptyException {
        if ((rear+1)%size==front) {
            throw new QueueEmptyException();

        } 
        return queue[front];
    }

}


class QueueFullException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	QueueFullException () {
    	
        super (" queue is full ");
    }
}
class ElementNullException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ElementNullException () {
    	
        super (" element is null ");
        
    }    
}
class QueueEmptyException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	QueueEmptyException () {
    	
        super (" queue is empty ");
        
        
    }
}