package org.acme.factor.grpc;

import javax.inject.Inject;

import io.quarkus.grpc.runtime.annotations.GrpcService;

public class GrpcDemo {
    @Inject
    @GrpcService(value = "x")
    public SomeService someService;

    @Inject
    @GrpcService(value = "someService2")
    public SomeService someService2;

    @Inject
    @GrpcService("someService3")
    public SomeService someService3, someService4;
}

class SomeService {
}