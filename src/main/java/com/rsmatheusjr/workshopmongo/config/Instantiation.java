package com.rsmatheusjr.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rsmatheusjr.workshopmongo.domain.Post;
import com.rsmatheusjr.workshopmongo.domain.User;
import com.rsmatheusjr.workshopmongo.repository.PostRepository;
import com.rsmatheusjr.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userReposiroty.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para sao paulo, abçs", maria);
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hj", maria);
		

		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}