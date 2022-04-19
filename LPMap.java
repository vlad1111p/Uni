
class HashEntry {
    int key;
    String data;

    HashEntry(int key, String data) {
      this.key = key;
      this.data = data;
    }
  }


public class LPMap implements Map {
	 private HashEntry[] table;

	 public LPMap( int tabsize ) {
	    /* tabsize sollte eine Primzahl sein */
	   this.table = new HashEntry[tabsize];
	 }
	@Override
	public String get(int key) {
		int hix = hash(key);
		if(table[hix].data == null) {
			return null;
		} else {
			for(int i=key; hash(i)<table.length; i++) {
				hix = hash(i);
				if(table[hix].key == key) {
					return table[hix].data;
				}
			}
			for(int i=0; i<key; i++) {
				hix = hash(i);
				if(table[hix].key == key) {
					return table[hix].data;
				}
			}
		}
		return null;
	}

	@Override
	public void put(int key, String value) {
	    if(value != null) {
	    	int hix = 0;
	    	boolean check = false;
	        HashEntry entry = new HashEntry(key, value);
	        for(int i=key; hash(i)<table.length; i++) {
	        	hix = hash(i);
	        	if(table[hix] == null || table[hix].key == key) {
	        		table[hix] = entry;
	        		check = true;
	        		break;
	        	}
	        }
	        if(check == false) {
	        	for(int i=0; i<key; i++) {
	        		hix = hash(i);
		        	if(table[hix] == null) {
		        		table[hix] = entry;
		        		check = true;
		        		break;
		        	}
	        	}
	        }
	    }
		
	}

	@Override
	public void remove(int key) {
	}
	
	 private int hash( int key ) {
	    return Math.abs(key) % table.length;
	 }
	
}
