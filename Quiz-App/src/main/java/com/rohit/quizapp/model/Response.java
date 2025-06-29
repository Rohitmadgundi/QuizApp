package com.rohit.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response implements Comparable<Response>{

    private Integer id;
    private String response;
    @Override
    public int compareTo(Response other) {
        return this.id.compareTo(other.id);
        // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
