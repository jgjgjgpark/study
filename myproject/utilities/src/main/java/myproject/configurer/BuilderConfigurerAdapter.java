package myproject.configurer;

public class BuilderConfigurerAdapter<O, B extends Builder<O>>
        implements BuilderConfigurer<O, B> {
  private B builder;

  public void init(B builder){

  }

  @Override
  public void configure(B builder) throws Exception {

  }
}
