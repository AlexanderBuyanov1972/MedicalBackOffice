package telran.m2m.service;

import java.util.List;

import telran.m2m.dto.BloodPressure;
import telran.m2m.entities.Sensor;

public interface ISensorBackOffice {

	List<BloodPressure> getBloodPressure(String from, String to, Integer id);

	List<Integer> getBloodSugar(String from, String to, Integer id);

	List<Integer> getPulseData(String from, String to, Integer id);

	List<Sensor> getAllRecords();

}
