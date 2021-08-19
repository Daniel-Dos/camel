/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.pg.replication.slot;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.spi.EndpointUriFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
public class PgReplicationSlotEndpointUriFactory extends org.apache.camel.support.component.EndpointUriFactorySupport implements EndpointUriFactory {

    private static final String BASE = ":host:port/database/slot:outputPlugin";

    private static final Set<String> PROPERTY_NAMES;
    private static final Set<String> SECRET_PROPERTY_NAMES;
    static {
        Set<String> props = new HashSet<>(30);
        props.add("backoffMultiplier");
        props.add("synchronous");
        props.add("slot");
        props.add("initialDelay");
        props.add("statusInterval");
        props.add("scheduler");
        props.add("database");
        props.add("password");
        props.add("bridgeErrorHandler");
        props.add("useFixedDelay");
        props.add("runLoggingLevel");
        props.add("backoffErrorThreshold");
        props.add("host");
        props.add("greedy");
        props.add("scheduledExecutorService");
        props.add("repeatCount");
        props.add("timeUnit");
        props.add("sendEmptyMessageWhenIdle");
        props.add("schedulerProperties");
        props.add("exchangePattern");
        props.add("autoCreateSlot");
        props.add("slotOptions");
        props.add("backoffIdleThreshold");
        props.add("delay");
        props.add("pollStrategy");
        props.add("port");
        props.add("startScheduler");
        props.add("outputPlugin");
        props.add("user");
        props.add("exceptionHandler");
        PROPERTY_NAMES = Collections.unmodifiableSet(props);
        Set<String> secretProps = new HashSet<>(1);
        secretProps.add("password");
        SECRET_PROPERTY_NAMES = Collections.unmodifiableSet(secretProps);
    }

    @Override
    public boolean isEnabled(String scheme) {
        return "pg-replication-slot".equals(scheme);
    }

    @Override
    public String buildUri(String scheme, Map<String, Object> properties, boolean encode) throws URISyntaxException {
        String syntax = scheme + BASE;
        String uri = syntax;

        Map<String, Object> copy = new HashMap<>(properties);

        uri = buildPathParameter(syntax, uri, "slot", null, true, copy);
        uri = buildPathParameter(syntax, uri, "host", "localhost", false, copy);
        uri = buildPathParameter(syntax, uri, "port", "5432", false, copy);
        uri = buildPathParameter(syntax, uri, "database", null, true, copy);
        uri = buildPathParameter(syntax, uri, "outputPlugin", null, true, copy);
        uri = buildQueryParameters(uri, copy, encode);
        return uri;
    }

    @Override
    public Set<String> propertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public Set<String> secretPropertyNames() {
        return SECRET_PROPERTY_NAMES;
    }

    @Override
    public boolean isLenientProperties() {
        return false;
    }
}
