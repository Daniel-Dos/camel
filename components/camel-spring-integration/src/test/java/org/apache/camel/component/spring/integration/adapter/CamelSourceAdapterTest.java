/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.spring.integration.adapter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.camel.test.spring.junit5.CamelSpringTestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CamelSourceAdapterTest extends CamelSpringTestSupport {

    @Test
    public void testSendingOneWayMessage() throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        DirectChannel channelA = getMandatoryBean(DirectChannel.class, "channelA");
        channelA.subscribe(new MessageHandler() {
            public void handleMessage(Message<?> message) {
                latch.countDown();
                assertEquals("Willem", message.getPayload(), "We should get the message from channelA");
            }
        });

        template.sendBody("direct:OneWay", "Willem");

        assertTrue(latch.await(1, TimeUnit.SECONDS));
    }

    @Test
    public void testSendingTwoWayMessage() throws Exception {
        String result = template.requestBody("direct:TwoWay", "Willem", String.class);

        assertEquals("Hello Willem", result, "Can't get the right response");
    }

    @Override
    protected ClassPathXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("/org/apache/camel/component/spring/integration/adapter/CamelSource.xml");
    }

}
