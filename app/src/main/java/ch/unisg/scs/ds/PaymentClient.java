package ch.unisg.scs.ds;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PaymentClient {
  private final static Logger LOGGER = Logger.getLogger(PaymentClient.class.getCanonicalName());

  public static void main(String[] args) {
    final ManagedChannel channel = ManagedChannelBuilder
      .forAddress("localhost", 50051)
      .usePlaintext()
      .build();

    PaymentServiceGrpc.PaymentServiceBlockingStub paymentServiceStub =
      PaymentServiceGrpc.newBlockingStub(channel);

    Payment.PaymentRequest request = Payment.PaymentRequest.newBuilder()
      .setCardNumber("1234567887654321")
      .setCardExpiryDate("10/2025")
      .setCardCvc("123")
      .setPaymentAmount(29.99)
      .setPaymentCurrency("CHF")
      .build();

    Payment.PaymentResponse response = paymentServiceStub.processPayment(request);
    LOGGER.info("Payment successful! Payment ID: " + response.getPaymentId());

    channel.shutdown();
  }
}
