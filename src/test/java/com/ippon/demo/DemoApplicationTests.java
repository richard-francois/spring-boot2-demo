package com.ippon.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.unit.DataSize;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
	}

	// sb2 new feature : more fiability
	@Test
	public void listShouldContainPropertiesFromProperties() {
		DemoProperties properties = this.context.getBean(DemoProperties.class);
		List<String> fruits = properties.getFruits();
		assertThat(fruits).containsExactly("melon"); // fails with sb 1.5.x
	}

	// sb2 new feature : more fiability
	@Test
	public void listMappedToSet() {
		DemoProperties properties = this.context.getBean(DemoProperties.class);
		Set<String> tools = properties.getTools();
		assertThat(tools).containsExactly("hammer", "screwdriver"); // fails with sb 1.5.x
	}

	// sb2 new feature : uniform name
	@Test
	public void underscoreNoMoreSupported() {
		DemoProperties properties = this.context.getBean(DemoProperties.class);
		Set<String> env = properties.getEnv();
		assertThat(env).isNull(); // must respect uniform name
	}

	// sb2 new feature : duration convertion
	@Test
	public void durationConvertion() {
		DemoProperties properties = this.context.getBean(DemoProperties.class);
		long timingOne = properties.getDurationOne();
		Duration timingTwo = properties.getDurationTwo();
		assertThat(timingOne).isEqualTo(1500);
		assertThat(timingTwo).isEqualTo(Duration.ofMinutes(2));
	}

	// sb2 new feature : size convertion
	@Test
	public void sizeConvertion() {
		DemoProperties properties = this.context.getBean(DemoProperties.class);
		DataSize size = properties.getDiskSize();
		assertThat(size).isEqualTo(DataSize.ofGigabytes(256));
	}
}
