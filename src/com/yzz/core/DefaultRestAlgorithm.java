package com.yzz.core;

public class DefaultRestAlgorithm implements RestAlgorithm {

    private final long workDurationMs;
    private final long restDurationMs;

    /**
     * Creates an algorithm with custom durations.
     */
    public DefaultRestAlgorithm(long workDurationMs, long restDurationMs) {
        this.workDurationMs = workDurationMs;
        this.restDurationMs = restDurationMs;
    }

    /**
     * Creates an algorithm with the standard 20-minute work, 20-second rest rule.
     */
    public DefaultRestAlgorithm() {
        this(20 * 60 * 1000L, 20 * 1000L); // 20 minutes work, 20 seconds rest
    }

    @Override
    public long getWorkDurationMs() {
        return workDurationMs;
    }

    @Override
    public long getRestDurationMs() {
        return restDurationMs;
    }
}
