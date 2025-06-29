package com.rohit.quizapp.model;

import lombok.Data;

@Data
public class QuizDto {

    private String category;
    private String title;
    private Integer numQuestions;

}
