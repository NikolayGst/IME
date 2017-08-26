package niko.ru.ime.model;

public class Photo {

  private final String desc;
  private final String url;

  public Photo(String desc, String url) {
    this.desc = desc;
    this.url = url;
  }

  public String getDesc() {
    return desc;
  }

  public String getUrl() {
    return url;
  }
}
