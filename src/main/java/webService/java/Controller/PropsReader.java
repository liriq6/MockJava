package webService.java.Controller;

import org.springframework.beans.factory.annotation.Value;

public class PropsReader {
    private long latency;
    private long latencyLong;

    public PropsReader(@Value("${stub_latency}") long latency,@Value("${stub_latencyLong}") long latencyLong){
        this.latency = latency;
        this.latencyLong = latencyLong;
    }

    public long getLatency() {
        return latency;
    }

    public long getLatncyInt() {
        return latencyLong;
    }
}