package com.traindetail;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.traindetail.exception.EmptyInputException;
import com.traindetail.model.Train;
import com.traindetail.repository.TrainRepository;
import com.traindetail.service.TrainService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TrainDetailsApplicationTests {

	
   @Autowired
   private TrainService trainService;
   
   @MockBean
   private TrainRepository trainRepository;
   
	@Test
	public void getTrainTest() {
		when(trainRepository.findAll()).thenReturn(Stream.of
				(new Train("111","Banglore local","Banglore","Mysur","10am"), new Train("112","Bijapur Express","Bijapur","Banglore","8am")).collect(Collectors.toList()));
		assertEquals(2,trainService.getTrain().size());
	}
	@Test
	public void addTrainTest() throws EmptyInputException {
		Train train =new Train("125","Mysur local","Mysur","Banglore","5am");
		when(trainRepository.save(train)).thenReturn(train);
	    assertEquals(train,trainService.addTrain(train));
		
		}

}

