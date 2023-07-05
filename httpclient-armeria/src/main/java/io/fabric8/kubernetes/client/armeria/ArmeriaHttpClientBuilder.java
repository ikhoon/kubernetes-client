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

import com.linecorp.armeria.client.ClientFactory;
import com.linecorp.armeria.client.ClientFactoryBuilder;
import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.client.WebClientBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.StandardHttpClientBuilder;

class ArmeriaHttpClientBuilder
  extends StandardHttpClientBuilder<ArmeriaHttpClient, ArmeriaHttpClientFactory, ArmeriaHttpClientBuilder> {

  public ArmeriaHttpClientBuilder(ArmeriaHttpClientFactory clientFactory) {
    super(clientFactory);
  }

  @Override
  public ArmeriaHttpClient build() {
    if (client != null) {
      return new ArmeriaHttpClient(this, client.getWebClient());
    }

    WebClientBuilder clientBuilder = WebClient.builder();
    ClientFactoryBuilder factoryBuilder = null;
    if (connectTimeout != null && !connectTimeout.isZero() && !connectTimeout.isNegative()) {
      factoryBuilder = ClientFactory.builder();
      factoryBuilder.connectTimeout(connectTimeout);
    }
    if (followRedirects) {
      clientBuilder.followRedirects();
    }

    return null;
  }

  @Override
  protected ArmeriaHttpClientBuilder newInstance(ArmeriaHttpClientFactory clientFactory) {
    return null;
  }
}
