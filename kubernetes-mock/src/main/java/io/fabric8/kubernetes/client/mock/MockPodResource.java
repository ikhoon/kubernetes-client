/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.dsl.ContainerResource;
import io.fabric8.kubernetes.client.dsl.Containerable;
import io.fabric8.kubernetes.client.dsl.LoggableResource;
import org.easymock.IExpectationSetters;

import java.io.InputStream;
import java.io.OutputStream;

public interface MockPodResource<T, D, B>
        extends LoggableResource<T, IExpectationSetters<T>, D, IExpectationSetters<B>, IExpectationSetters<String>>,
        Containerable<String, ContainerResource<String, InputStream, OutputStream, OutputStream, String, IExpectationSetters<Watch>>>,
        ContainerResource<IExpectationSetters<String>, InputStream, OutputStream, OutputStream, String, IExpectationSetters<Watch>> {
}
