/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package myproject.utilities;

import myproject.list.LinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringUtils {
  public static String join(LinkedList source) {
    return JoinUtils.join(source);
  }

  public static LinkedList split(String source) {
    return SplitUtils.split(source);
  }

  /**
   * @param objects
   * @return a list of string
   * @throws ClassCastException if object is not all string
   */
  public static List<String> convert(List<Object> objects) {
    List<String> strings = new ArrayList<>();
    try {
      for (Object object : objects) {
        String string = (String) object;
        strings.add(string);
      }
    } catch (ClassCastException e) {
      throw e;
    }
    return strings;
  }

  public static <T> T[] collectionToArray(Collection<T> collection) {
    Object[] result = new Object[collection.size()];
//    for (int i = 0; i < collection.size(); i++)
//      collection.


    return null;
  }
}
