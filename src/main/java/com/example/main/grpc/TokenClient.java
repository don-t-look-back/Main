package com.example.main.grpc;
import com.example.main.grpc.request.TokenRequest;
import com.example.main.grpc.response.TokenResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class TokenClient {
//    private final TokenServiceGrpc.TokenServiceBlockingStub blockingStub;
//
//    public TokenClient(ManagedChannel channel) {
//        blockingStub = TokenServiceGrpc.newBlockingStub(channel);
//    }
//
//    public String verifyToken(String token) {
//        TokenRequest request = TokenRequest.builder().token(token).build();
//        TokenResponse response;
//        try {
//            response = blockingStub.verifyToken(request);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//        return response.getIsValid() ? response.getUserId() : null;
//    }

//    public static void main(String[] args) {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
//                .usePlaintext()
//                .build();
//        TokenClient client = new TokenClient(channel);
//        String userId = client.verifyToken("exampleToken");
//        System.out.println("User ID: " + userId);
//        channel.shutdown();
//    }
}
