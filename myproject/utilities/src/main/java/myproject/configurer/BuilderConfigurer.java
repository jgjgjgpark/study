package myproject.configurer;

/**
 *
 * @param <O> type of object to build
 * @param <B> type of builder
 */
public interface BuilderConfigurer<O, B extends Builder<O>> {
  void configure(B builder) throws Exception;
}
