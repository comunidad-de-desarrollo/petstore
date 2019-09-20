package com.cdc.dcop.daos;

import com.cdc.dcop.entity.Pet;
import com.cdc.dcop.entity.Category;
import com.cdc.dcop.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetstoreDAO implements IPetstoreDAO {

	public Pet findById(Long id) {

		Pet pet;

		// Categorias

		Category cat = new Category();
		cat.setId(1L);
		cat.setName("Domesticos");

		Category cat2 = new Category();
		cat2.setId(2L);
		cat2.setName("Salvajes");

		// Tags

		Tag tag = new Tag();
		tag.setId(1L);
		tag.setName("chico");

		Tag tag2 = new Tag();
		tag2.setId(2L);
		tag2.setName("grande");

		List<Tag> tags = new ArrayList<Tag>();
		tags.add(tag);

		List<Tag> tags2 = new ArrayList<Tag>();
		tags2.add(tag2);

		// urls

		String url = "https://images.clarin.com/2019/01/19/BHaslG6vz_1256x620__1.jpg";
		String url2 = "https://commons.wikimedia.org/wiki/File:Cat_November_2010-1a.jpg";

		List<String> urls = new ArrayList<String>();
		urls.add(url);

		List<String> urls2 = new ArrayList<String>();
		urls2.add(url2);

		// Pets

		Pet sold = new Pet();
		sold.setId(1L);
		sold.setName("Perro");
		sold.setStatus("Sold");
		sold.setCategory(cat);
		sold.setTags(tags);
		sold.setPhotoUrls(urls);

		Pet available = new Pet();
		available.setId(2L);
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
		cat.setId(1L);
		cat.setName("Domesticos");

		Category cat2 = new Category();
		cat2.setId(2L);
		cat2.setName("Salvajes");

		// Tags

		Tag tag = new Tag();
		tag.setId(1L);
		tag.setName("chico");

		Tag tag2 = new Tag();
		tag2.setId(2L);
		tag2.setName("grande");

		List<Tag> tags = new ArrayList<>();
		tags.add(tag);

		List<Tag> tags2 = new ArrayList<>();
		tags2.add(tag2);

		// urls

		String url = "https://images.clarin.com/2019/01/19/BHaslG6vz_1256x620__1.jpg";
		String url2 = "https://commons.wikimedia.org/wiki/File:Cat_November_2010-1a.jpg";

		List<String> urls = new ArrayList<String>();
		urls.add(url);

		List<String> urls2 = new ArrayList<String>();
		urls2.add(url2);

		// Pets

		Pet sold = new Pet();
		sold.setId(1L);
		sold.setName("Perro");
		sold.setStatus("Sold");
		sold.setCategory(cat);
		sold.setTags(tags);
		sold.setPhotoUrls(urls);

		Pet available = new Pet();
		available.setId(2L);
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
