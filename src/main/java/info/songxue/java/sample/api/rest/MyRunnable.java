package info.songxue.java.sample.api.rest;

public class MyRunnable implements Runnable {

  static long factorial(long n) {
    if (n == 0) {
      return 1;
    } else {
      return (n * factorial(n - 1));
    }
  }

  private final long num;

  MyRunnable(long num) {
    this.num = num;
  }

  @Override
  public void run() {
    factorial(num);
  }
}
