package com.tascks.TaskList.Task.Configs;

import com.tascks.TaskList.Task.Model.Task;
import com.tascks.TaskList.Task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository){
        return args -> {
            Task createClassCat = new Task(
                    "Create Cat",
                    "Напишите на JAVA кошечку",
                    Boolean.TRUE
            );

            Task createWorld = new Task(
                    "Learn Spring",
                    "А теперь прочитайте 8 статей, посмотрите 3 видеоурока на 5 часов суммарного времени и напишите что-нибудь на spring",
                    Boolean.FALSE
            );

            repository.saveAll(
                    List.of(createClassCat, createWorld)
            );
        };
    }

}

