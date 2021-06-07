//
package com.revature.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Image;
import com.revature.model.Tag;
import com.revature.model.TagJunction;
import com.revature.service.RatingService;
import com.revature.service.TagJunctionService;
import com.revature.service.TagService;

@RestController
@RequestMapping(value="/image")
@CrossOrigin(origins="*")
public class ImageController {
	
	private TagJunctionService tagJuncServ;
	private RatingService ratingServ;
	private TagService tagServ;
	
	public ImageController(TagJunctionService tjServ, RatingService rServ, TagService tServ) {
		this.tagJuncServ = tjServ;
		this.ratingServ = rServ;
		this.tagServ = tServ;
	}
	
	@GetMapping(value="/")
	public ResponseEntity<Image[]> getApod(@RequestParam Long userId){
		System.out.println("test");
	    LocalDate date = LocalDate.now();
			
		String apiCall = "https://api.nasa.gov/planetary/apod?"
		+ "api_key=OrYgMm5s6rF8nMLv95C5bbqgl440knaSZRijQzn5"
		+ "&start_date=" 
		+ date
		+ "&end_date="
		+ date;
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Image[]> response = rt.getForEntity(apiCall, Image[].class);
		Image[] images = response.getBody();
		//sets rating to iamge
		images[0].setRating(ratingServ.getRating(date, userId));
		
		// Then make a query to the database depending on what you are looking for
		// return image for current date

		return new ResponseEntity<Image[]>(images, HttpStatus.OK);
	}
	
	@GetMapping(value="/tag")
	public ResponseEntity<Image[]> getTagJunctionByTagId(@RequestParam Long tagId, @RequestParam Long userId){
		
		List<TagJunction> tagJuncList = tagJuncServ.getAllByTagId(tagId);
		
		int size = tagJuncList.size();
		
		RestTemplate rt = new RestTemplate();
		int i = 0;
		ResponseEntity<Image[]> response;
		Image[] images = new Image[size];
		
		//iterates through list of TagJunction items, does an api call for each date, then adds to image array
		for (TagJunction tj : tagJuncList) {
			LocalDate date = tj.getImageDate();
			
			String apiCall = "https://api.nasa.gov/planetary/apod?"
					+ "api_key=OrYgMm5s6rF8nMLv95C5bbqgl440knaSZRijQzn5"
					+ "&start_date=" 
					+ date
					+ "&end_date="
					+ date;

	
			response = rt.getForEntity(apiCall, Image[].class);
			
			images[i] = response.getBody()[0];
			//sets rating to image
			images[i].setRating(ratingServ.getRating(date, userId));
			
			i++;
		}
				
		//4 send the images to the front end
		return new ResponseEntity<Image[]>(images, HttpStatus.OK);
	}
	
	@GetMapping(value="/tag-get-all")
	public ResponseEntity<List<Tag>> getAllTags(){
		
		List<Tag> tagList = tagServ.getAll();
				
		return new ResponseEntity<List<Tag>>(tagList, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/tag-create")
	public String createTag(@RequestParam String tagName) {
		return tagServ.createTag(tagName);
	}
	
	@PostMapping(value="/tag-add")
	public String addTagToImage(@RequestParam String imageDate, @RequestParam Long tagId) {
		LocalDate date = LocalDate.parse(imageDate);
		return tagJuncServ.createTagJunction(tagId, date);
	}

	@GetMapping(value="/date")
	public ResponseEntity<Image[]> getByDay(@RequestParam String imageDate, @RequestParam Long userId){
		String dateString = imageDate;
		LocalDate day = LocalDate.parse(dateString);
		
		String apiCall = "https://api.nasa.gov/planetary/apod?"
		+ "api_key=OrYgMm5s6rF8nMLv95C5bbqgl440knaSZRijQzn5"
		+ "&start_date=" 
		+ dateString
		+ "&end_date="
		+ dateString;
		
		RestTemplate rt = new RestTemplate();	
		
		// Turns JSON into Java Model
		ResponseEntity<Image[]> response = rt.getForEntity(apiCall, Image[].class);
		Image[] images = response.getBody();
		//sets rating to iamge
		images[0].setRating(ratingServ.getRating(day, userId));
		
		// Turns the Java into JSON
		return new ResponseEntity<Image[]>(images, HttpStatus.OK);
	}

	@GetMapping(value="/range")
	public ResponseEntity<Image[]> getRangeOfImages(@RequestParam String startDate, @RequestParam String endDate, @RequestParam Long userId){
		
		LocalDate day1 = LocalDate.parse(startDate);
		LocalDate day2 = LocalDate.parse(endDate);

		//find number of days between dates, creates array of images that size
	    long noOfDays = ChronoUnit.DAYS.between(day1, day2);
		int size = (int)noOfDays;
		LocalDate day = day1;
	    
		RestTemplate rt = new RestTemplate();
		int i = 0;
		ResponseEntity<Image[]> response;
		Image[] images = new Image[size];
		
		//iterates through list of items, does an api call for each date, then adds to image array
		do {
			String apiCall = "https://api.nasa.gov/planetary/apod?"
					+ "api_key=OrYgMm5s6rF8nMLv95C5bbqgl440knaSZRijQzn5"
					+ "&start_date=" 
					+ day
					+ "&end_date="
					+ day;

	
			response = rt.getForEntity(apiCall, Image[].class);
			
			images[i] = response.getBody()[0];
			//sets rating to image
			images[i].setRating(ratingServ.getRating(day, userId));
			
			day = day.plusDays(1);
			i++;
		} while (i < size);
				
		//4 send the images to the front end
		return new ResponseEntity<Image[]>(images, HttpStatus.OK);
	}

	@GetMapping(value="/random")
	public ResponseEntity<Image[]> getRandomImage(@RequestParam Long userId) {
		//sets current date and first day of apod
	    LocalDate currentDate = LocalDate.now();
	    LocalDate startDate = LocalDate.of(1995, Month.JUNE, 16);
  
	    //finds number of days between current day and first day of apod
	    long noOfDays = ChronoUnit.DAYS.between(startDate, currentDate);
	    
	    //gets a random date between current day and first day of apod
	    LocalDate randomDate = startDate.plusDays(ThreadLocalRandom.current().nextLong(noOfDays+1));
	    
	    //sets randomDate in api call to apod
		String apiCall = "https://api.nasa.gov/planetary/apod?"
		+ "api_key=OrYgMm5s6rF8nMLv95C5bbqgl440knaSZRijQzn5"
		+ "&start_date=" 
		+ randomDate
		+ "&end_date="
		+ randomDate;

		//packages and returns
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Image[]> response = rt.getForEntity(apiCall, Image[].class);
		Image[] images = response.getBody();
		//sets rating to image
		images[0].setRating(ratingServ.getRating(randomDate, userId));
		
		return new ResponseEntity<Image[]>(images, HttpStatus.OK);
	}

	@PostMapping(value="/rate")
	public String rateImage(@RequestParam Integer finalRating, @RequestParam String imageDate, @RequestParam Long userId){
		LocalDate date = LocalDate.parse(imageDate);
		return ratingServ.createRating(finalRating, date, userId);
	}
}
//
