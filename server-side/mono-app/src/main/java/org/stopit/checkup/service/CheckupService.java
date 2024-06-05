package org.stopit.checkup.service;

import org.stopit.checkup.*;
import org.stopit.checkup.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@Data
@AllArgsConstructor
@Service
public class CheckupService implements TServiceCRUD<Integer, CheckupDto, CheckupModel> {
	private final CheckupRepository repository;
	@Override
	public int insert(CheckupDto checkupdto) {
		 return 0;
	}
	@Override
	public List<CheckupDto> getAll() {
		 return null;
	}
	@Override
	public boolean removeById(Integer id) {
		 return false;
	}
	@Override
	public boolean update(Integer id, CheckupModel checkupmodel) {
		 return false;
	}
}
