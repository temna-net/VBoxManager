package com.kedzie.vbox.api.jaxb;

import java.io.Serializable;

public enum NATAliasMode implements Serializable{
    ALIAS_LOG("AliasLog"),
    ALIAS_PROXY_ONLY("AliasProxyOnly"),
    ALIAS_USE_SAME_PORTS("AliasUseSamePorts");
    private final String value;
    public String toString() {
        return value;
    }
    NATAliasMode(String v) {
        value = v;
    }
    public String value() {
        return value;
    }
    public static NATAliasMode fromValue(String v) {
        for (NATAliasMode c: NATAliasMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
