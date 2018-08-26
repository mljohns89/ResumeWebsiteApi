package xyz.michaeljohnson.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.michaeljohnson.database.CoverLetterDatabase;
import xyz.michaeljohnson.database.ResumeDatabase;

@RestController 
@RequestMapping("/content")
public class ContentController {

	
	@GetMapping("/resume")
	public Map<String, String> resume() {
		return ResumeDatabase.getResumeData();
	}
	
	@GetMapping("/coverLetter")
	public String coverLetter() {
//		return "cover\nletter\ncontent";
		return CoverLetterDatabase.getCoverLetter();
	}
}
