package niko.ru.ime.model;

public class Menu {

  private final String name;
  private final String url;

  public Menu(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }
}
