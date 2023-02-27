import io.camunda.zeebe.client.ZeebeClient;

import java.io.IOException;

public class ZeebeWorkerApp {
    private static final ZeebeProvider zeebeProvider = new ZeebeProvider();

    public static void main(String[] args) throws IOException {
        ZeebeClient client = zeebeProvider.buildClient();
        zeebeProvider.runWorker(client);
        System.in.read();
    }
}
