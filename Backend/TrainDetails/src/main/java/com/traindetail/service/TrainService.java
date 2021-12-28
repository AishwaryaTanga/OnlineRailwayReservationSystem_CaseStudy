package com.traindetail.service;

import java.util.List;
import java.util.Optional;

import com.traindetail.exception.EmptyInputException;
import com.traindetail.model.Train;

public interface TrainService {

	public abstract Train addTrain(Train train) throws EmptyInputException;

	public abstract List<Train> getTrain();

	public abstract Optional<Train> getTrainbyId(String id);

	public abstract Train updateTrain(String trainid, Train train);

	public abstract void deleteTrain(String id);

}
