package com.bourntec.s3sam.s3sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

@RestController
@RequestMapping(value= "/common")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class S3CommonControllers {
	
	@Autowired
	private AmazonS3 s3;
	
	
	@GetMapping
	public void listAllS3Buck (){
		List<Bucket> buckets = s3.listBuckets();
		System.out.println("Your {S3} buckets are:");
		for (Bucket b : buckets) {
		    System.out.println("* " + b.getName());
		}
	}
}
