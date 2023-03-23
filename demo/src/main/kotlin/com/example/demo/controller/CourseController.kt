package com.example.demo.controller

import com.example.demo.model.Course
import com.example.demo.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CourseController(private val courseService: CourseService) {

    @GetMapping("/course/{id}")
    fun getCourse(@PathVariable id: String): ResponseEntity<List<Course>>{
        return ResponseEntity.ok(courseService.getCourseById(id))
    }

    @PostMapping("/course")
    fun coursePost(@RequestBody course: Course): ResponseEntity<String> {
        return ResponseEntity.ok(courseService.createCourse(course))
    }
}