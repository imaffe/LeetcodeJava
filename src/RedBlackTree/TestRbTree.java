package RedBlackTree;

import java.util.Arrays;
import java.util.Collections;

public class TestRbTree {
  public static int TEST_ARRAY_SIZE = 100;
  public static int TEST_REPETITION = 20;
  public static int fixed_array_size = 20;
  public static int [] fix_array = {4, 17, 8, 13, 10, 19, 3, 14, 2, 9, 6, 11, 1, 5, 16, 7, 18, 12, 20, 15};

  public static void main(String[] args) {
    // 1. test insertion
    oneFixedTest();
    for (int i = 0; i < TEST_REPETITION; i++) {
      oneShuffleTest();
    }

    // 2. test deletion
  }
  public static void oneShuffleTest() {
    Integer[] input = new Integer[TEST_ARRAY_SIZE];
    for (int i = 0; i < TEST_ARRAY_SIZE; i++) {
      input[i] = i + 1;
    }
    Collections.shuffle(Arrays.asList(input));
    System.out.println(Arrays.toString(input));

    RbTree t = RbTree.createNewRbTree();

    for (int i = 0 ; i < TEST_ARRAY_SIZE; i ++) {
      System.out.printf("======= Adding %d th key %d =======%n", i, input[i]);
      t.insert(input[i], input[i]);
      t.validateRbTree();
    }
  }

  public static void oneFixedTest() {
    RbTree t = RbTree.createNewRbTree();

    for (int i = 0 ; i < fixed_array_size; i ++) {
      System.out.printf("======= Adding %d th key %d =======%n", i, fix_array[i]);
      t.insert(fix_array[i], fix_array[i]);
      t.validateRbTree();
    }
  }
}
