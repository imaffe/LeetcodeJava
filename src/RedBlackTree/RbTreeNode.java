package RedBlackTree;

public class RbTreeNode {
  public static String COLOR_RED = "red";
  RbTreeNode left;
  RbTreeNode right;
  RbTreeNode parent; // we will need this one
  RbUtils.RB_COLOR color;
  int key;
  int value;

  public RbTreeNode(int key, int value, RbUtils.RB_COLOR color) {
    this.key = key;
    this.value = value;
    this.color = color;
  }

  public static RbTreeNode createNode(int key, int value, RbUtils.RB_COLOR color) {
    return new RbTreeNode(key, value, color);
  }





  public static String getColorRed() {
    return COLOR_RED;
  }

  public static void setColorRed(String colorRed) {
    COLOR_RED = colorRed;
  }

  public RbTreeNode getLeft() {
    return left;
  }

  public void setLeft(RbTreeNode left) {
    this.left = left;
  }

  public RbTreeNode getRight() {
    return right;
  }

  public void setRight(RbTreeNode right) {
    this.right = right;
  }

  public RbTreeNode getParent() {
    return parent;
  }

  public void setParent(RbTreeNode parent) {
    this.parent = parent;
  }

  public RbUtils.RB_COLOR getColor() {
    return color;
  }

  public void setColor(RbUtils.RB_COLOR color) {
    this.color = color;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
