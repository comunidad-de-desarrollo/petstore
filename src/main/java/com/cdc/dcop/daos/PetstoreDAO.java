package com.cdc.dcop.daos;

import com.cdc.dcop.models.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PetstoreDAO implements IPetstoreDAO {

	public Pet findById(int id) {

		Pet pet;

		// Categorias

		Category cat = new Category();
		cat.setId(1);
		cat.setName("Domesticos");

		Category cat2 = new Category();
		cat2.setId(2);
		cat2.setName("Salvajes");

		// Tags

		Tag tag = new Tag();
		tag.setId(1);
		tag.setName("chico");

		Tag tag2 = new Tag();
		tag2.setId(2);
		tag2.setName("grande");

		ArrayList<Tag> tags = new ArrayList<Tag>();
		tags.add(tag);

		ArrayList<Tag> tags2 = new ArrayList<Tag>();
		tags2.add(tag2);

		// urls

		String url = "https://images.clarin.com/2019/01/19/BHaslG6vz_1256x620__1.jpg";
		String url2 = "https://commons.wikimedia.org/wiki/File:Cat_November_2010-1a.jpg";

		ArrayList<String> urls = new ArrayList<String>();
		urls.add(url);

		ArrayList<String> urls2 = new ArrayList<String>();
		urls2.add(url2);

		// Pets

		Pet sold = new Pet();
		sold.setId(1);
		sold.setName("Perro");
		sold.setStatus("Sold");
		sold.setCategory(cat);
		sold.setTags(tags);
		sold.setPhotoUrls(urls);

		Pet available = new Pet();
		available.setId(2);
		available.setName("Gato");
		available.setStatus("Available");
		available.setCategory(cat2);
		available.setTags(tags2);
		available.setPhotoUrls(urls2);

		if (id == 1) {
			pet = sold;
		} else if (id == 2) {
			pet = available;
		} else {
			pet = new Pet();
		}

		return pet;
	}
	
	public Pet findByStatus(String Status) {

		Pet pet;

		// Categorias

		Category cat = new Category();
		cat.setId(1);
		cat.setName("Domesticos");

		Category cat2 = new Category();
		cat2.setId(2);
		cat2.setName("Salvajes");

		// Tags

		Tag tag = new Tag();
		tag.setId(1);
		tag.setName("chico");

		Tag tag2 = new Tag();
		tag2.setId(2);
		tag2.setName("grande");

		ArrayList<Tag> tags = new ArrayList<Tag>();
		tags.add(tag);

		ArrayList<Tag> tags2 = new ArrayList<Tag>();
		tags2.add(tag2);

		// urls

		String url = "https://images.clarin.com/2019/01/19/BHaslG6vz_1256x620__1.jpg";
		String url2 = "https://commons.wikimedia.org/wiki/File:Cat_November_2010-1a.jpg";

		ArrayList<String> urls = new ArrayList<String>();
		urls.add(url);

		ArrayList<String> urls2 = new ArrayList<String>();
		urls2.add(url2);

		// Pets

		Pet sold = new Pet();
		sold.setId(1);
		sold.setName("Perro");
		sold.setStatus("Sold");
		sold.setCategory(cat);
		sold.setTags(tags);
		sold.setPhotoUrls(urls);

		Pet available = new Pet();
		available.setId(2);
		available.setName("Gato");
		available.setStatus("Available");
		available.setCategory(cat2);
		available.setTags(tags2);
		available.setPhotoUrls(urls2);

		if (Status.equals("Sold")) {
			pet = sold;
		} else if (Status.equals("Available")) {
			pet = available;
		} else {
			pet = new Pet();
		}

		return pet;
	}

}
