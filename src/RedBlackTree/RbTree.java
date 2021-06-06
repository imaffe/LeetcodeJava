package RedBlackTree;

import com.sun.tools.internal.xjc.reader.relaxng.RawTypeSetBuilder;

public class RbTree {

  private RbTreeNode dummyRoot;
  private RbTreeNode root;

  public static int MIN_KEY_VALUE = Integer.MIN_VALUE;
  public static int MAX_KEY_VALUE = Integer.MAX_VALUE;

  public RbTree() {
    root = null;
    // we always assign th
    dummyRoot = new RbTreeNode(0, 0, RbUtils.RB_COLOR.BLACK);
  }

  public static RbTree createNewRbTree() {
    return new RbTree();
  }

  public RbUtils.STATUS insert(int key, int value) {
    RbTreeNode result = findNode(key);
    if (result != null) {
      return RbUtils.STATUS.INSERT_FAILE_KEY_ALREADY_EXIST;
    }

    if (root == null) {
      RbTreeNode newNode = RbTreeNode.createNode(key, value, RbUtils.RB_COLOR.BLACK);
      root = newNode;
      return RbUtils.STATUS.INSERT_SUCCESS;
    }

    // 1. start insertion, assuming that at least root node exist
    RbTreeNode insertionParent = findParentToInsertKey(key);
    if (isBlack(insertionParent)) {
      insertNewNodeToParent(insertionParent, key, value);
    } else if (isRed(insertionParent)) {
      RbTreeNode newNode = insertNewNodeToParent(insertionParent, key, value);
      if (isRedParentSiblingExistAndRed(newNode)) {
        // 1. this is a recursive call
        performCaseOneRedParentRedParentSiblingFromNode(newNode);
      } else if (isRedParentSiblingBlackOrNonexist(newNode)) {
        performCaseTwoRedParentSiblingNonexistFromNode(newNode);
      } else {
        throw new RuntimeException("Invalid state: when inserting new node to the tree, it has to be one of the predefined case");
      }
    } else {
      throw new RuntimeException(String.format("Invalid state: RbTreeNode of key %s is neither red or black", insertionParent.getKey()));
    }

    return RbUtils.STATUS.INSERT_SUCCESS;
  }

  public RbUtils.STATUS delete(int key) {
    if (root == null) {
      return RbUtils.STATUS.DELETE_FAILED_NON_EXIST_KEY;
    }
    // TODO
    return RbUtils.STATUS.DELETE_SUCCESS;
  }

  public int find(int key) {
    // TODO
    return -1;
  }

