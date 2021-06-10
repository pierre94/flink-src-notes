package org.apache.flink.runtime.rest.messages.pierre;

import org.apache.flink.runtime.rest.messages.ResponseBody;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

public class BarResponseBody implements ResponseBody {
    private static final String FIELD_BAR = "response";

    @JsonProperty(FIELD_BAR)
    public final String response = "bar";

    private static final BarResponseBody INSTANCE = new BarResponseBody();

    public static BarResponseBody getInstance() {
        return INSTANCE;
    }
}
