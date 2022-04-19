public class DLIntList {
    private final DNode dummy;
    private int size = 0;
    

    /**
     * Erstellt eine neue, leere Liste
     */
    public DLIntList() {
        dummy = new DNode(null, 0, null);
        dummy.setNext(dummy);
        dummy.setPrev(dummy);
    }

    /**
     * Fuegt ein Element am Ende der Liste ein
     */
    public void add(int element) {
        DNode n = new DNode(dummy.getPrev(), element, dummy);
        dummy.getPrev().setNext(n);
        dummy.setPrev(n);
        size = size + 1;
    }

    /**
     * Liefert die Anzahl der Elemente in der Liste
     */
    public int size() {
        return size;
    }

    public void add(int index, int element) {
        if (index < size && index >= 0) {
        	DNode n = dummy;
        	for(int i = 0; i <= index; i++) {
        		n = n.getNext();
        	}
        	DNode l = new DNode(n.getPrev(), element, n);
        	l.getPrev().setNext(l);
        	l.getNext().setPrev(l);
        	size = size +1;
        } else if (size == index) {
        	add(element);
        }
        	
    }

    public int[] toArray() {
    	int[] ausgabe = new int[size];
    	DNode n = dummy;
    	for(int i = 0; i < size; i++) {
    		n = n.getNext();
    		ausgabe[i] = n.getValue();
    	}
    		
        return ausgabe;
    }

    public int indexOf(int element) {
    	DNode n = dummy;
    	int f = 0;
    	for(int i = 0; i < size; i++) {
    		n = n.getNext();
    		f = n.getValue();
    		if(f == element) {
    			return i;
    		}
    	}
        return -1;
    }

    public int lastIndexOf(int element) {
    	DNode n = dummy;
    	int f = 0;
    	for(int i = size-1; i >= 0; i--) {
    		n = n.getPrev();
    		f = n.getValue();
    		if(f == element) {
    			return i;
    		}
    	}
        return -1;
    }

    public void remove(int element) {
    	DNode n = dummy;
    	int f = 0;
    	for(int i = 0; i < size; i++) {
    		n = n.getNext();
    		f = n.getValue();
    		if(f == element) {
    			n.getPrev().setNext(n.getNext());
    			n.getNext().setPrev(n.getPrev());
    			size--;
    			break;
    		}
    	}
    }

    public DLIntListRevIterator reverseIterator() {
    	int size = this.size;
    	DNode current = dummy;
    	if(size > 0) {
    	current = dummy.getPrev();
    	}
    	return new DLIntListRevIterator(size, current);
    }
}


class DLIntListRevIterator {
	private int iterSize;
	private DNode current;
	
	public DLIntListRevIterator (int size, DNode current) {
		this.iterSize = size;
		this.current = current;
	}

    public boolean hasNext() {
    	if (iterSize <= 0) {
    		return false;
    	} else {
    		return true;
    	}
    }

    public int next() {
    	int ausgabe = 0;
    	if(iterSize > 0) {
		ausgabe = current.getValue();
    	current = current.getPrev();
    	iterSize--;
    	}
    		
    	return ausgabe;
    }
    
}

class Sum {
	
	public static int sum(DLIntList list) {
		if (list.size() > 0) {
		    DLIntListRevIterator r = list.reverseIterator();
		    int ausgabe = 0;
		    while(r.hasNext()) {
			    ausgabe = ausgabe + r.next();
		    }
		    return ausgabe;
		} else {
			return 0;
		}
	}

} 