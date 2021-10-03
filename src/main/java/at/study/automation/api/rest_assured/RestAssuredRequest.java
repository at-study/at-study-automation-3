package at.study.automation.api.rest_assured;

import java.util.HashMap;
import java.util.Map;

import at.study.automation.api.client.RestMethod;
import at.study.automation.api.client.RestRequest;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RestAssuredRequest implements RestRequest {

    @NonNull
    private RestMethod method;
    @NonNull
    private String uri;

    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> queryParameters = new HashMap<>();
    private String body;

    public RestAssuredRequest(@NonNull RestMethod method, @NonNull String uri, Map<String, String> headers, Map<String, String> queryParameters, String body) {
        this.method = method;
        this.uri = uri;
        if (headers != null) {
            this.headers = headers;
        }
        if (queryParameters != null) {
            this.queryParameters = queryParameters;
        }
        this.body = body;
    }

}
