import java.util.List;
class DefProg {

  /*
   * requires entries != null
   *       && key != null
   *       && fÃžr alle e in entries: e != null
   *       && entries enthÃĪlt einen Eintrag e mit key.equals(e.getKey())
   * returns e.getValue(), wobei e der erste Eintrag in entries
   *                       mit key.equals(e.getKey()) ist
   */
  public static Object find(List<Entry> entries, String key) {
	  boolean check = false;
	  Object save = new Object();
	  if(entries == null) {
		  throw new IllegalArgumentException("entries darf nicht null sein");
	  }
	  if(key == null) {
		  throw new IllegalArgumentException("key darf nicht null sein");
	  }

	  try {
		  for (Entry e : entries) {
			  if (key.equals(e.getKey()) && check==false) {
				  check = true;
				  save = e.getValue();
			  }
		  }
	  } catch (NullPointerException e) {
  		  throw new IllegalArgumentException("kein eintrag e in entries darf null sein");
  	  }
	  if(check==true) {
	  return save;
	  } else {
	  throw new IllegalArgumentException("kein eintrag e in entries, der dem key gleicht");
	  }
  }

}