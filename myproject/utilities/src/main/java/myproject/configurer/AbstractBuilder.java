package myproject.configurer;

public abstract class AbstractBuilder<O> implements Builder<O> {
  private O object;

  @Override
  public O build() throws Exception {
    return doBuild();
  }

  protected abstract O doBuild();
}
