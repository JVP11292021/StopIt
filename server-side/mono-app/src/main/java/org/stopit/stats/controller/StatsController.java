package org.stopit.stats.controller;

import org.stopit.stats.*;
import org.stopit.stats.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.restframework.web.annotations.markers.*;
import org.utils.TAuthController;

@CompilationComponent
@Data
@AllArgsConstructor
@RestController
@RequestMapping("/stop-it/v1/stats")
public class StatsController implements TAuthController<Integer, StatsDto, Stats> {
	private final StatsService statsService;

	@Override
	@GetMapping(path="/{email}")
	public ResponseEntity<?> getAllEntities(@PathVariable("email") String email) {
		 return ResponseEntity.ok(statsService.getAll(email));
	}
	@Override
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> removeEntityById(@PathVariable("id") Integer id) {
		 return ResponseEntity.ok(statsService.removeById(id));
	}
	@Override
	@PatchMapping(path="/{id}")
	public ResponseEntity<?> updateEntity(
			@PathVariable("id") Integer id,
			@RequestBody Stats stats
	) {
		 return ResponseEntity.ok(statsService.update(id, stats));
	}
}
