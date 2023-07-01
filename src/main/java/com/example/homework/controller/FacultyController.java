package com.example.homework.controller;

import com.example.homework.model.Faculty;
import com.example.homework.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public ResponseEntity<Faculty> addFaculty(@PathVariable Faculty faculty) {
        Faculty addFaculty = facultyService.addFaculty(faculty);
        return ResponseEntity.ok(addFaculty);
    }

    @GetMapping({"getFaceltyId"})
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long facultyId) {
        Faculty getFacultets = facultyService.getFaculty(facultyId);
        if (getFacultets == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(getFacultets);
    }

    @GetMapping("editFacultyId")
    public ResponseEntity<Faculty> editFaulty(@RequestBody Faculty faculty) {
        Faculty editFaculty = facultyService.editFaculty(faculty);
        if (editFaculty == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editFaculty);
    }
    @GetMapping("removeFacultyId")
public ResponseEntity<Faculty> removeFaculty(@PathVariable Long facultyId) {
    Faculty removeFaculty = facultyService.removeFaculty(facultyId);
    if (removeFaculty == null) {
        return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(removeFaculty);
    }

}
