package com.example.demo.service

import com.example.demo.model.Course
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(val jdbc: JdbcTemplate) {

    fun getCourseById(id: String): List<Course> = jdbc.query("select * from courses where id='$id'"){ response, _ ->
        Course(response.getString("id"), response.getString("name"), response.getString("professor"))
    }

    fun createCourse(course: Course): String{
        val id = course.id ?: UUID.randomUUID().toString()
        jdbc.update("insert into courses values ( ?, ?, ?)", id, course.name, course.professor)
        return "id : $id"
    }
}