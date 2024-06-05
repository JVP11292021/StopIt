package org.stopit;

import org.restframework.web.annotations.EnableRestConfiguration;
import org.restframework.web.annotations.RestApi;
import org.restframework.web.annotations.types.API;
import org.restframework.web.annotations.types.FieldData;
import org.restframework.web.annotations.types.Model;
import org.restframework.web.core.generics.Generic;
import org.restframework.web.core.templates.TControllerEntityResponseWildcard;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.utils.SafeWebAppRunner.safeApplicationRunner;

@SpringBootApplication
@EnableRestConfiguration
@RestApi(
        controller = TControllerEntityResponseWildcard.class,
        basePackage = "org.stopit",
        APIS = {
                @API(
                        endpoint = "/stop-it/v1/stats",
                        apiPackage = "stats",
                        apiName = "Stats",
                        model = @Model(
                                tableName = "t_stats",
                                generic = Generic.INTEGER,
                                fields = {
                                        @FieldData(datatype = "double", name = "moneySaved"),
                                        @FieldData(datatype = "int", name = "currentStreak"),
                                        @FieldData(datatype = "int", name = "longestStreak"),
                                        @FieldData(datatype = "HealthScale", name = "healthLevel")
                                },
                                abbrev = ""
                        )
                ),
                @API(
                        endpoint = "/stop-it/v1/push",
                        apiPackage = "push",
                        apiName = "Push",
                        model = @Model(
                                tableName = "t_push_messages",
                                generic = Generic.INTEGER,
                                fields = {
                                        @FieldData(datatype = "Date", name = "pushMsgInterval"),
                                        @FieldData(name = "text")
                                },
                                abbrev = ""
                        )
                ),
                @API(
                        endpoint = "/stop-it/v1/checkup",
                        apiPackage = "checkup",
                        apiName = "Checkup",
                        model = @Model(
                                tableName = "t_daily_checkup",
                                generic = Generic.INTEGER,
                                fields = {
                                        @FieldData(datatype = "boolean", name = "hasSmoked"),
                                        @FieldData(name = "comment"),
                                        @FieldData(datatype = "StopWithSmokingScale", name = "difficultyScale")
                                }
                        )
                )
        }
)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class App {
    public static void main(String[] args) {
        safeApplicationRunner(App.class, args);
    }
}