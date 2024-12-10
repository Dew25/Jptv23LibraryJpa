package ee.ivkhkdev.jptv23libraryjpa;

import ee.ivkhkdev.jptv23libraryjpa.enity.Author;
import ee.ivkhkdev.jptv23libraryjpa.input.Input;
import ee.ivkhkdev.jptv23libraryjpa.service.AppService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jptv23LibraryJpaApplication implements CommandLineRunner {
	private final AppService<Author> authorService;
	private Input input;

	public Jptv23LibraryJpaApplication(Input input, AppService<Author> authorService) {
		this.input = input;
		this.authorService = authorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Jptv23LibraryJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean repeat = true;
		do {
			System.out.println("Список задач: ");
			System.out.println("0. Выход");
			System.out.println("1. Добавить автора");
			System.out.println("2. Список авторов");
			System.out.println("3. Изменить атрибуты автора");
			System.out.print("Введите номер задачи: ");
			int task = input.nextInt();
			switch (task){
				case 0:
					repeat = false;
					break;
				case 1:
					if(authorService.add()){
						System.out.println("Автор добавлен");
					}else{
						System.out.println("Автора добавить не удалось");
					};
					break;
				case 2:
					if(!authorService.print()){
						System.out.println("---- Список авторов пуст ----");
					};
					break;
				case 3:
					if(!authorService.edit()){
						System.out.println("---- Изменить автора не удалось ----");
					};
					break;
				default:
					System.out.println("Выберите номер задачи из списка!");
			}

		}while(repeat);
		System.out.println("До свидания!");
	}
}
