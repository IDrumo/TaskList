package com.tascks.TaskList.TaskList.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


//        Чтобы воспользоваться DTO-классом необходим механизм десериализации -
//        превращения JSON-строки вида {"name": "John Doe"} в экземпляр класса
//        CreateUserDto. Класс Builder реализует шаблон Строитель,
//        который принято использовать в классах моделей и DTO

@JsonDeserialize(builder = CreateTaskDTO.Builder.class)
public class CreateTaskDTO {
    //    private Integer id;
    private String title;
    private String description;

    public static Builder builder() {
        return new Builder();
    }

    private CreateTaskDTO(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CreateTaskDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @JsonPOJOBuilder(withPrefix = "set")
//    билдер это все, что начинается с set
    public static class Builder {
        private String title;
        private String description;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateTaskDTO build() {
            return new CreateTaskDTO(this);
        }
    }
}
