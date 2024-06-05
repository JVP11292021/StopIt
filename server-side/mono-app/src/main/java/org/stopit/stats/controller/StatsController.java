package org.stopit.stats.controller;

import org.stopit.stats.*;
import org.stopit.stats.service.*;
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
@RequestMapping("/stop-it/v1/stats")
public class StatsController implements TControllerEntityResponseWildcard<Integer, StatsDto, Stats> {
	private final StatsService statsService;
	@Override
	@PostMapping
	public ResponseEntity<?> insertEntity(StatsDto statsdto) {
		 return ResponseEntity.ok(statsService.insert(statsdto));
	}
	@Override
	@GetMapping
	public ResponseEntity<?> getAllEntities() {
		 return ResponseEntity.ok(statsService.getAll());
	}
	@Override
	@DeleteMapping
	public ResponseEntity<?> removeEntityById(Integer id) {
		 return ResponseEntity.ok(statsService.removeById(id));
	}
	@Override
	@PutMapping
	public ResponseEntity<?> updateEntity(Integer id, Stats stats) {
		 return ResponseEntity.ok(statsService.update(id, stats));
	}
}
