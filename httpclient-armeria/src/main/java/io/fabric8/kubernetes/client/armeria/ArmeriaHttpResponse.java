/*
 *  Copyright (C) 2015 Red Hat, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.fabric8.kubernetes.client.armeria;

import com.linecorp.armeria.common.ResponseHeaders;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.netty.util.AsciiString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

final class ArmeriaHttpResponse implements HttpResponse<AsyncBody> {

  private final ResponseHeaders responseHeaders;
  private final AsyncBody body;

  ArmeriaHttpResponse(ResponseHeaders responseHeaders, AsyncBody body) {
    this.responseHeaders = responseHeaders;
    this.body = body;
  }

  @Override
  public int code() {
    return responseHeaders.status().code();
  }

  @Override
  public String message() {
    return responseHeaders.status().reasonPhrase();
  }

  @Override
  public AsyncBody body() {
    return body;
  }

  @Override
  public HttpRequest request() {
    return null;
  }

  @Override
  public Optional<HttpResponse<?>> previousResponse() {
    return Optional.empty();
  }

  @Override
  public List<String> headers(String key) {
    return responseHeaders.getAll(key);
  }

  @Override
  public Map<String, List<String>> headers() {
    Map<String, List<String>> headers = new HashMap<>();
    for (AsciiString name : responseHeaders.names()) {
      headers.put(name.toString(), responseHeaders.getAll(name));
    }
    return headers;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ArmeriaHttpResponse{");
    sb.append("responseHeaders=").append(responseHeaders);
    sb.append(", body=").append(body);
    sb.append('}');
    return sb.toString();
  }
}
