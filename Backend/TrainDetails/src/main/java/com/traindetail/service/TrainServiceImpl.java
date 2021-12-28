package com.traindetail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traindetail.exception.EmptyInputException;
import com.traindetail.exception.TrainNotfoundException;
import com.traindetail.model.Train;
import com.traindetail.repository.TrainRepository;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository trainRepository;
	

	public Train addTrain (Train train) throws EmptyInputException {
		if(train.getTrainName().isEmpty() || train.getTrainName().length()==0){
			throw new EmptyInputException();
		}
		
		return trainRepository.save(train);
	}

	public List<Train> getTrain() {
		List<Train> train = trainRepository.findAll();
		System.out.println("Getting data from DB:" +train);
		return train;
	}

	public Optional<Train> getTrainbyId(String id) {
		boolean isTrainExist=trainRepository.existsById(id);
		if(isTrainExist)
		{
			return trainRepository.findById(id);
		}
		else {
			
			throw new TrainNotfoundException();
		}
	}
	

	public void deleteTrain(String id) {
		boolean isTrainExist=trainRepository.existsById(id);
		if(isTrainExist)
		{
		trainRepository.deleteById(id);
		}
		else {
			throw new TrainNotfoundException();
		}
	}
	
	public Train updateTrain(String trainid, Train train) {
	   	 boolean isTrainExist=trainRepository.existsById(trainid);
			if(isTrainExist)
			{
				train.setTrainid(trainid);
				trainRepository.save(train);
				return train;
			}
			else 
			{
				throw new TrainNotfoundException();
				
			}
	    }	
}