// Markierter Binaerbaum
public class BinTree {
  private int size;
  private TreeNode root;

  // Berechnet die Summe der Markierungen des Baums
  public int sum() {
    return sum(this.root);
  }
  private int sum(TreeNode node) {
    if (node == null) {
        return 0;
    }
    return node.getMark() + sum(node.getLeft())
                          + sum(node.getRight());
  }

  // Testet, ob es einen Knoten mt Markierung x in dem Baum gibt
  public boolean contains(int x) {
    return contains(x, this.root);
  }
  private boolean contains(int x, TreeNode n){
    if (n == null) {
      return false;
    } else {
      return n.getMark() == x
        || contains(x, n.getLeft())
        || contains(x, n.getRight());
    }
  }

  // Fuegt einen Knoten mit Markierung element in den Baum ein
  // (Die Methode erhÃ¤lt die Suchbaumeigenschaft, dies ist hier allerdings nicht notwendig!)
  public void add(int element) {
    this.root = add(this.root, element);
  }

  private TreeNode add(TreeNode node, int element){
    if (node == null) {
        return new TreeNode(element,null,null);
    } else if (element <= node.getMark()) {
        node.setLeft(add(node.getLeft(), element));
    } else {
        node.setRight(add(node.getRight(), element));
    }
    return node;
  }
  
  public int max() {
	  int ausgabe = Integer.MIN_VALUE;
	  if(root != null) {
		  ausgabe = max(root).getMark();
	  }
	  return ausgabe;
  }
  
  private TreeNode max(TreeNode node) {
	  TreeNode ausgabe = node;
	  if(node.getRight() != null) {
		  ausgabe = max(node.getRight());
	  }
	  return ausgabe;
  }
  
  public int size() {
	  int ausgabe = 0;
	  if(root != null) {
		  this.size = 0;
		  size2(root);
		  ausgabe = this.size;
	  }
	  return ausgabe;
  }
  
  private int size2(TreeNode node) {
	    if (node == null) {
	        return 0;
	    }
	    this.size++;
	    return size2(node.getLeft())
	           + size2(node.getRight());
  }
  
  
  public int[] toArray() {
	  int[] ausgabe = new int[size()];
	  if (root != null) {
		  toArray2(root, ausgabe, 0);
	  }
	  return ausgabe;
  }	  
  
  private int toArray2(TreeNode root, int [] ausgabe, int save) {
	    if (root.getLeft() !=null) {
	        save = toArray2(root.getLeft(), ausgabe, save);
	    }
	    ausgabe[save++] = root.getMark();
	    if (root.getRight() !=null) {
	        save = toArray2(root.getRight(), ausgabe, save);
	    }
	    return save;
  }

}