package org.teamcascade.java.bamboo.rest.client.api.domain;

/**
 * TODO: Document this class / interface here
 *
 * @since v7.0
 */
public class Result {
    private final String key;
    private final String state;

    public Result(String key, String state) {
        this.key = key;
        this.state = state;
    }

    public String getKey() {
        return key;
    }

    public String getState() {
        return state;
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