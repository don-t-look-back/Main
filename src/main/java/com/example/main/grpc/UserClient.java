package com.example.main.grpc;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class UserClient {
    public static void main(String[] args) {
        String serviceConfigJson = "";
        try {
            serviceConfigJson = new String(Files.readAllBytes(Paths.get(UserClient.class.getClassLoader().getResource("service_config.json").toURI())));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 9090)
//                .usePlaintext()
//                .defaultServiceConfig(JsonParser.parseString(serviceConfigJson).getAsJsonObject())
//                // .defaultServiceConfig((JsonObject) JsonParser.parseString(serviceConfigJson))
//                .enableRetry()
//                .build();

        try {
            JsonElement element = JsonParser.parseString(serviceConfigJson);
            JsonObject jsonObject = element.getAsJsonObject();
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> serviceConfig = gson.fromJson(jsonObject, type);

            ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 9090)
                    .usePlaintext()
                    .defaultServiceConfig(serviceConfig)
                    .enableRetry()
                    .build();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            // JSON 구문 분석 오류 처리
        }


        // ExampleServiceGrpc.ExampleServiceBlockingStub stub = ExampleServiceGrpc.newBlockingStub(channel);

        // gRPC 단일 응답 요청
//        UnaryRequest request = UnaryRequest.newBuilder().setMessage("Retry Example").build();
//        try {
//            UnaryResponse response = stub.unaryCall(request);
//            System.out.println(response.getMessage());
//        } catch (Exception e) {
//            System.err.println("RPC failed: " + e.getMessage());
//        } finally {
//            channel.shutdown();
//        }
    }
}
