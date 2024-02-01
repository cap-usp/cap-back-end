package br.com.usp.mac0472.cartografiapaulistana.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		    .setFieldMatchingEnabled(true)
		    .setFieldAccessLevel(AccessLevel.PRIVATE)
		    .setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
