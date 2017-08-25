package niko.ru.ime.model;
public class Employee {

  private  String username;
  private  String shortDesc;
  private  String fullDesc;
  private  String urlAvatar;

  public Employee(String username, String urlAvatar, String shortDesc, String fullDesc) {
    this.username = username;
    this.shortDesc = shortDesc;
    this.fullDesc = fullDesc;
    this.urlAvatar = urlAvatar;
  }

  public String getUsername() {
    return username;
  }

  public String getShortDesc() {
    return shortDesc;
  }

  public String getFullDesc() {
    return fullDesc;
  }

  public String getUrlAvatar() {
    return urlAvatar;
  }
}
