import java.util.ArrayList;

public class Category {
	// All information has been produced by ChatGPT.
	// Don't attack me if I get some of the informations wrong.
	
	ArrayList<Animal> animals;
	ArrayList<Country> countries;
	ArrayList<US_States> us_states;
	
	public Animal choose_animal() {
		// Before running this function, make sure that the size of the array being accessed is not 0
		// or else you will run into a Segmentation Fault
		// You will not need to check for duplication as this function already handles it.
		
		int randomIndex =  (int) ( Math.random() * animals.size() ); // This will return a random index
		Animal chosen_random_animal = animals.get(randomIndex); // Save the animal's values
		animals.remove(randomIndex); // Remove the animal from the ArrayList
		
		return chosen_random_animal;
	}
	
	public Country choose_country() {
		// Before running this function, make sure that the size of the array being accessed is not 0
		// or else you will run into a Segmentation Fault
		// You will not need to check for duplication as this function already handles it.
		
		int randomIndex = (int) ( Math.random() * countries.size() ); // This will return a random index
		Country chosen_random_country = countries.get(randomIndex); // Save the country's values;
		animals.remove(randomIndex); // Remove the country from the ArrayList
		
		return chosen_random_country;
	}
	
	public US_States choose_state() {
		// Before running this function, make sure that the size of the array being accessed is not 0
		// or else you will run into a Segmentation Fault
		// You will not need to check for duplication as this function already handles it.
				
		int randomIndex = (int) ( Math.random() * us_states.size() ); // This will return a random index\
		US_States chosen_random_state = us_states.get(randomIndex); // Save the state's values
		us_states.remove(randomIndex); // Remove the state from the ArrayList
		
		return chosen_random_state;
	}
	
	public void generate_animals() {
		Animal zebra = new Animal();
		Animal monkey = new Animal();
		Animal lion = new Animal();
		Animal dragon = new Animal();
		Animal unicorn = new Animal();
		
		zebra.animal_name = "Zebra";
		zebra.animal_descriptions.add("This animal is found in Africa");
		zebra.animal_descriptions.add("This animal has black and white stripes.");
		zebra.animal_descriptions.add("The pattern on its body is often used as a metaphor for opposites.");
		
		monkey.animal_name = "Monkey";
		monkey.animal_descriptions.add("This mammal is often seen swinging from trees and is known for its playful nature.");
		monkey.animal_descriptions.add("Some species of this animal have prehensile tails, allowing them to grasp objects.");
		monkey.animal_descriptions.add("Found in tropical forests, this animal is intelligent and known for its social behavior.");
		
		lion.animal_name = "Lion";
		lion.animal_descriptions.add("Often referred to as the king");
		lion.animal_descriptions.add("Found in grasslands and savannas, this social feline species is known for living in prides.");
		lion.animal_descriptions.add("This carnivorous big cat is a symbol of strength and courage, often associated with royalty.");
		
		dragon.animal_name = "Dragon";
		dragon.animal_descriptions.add("Mythical creatures often depicted with wings, scales, and the ability to breathe fire.");
		dragon.animal_descriptions.add("Legendary beings that appear in many cultures' folklore and are often associated with treasure hoards.");
		
		unicorn.animal_name = "Unicorn";
		unicorn.animal_descriptions.add("A mythical horse-like creature often depicted with a single, spiraled horn on its forehead");
		unicorn.animal_descriptions.add("Legendary beings known for their magical and gentle nature, often associated with purity and beauty.");
		
		animals.add(zebra);
		animals.add(monkey);
		animals.add(lion);
		animals.add(dragon);
		animals.add(unicorn);
	}
	
	public void generate_countries() {
		Country india = new Country();
		Country indonesia = new Country();
		Country australia = new Country();
		Country singapore = new Country();
		Country japan = new Country();
		
		india.country_name = "India";
		india.country_descriptions.add("This country is the seventh-largest in the world and is known for its diverse culture and traditions.");
		india.country_descriptions.add("The Taj Mahal is located in the northern part of this country.");
		india.country_descriptions.add("The most popular sport of this country is Cricket.");
		
		indonesia.country_name = "Indonesia";
		indonesia.country_descriptions.add("This is an archipelagic country.");
		indonesia.country_descriptions.add("The Komodo dragon is native to a few islands in this country.");
		indonesia.country_descriptions.add("The capital city of this Southeast Asian nation is located on the island of Java and is one of the most populous urban areas in the world.");
		
		australia.country_name = "Australia";
		australia.country_descriptions.add("This continent and country is known for its unique wildlife, including kangaroos and koalas.");
		australia.country_descriptions.add("The Great Barrier Reef, one of the world's largest coral reef systems, is located off the northeastern coast of this country.");
		australia.country_descriptions.add("The famous landmark known as Ayers Rock or Uluru is situated in the central part of this country.");
		
		singapore.country_name = "Singapore";
		singapore.country_descriptions.add("This city-state in Southeast Asia is known for its efficient and extensive public transportation system.");
		singapore.country_descriptions.add("Marina Bay Sands is located in the downtown area of this country.");
		singapore.country_descriptions.add("This nation is made up of one main island and 62 smaller islands, and it has a reputation for being a global financial hub.");
		
		japan.country_name = "Japan";
		japan.country_descriptions.add("Land of the rising sun, where cherry blossoms dance in the zephyr.");
		japan.country_descriptions.add("Archipelago adorned with sacred shrines and the art of origami.");
		japan.country_descriptions.add("Home to samurai echoes and bullet trains that whisper through neon-lit corridors.");
	}

	public void generate_states() {
		US_States illinois = new US_States();
		US_States california = new US_States();
		US_States texas = new US_States();
		US_States alabama = new US_States();
		US_States michigan = new US_States();
		
		illinois.state_name = "Illinois";
		illinois.state_descriptions.add("The Windy City state, where the skyline reflects on the waters of Lake Michigan.");
		illinois.state_descriptions.add("Abraham Lincoln's political roots run deep in this state, where the prairie blooms.");
		illinois.state_descriptions.add("Home to a university with an orange-and-blue legacy, nestled in the heart of the Midwest.");
		
		california.state_name = "California";
		california.state_descriptions.add("The Golden State, where Hollywood dreams shine under the Pacific sun.");
		california.state_descriptions.add("This state boasts the iconic redwood forests and the entertainment hub of Disneyland.");
		california.state_descriptions.add("Silicon Valley's tech heart pulsates in this diverse and geographically vast region.");
		
		texas.state_name = "Texas";
		texas.state_descriptions.add("The Lone Star State, where cowboy boots and BBQ are part of the cultural fabric.");
		texas.state_descriptions.add("Home to the Alamo and expansive landscapes, from the Gulf Coast to the Panhandle.");
		texas.state_descriptions.add("This state's capital, Austin, is known for live music scenes and a tech-savvy atmosphere.");
		
		alabama.state_name = "Alabama";
		alabama.state_descriptions.add("The Heart of Dixie, where the Civil Rights Movement took significant strides.");
		alabama.state_descriptions.add("Home to the rocket city, Huntsville, where NASA's Marshall Space Flight Center resides.");
		alabama.state_descriptions.add("This state, bordered by the Gulf of Mexico, is known for its southern hospitality.");
		
		michigan.state_name = "Michigan";
		michigan.state_descriptions.add("The Great Lakes State, where freshwater shores meet the automotive heartbeat.");
		michigan.state_descriptions.add("Home to the Motor City, where the hum of assembly lines once defined American industry.");
		michigan.state_descriptions.add("This state's upper and lower peninsulas are connected by the Mackinac Bridge.");
	}
}
