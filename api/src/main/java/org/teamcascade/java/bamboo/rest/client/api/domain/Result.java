package org.teamcascade.java.bamboo.rest.client.api.domain;

public class Result {
    private final String key;
    private final String state;
    private final String buildStartedTime;
    private final String buildCompletedTime;
    private final String buildDurationInSeconds;

    public Result(String key, String state, String buildStartedTime, String buildCompletedTime, String buildDurationInSeconds) {
        this.key = key;
        this.state = state;
        this.buildStartedTime = buildStartedTime;
        this.buildCompletedTime = buildCompletedTime;
        this.buildDurationInSeconds = buildDurationInSeconds;
    }

    public String getKey() {
        return key;
    }

    public String getState() {
        return state;
    }

    public String getBuildStartedTime() {
        return buildStartedTime;
    }

    public String getBuildCompletedTime() {
        return buildCompletedTime;
    }

    public String getBuildDurationInSeconds() {
        return buildDurationInSeconds;
    }

    @Override
    public String toString() {
        return "Result{" +
                "key='" + key + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result = (Result) o;

        if (!key.equals(result.key)) return false;
        return state.equals(result.state);

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }
}