  /**
   * Should return null if node with specified key not found
   * Otherwise return the RbTreeNode
   * @param key
   * @return RbTreeNode
   */
  private RbTreeNode findNode(int key) {
    if (root == null) {
      return null;
    }

    RbTreeNode cur = root;
    while (cur != null) {
      if (key == cur.getKey()) {
        return cur;
      } else if (key < cur.getKey()) {
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    // should break when cur is null
    return cur;
  }

  /**
   * Should return the node if specified key is found, otherwise return the parent of where the key should be child of.
   * We can assume this method is never called when RbTree is empty, so RbTreeNode never returns null. We also assume
   * that the key is not in the tree yet, otherwise throw an exception
   * @param key
   * @return
   */
  private RbTreeNode findParentToInsertKey(int key) {
    if (root == null) {
      throw new RuntimeException("Invalid State: findNodeOrParent never be called when root is null");
    }

    RbTreeNode cur = root;
    RbTreeNode parent = root;
    while (cur != null) {
      if (key == cur.getKey()) {
        throw new RuntimeException(String.format("Invalid state: findParentToInsertKey() should not find the key existing in the tree, key: %s", key));
      } else if (key < cur.getKey()) {
        parent = cur;
        cur = cur.left;
      } else {
        parent = cur;
        cur = cur.right;
      }
    }
    return parent;
  }

  private boolean isBlack(RbTreeNode node) {
    return node.getColor() == RbUtils.RB_COLOR.BLACK;
  }

  private boolean isRed(RbTreeNode node) {
    return node.getColor() == RbUtils.RB_COLOR.RED;
  }

  private RbTreeNode insertNewNodeToParent(RbTreeNode parent, int key, int value) {
    RbTreeNode newNode = RbTreeNode.createNode(key, value, RbUtils.RB_COLOR.RED);
    if (parent.getKey() > key) {
      assert(parent.left == null);
      parent.left = newNode;
      newNode.parent = parent;
    } else {
      assert(parent.right == null);
      parent.right = newNode;
      newNode.parent = parent;
    }
    return newNode;
  }

  /**
   * check if parent node of curNode is Red and if the sibling of parent node is red as well.
   * We also assume that curNode has at least 2 layer of ancestor. But in more general case, root
   * node could become red, then we need to set the root node to black.
   * @param curNode
   * @return
   */
  private boolean isRedParentSiblingExistAndRed(RbTreeNode curNode) {
    RbTreeNode parent = curNode.parent;
    if (parent == null) {
      throw new RuntimeException("Invalid State: this method is only called for initial iteration of insertion");
    }
    RbTreeNode grandParent = parent.parent;
    RbTreeNode parentSibling = findSibling(parent);
    if (parentSibling == null || isBlack(parentSibling)) {
      return false;
    } else {
      return true;
    }
  }

  private boolean isRedParentSiblingBlackOrNonexist(RbTreeNode curNode) {
    RbTreeNode parent = curNode.parent;
    assert(parent != null);
    RbTreeNode grandparent = parent.parent;
    assert grandparent != null;
    RbTreeNode parentSibling = findSibling(parent);
    return parentSibling == null || isBlack(parentSibling);
  }

  /**
   * We assume that child must have parent when called
   * @param child
   * @return
   */
  private RbTreeNode findSibling(RbTreeNode child) {

    RbTreeNode parent = child.parent;
    if (parent == null) {
      throw new RuntimeException(String.format("Invalid State: findSibling is called on a node without parent, child key: %s", child.getKey()));
    }
    if (parent.left != null) {
      if (parent.left == child) {
        return parent.right;
      } else {
        return parent.left;
      }
    } else {
      // because left is null, then child has to be the right
      return null;
    }
  }


  private void performCaseOneRedParentRedParentSiblingFromNode(RbTreeNode curNode) {
    RbTreeNode parent = curNode.parent;
    RbTreeNode parentSibling = findSibling(parent);
    RbTreeNode grandParent = parent.parent;
    markFromRedToBlack(parent);
    markFromRedToBlack(parentSibling);
    markFromBlackToRed(grandParent);

    caseOneRecursiveRedNodeFrom(grandParent);
  }

  private void performCaseTwoRedParentSiblingNonexistFromNode(RbTreeNode curNode) {
    RbTreeNode parent = curNode.parent;
    assert parent != null;
    RbTreeNode grandParent = parent.parent;
    assert grandParent != null;
    if (isLeftChild(parent)) {
      if (isLeftChild(curNode)) {
        RbTreeNode newLocalTop = rightRotateNode(grandParent);
        markFromRedToBlack(newLocalTop);
        markFromBlackToRed(newLocalTop.right);
      } else {
        leftRotateNode(parent);
        RbTreeNode newLocalTop = rightRotateNode(grandParent);
        markFromRedToBlack(newLocalTop);
        markFromBlackToRed(newLocalTop.right);
      }
    } else {
      if (isRightChild(curNode)) {
        RbTreeNode newLocalTop = leftRotateNode(grandParent);
        markFromRedToBlack(newLocalTop);
        markFromBlackToRed(newLocalTop.left);
      } else {
        rightRotateNode(parent);
        RbTreeNode newLocalTop = leftRotateNode(grandParent);
        markFromRedToBlack(newLocalTop);
        markFromBlackToRed(newLocalTop.left);
      }
    }
  }

  private void markFromBlackToRed(RbTreeNode node) {
    if (!isBlack(node)) {
      throw new RuntimeException("Invalid State: mark from black to red but the node is already red");
    }
    node.setColor(RbUtils.RB_COLOR.RED);
  }

  private void markFromRedToBlack(RbTreeNode node) {
    if (!isRed(node)) {
      throw new RuntimeException("Invalid State: mark from red to black but the node is already black");
    }

    node.setColor(RbUtils.RB_COLOR.BLACK);
  }


  /**
   * This method will consider if the node is already root
   * @param node
   */
  private void caseOneRecursiveRedNodeFrom(RbTreeNode node) {
    RbTreeNode parent = node.parent;
    if (parent == null) {
      // already root node, then
      if (root != node) {
        throw new RuntimeException("Invalid State: this red node should be root but it's not");
      }
      markFromRedToBlack(node);
      return;
    } else {
      if (isBlack(parent)) {
        return;
      } else {
        // red parent must have a black parent
        RbTreeNode grandParent = parent.parent;
        if (grandParent == null) {
          throw new RuntimeException("Invalid State: parent of red node should be a black and non null");
        }
        if (isRedParentSiblingExistAndRed(node)) {
          performCaseOneRedParentRedParentSiblingFromNode(node);
        } else if (isRedParentSiblingBlackOrNonexist(node)) {
          if (isLeftChild(parent)) {
            if (isLeftChild(node)) {
              RbTreeNode newLocalTop = rightRotateNode(grandParent);
              markFromRedToBlack(newLocalTop);
              markFromBlackToRed(newLocalTop.right);
            } else {
              leftRotateNode(parent);
              RbTreeNode newLocalTop = rightRotateNode(grandParent);
              markFromRedToBlack(newLocalTop);
              markFromBlackToRed(newLocalTop.right);
            }
          } else {
            if (isRightChild(node)) {
              RbTreeNode newLocalTop = leftRotateNode(grandParent);
              markFromRedToBlack(newLocalTop);
              markFromBlackToRed(newLocalTop.left);
            } else {
              rightRotateNode(parent);
              RbTreeNode newLocalTop = leftRotateNode(grandParent);
              markFromRedToBlack(newLocalTop);
              markFromBlackToRed(newLocalTop.left);
            }
          }
        } else {
          throw new RuntimeException("Invalid state: when inserting new node to the tree, it has to be one of the predefined case");
        }
      }
    }
  }

  private RbTreeNode leftRotateNode(RbTreeNode node) {
    RbTreeNode parent = node.parent;
    RbTreeNode rightChild = node.right;
    if (rightChild == null) {
      throw new RuntimeException("Invalid State: perform left rotate on a node where there is no right child");
    }
    RbTreeNode rightChildLeftChild = rightChild.left;
    // TODO this is a workaround to
    boolean isLeftChildWhenParentIsNotNull = parent != null && isLeftChild(node);

    // break all the chains
    node.right = null;
    rightChild.parent = null;

    rightChild.left = null;
    if (rightChildLeftChild != null) {
      rightChildLeftChild.parent = null;
    }

    node.parent = null;
    // should break the chain where parent.left or right set to null, for simplicity we don't do that here

    rightChild.left = node;
    node.parent = rightChild;

    node.right = rightChildLeftChild;
    if (rightChildLeftChild != null) {
      rightChildLeftChild.parent = node;
    }

    if (parent != null) {
      if (isLeftChildWhenParentIsNotNull) {
        parent.left = rightChild;
      } else {
        parent.right = rightChild;
      }
      rightChild.parent = parent;
    }

    if (rightChild.parent == null) {
      root = rightChild;
    }
    return rightChild;
  }


  private RbTreeNode rightRotateNode(RbTreeNode node) {
    RbTreeNode parent = node.parent;
    RbTreeNode leftChild = node.left;
    if (leftChild == null) {
      throw new RuntimeException("Invalid State: perform right rotate on a node where there is no left child");
    }
    RbTreeNode leftChildRightChild = leftChild.right;
    boolean isLeftChildWhenParentIsNotNull = parent != null && isLeftChild(node);
    node.left = null;
    leftChild.parent = null;

    leftChild.right = null;
    if (leftChildRightChild != null ) {
      leftChildRightChild.parent = null;
    }

    node.parent = null;

    leftChild.right  = node;
    node.parent = leftChild;

    node.left = leftChildRightChild;
    if (leftChildRightChild != null ) {
      leftChildRightChild.parent = node;
    }

    if (parent != null) {
      if (isLeftChildWhenParentIsNotNull) {
        parent.left = leftChild;
      } else {
        parent.right = leftChild;
      }
      leftChild.parent = parent;
    }

    if (leftChild.parent == null) {
      root = leftChild;
    }
    return leftChild;
  }

  /**
   * We can assume this leftChild is not null
   * @param node
   * @return
   */
  private boolean isLeftChild(RbTreeNode node) {
    RbTreeNode parent = node.parent;
    return parent.left == node;
  }

  private boolean isRightChild(RbTreeNode node) {
    RbTreeNode parent = node.parent;
    return parent.right == node;
  }

  public void visualizeRbTree() {
    int size = calculateSize(root);
    int height = calculateHeight(root);
  }

  private int calculateSize(RbTreeNode node) {
    if (node == null) return 0;
    int leftSize = calculateSize(node.left);
    int rightSize = calculateSize(node.right);
    return leftSize + rightSize + 1;
  }

  private int calculateHeight(RbTreeNode node) {
    if (node == null) return 0;
    int leftHeight = calculateHeight(node.left);
    int rightHeight = calculateHeight(node.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  public boolean validateRbTree() {
    // to validate if a tree is a rb tree, we need to make sure it follows some rules.
    // we assume there is no repeat keys in the tree
    // 1. it is a BST
    // 2. root node is black
    // 3. all RED node has 2 black nodes or 2 null node
    // 4. for any subtree, all path from root of subtree to leaf contains the same number of black nodes.
    boolean check = validateIsBinarySearchTree(root)
      && validateRootNodeIsBlack(root)
      && validateAllRedNodeHasTwoBlackNodeOrNull(root);
    int result = validateAllPathsContainsSameNumberOfBlackNodes(root);
    if (result == -1) {
      return false;
    } else {
      return check;
    }
  }

  private boolean validateIsBinarySearchTree(RbTreeNode root) {
    return validateIsBinarySearchTreeWithLimit(root, MIN_KEY_VALUE, MAX_KEY_VALUE);
  }

  private boolean validateIsBinarySearchTreeWithLimit(RbTreeNode root, int min, int max) {
    if (root == null) return true;
    if (root.getKey() > max || root.getKey() < min) {
      System.out.println("BST Validation Error: do not satisfy BST constraint");
      printErrorTrace(root);
      return false;
    }

    return validateIsBinarySearchTreeWithLimit(root.left, min, root.getKey())
      && validateIsBinarySearchTreeWithLimit(root.right, root.getKey(), max);
  }

  private boolean validateRootNodeIsBlack(RbTreeNode root) {
    if (!isBlack(root)) {
      System.out.println("Black Root Validation Error: root is not black");
      return false;
    } else {
      return true;
    }
  }

  private boolean validateAllRedNodeHasTwoBlackNodeOrNull(RbTreeNode root) {
    if (root == null) return true;
    if (isBlack(root)) {
      return validateAllRedNodeHasTwoBlackNodeOrNull(root.left)
        && validateAllRedNodeHasTwoBlackNodeOrNull(root.right);
    } else {
      if (root.left == null && root.right == null) {
        return true;
      } else if (root.left != null && isBlack(root.left) && root.right != null && isBlack(root.right)) {
        return true;
      } else {
        System.out.println("Red Node Validation Error: red node must have 2 black node or 2 null node");
        return false;
      }
    }
  }

  /**
   * To avoid using a structure as the result, we will use a negative number to represent that the subtree is not a RBT
   * , if positive means the subtree is a RBT and the number of black nodes to each leaf.
   * @param root
   * @return
   */
  private int validateAllPathsContainsSameNumberOfBlackNodes(RbTreeNode root) {
    if (root == null) return 0;

    int leftBlackNodes = validateAllPathsContainsSameNumberOfBlackNodes(root.left);
    int rightBlackNodes = validateAllPathsContainsSameNumberOfBlackNodes(root.right);

    if (leftBlackNodes == -1|| rightBlackNodes == -1) {
      return -1;
    }

    if (leftBlackNodes != rightBlackNodes) {
      System.out.printf("Black Node Number Validation Error: %s node has different number of black nodes to its leaf%n", root.getKey());
      return -1;
    }

    if (isBlack(root)) {
      return leftBlackNodes + 1;
    } else {
      return leftBlackNodes;
    }
  }

  private void printErrorTrace(RbTreeNode curnode) {
    RbTreeNode cur = curnode;
    while (cur != null) {
      System.out.printf("%s -> ",cur.getKey());
      cur = cur.parent;
    }
    System.out.println("");
  }
}
