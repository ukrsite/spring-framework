//package javaProfessional;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

  private static Event event;
  Client client;
  EventLoger eventLogger;
  Map<EnevtType, EventLoger> loggers;

  public App(Client client, Map<EnevtType, EventLoger> loggers,
             Event event, EventLoger logger) {
    this.client = client;
    this.eventLogger = logger;
    this.loggers = loggers;
    this.event = event;
  }

  public static void main(String[] args) {

    ConfigurableApplicationContext apx =
            new ClassPathXmlApplicationContext("spring.xml");
    App app = (App) apx.getBean("app");

    app.logEvent(event.getEnevtType(), event.getMsg());
    apx.close();
  }

  private void logEvent(EnevtType type, String msg) {
    EventLoger logger = loggers.get(type);
    if (logger==null) {
      logger = eventLogger;
    }
    logger.eventLoger(event);
  }

}
