package org.stopit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.restframework.web.annotations.markers.CompilationComponent;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.stopit.auth.user.User;
import org.stopit.auth.user.UserRepo;
import org.stopit.checkup.CheckupDto;
import org.stopit.checkup.CheckupModel;
import org.stopit.push.Push;
import org.stopit.push.PushDto;
import org.stopit.stats.Stats;
import org.stopit.stats.StatsDto;

import java.security.Principal;
import java.security.SecureRandom;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@CompilationComponent
public class InsertionService {

    private final UserRepo userRepo;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int insertStats(StatsDto statsdto, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        var longestStreak = 0;
        for (var model : user.getCheckups()) {
            if (!model.isHasSmoked()) longestStreak++;
            else longestStreak = 0;
        }

        var amountOfCheckups = user.getCheckups().size();

        var model = Stats.builder()
                .id(new SecureRandom().nextInt())
                .healthLevel(statsdto.getHealthLevel())
                .moneySaved(Math.max(amountOfCheckups * 17.5D, statsdto.getCurrentStreak() * 17.5D))
                .currentStreak(statsdto.getCurrentStreak())
                .longestStreak(Math.max(longestStreak, statsdto.getCurrentStreak()))
                .build();

        user.setStats(model);
        log.info("Inserted: {} for user {}", model, user.getEmail());
        this.userRepo.save(user);
        return 1;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int insertPush(PushDto pushdto, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        var model = Push.builder()
                .id(new SecureRandom().nextInt())
                .text(pushdto.getText())
                .pushMsgInterval(pushdto.getPushMsgInterval())
                .build();

        user.getPushNotifications().add(model);
        log.info("Inserted: {} for user {}", model, user.getEmail());
        this.userRepo.save(user);
        return 1;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int insertCheckup(CheckupDto checkupdto, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        var model = CheckupModel.builder()
                .id(new SecureRandom().nextInt())
                .comment(checkupdto.getComment())
                .difficultyScale(checkupdto.getDifficultyScale())
                .hasSmoked(checkupdto.isHasSmoked())
                .date(checkupdto.getDate())
                .build();

        user.getCheckups().add(model);
        log.info("Inserted: {} for user {}", model, user.getEmail());
        this.userRepo.save(user);

        return 1;
    }

}
