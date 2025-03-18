package myAnnotation;

public class ServerConfig {
    @ValidPort
    private int port;

    public ServerConfig(int port) {
        this.port = port;
    }

}
