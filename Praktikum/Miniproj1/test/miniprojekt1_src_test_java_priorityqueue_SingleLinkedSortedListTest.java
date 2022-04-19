public void insert(K key, V value) { 
		checkKey(key);

		Item<K,V> newest = new Item<K,V>(key,value);

		if(isEmpty()) { 
			data.addFirst(newest);
		} else {
			
			Iterator<Item<K,V>> iter = data.descendingIterator();
			Item<K,V> walker = iter.next();
			// keep moving left while newest is less than walker
			int ix = data.size();
			while(walker!=null && compare(newest, walker)<0 ) {
				// advance walker left (left = next, descending iterator)
				try {-
				    walker = iter.next();
					ix--;
				} catch(NoSuchElementException e) { 
					walker = null;
				}
			}
			// check what caused the stop
			if(walker==null) {  
				data.addFirst(newest);
			} else {
				data.add(ix,newest);
			}
		}
	}
	
	private Comparator<K> keyCompare;
	
	
	
	protected boolean checkKey(K key) {
		try{ 
			return keyCompare.compare(key,key)==0;
		} catch (ClassCastException e) {
			throw new WeirdKey();
		}
	} 	
	
	
	
	protected int compare(Item<K,V> a, Item<K,V> b) { 
		// Compare two Items 
		// using keyComparator
		// and passing their keys.
		// Don't bother with the details.
		return keyCompare.compare(a.getKey(), b.getKey());
	}
	
	
	
	 public Link remove()        

      {                        

      Link temp =  last;               

      Link current = first;

       

      if(first.next == null)

          first = null;

      else

          while(current.next!=null && current.dData > current.next.dData){

              current = current.next;

              last = current;}

          last = last.previous;

          last.next = null;

      return temp;              

      }
