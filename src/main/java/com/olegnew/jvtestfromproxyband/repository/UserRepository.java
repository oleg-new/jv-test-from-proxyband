package com.olegnew.jvtestfromproxyband.repository;

import com.olegnew.jvtestfromproxyband.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
