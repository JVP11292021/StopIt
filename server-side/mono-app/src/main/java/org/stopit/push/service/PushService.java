package org.stopit.push.service;

import org.stopit.push.*;
import org.stopit.push.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@Data
@AllArgsConstructor
@Service
public class PushService implements TServiceCRUD<Integer, PushDto, Push> {
	private final PushRepository repository;
	@Override
	public int insert(PushDto pushdto) {
		 return 0;
	}
	@Override
	public List<PushDto> getAll() {
		 return null;
	}
	@Override
	public boolean removeById(Integer id) {
		 return false;
	}
	@Override
	public boolean update(Integer id, Push push) {
		 return false;
	}
}
