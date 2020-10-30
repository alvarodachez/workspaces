package com.jacalix.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacalix.model.entity.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Integer>{

}
