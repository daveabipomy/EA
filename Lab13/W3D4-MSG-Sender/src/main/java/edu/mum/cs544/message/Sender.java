package edu.mum.cs544.message;

import edu.mum.cs544.Book;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {

	@Autowired
	private RabbitTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		String queue = "book";
		//String msg = "Hello World!";
//		Person msg = new Person("Frank");
//		template.convertAndSend(queue, msg);
//		System.out.println("Sent: " + msg +" to: " + queue);

//		Book msg = new Book("The history of us_xx", "4578-7845-547", 65.89, "Human");
//		msg.setId(3);
//		template.convertAndSend(queue, msg);
//		System.out.println("Sent: " + msg +" to: " + queue);

		int msgId = 1;
		template.convertAndSend(queue, msgId);
		System.out.println("Sent: " + msgId +" to: " + queue);
	}
}
