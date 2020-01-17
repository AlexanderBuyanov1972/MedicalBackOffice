package telran.m2m.dao;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.m2m.entities.Sensor;


public interface SensorsRepository extends MongoRepository<Sensor, String> {

	Stream<Sensor> findAllBy();

}
