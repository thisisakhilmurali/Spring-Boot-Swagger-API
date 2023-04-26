package com.example.springboottest.StudentControllerTest;

import com.example.springboottest.controller.StudentController;
import com.example.springboottest.entity.Student;
import com.example.springboottest.service.StudentServiceMain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentTestController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceMain studentServiceMain;
    private Student student;

    @BeforeEach
    public void setup() {
        student = new Student(3, "Ray", "TVM-KL", "2444");
    }

    @Test
    void testSaveStudent() throws Exception {
        Student student = new Student(3, "Ray", "TVM-KL", "2444");
        Mockito.when(studentServiceMain.addStudent(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" +
                        " \"id\" : 3, \r\n" +
                        " \"name\" : \"Ray\", \r\n" +
                        " \"address\" :\"TVM-KL\", \r\n" +
                        " \"rollNumber\" : \"2444\" \r\n" + "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }



}


/*
@Test
void testSaveStudent() throws Exception {
    Student student = new Student(1,"Yashwanth","Hyderabad","245098");
    Mockito.when(studentService.addStudent(student)).thenReturn(student);
    mockMvc.perform(MockMvcRequestBuilders.post("/student/")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\r\n" +
                    " \"id\" : 1, \r\n" +
                    " \"name\" : \"Yashwanth\", \r\n" +
                    " \"address\" :\"Hyderabad\", \r\n" +
                    " \"rollNo\" : \"245098\" \r\n" + "}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
}
 */
