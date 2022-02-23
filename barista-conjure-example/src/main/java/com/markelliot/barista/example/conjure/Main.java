package com.markelliot.barista.example.conjure;

import com.markelliot.barista.Server;
import com.palantir.conjure.java.undertow.lib.UndertowRuntime;
import com.palantir.conjure.java.undertow.runtime.ConjureUndertowRuntime;
import test.api.SampleResponse;
import test.api.SampleService;
import test.api.SampleServiceEndpoints;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("Unexpected command line arguments.");
            return;
        }

        UndertowRuntime conjureRuntime = ConjureUndertowRuntime.builder().build();
        Server.builder()
                .disableTls() // our host provides this for us
                .allowOrigin("http://localhost:8080") // for development
                .allowOrigin("http://localhost:8443") // for development
                .tracingRate(1.0)
                .endpoints(
                        ConjureAdapter.adapt(
                                SampleServiceEndpoints.of(new DefaultSampleService()),
                                conjureRuntime))
                .start();
    }

    private static final class DefaultSampleService implements SampleService {
        @Override
        public SampleResponse sample() {
            return SampleResponse.builder().str("sample").build();
        }
    }
}
