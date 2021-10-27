package com.spring.tdd.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.tdd.data.WidgetEntity;
import com.spring.tdd.data.WidgetRepository;
import com.spring.tdd.resources.WidgetResource;

@RestController
public class WidgetController {

	@Autowired
	WidgetRepository widgetRepository;

	@PostMapping("/widgets")
	public ResponseEntity<String> CreateWidget(@RequestBody WidgetResource widgetResource) {

		WidgetEntity entity = new WidgetEntity();

		entity.setProductName(widgetResource.getName());
		entity.setProductDetail(widgetResource.getDescription());

		widgetRepository.save(entity);

		URI widgets = URI.create("widgets");
		return ResponseEntity.created(widgets).header("MyResponseHeader", "widgetResource").body("Hello World");

		// return widgetResource;

	}

	/*
	 * @GetMapping("/widgets") public String getWidget() {
	 * 
	 * URI widgets = URI.create("widgets"); return
	 * ResponseEntity.created(widgets).header("MyResponseHeader",
	 * "widgetResource").body("Hello World");
	 * 
	 * }
	 */

}
