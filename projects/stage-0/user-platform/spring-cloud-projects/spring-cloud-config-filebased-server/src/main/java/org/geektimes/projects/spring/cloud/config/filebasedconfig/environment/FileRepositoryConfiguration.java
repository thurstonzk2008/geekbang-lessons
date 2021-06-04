package org.geektimes.projects.spring.cloud.config.filebasedconfig.environment;

import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;


@Configuration
public class FileRepositoryConfiguration {

	@Bean
	public EnvironmentRepository fileEnvironmentRepository(
			ConfigurableEnvironment configurableEnvironment,
			FileEnvironmentRepositoryProperties fileEnvironmentRepositoryProperties) {
		return new FileEnvironmentRepository(configurableEnvironment,
				fileEnvironmentRepositoryProperties);
	}

}
