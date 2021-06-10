package org.apache.flink.runtime.rest.messages.pierre;

import org.apache.flink.runtime.rest.HttpMethodWrapper;
import org.apache.flink.runtime.rest.messages.EmptyMessageParameters;
import org.apache.flink.runtime.rest.messages.EmptyRequestBody;
import org.apache.flink.runtime.rest.messages.MessageHeaders;

import org.apache.flink.shaded.netty4.io.netty.handler.codec.http.HttpResponseStatus;

public class FooHeaders
        implements MessageHeaders<EmptyRequestBody, BarResponseBody, EmptyMessageParameters> {

    // 单实例模式
    private static final FooHeaders INSTANCE = new FooHeaders();

    public static FooHeaders getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<BarResponseBody> getResponseClass() {
        return BarResponseBody.class;
    }

    @Override
    public HttpResponseStatus getResponseStatusCode() {
        return HttpResponseStatus.OK;
    }

    @Override
    public String getDescription() {
        return "pierre foobar service";
    }

    @Override
    public Class<EmptyRequestBody> getRequestClass() {
        return EmptyRequestBody.class;
    }

    // 解析url里面的参数
    @Override
    public EmptyMessageParameters getUnresolvedMessageParameters() {
        return EmptyMessageParameters.getInstance();
    }

    @Override
    public HttpMethodWrapper getHttpMethod() {
        return HttpMethodWrapper.GET;
    }

    @Override
    public String getTargetRestEndpointURL() {
        return "/pierre/foo";
    }
}
