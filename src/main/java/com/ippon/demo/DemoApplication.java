package com.ippon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.Counter;

import com.ippon.demo.actuators.ExampleEndpoint;
import com.ippon.demo.registry.SampleRegistries;

import java.util.Timer;
import java.util.TimerTask;

@EnableConfigurationProperties(DemoProperties.class)
@SpringBootApplication
public class DemoApplication {

	// only one at time, comment unwanted
	@Bean
	public ExampleEndpoint exampleEndpoint() { return new ExampleEndpoint();}

	/*
	@Bean
	public ExampleEndpointWebExtension exampleEndpointWebExtension(ExampleEndpoint endpoint) {
		return new ExampleEndpointWebExtension(endpoint);
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// micrometer
		CompositeMeterRegistry registry = new CompositeMeterRegistry();
		registry.add(SampleRegistries.atlas()); // add other monitoring system

		Counter ping = registry.counter("my.counter", "type", "ping");

		Timer timer = new Timer();
		TimerTask task = new MyTask(ping);
		timer.schedule(task, 1000, 10);
	}

	static class MyTask extends TimerTask {

		double abscisse = 0;
		Counter counter;

		public MyTask(Counter counter) {
			this.counter = counter;
		}

		public void run() {
			abscisse+=0.01d;
			counter.increment(1000*Math.cos(abscisse));
		}
	}

}
