package com.example.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

	Optional<User> findByEmailAndHash(String email, byte[] hash);

	boolean existsByEmail(String email);

}
