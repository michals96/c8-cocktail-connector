import io.camunda.connector.CocktailConnector;
import io.camunda.connector.api.secret.SecretProvider;
import io.camunda.connector.runtime.util.outbound.ConnectorJobHandler;
import io.camunda.zeebe.client.ZeebeClient;

public class ZeebeProvider {
    private static final ConfigProvider CONFIG = new ConfigProvider("zeebe.web.app.properties");

    public ZeebeClient buildClient() {
        return ZeebeClient.newCloudClientBuilder()
                .withClusterId(CONFIG.clusterId())
                .withClientId(CONFIG.clientId())
                .withClientSecret(CONFIG.clientSecret())
                .build();
    }

    public void runWorker(ZeebeClient client) {
        client.newWorker()
                .jobType(CONFIG.jobType())
                .handler(new ConnectorJobHandler(new CocktailConnector(), new SecretProvider() {
                    @Override
                    public String getSecret(String s) {
                        return "";
                    }
                }))
                .name(CONFIG.workerName())
                .open();
    }
}
