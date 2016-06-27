package org.teamcascade.java.bamboo.rest.client.api.domain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * TODO: Document this class / interface here
 *
 * @since v7.0
 */
public class Results {
    private final int size;
    private final int startIndex;
    private final int maxResult;
    private final List<Result> resultArray;

    public Results(int size, int startIndex, int maxResult) {
        this(size, startIndex, maxResult, Lists.<Result>newArrayList());
    }

    public Results(int size, int startIndex, int maxResult, List<Result> resultArray) {
        this.size = size;
        this.startIndex = startIndex;
        this.maxResult = maxResult;
        this.resultArray = resultArray;
    }

    public int getSize() {
        return size;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public List<Result> getResults() {
        return resultArray;
    }

    @Override
    public String toString() {
        return "Results{" +
                "size=" + size +
                ", startIndex=" + startIndex +
                ", maxResult=" + maxResult +
                ", resultArray=" + resultArray +
                '}';
    }
}
