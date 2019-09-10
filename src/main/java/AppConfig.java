import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Configuration
public class AppConfig {

  @Bean
  public Client client() {
    return new Client("1", "1");
  }

  @Bean
  @Scope(scopeName = "prototype")
  public Event event(){
    return new Event(new Date(),
              DateFormat.getDateInstance());
  }

  @Bean
  public ConsolEventLoger consolEventLoger(){
    return new ConsolEventLoger();
  }

  @Bean
  public FileEventLoger fileEventLoger(){
    return new FileEventLoger("fileEventLoger.log");
  }

  @Bean
  @DependsOn("fileEventLoger")
  public CachFileEventLogger cachEventLoger() {
    return new CachFileEventLogger(1);
  }

  List<EventLoger> loggers;

  @Bean
  public CombinedEventLoger combinedEventLoger() {
    return new CombinedEventLoger(loggers);
  }
}
