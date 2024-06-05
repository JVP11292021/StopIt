package org.stopit.push.controller;

import org.stopit.push.*;
import org.stopit.push.service.*;
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
@RequestMapping("/stop-it/v1/push")
public class PushController implements TControllerEntityResponseWildcard<Integer, PushDto, Push> {
	private final PushService pushService;
	@Override
	@PostMapping
	public ResponseEntity<?> insertEntity(
			@RequestBody PushDto pushdto
	) {
		 return ResponseEntity.ok(pushService.insert(pushdto));
	}
	@Override
	@GetMapping
	public ResponseEntity<?> getAllEntities() {
		 return ResponseEntity.ok(pushService.getAll());
	}
	@Override
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> removeEntityById(
			@PathVariable("id") Integer id
	) {
		 return ResponseEntity.ok(pushService.removeById(id));
	}
	@Override
	@PatchMapping(path="/{id}")
	public ResponseEntity<?> updateEntity(
			@PathVariable("id") Integer id,
			@RequestBody Push push
	) {
		 return ResponseEntity.ok(pushService.update(id, push));
	}
}
