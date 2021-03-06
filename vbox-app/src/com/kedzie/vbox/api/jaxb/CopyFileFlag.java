package com.kedzie.vbox.api.jaxb;

public enum CopyFileFlag implements java.io.Serializable{
    NONE("None"),
    RECURSIVE("Recursive"),
    UPDATE("Update"),
    FOLLOW_LINKS("FollowLinks");
    private final String value;
    public String toString() {
        return value;
    }
    CopyFileFlag(String v) {
        value = v;
    }
    public String value() {
        return value;
    }
    public static CopyFileFlag fromValue(String v) {
        for (CopyFileFlag c: CopyFileFlag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
