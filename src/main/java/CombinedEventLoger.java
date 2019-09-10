import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CombinedEventLoger implements EventLoger{

  List<EventLoger> loggers;

  public CombinedEventLoger(List<EventLoger> loggers) {
    this.loggers = loggers;
  }

  @Override
  public void eventLoger(Event event) {
    // обрабатывает коллекцию переданных ему логеров
    for (EventLoger logger : loggers) {
      logger.eventLoger(event);
    }
  }
}
