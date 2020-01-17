package telran.m2m.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import telran.m2m.dto.ApplicationCodes;
import telran.m2m.dto.BloodPressure;
import telran.m2m.entities.Sensor;
import telran.m2m.service.SensorBackOffice;

@RestController
public class BackOfficeController {
	@Autowired
	SensorBackOffice sensorBackOffice;

	@RequestMapping(value = ApplicationCodes.GET_BLOOD_PRESSURE+"/{id}/{from}/{to}", method = RequestMethod.GET)
	List<BloodPressure> getBloodPressure(@PathVariable(value = "from") String from,
			@PathVariable(value = "to") String to, @PathVariable(value = "id") Integer id) {
		return sensorBackOffice.getBloodPressure(from, to, id);

	}

	@RequestMapping(value = ApplicationCodes.GET_BLOOD_SUGAR+"/{id}/{from}/{to}", method = RequestMethod.GET)
	List<Integer> getBloodSugar(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to,
			@PathVariable(value = "id") Integer id) {
		return sensorBackOffice.getBloodSugar(from, to, id);
	}

	@RequestMapping(value = ApplicationCodes.GET_BLOOD_PULSE+"/{id}/{from}/{to}", method = RequestMethod.GET)
	List<Integer> getPulseData(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to,
			@PathVariable(value = "id") Integer id) {
		return sensorBackOffice.getPulseData(from, to, id);
	}

	@RequestMapping(value = ApplicationCodes.GET_ALL_RECORDS, method = RequestMethod.GET)
	List<Sensor> getAllRecords() {
		return sensorBackOffice.getAllRecords();
	}

}
