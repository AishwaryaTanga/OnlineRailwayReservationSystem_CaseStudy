package com.traindetail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.traindetail.model.Train;

public interface TrainRepository extends MongoRepository<Train, String> {

}
