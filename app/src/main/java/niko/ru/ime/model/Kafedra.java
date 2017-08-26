package niko.ru.ime.model;

public class Kafedra {

  private final String name;
  private final String desc;

  public Kafedra(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }
}
