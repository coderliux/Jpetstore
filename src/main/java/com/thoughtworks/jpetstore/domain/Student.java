package com.thoughtworks.jpetstore.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coderliu on 3/5/16.
 */
@Data
public class Student {
    private int id;
    private String name;
    private int grade;

    List<Klass> klasses= new ArrayList<Klass>();


}
