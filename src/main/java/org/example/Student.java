package org.example;

public class Student {
    private String name;
    private int semester;
    private boolean isActive;

    public Student(String name, int semester, boolean isActive) {
        this.name = name;
        this.semester = semester;
        this.isActive = isActive;
    }

    public boolean isDoingMBKM() {
        if (semester >= 6 && isActive) {
            return true;
        }
        return false;
    }
}
