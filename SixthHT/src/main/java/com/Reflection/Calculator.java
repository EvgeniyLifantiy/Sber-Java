package com.Reflection;

public interface Calculator{
    /**
     * Расчет факториала числа.
     * @param number
     */

    @Metric
    long calc (int number);
}

