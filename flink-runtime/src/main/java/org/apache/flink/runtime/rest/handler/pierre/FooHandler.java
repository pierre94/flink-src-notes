package org.apache.flink.runtime.rest.handler.pierre;

import org.apache.flink.api.common.time.Time;
import org.apache.flink.runtime.rest.handler.AbstractRestHandler;
import org.apache.flink.runtime.rest.handler.HandlerRequest;
import org.apache.flink.runtime.rest.handler.RestHandlerException;
import org.apache.flink.runtime.rest.messages.EmptyMessageParameters;
import org.apache.flink.runtime.rest.messages.EmptyRequestBody;
import org.apache.flink.runtime.rest.messages.MessageHeaders;
import org.apache.flink.runtime.rest.messages.pierre.BarResponseBody;
import org.apache.flink.runtime.webmonitor.RestfulGateway;
import org.apache.flink.runtime.webmonitor.retriever.GatewayRetriever;

import javax.annotation.Nonnull;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class FooHandler
        extends AbstractRestHandler<
                RestfulGateway, EmptyRequestBody, BarResponseBody, EmptyMessageParameters> {

    public FooHandler(
            GatewayRetriever<? extends RestfulGateway> leaderRetriever,
            Time timeout,
            Map<String, String> responseHeaders,
            MessageHeaders<EmptyRequestBody, BarResponseBody, EmptyMessageParameters>
                    messageHeaders) {
        super(leaderRetriever, timeout, responseHeaders, messageHeaders);
    }

    @Override
    protected CompletableFuture<BarResponseBody> handleRequest(
            @Nonnull HandlerRequest<EmptyRequestBody, EmptyMessageParameters> request,
            @Nonnull RestfulGateway gateway)
            throws RestHandlerException {
        return CompletableFuture.completedFuture(BarResponseBody.getInstance());
    }
}
