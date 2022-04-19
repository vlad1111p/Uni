// Repraesentiert die Knoten eines Baums mit Markierungen
class TreeNode {
  private int mark;
  private TreeNode left;
  private TreeNode right;

  TreeNode(int mark, TreeNode left, TreeNode right) {
    this.mark = mark;
    this.left = left;
    this.right = right;
  }
  // Liefert die Markierung eines Knotens
  int getMark() {
    return this.mark;
  }
  // Liefert die Referenz auf den linken Kindknoten
  TreeNode getLeft() {
    return this.left;
  }
  // Liefert die Referenz auf den rechten Kindknoten
  TreeNode getRight() {
    return this.right;
  }

  // Veraendert die Referenz auf den linken Kindknoten
  void setLeft(TreeNode n) {
    this.left = n;
  }
  // Veraendert die Referenz auf den rechten Kindknoten
  void setRight(TreeNode n) {
    this.right = n;
  }
}