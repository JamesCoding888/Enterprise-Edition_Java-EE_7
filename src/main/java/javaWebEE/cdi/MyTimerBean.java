package javaWebEE.cdi;


import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/TimerService")
@Singleton
public class MyTimerBean {

  @Resource
  private TimerService timerService;

  @Schedule(second="0", minute="0", hour="*/1", persistent=false)
  public void scheduleTimer() {
    // Schedule a timer to execute after 10 seconds
    // Duration duration = Duration.ofSeconds(10);
    long duration = javax.management.timer.Timer.ONE_SECOND;
    TimerConfig config = new TimerConfig();
    config.setInfo("SingleActionTimer");
    timerService.createSingleActionTimer(duration, config);
  }

  @Timeout
  public void execute(Timer timer) {
    System.out.println("Timer executed at: " + new Date());
    System.out.println("Timer info: " + timer.getInfo());
  }
}
