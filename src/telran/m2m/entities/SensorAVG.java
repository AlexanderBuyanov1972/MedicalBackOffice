package telran.m2m.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Document(collection = "sensors_avg")
public class SensorAVG {
	public int id;
	@Id
	@JsonFormat(pattern = "yyyy-MM-dd_HH:mm:ss.SSS")
	public LocalDateTime time;
	public int dataUBP;
	public int dataLBP;
	public int dataPuls;
	public int dataSugar;

}