package ch.unisg.scs.ds;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class PaymentServer {
  private static final int PORT = 50051;
  private final static Logger LOGGER = Logger.getLogger(PaymentServer.class.getCanonicalName());

  public static void main(String[] args) throws InterruptedException, IOException {
    // Create a new server to listen on port 8080
    Server server = ServerBuilder.forPort(PORT)
      .addService(new PaymentServiceImpl())
      .build();

    // Start the server
    server.start();

    // Server threads are running in the background.
    LOGGER.info("Server started");
    // Don't exit the main thread. Wait until server is terminated.
    server.awaitTermination();
  }
}
