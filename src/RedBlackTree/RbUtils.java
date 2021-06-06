package RedBlackTree;

public class RbUtils {
  public enum RB_COLOR {
    RED,
    BLACK;
  }

  public enum STATUS {
    INSERT_SUCCESS,
    INSERT_FAILE_KEY_ALREADY_EXIST,
    DELETE_SUCCESS,
    DELETE_FAILED_NON_EXIST_KEY;
  }
}
