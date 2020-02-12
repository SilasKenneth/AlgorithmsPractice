package main.java.com.algorithms.practice.hackerrank;

import java.io.Serializable;
import java.util.*;

public class JavaPriorityQueue {

    static class Student implements  Comparable<Student>{
        private int id;
        private String name;
        private double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCGPA() {
            return cgpa;
        }

        @Override
        public int compareTo(Student student2) {
            Student student1 = this;
            if(student1.cgpa != student2.cgpa){
                return Double.compare(student2.cgpa, student1.cgpa);
            }
            if(!student1.name.equals(student2.name)){
                return student1.name.compareTo(student2.name);
            }
            return student1.id - student2.id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", cgpa=" + cgpa +
                    '}';
        }
    }

    static class Priorities{

        public Priorities(){ }
        public List<Student> getStudents(List<String> events) {
            List<Student> result = new ArrayList<>();
            PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
            for(String event: events){
                String[] eventDesc = event.split(" ");
                if(eventDesc.length == 1){
                    if(priorityQueue.size() > 0){
                        priorityQueue.remove();
                    }
                } else{
                    Student toAdd = new Student(Integer.parseInt(eventDesc[3]),eventDesc[1], Double.parseDouble(eventDesc[2]));
                    priorityQueue.offer(toAdd);
                }
            }

            while(!priorityQueue.isEmpty()){
                result.add(priorityQueue.remove());
            }
            return result;
        }
    }

    private static void solution(List<String> events, Priorities priorities){
        System.out.println(priorities.getStudents(events));
    }
    public static void main(String[] args) {
        Priorities priorities = new Priorities();
        String[] events = {"ENTER John 3.75 50", "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35", "SERVED", "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED", "ENTER ashley 3.9 42",
                "ENTER Ashley 3.9 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        };
        solution(List.of(events), priorities);
    }
}
