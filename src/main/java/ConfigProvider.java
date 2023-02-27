import java.io.IOException;
import java.util.Properties;

class ConfigProvider {
    private final Properties appProps = new Properties();

    ConfigProvider(String filename) {
        try {
            appProps.load(ConfigProvider.class.getResourceAsStream("/" + filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String clusterId() {
        return appProps.getProperty("zeebe.client.cloud.clusterId");
    }

    String clientId() {
        return appProps.getProperty("zeebe.client.cloud.clientId");
    }

    String clientSecret() {
        return appProps.getProperty("zeebe.client.cloud.clientSecret");
    }

    String jobType() {
        return appProps.getProperty("job.type");
    }

    String workerName() {
        return appProps.getProperty("worker.name");
    }
}

