package com.common.notification_service.grpc;

import com.common.grpc.NotificationServiceGrpc;
import com.common.grpc.NotifyRequest;
import com.common.grpc.NotifyResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService                                          // (1)
public class NotificationGrpcServer extends NotificationServiceGrpc.NotificationServiceImplBase { // (2)

    @Override
    public void notify(NotifyRequest request, StreamObserver<NotifyResponse> responseObserver) { // (3)
        System.out.println("Sending notification to user " + request.getUserId()
                + " for order " + request.getOrderId());

        NotifyResponse response = NotifyResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Notification sent")
                .build();

        responseObserver.onNext(response);            // (4) send the response
        responseObserver.onCompleted();                // (5) signal "no more messages"
    }
}
