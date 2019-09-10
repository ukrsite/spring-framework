import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;

import static java.util.concurrent.ThreadLocalRandom.current;

@Component
public class Event {
  int id = current().nextInt(1,99);
  String msg="";
  EnevtType enevtType;
  Date date;
  DateFormat df;

  public Event(Date date, DateFormat df) {
    this.date = date;
    this.df = df;
  }

  public EnevtType getEnevtType() {
    return enevtType;
  }

  @Value("INFO")
  public void setEnevtType(EnevtType enevtType) {
    this.enevtType = enevtType;
  }

  @Value("User has already generated event")
  public void setMsg(String msg) {
    this.msg = msg;
  }

  public void setId(int id) {
    this.id = 1;
  }

  public int getId() {
    return id;
  }

  public String getMsg() {
    return msg;
  }

  public Date getDate() {
    return date;
  }

  @Override
  public String toString() {
    return "Event{" +
            "id=" + id +
            ", msg='" + msg + '\'' +
            ", enevtType=" + enevtType +
            ", date=" + date +
            ", df=" + df +
            '}';
  }
}
