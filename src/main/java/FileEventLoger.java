import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class FileEventLoger implements EventLoger {
  String fileName = null;
  File file = null;

  public FileEventLoger(String fileName) {
    this.fileName = fileName;
  }

  public FileEventLoger() {

  }

  @Override
  public void eventLoger(Event event) {
//    add bean to spring.xml
//    create class fileloger
//    add dependonci to pom.xml
//    add metod init for check file

    try {
      FileUtils.writeStringToFile(file, event.toString(), true );
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @PostConstruct
  private void init() throws IOException {

    this.file = new File(fileName);
    System.out.println("canWrite : " + file.canWrite());

  }
}
