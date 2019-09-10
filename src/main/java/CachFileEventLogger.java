import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class CachFileEventLogger extends FileEventLoger {

//  принимает на вход конструктора размер кеша
//  пишет ивенты в буфер что-бы не дергать диск
//  проверяет размер коллекции лист
//  записывает буфер на диск
//  спринг конфиг добавить бин кешивен с аргументом для конструктора

  int cachSize;
  List<Event> cach = new ArrayList<Event>();

  public CachFileEventLogger(String fileName, int cachSize) {
    super(fileName);
    this.cachSize = cachSize;
  }

  public CachFileEventLogger(int cachSize) {
    this.cachSize = cachSize;
  }

  @Override
  public void eventLoger(Event event) {
    cach.add(event);

    if (cach.size()==cachSize) {
      for (Event el : cach) {
        super.eventLoger(el);
      }
      cach.clear();
    }
  }

  @PreDestroy
  public void destroy() {
    for (Event el : cach) {
      super.eventLoger(el);
    }
  }
}
