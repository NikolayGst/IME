package niko.ru.ime;

import java.util.Arrays;
import java.util.List;
import niko.ru.ime.model.Employee;
import niko.ru.ime.model.Menu;

public class Config {

  public static final String ABOUT_US = "about_us";
  public static final String INFORMATION = "information";
  public static final String EMPLOYEES_FAC = "employees_fac";
  public static final String TEACHERS = "teachers";
  public static final String PHOTO = "photo";
  public static final String ALBUM = "album";
  public static final String THREE_D = "3d";
  public static final String SHARE = "share";

  public static List<Menu> getMenuList() {
    return Arrays.asList(
        new Menu("Про факультет ІМЕ", ABOUT_US),
        new Menu("Кафедри факультету", INFORMATION),
        new Menu("Управління факультетом", EMPLOYEES_FAC),
        new Menu("Співробітники факультету", TEACHERS),
        new Menu("Розташування аудиторій", PHOTO),
        new Menu("Фотоальбом", ALBUM),
        new Menu("3D-подорож", THREE_D),
        new Menu("Поділитися додатком", SHARE)
        );
  }

  public static List<Employee> getEmployeeFacList() {
    return Arrays.asList(
        new Employee("Бєльчев Павло Васильович","http://mdpu.org.ua/new/images/stories/fakulteti/inf/belchev.jpg","Декан факультету",""),
        new Employee("Стрілець Олена Володимирівна","http://mdpu.org.ua/new/images/stories/fakulteti/inf/strilec.jpg","Заступник декана з навчальної роботи",""),
        new Employee("Сюсюкан Юрій Миколайович","http://mdpu.org.ua/new/images/stories/fakulteti/inf/susukan.jpg","Заступник декана з виховної роботи",""),
        new Employee("Глебова Наталя Іванівна","http://cs624522.vk.me/v624522668/aa5b/s_F8sEDQLaI.jpg","Заступник декана з наукової роботи",""),
        new Employee("Николаєнко Юлія Олександрівна","http://mdpu.org.ua/new/images/stories/fakulteti/inf/nikolaenko.jpg","Секретар факультету","")
    );
  }

}
