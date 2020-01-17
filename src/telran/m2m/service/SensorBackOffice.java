package telran.m2m.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.m2m.dao.SensorsRepository;
import telran.m2m.dto.BloodPressure;
import telran.m2m.entities.Sensor;

@Service
public class SensorBackOffice implements ISensorBackOffice {

	@Autowired
	SensorsRepository repository;

	@Override
	public List<BloodPressure> getBloodPressure(String from, String to, Integer id) {
		return repository.findAllBy()
				.filter(x->x.getId()==id)
				.filter(x -> getLocalDateTime(x.getTime()).isAfter(getLocalDateTime(from)))
				.filter(x ->  getLocalDateTime(x.getTime()).isBefore(getLocalDateTime(to)))
				.map(x -> new BloodPressure(x.getTime(), x.getDataUBP(), x.getDataLBP()))
				.collect(Collectors.toList());
	}
//, "yyyy-MM-dd_HH:mm:ss.SSS"
	private LocalDateTime getLocalDateTime(String time) {
		String newTime = time.replace("_", "T");
		return LocalDateTime.parse(newTime);
	}

	@Override
	public List<Integer> getBloodSugar(String from, String to, Integer id) {
		return repository.findAllBy()
				.filter(x->x.getId()==id)
				.filter(x ->  getLocalDateTime(x.getTime()).isAfter(getLocalDateTime(from)))
				.filter(x ->  getLocalDateTime(x.getTime()).isBefore(getLocalDateTime(to)))
				.map(x -> x.getDataSugar()).collect(Collectors.toList());
	}

	@Override
	public List<Integer> getPulseData(String from, String to, Integer id) {
		return repository.findAllBy()
				.filter(x->x.getId()==id)
				.filter(x ->  getLocalDateTime(x.getTime()).isAfter(getLocalDateTime(from)))
				.filter(x -> getLocalDateTime(x.getTime()).isBefore(getLocalDateTime(to)))
				.map(x -> x.getDataPuls()).collect(Collectors.toList());
	}

	@Override
	public List<Sensor> getAllRecords() {
		return repository.findAll();
	}

}
