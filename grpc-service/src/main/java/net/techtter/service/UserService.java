package net.techtter.service;

import io.grpc.stub.StreamObserver;
import net.techtter.grpc.User;
import net.techtter.grpc.userGrpc;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {

        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        if(username.equals(password)){
            //success message
            response.setResponseCode(1).setResponseMessage("Success");

        } else  {
            //failure message
            response.setResponseCode(0).setResponseMessage("Invalid username or password");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }
}
