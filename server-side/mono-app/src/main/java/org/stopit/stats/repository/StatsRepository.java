package org.stopit.stats.repository;

import org.stopit.stats.*;
import org.springframework.stereotype.Repository;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@Repository
public interface StatsRepository extends TRepo<Stats, Integer> {
}
