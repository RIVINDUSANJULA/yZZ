package com.yzz.core;

public interface RestAlgorithm {
    /**
     * Gets the duration of the work period in milliseconds.
     * 
     * @return Work duration in milliseconds.
     */
    long getWorkDurationMs();

    /**
     * Gets the duration of the rest period in milliseconds.
     * 
     * @return Rest duration in milliseconds.
     */
    long getRestDurationMs();
}
