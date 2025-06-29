package com.rohit.quizapp.service;

import com.rohit.quizapp.dao.QuizDao;
import com.rohit.quizapp.feign.QuizInterface;
import com.rohit.quizapp.model.QuestionWrapper;
import com.rohit.quizapp.model.Quiz;
import com.rohit.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz = quizDao.findById(id);
        List<Integer> questionIds = quiz.get().getQuestionIds();

        return quizInterface.getQuestionsFromId(questionIds);

    }

    public ResponseEntity<Integer> calculateResult(List<Response> responses) {

        return quizInterface.getScores(responses);
    }

    

}
