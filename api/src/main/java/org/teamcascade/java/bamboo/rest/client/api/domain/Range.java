package org.teamcascade.java.bamboo.rest.client.api.domain;

public class Range {

    private final int start;
    private final int limit;

    public Range(int start, int limit) {
        if (start < 0)
            throw new IllegalArgumentException("start should be greater than 0 not:" + start);
        if (limit < 0)
            throw new IllegalArgumentException("limit should be greater than 0 not:" + start);

        this.start = start;
        this.limit = limit;
    }

    public int getStart() {
        return start;
    }

    public int getLimit() {
        return limit;
    }

    public int getEnd() {
        return start + limit - 1;
    }
}
