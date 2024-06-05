package org.stopit.checkup.repository;

import org.stopit.checkup.*;
import org.springframework.stereotype.Repository;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@Repository
public interface CheckupRepository extends TRepo<CheckupModel, Integer> {
}
