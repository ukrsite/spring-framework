import org.springframework.stereotype.Component;

@Component
public class ConsolEventLoger implements EventLoger {

  public void eventLoger(Event event) {
    System.out.println(event.toString());
  }

}