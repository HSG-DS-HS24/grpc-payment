package ch.unisg.scs.ds;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {
    private final static Logger LOGGER = Logger.getLogger(PaymentServiceImpl.class.getCanonicalName());

    @Override
    public void processPayment(Payment.PaymentRequest request, StreamObserver<Payment.PaymentResponse> responseObserver) {
        LOGGER.info("Processing payment request:\n" + request.toString());

        String paymentId = "XP61hHw2Rvo";
        Payment.PaymentResponse response =
                Payment.PaymentResponse.newBuilder()
                        .setPaymentId(paymentId).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
