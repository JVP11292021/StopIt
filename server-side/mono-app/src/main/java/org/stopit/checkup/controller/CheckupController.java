package org.stopit.checkup.controller;

import org.stopit.checkup.*;
import org.stopit.checkup.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@Data
@AllArgsConstructor
@RestController
@RequestMapping("/stop-it/v1/checkup")
public class CheckupController implements TControllerEntityResponseWildcard<Integer, CheckupDto, CheckupModel> {
	private final CheckupService checkupService;
	@Override
	@PostMapping
	public ResponseEntity<?> insertEntity(CheckupDto checkupdto) {
		 return ResponseEntity.ok(checkupService.insert(checkupdto));
	}
	@Override
	@GetMapping
	public ResponseEntity<?> getAllEntities() {
		 return ResponseEntity.ok(checkupService.getAll());
	}
	@Override
	@DeleteMapping
	public ResponseEntity<?> removeEntityById(Integer id) {
		 return ResponseEntity.ok(checkupService.removeById(id));
	}
	@Override
	@PutMapping
	public ResponseEntity<?> updateEntity(Integer id, CheckupModel checkupmodel) {
		 return ResponseEntity.ok(checkupService.update(id, checkupmodel));
	}
}
