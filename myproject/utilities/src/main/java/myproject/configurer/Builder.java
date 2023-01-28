package myproject.configurer;

/**
 *
 * @param <O> type of Object
 */
public interface Builder<O> {
  O build() throws Exception;
}
