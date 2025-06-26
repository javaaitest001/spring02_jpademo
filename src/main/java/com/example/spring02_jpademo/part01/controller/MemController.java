package com.example.spring02_jpademo.part01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring02_jpademo.part01.dto.MemDTO;
import com.example.spring02_jpademo.part01.service.MemService;

@RestController
public class MemController {

	@Autowired
	private MemService memService;

	public MemController() {

	}

	// http://localhost:8090/mem/홍길동
	@GetMapping(value = "/mem/{name}")
	public ResponseEntity<List<MemDTO>> getListName(@PathVariable("name") String name) {

		// return ResponseEntity.ok().body(memService.getByJPQL(name));
		// return ResponseEntity.ok().body(memService.getByCriteria(name));
		// return ResponseEntity.ok().body(memService.getByNativeQuery(name));
		return ResponseEntity.ok().body(memService.getByNamedQuery(name));
	}

	// http://localhost:8090/mem/num/1
	@GetMapping(value = "/mem/num/{num}")
	public ResponseEntity<List<MemDTO>> getListNum(@PathVariable("num") int num) {
		return ResponseEntity.ok().body(memService.getMemByNum(num));
	}

	// http://localhost:8090/mem/namenum/홍길동/10
	@GetMapping(value = "/mem/namenum/{name}/{age}")
	public ResponseEntity<List<MemDTO>> getListNameAndNum(@PathVariable("name") String name,
			@PathVariable("age") int age) {
		return ResponseEntity.ok().body(memService.getMemByNameAndAge(name, age));
	}

	// http://localhost:8090/mem/age
	@GetMapping(value = "/mem/age")
	public ResponseEntity<List<MemDTO>> getListAge() {
		return ResponseEntity.ok().body(memService.getMemByAgeIsNotNull());
	}

	// {"name" : "김규리", "age" : 40, "loc" : "대전"}
	// http://localhost:8090/mem
	@PostMapping(value = "/mem")
	public ResponseEntity<Integer> insertMemByNative(@RequestBody MemDTO mem) {
		// return ResponseEntity.ok().body(memService.insertMemByNative(mem.getName(),
		// mem.getAge(), mem.getLoc()));
		return ResponseEntity.ok().body(memService.insertMemByNative(mem));
	}

	// {"num":8, "name":"김사랑", "age":20, "loc":"일산"}
	// {"num":8, "name":"홍길동", "age":30, "loc":"수원"}
	// http://localhost:8090/mem
	@PutMapping(value = "/mem")
	public ResponseEntity<Integer> updateMem(@RequestBody MemDTO memDTO) {
		return ResponseEntity.ok().body(memService.updateMem(memDTO));
	}
	
	// http://localhost:8090/mem/8
	@DeleteMapping(value="/mem/{num}")
	public ResponseEntity<Integer> deleteMem(@PathVariable("num") int num){
		return ResponseEntity.ok().body(memService.deleteMem(num));
	}

}
