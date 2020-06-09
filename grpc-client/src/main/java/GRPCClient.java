import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.techtter.grpc.User;
import net.techtter.grpc.userGrpc;

import static net.techtter.grpc.userGrpc.newBlockingStub;

public class GRPCClient {

 public static void main(String[] args){

     ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();

     //stub from proto file

     userGrpc.userBlockingStub stub =  userGrpc.newBlockingStub(channel);

     User.LoginRequest request = User.LoginRequest.newBuilder().setUsername("Hello").setPassword("Helrrlo").build();

     User.APIResponse response = stub.login(request);

     System.out.println("Response : "+ response.getResponseMessage());

 }

}
