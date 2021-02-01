package com.ippon.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.unit.DataSize;

import java.time.Duration;
import java.util.*;

@ConfigurationProperties(prefix="demo")
public class DemoProperties {

    private List<String> fruits = Arrays.asList("Apple", "Orange");

    private Set<String> tools;

    private final Map<String, String> map = new HashMap<>();

    private Set<String> env;

    private long durationOne;

    private Duration durationTwo;

    private DataSize diskSize;

    //getters & setters

    public List<String> getFruits() {
        return fruits;
    }

    public void setFruits(List<String> fruits) {
        this.fruits = fruits;
    }

    public Set<String> getTools() {
        return tools;
    }

    public void setTools(Set<String> tools) {
        this.tools = tools;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Set<String> getEnv() {
        return env;
    }

    public void setEnv(Set<String> env) {
        this.env = env;
    }

    public long getDurationOne() {
        return durationOne;
    }

    public void setDurationOne(long durationOne) {
        this.durationOne = durationOne;
    }

    public Duration getDurationTwo() {
        return durationTwo;
    }

    public void setDurationTwo(Duration durationTwo) {
        this.durationTwo = durationTwo;
    }

    public DataSize getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(DataSize diskSize) {
        this.diskSize = diskSize;
    }
}
