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
public class StatsController {
	private final StatsService statsService;

	@GetMapping(path="/{email}")
	public ResponseEntity<?> getAllEntities(@PathVariable("email") String email) {
		 return ResponseEntity.ok(statsService.getAll(email));
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> removeEntityById(@PathVariable("id") Integer id) {
		 return ResponseEntity.ok(statsService.removeById(id));
	}

	@PatchMapping(path="/{email}")
	public ResponseEntity<?> updateEntity(
			@PathVariable("email") String id,
			@RequestBody StatsDto stats
	) {
		 return ResponseEntity.ok(statsService.update(id, stats));
	}
}
