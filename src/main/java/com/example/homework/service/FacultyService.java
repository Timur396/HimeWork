package com.example.homework.service;
import com.example.homework.model.Faculty;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FacultyService {
    private final Map<Long, Faculty> facultets = new HashMap<>();
    private long couner = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(couner++);
        facultets.put(couner, faculty);
        return faculty;
    }

    public Faculty getFaculty(Long id) {
        return facultets.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultets.containsKey(faculty.getId())) {
            facultets.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty removeFaculty(Long id) {
        return facultets.remove(id);
    }

    public Collection<Faculty> getAllFacultiesByColor(String color) {
        return facultets.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }


    public Collection<Faculty> getAllFaculty() {
        return facultets.values();

    }

}


