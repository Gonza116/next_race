package com.gonza116.nextRace.controllers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonza116.nextRace.entity.GrandPrix;


@RestController
@RequestMapping("/api/f1")
public class GrandPrixController {

	@GetMapping("/next")
	public GrandPrix nextRace() throws IOException {
		LocalDate dateNow = LocalDate.now();
		GrandPrix nextGP = null;
		for(GrandPrix gp: loadAll()) {
			String[] date = gp.date.split("/");
			if(LocalDate.of(Integer.valueOf(date[2]), Integer.valueOf(date[1]), Integer.valueOf(date[0])).isAfter(dateNow)) {
				nextGP = gp;
				break;
			}
		}
		return nextGP;
	}
	
	
	private List<GrandPrix> loadAll() throws IOException {

		Type listOfGrandPrixList = new TypeToken<ArrayList<GrandPrix>>() {}.getType();

		Gson gson = new Gson();
		String jsonToString = new String(Files.readAllBytes(Paths.get("data/F12020.json")));
		List<GrandPrix> allGPs = gson.fromJson(jsonToString, listOfGrandPrixList);

		return allGPs;
	}
}
