package com.rohit.quizapp.controller;

import com.rohit.quizapp.model.QuestionWrapper;
import com.rohit.quizapp.model.QuizDto;
import com.rohit.quizapp.model.Response;
import com.rohit.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
        
        return quizService.createQuiz(quizDto.getCategory(),quizDto.getNumQuestions(),quizDto.getTitle());
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> responses){
        return quizService.calculateResult(responses);
    }
}
