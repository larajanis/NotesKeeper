package com.psna.digilearn.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.psna.digilearn.model.Course;
import com.psna.digilearn.model.CustomFile;
import com.psna.digilearn.model.User;
import com.psna.digilearn.repository.CustomFileRepository;
import com.psna.digilearn.service.CourseService;
import com.psna.digilearn.service.UserService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;
	
	@Autowired
	CustomFileRepository fileRepository;

	private static String UPLOADED_FOLDER = "E://Courses//";

	@GetMapping("/getCourse")
	public String courseTest(Model model) {
		List<Course> courses = courseService.findCourses(8, "ECE");
		System.out.println("Got list of course: " + courses.size());
		model.addAttribute("courses", courses);
		return "tester";
	}

	@GetMapping("/course/{coursename}")
	public String course(@PathVariable("coursename") int courseId, Model model, Principal principal) {
		String username = principal.getName();
		boolean admin = false;
		User user = userService.findByUsername(username);
		if (user.getRole().getId() > 1) {
			admin = true;
		}
		Course course = courseService.findCourse(courseId);
		List<CustomFile> notes = course.getFiles();
		model.addAttribute("course", course);
		model.addAttribute("notes",notes);
		model.addAttribute(user);
		model.addAttribute("admin", admin);
		System.out.println(admin);
		return "course";
	}

	@PostMapping("/course/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {

		String courseid = request.getParameter("coursename");
		
		int id = Integer.parseInt(courseid);
		
		Course course = courseService.findCourse(id);
		
		CustomFile newfile = new CustomFile();
		
		newfile.setFileName(file.getOriginalFilename());
		newfile.setFilePath(UPLOADED_FOLDER);
		newfile.setCourse(course);
		
		fileRepository.save(newfile);

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		} catch (IOException e) {
			System.out.println("Exception while saving file to location");
		}
		return "redirect:/course/" + courseid;
	}
	
	@GetMapping("/download/{fileName:.+}")
	public ResponseEntity<Resource> downloadFileFromLocal(@PathVariable String fileName) {
		Path path = Paths.get(UPLOADED_FOLDER + fileName);
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}
