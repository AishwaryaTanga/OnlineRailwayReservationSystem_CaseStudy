package com.traindetail.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traindetail.exception.EmptyInputException;
import com.traindetail.exception.TrainNotfoundException;
import com.traindetail.model.Train;
import com.traindetail.repository.TrainRepository;
import com.traindetail.service.TrainService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/trains")
public class TrainController {
	
    @Autowired
	private TrainRepository trainRepository;
	
	@Autowired
	private TrainService trainService;
	
	//add train
	@PostMapping("/addTrain")
	public String addTrain(@RequestBody Train train) throws EmptyInputException{
		trainService.addTrain(train);
        return "Added tarin with ID:" + train.getTrainid();
	}
	
	//getAlltrain
	@GetMapping("/findAllTrain")
	public List<Train> getTrain(){
		return trainService.getTrain();
	}
	
	//getAlltrain by id
	@GetMapping("/findAllTrain/{id}")
	public Optional<Train> getTrainbyId(@PathVariable String id){
			return trainService.getTrainbyId(id);
		
		
	}
	
	//update train by id
	@PutMapping("/update/{trainid}")
	public Train updateTrain(@PathVariable("trainid") String trainid,@RequestBody Train train ) {
		return trainService.updateTrain(trainid, train);
	
		
	}
	
	//delete train by id
	 @DeleteMapping("/delete/{trainid}")
	 public String deleteTrain (@PathVariable String trainid) {
		 trainService.deleteTrain(trainid);
			 return "Train deleted with id : "+trainid;
		 
	}
}