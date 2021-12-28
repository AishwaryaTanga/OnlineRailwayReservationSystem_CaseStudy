package com.traindetail.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.traindetail.model.Train;
import com.traindetail.repository.TrainRepository;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/trains/search")
public class UserController {
	
		
		@Autowired
		private TrainRepository trainRepository;
        
		//get Alltrains
	    @GetMapping("/findAllTrains")
	    public List<Train> getTrains(){
		return trainRepository.findAll();
		
	}
	    
	    //get Alltrains by id
	    @GetMapping("/findAllTrains/{trainid}")
	    public Optional<Train> getTrains(@PathVariable String trainid){
		return trainRepository.findById(trainid);
	}
		
	}



