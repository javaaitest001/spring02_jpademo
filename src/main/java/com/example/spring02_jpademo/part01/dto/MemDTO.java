package com.example.spring02_jpademo.part01.dto;

import com.example.spring02_jpademo.part01.entity.MemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemDTO {
	private int num;
	private String name;
	private int age;
	private String loc;


	
	//MemDTO => MemEntity
		public MemEntity toEntity() {
			return MemEntity.builder()
					.num(num)
					.name(name)
					.age(age)
					.loc(loc)
					.build();
		}


		
		//MemEntity => MemDTO
		public static MemDTO toDTO(MemEntity memEntity) {
			return MemDTO.builder()
					.num(memEntity.getNum())
					.name(memEntity.getName())
					.age(memEntity.getAge())
					.loc(memEntity.getLoc())
					.build();
		}
}
