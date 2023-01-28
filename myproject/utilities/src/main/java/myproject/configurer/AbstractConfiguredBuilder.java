package myproject.configurer;

import java.util.LinkedHashMap;
import java.util.List;

public class AbstractConfiguredBuilder<O> extends AbstractBuilder<O> {
  private LinkedHashMap<Class<? extends BuilderConfigurer>, List<BuilderConfigurer>> configurers
          = new LinkedHashMap<>();

  @Override
  protected O doBuild() {
    init();
    configure();
    return performBuild();
  }

  private O performBuild() {
    return null;
  }

  private void configure() {

  }

  private void init() {

  }
}
