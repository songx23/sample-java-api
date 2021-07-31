package info.songxue.java.sample.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class CrazyController {

  private static final int MYTHREADS = 1000;

  @GetMapping("/go-crazy")
  public Crazy calculate(@RequestParam(value = "number") long number, @RequestParam(value = "repeat") long rep) {
    if (number > 20) {
      return new Crazy("This is too hard for me. Try a smaller number.");
    }

    ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
    for (int i = 0; i < rep; i++) {
      Runnable worker = new MyRunnable(number);
      executor.execute(worker);
    }
    executor.shutdown();
    // Wait until all threads are finish
    while (!executor.isTerminated()) {

    }
    return new Crazy("Calculation finished.");
  }
}
