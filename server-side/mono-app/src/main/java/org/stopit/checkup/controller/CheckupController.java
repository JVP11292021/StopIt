package org.stopit.checkup.controller;

import org.stopit.checkup.*;
import org.stopit.checkup.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import org.utils.TAuthController;

import java.security.Principal;
import java.util.*;

@CompilationComponent
@Data
@AllArgsConstructor
@RestController
@RequestMapping("/stop-it/v1/checkup")
public class CheckupController implements TAuthController<Integer, CheckupDto, CheckupModel> {
	private final CheckupService checkupService;

	@Override
	@GetMapping
	public ResponseEntity<?> getAllEntities() {
		 return ResponseEntity.ok(checkupService.getAll());
	}
	@Override
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> removeEntityById(
			@PathVariable("id") Integer id
	) {
		 return ResponseEntity.ok(checkupService.removeById(id));
	}
	@Override
	@PatchMapping(path="/{id}")
	public ResponseEntity<?> updateEntity(
			@PathVariable("id") Integer id,
			@RequestBody CheckupModel checkupmodel
	) {
		 return ResponseEntity.ok(checkupService.update(id, checkupmodel));
	}
}
