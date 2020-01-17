package telran.m2m.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Document(collection = "sensors")
public class Sensor {
	@Id
	public String time;
	public int id;
	public int dataUBP;
	public int dataLBP;
	public int dataPuls;
	public int dataSugar;

}
