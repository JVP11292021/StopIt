package org.stopit.stats.controller;

import org.stopit.stats.*;
import org.stopit.stats.service.*;
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
@RequestMapping("/stop-it/v1/stats")
public class StatsController implements TAuthController<Integer, StatsDto, Stats> {
	private final StatsService statsService;
	@Override
	@PostMapping
	public ResponseEntity<?> insertEntity(
			@RequestBody StatsDto statsdto,
			Principal connectedUser
	) {
		 return ResponseEntity.ok(statsService.insert(statsdto, connectedUser));
	}
	@Override
	@GetMapping
	public ResponseEntity<?> getAllEntities() {
		 return ResponseEntity.ok(statsService.getAll());
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
