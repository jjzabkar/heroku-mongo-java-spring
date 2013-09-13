package com.jjz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import com.jjz.domain.Foo;
import com.jjz.repository.FooRepository;

/**
 * {@link Service} that contains business logic and allows a {@code Controller} to interact with a DAO {@code Repository}.
 * 
 * @author JJ Zabkar
 */
@Service
public class FooService {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Inject
	FooRepository repo;

	public Foo getFoo(UUID uuid) {

		LOGGER.debug("getFoo({})", uuid);

		Foo foo = repo.findOne(uuid);
		if (foo == null) {
			foo = new Foo();
			foo.setUuid(uuid);
			LOGGER.debug("saving uuid={}", uuid);
			repo.save(foo);
		}
		return foo;
	}

	public List<Foo> getFoos() {
		return repo.findAll();
	}

}
