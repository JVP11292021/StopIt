package org.stopit.push.repository;

import org.stopit.push.*;
import org.springframework.stereotype.Repository;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@Repository
public interface PushRepository extends TRepo<Push, Integer> {
}
