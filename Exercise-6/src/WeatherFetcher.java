import java.util.concurrent.Callable;

public class WeatherFetcher implements Callable<String> {

    private final String source;
    private final int delay;

    public WeatherFetcher(String source, int delay) {
        this.source = source;
        this.delay = delay;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(delay * 1000L);
        return "Weather data from " + source + " received after " + delay + " seconds.";
    }
}
