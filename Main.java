package Lesson09;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        1.Написать функцию, принимающую список Student и возвращающую список
уникальных курсов, на которые подписаны студенты.
        2.Написать функцию, принимающую на вход список Student и
 возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
        3.Написать функцию, принимающую на вход список Student и
 экземпляр Course, возвращающую список студентов, которые посещают этот курс.
         */
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ignat", Arrays.asList(new Course("Math"),
                        new Course("Biology"))),
                new Student("Boris", Arrays.asList(new Course("Physics"),
                        new Course("History"), new Course("Biology"))),
                new Student("Anna", Arrays.asList(new Course("Math"),
                        new Course("Testing"), new Course("Biology"))),
                new Student("Anna", Arrays.asList(new Course("Math"),
                        new Course("Testing"), new Course("Biology")))

        ));
        System.out.println(students.stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));
        System.out.println(students.stream()
                .sorted(s1, s2) ->s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

            Course course=new Course("Physics");
        System.out.println(students.stream()
                .filter(s->s.getCourses().contains(course))
                .collect(Collectors.toList()));


    }

}
